import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.STOP_ON_FAILURE
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CART-003 user can add products and back to shopping'), null)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_checkout'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Checkout_Your Information'), 'Checkout: Your Information')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_First Name'), 'John')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Last Name'), 'Doe')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Zip_Postal Code'), '123098')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_continue'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Checkout_Overview'), 'Checkout: Overview')

String itemOneInCart = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Backpack from cart'))

String itemTwoInCart = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Bike Light at cart'))

String itemOneInCheckout = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Backpack at Checkout Overview'))

String itemTwoInCheckout = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Bike Light at Checkout Overview'))

WebUI.verifyMatch(itemOneInCart, itemOneInCheckout, false, STOP_ON_FAILURE)

WebUI.verifyMatch(itemTwoInCart, itemTwoInCheckout, false, STOP_ON_FAILURE)

//Getting the number
String priceTextOne = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Labs Backpack Price 29.99 at Checkout'))
String priceTextTwo = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Labs Bike Light Price 9.99 at Checkout'))
String priceTextTax = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Tax price 3.20'))
String priceTextSubTotal = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Item total price 39.98'))
String priceTextGrandTotal = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Grand Total 43.18'))

//parsing the number to double
Double price1 = Double.parseDouble(priceTextOne.replaceAll("[^0-9.]", ""))
Double price2 = Double.parseDouble(priceTextTwo.replaceAll("[^0-9.]", ""))
Double subTotalExpected = Double.parseDouble(priceTextSubTotal.replaceAll("[^0-9.]", ""))
Double tax = Double.parseDouble(priceTextTax.replaceAll("[^0-9.]", ""))
Double grandTotalExpected = Double.parseDouble(priceTextGrandTotal.replaceAll("[^0-9.]", ""))

Double subTotalActual = price1 + price2
subTotalActual = Math.round(subTotalActual * 100.0) / 100.0
WebUI.verifyEqual(subTotalActual, subTotalExpected)
println('Subtotal actual: '+ subTotalActual)
println('Subtotal expected: '+ subTotalExpected)

Double grandTotalActual = subTotalActual + tax
grandTotalActual = Math.round(grandTotalActual * 100.0) / 100.0
WebUI.verifyEqual(grandTotalActual, grandTotalExpected)
println('grand total actual: '+ grandTotalActual)
println('grand total expected: '+ grandTotalExpected)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_finish'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Checkout_Complete'), 'Checkout: Complete!')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/h2_Thank you for your order'), 'Thank you for your order!')







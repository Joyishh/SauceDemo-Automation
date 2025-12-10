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

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CART-001 user can add products from product page'), null)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_continue-shopping'))

String nameItemAtProducts = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Bike Light at products'))

String descItemAtProducts = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_bike light desc'))

String priceItemAtProducts = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_bike light price'))

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_add-to-cart-sauce-labs-bike-light'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/button_remove-sauce-labs-bike-light'), 'Remove')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_2'), '2')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icon_cart'))

String nameItemAtCart = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Bike Light at cart'))

String descItemAtCart = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_bike light desc at cart'))

String priceItemAtCart = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_bike light price at cart'))

WebUI.verifyMatch(nameItemAtProducts, nameItemAtCart, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(descItemAtProducts, descItemAtCart, false, STOP_ON_FAILURE)

WebUI.verifyMatch(priceItemAtProducts, priceItemAtCart, false, STOP_ON_FAILURE)
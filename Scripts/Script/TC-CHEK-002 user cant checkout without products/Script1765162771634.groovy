import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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

WebUI.callTestCase(findTestCase('null'), null)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icon_cart'))

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_checkout'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Checkout_Your Information'), 'Checkout: Your Information')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_First Name'), 'John')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Last Name'), 'Doe')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Zip_Postal Code'), '123098')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_continue'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Checkout_Overview'), 'Checkout: Overview')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_finish'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Checkout_Complete'), 'Checkout: Complete!')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/h2_Thank you for your order'), 'Thank you for your order!')
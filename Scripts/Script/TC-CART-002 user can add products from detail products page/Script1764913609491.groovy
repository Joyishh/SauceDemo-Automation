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

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-AUTH-001 login with correct credential'), null)

WebUI.navigateToUrl('https://www.saucedemo.com/inventory.html')

String nameItemAtProduct = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Backpack title form products'))

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Backpack title form products'))

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_add-to-cart in detail item'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/button_remove in detail item'), 'Remove')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_1'), '1')

String incrementItems = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/span_1'))

String nameItemsAtDetail = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Backpack in detail item'))

WebUI.verifyMatch(nameItemAtProduct, nameItemsAtDetail, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icon_cart'))

String nameItemsAtCart = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Backpack from cart'))

WebUI.verifyMatch(nameItemsAtDetail, nameItemsAtCart, false, FailureHandling.STOP_ON_FAILURE)

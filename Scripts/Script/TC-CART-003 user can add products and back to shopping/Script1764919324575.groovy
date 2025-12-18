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

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/btn_dynamic_add_to_cart', [('productName') : var_productName]))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_2'), '2')

String descItem = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/txt_product_page_item_desc', [('productName') : var_productName]))

String priceItem = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/txt_product_page_item_price', [('productName') : var_productName]))

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icon_cart'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/txt_cart_item_name', [('productName') : var_productName]), var_productName, STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/txt_cart_item_desc', [('productName') : var_productName]), descItem, STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/txt_cart_item_price', [('productName') : var_productName]), priceItem, STOP_ON_FAILURE)
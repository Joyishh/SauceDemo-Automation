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

WebUI.deleteAllCookies()

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-AUTH-001 login with correct credential'), null)

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CART-001 user can add products from product page'), [('var_productName') : var_item1], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CART-002 user can add products from detail products page'), [('var_productName') : var_item2], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CART-003 user can add products and back to shopping'), [('var_productName') : var_item3], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CART-004 user can remove product from cart'), [('var_productName') : var_item_delete], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CHEK-001 user can fill checkout info'), null)

if (var_item1 != var_item_delete) {
    WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CHEK-002 verify checkout items'), 
        [('var_productName') : var_item1], FailureHandling.STOP_ON_FAILURE)
}

if (var_item2 != var_item_delete) {
    WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CHEK-002 verify checkout items'), 
        [('var_productName') : var_item2], FailureHandling.STOP_ON_FAILURE)
}

if (var_item3 != var_item_delete) {
    WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CHEK-002 verify checkout items'), 
        [('var_productName') : var_item3], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-CHEK-003 verify checkout total'), null)

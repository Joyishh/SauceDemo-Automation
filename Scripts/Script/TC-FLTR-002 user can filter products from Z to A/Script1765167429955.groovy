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
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('null'), null)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/select_Name (A to Z)Name (Z to A)Price (low to h'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Swag Labs/select_Name (A to Z)Name (Z to A)Price (low to h'), 'Name (Z to A)', false)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Swag Labs/list_Products_Names'), 10)

List<WebElement> productElements = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/list_Products_Names'), 10)

List<String> actualProductNames = []

for(WebElement element : productElements) {
	actualProductNames.add(element.getText())
}
println("Urutan di Website: " + actualProductNames)

List<String> expectedSortedList = new ArrayList(actualProductNames)

Collections.sort(expectedSortedList)

Collections.reverse(expectedSortedList)
println("Ekspektasi Urutan (Z-A): " + expectedSortedList)

if (actualProductNames.equals(expectedSortedList)) {
	println("✅ PASS: Produk sudah urut Z-A!")
} else {
	KeywordUtil.markFailed("❌ FAIL: Produk berantakan! Website: " + actualProductNames)
}
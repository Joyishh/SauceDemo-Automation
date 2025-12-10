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

WebUI.callTestCase(findTestCase('Test Cases/Script/TC-AUTH-001 login with correct credential'), null)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/select_Name (A to Z)Name (Z to A)Price (low to h'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Swag Labs/select_Name (A to Z)Name (Z to A)Price (low to h'), 'Price (low to high)', false)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Swag Labs/list_Product_Prices'), 10)

List<WebElement> priceElements = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/list_Product_Prices'), 10)

List<Double> actualPrices = []

for (WebElement element : priceElements) {
	String priceText = element.getText()
	String cleanPrice = priceText.replace('$', '')
	double priceValue = Double.parseDouble(cleanPrice)
	actualPrices.add(priceValue)
}

println("Harga di Website: " + actualPrices)

List<Double> expectedSortedList = new ArrayList(actualPrices)

Collections.sort(expectedSortedList)

println("Ekspektasi (Low-High): " + expectedSortedList)

if (actualPrices.equals(expectedSortedList)) {
	println("✅ PASS: Harga sudah urut dari Murah ke Mahal!")
} else {
	KeywordUtil.markFailed("❌ FAIL: Harga berantakan.")
}

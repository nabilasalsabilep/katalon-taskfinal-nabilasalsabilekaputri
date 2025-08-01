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

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/StartExistingApp'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.taskTitle = Mobile.getText(findTestObject('Object Repository/Home/TitleDataofFirstTask'), 10)

GlobalVariable.activity = Mobile.getText(findTestObject('Object Repository/Home/AvtivityDataofFirstTask'), 10)

Mobile.tap(findTestObject('Object Repository/Home/btnMoreOptions'), 5)

Mobile.tap(findTestObject('Object Repository/Home/btnOptionCopy'), 5)

Mobile.tap(findTestObject('Object Repository/Home/btnMoreOptions'), 5)

Mobile.tap(findTestObject('Object Repository/Home/btnOptionEdit'), 5)

Mobile.longPress(findTestObject('Object Repository/EditTask/InputTitle'), 2)

Mobile.tapAtPosition(246, 661)

Mobile.delay(1)

Mobile.tapAtPosition(674, 649)

Mobile.delay(1)

String expectedText = 'Title : ' + GlobalVariable.taskTitle + ' Task : ' + GlobalVariable.activity
String actualText = Mobile.getText(findTestObject('Object Repository/EditTask/InputTitle'), 10)

if (actualText == expectedText) {
    println("✅ Paste successful. Text matches the expected value.")
} else {
    println("❌ Paste failed or text does not match.")
	
    println("Expected: " + expectedText)
	
    println("Actual: " + actualText)
	
    assert false : "Text verification failed!" 
}

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/CloseApp'), [:], FailureHandling.STOP_ON_FAILURE)


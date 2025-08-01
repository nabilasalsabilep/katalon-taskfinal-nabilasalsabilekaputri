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

Mobile.tap(findTestObject('Object Repository/Home/btnMoreOptions'), 5)

Mobile.tap(findTestObject('Object Repository/Home/btnOptionDelete'), 5)

Mobile.waitForElementPresent(findTestObject('Object Repository/DeleteTask/titleDeleteTask'), 5)

Mobile.verifyElementText(findTestObject('Object Repository/DeleteTask/titleDeleteTask'), 'Delete Task!')

Mobile.verifyElementText(findTestObject('Object Repository/DeleteTask/ConfirmationMessageforDeletTask'), 'Do you want to delete this task?')

Mobile.verifyElementText(findTestObject('Object Repository/DeleteTask/btnCANCEL'), 'CANCEL')

Mobile.verifyElementText(findTestObject('Object Repository/DeleteTask/btnDELETE'), 'DELETE')

Mobile.tap(findTestObject('Object Repository/DeleteTask/btnDELETE'), 5)

boolean isTitleGone = Mobile.waitForElementNotPresent(findTestObject('Object Repository/Home/TitleDataofFirstTask'), 5)

boolean isActivityGone = Mobile.waitForElementNotPresent(findTestObject('Object Repository/Home/AvtivityDataofFirstTask'), 5)

if (isTitleGone && isActivityGone) {
    println("✅ Task successfully deleted. Title and activity elements are no longer present.")
} else {
    println("❌ Task deletion failed.")
	
    println("Title still visible: " + !isTitleGone)
	
    println("Activity still visible: " + !isActivityGone)
	
    assert false : "One or more elements were not removed from the screen after deletion."
}

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/CloseApp'), [:], FailureHandling.STOP_ON_FAILURE)


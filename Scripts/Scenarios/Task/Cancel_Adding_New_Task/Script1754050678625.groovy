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

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/StartApp'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Home/btnPlustoAddNewTask'), 5)

Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/pageTitleAddTask'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/pageTitleAddTask'), 'Add Task')

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleTaskTitle'), 'Task Title')

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleWhatistobedone'), 'What is to be done?')

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleSetreminderdateandtime(optional)'), 'Set reminder date and time (optional)')

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleAddtocategory'), 'Add to category')

GlobalVariable.taskTitle = taskTitle

Mobile.setText(findTestObject('Object Repository/AddTask/InputTasktitle'), GlobalVariable.taskTitle, 10)

GlobalVariable.activity = activity

Mobile.setText(findTestObject('Object Repository/AddTask/InputYourtask'), GlobalVariable.activity, 10)

Mobile.tap(findTestObject('Object Repository/AddTask/btnBack'), 10)

if (Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/titleInPopUpSaveTask'), 10)) {
	
    Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleInPopUpSaveTask'), 'Save task!')
	
    Mobile.verifyElementText(findTestObject('Object Repository/AddTask/messageInPopUpSaveTask'), 'Do you want to save this task?')
	
    Mobile.verifyElementText(findTestObject('Object Repository/AddTask/btnCANCELInPopUpSaveTask'), 'CANCEL')
	
    Mobile.verifyElementText(findTestObject('Object Repository/AddTask/btnSAVEInPopUpSaveTask'), 'SAVE')

    Mobile.tap(findTestObject('Object Repository/AddTask/btnCANCELInPopUpSaveTask'), 10)

    Mobile.waitForElementPresent(findTestObject('Object Repository/Home/EmptyStateMessage'), 10)
	
    Mobile.verifyElementText(findTestObject('Object Repository/Home/EmptyStateMessage'), 'No task to show')
	
} else {
	
    println("Save task pop-up did not appear after tapping the Back button.")
	
}

Mobile.tap(findTestObject('Object Repository/Home/btnPlustoAddNewTask'), 5)

Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/pageTitleAddTask'), 10)

Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/pageTitleAddTask'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/pageTitleAddTask'), 'Add Task')

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleTaskTitle'), 'Task Title')

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleWhatistobedone'), 'What is to be done?')

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleSetreminderdateandtime(optional)'), 'Set reminder date and time (optional)')

Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleAddtocategory'), 'Add to category')

String currentTaskTitle = Mobile.getText(findTestObject('Object Repository/AddTask/InputTasktitle'), 10)

String currentActivity = Mobile.getText(findTestObject('Object Repository/AddTask/InputYourtask'), 10)

if (currentTaskTitle == 'Enter task title' && currentActivity == 'Enter your task') {
	
    println("Input fields are cleared. No cached data found.")
	
} else {
	
    println("Cached data detected!")
	
    println("Task Title: " + currentTaskTitle)
	
    println("Activity: " + currentActivity)
	
}

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/CloseApp'), [:], FailureHandling.STOP_ON_FAILURE)


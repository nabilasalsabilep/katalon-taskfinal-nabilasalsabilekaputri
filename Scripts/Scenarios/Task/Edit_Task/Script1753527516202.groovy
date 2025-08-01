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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/StartExistingApp'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Home/TitleDataofFirstTask'), 10)

GlobalVariable.taskTitle = Mobile.getText(findTestObject('Object Repository/Home/TitleDataofFirstTask'), 10)

GlobalVariable.activity = Mobile.getText(findTestObject('Object Repository/Home/AvtivityDataofFirstTask'), 10)

GlobalVariable.category = Mobile.getText(findTestObject('Object Repository/Home/CategoryDataofFirstTask'), 10)

GlobalVariable.date = ''

GlobalVariable.time = ''

if(Mobile.waitForElementPresent(findTestObject('Object Repository/Home/DateofFirstDataAfterExpand'), 5)) {
	GlobalVariable.date = Mobile.getText(findTestObject('Object Repository/Home/DateofFirstDataAfterExpand'), 10)
}

if(Mobile.waitForElementPresent(findTestObject('Object Repository/Home/TimeofFirstDataAfterExpand'), 5)) {
	GlobalVariable.time = Mobile.getText(findTestObject('Object Repository/Home/TimeofFirstDataAfterExpand'), 10)
}

Mobile.tap(findTestObject('Object Repository/Home/btnMoreOptions'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/Home/btnOptionEdit'), 'Edit')

Mobile.verifyElementText(findTestObject('Object Repository/Home/btnOptionCopy'), 'Copy')

Mobile.verifyElementText(findTestObject('Object Repository/Home/btnOptionShare'), 'Share')

Mobile.verifyElementText(findTestObject('Object Repository/Home/btnOptionDelete'), 'Delete')

Mobile.tap(findTestObject('Object Repository/Home/btnOptionEdit'), 10)

Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/titleAddTaskinHeader'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/EditTask/titleAddTaskinHeader'), 'Add Task')

Mobile.verifyElementText(findTestObject('Object Repository/EditTask/titleTaskTitle'), 'Task Title')

Mobile.verifyElementText(findTestObject('Object Repository/EditTask/titleWhatistobedone'), 'What is to be done?')

Mobile.verifyElementText(findTestObject('Object Repository/EditTask/titleSetreminderdateandtime(optional)'), 'Set reminder date and time (optional)')

Mobile.verifyElementText(findTestObject('Object Repository/EditTask/titleAddtocategory'), 'Add to category')

Mobile.verifyElementText(findTestObject('Object Repository/EditTask/InputTitle'), GlobalVariable.taskTitle)

Mobile.verifyElementText(findTestObject('Object Repository/EditTask/InputActivity'), GlobalVariable.activity)

GlobalVariable.taskTitle = taskTitle

Mobile.setText(findTestObject('Object Repository/EditTask/InputTitle'), GlobalVariable.taskTitle, 10)

GlobalVariable.activity = activity

Mobile.setText(findTestObject('Object Repository/EditTask/InputActivity'), GlobalVariable.activity, 10)

Mobile.delay(2)

if(GlobalVariable.date != '') {
	Mobile.verifyElementText(findTestObject('Object Repository/EditTask/datePicker'), GlobalVariable.date)
}

if(GlobalVariable.time != '') {
	Mobile.verifyElementText(findTestObject('Object Repository/EditTask/timePicker'), GlobalVariable.time)
	
	Mobile.tap(findTestObject('Object Repository/EditTask/btnResetDate'), 10)
	
	Mobile.verifyElementText(findTestObject('Object Repository/EditTask/datePicker'), 'Set Date')
	
}

GlobalVariable.setDate = setDate

if(GlobalVariable.setDate) {
	Mobile.tap(findTestObject('Object Repository/EditTask/datePicker'), 10)
	
	Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/btnPickaYearinCalendar'), 10)
	
	Mobile.tap(findTestObject('Object Repository/EditTask/btnPickaYearinCalendar'), 5)

	Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/btnYear2025'), 10)
	
	Mobile.tap(findTestObject('Object Repository/EditTask/btnYear2025'), 5)

	Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/date2inCalendar'), 10)
	
	Mobile.tap(findTestObject('Object Repository/EditTask/btnNextinCalendar'), 10)

	Mobile.delay(2)
	
	Mobile.tap(findTestObject('Object Repository/EditTask/date2inCalendar'), 5)
	
	Mobile.tap(findTestObject('Object Repository/EditTask/btnOKinCalendar'), 5)

	Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/datePicker'), 10)
	
	GlobalVariable.date = Mobile.getText(findTestObject('Object Repository/EditTask/datePicker'), 10)
}

GlobalVariable.setTime = setTime

// SET TIME
if (GlobalVariable.setTime) {
	Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/timePicker'), 10)
	
	Mobile.tap(findTestObject('Object Repository/EditTask/timePicker'), 5)

	Mobile.delay(2)
	
	Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/currentHourinTimePicker'), 10)

	Mobile.tap(findTestObject('Object Repository/EditTask/btnAMinTimePicker'), 5)

	Mobile.delay(2)
	
	Mobile.tapAtPosition(271, 1072)
	
	Mobile.delay(2)
	
	Mobile.tapAtPosition(608, 982)
	
	Mobile.delay(2)
	
	Mobile.tap(findTestObject('Object Repository/EditTask/btnOKinTimePicker'), 5)

	Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/btnResetTime'), 10)
	
	GlobalVariable.time = Mobile.getText(findTestObject('Object Repository/EditTask/timePicker'), 10)
}

Mobile.tap(findTestObject('Object Repository/EditTask/dropdownCategory'), 5)

GlobalVariable.category = category

switch (GlobalVariable.category) {
	case 'Banking':
		Mobile.tap(findTestObject('Object Repository/EditTask/dropdownCategoryDataBanking'), 5)

		break
	case 'Business':
		Mobile.tap(findTestObject('Object Repository/EditTask/dropdownCategoryDataBusiness'), 5)

		break
	case 'Insurance':
		Mobile.tap(findTestObject('Object Repository/EditTask/dropdownCategoryDataInsurance'), 5)

		break
	case 'Personal':
		Mobile.tap(findTestObject('Object Repository/EditTask/dropdownCategoryDataPersonal'), 5)

		break
	case 'Shopping':
		Mobile.tap(findTestObject('Object Repository/EditTask/dropdownCategoryDataShopping'), 5)

		break
	default:
		Mobile.tapAtPosition(966, 1387)
		
		Mobile.delay(1)
	
		Mobile.tap(findTestObject('Object Repository/EditTask/btnAddNewCategory'), 5)

		Mobile.waitForElementPresent(findTestObject('Object Repository/EditTask/titleAddCategory'), 10)
		
		Mobile.verifyElementText(findTestObject('Object Repository/EditTask/titleAddCategory'), 'Add Category')

		Mobile.setText(findTestObject('Object Repository/EditTask/InputNewCategory'), GlobalVariable.category, 0)

		Mobile.tap(findTestObject('Object Repository/EditTask/btnADDCategory'), 5)
		
		TestObject dynamicCategory = new TestObject("dynamicCategory")
		
		dynamicCategory.addProperty("xpath", ConditionType.EQUALS, "//*[@class = 'android.widget.CheckedTextView' and (@text = '${GlobalVariable.category}' or . = '${GlobalVariable.category}') and @resource-id = 'android:id/text1']")
		
		Mobile.tap(findTestObject('Object Repository/EditTask/dropdownCategory'), 5)
		
		Mobile.tap(dynamicCategory, 5)

		break
		
}

Mobile.tap(findTestObject('Object Repository/EditTask/btnChecklistinHeader'), 10)

Mobile.delay(2)

Mobile.verifyElementText(findTestObject('Object Repository/Home/TitleDataofFirstTask'), GlobalVariable.taskTitle)

Mobile.verifyElementText(findTestObject('Object Repository/Home/AvtivityDataofFirstTask'), GlobalVariable.activity)

Mobile.verifyElementText(findTestObject('Object Repository/Home/CategoryDataofFirstTask'), GlobalVariable.category)

if (GlobalVariable.date != null) {
	String actualDate = Mobile.getText(findTestObject('Object Repository/Home/DateofFirstDataAfterExpand'), 5)
	
	if (!actualDate.equals(GlobalVariable.date)) {
		println("⚠️ Date mismatch! Expected: ${GlobalVariable.date}, Found: ${actualDate}")
	}
}

if (GlobalVariable.time != null) {
	String actualTime = Mobile.getText(findTestObject('Object Repository/Home/TimeofFirstDataAfterExpand'), 5)
	
	if (!actualTime.equals(GlobalVariable.time)) {
		println("⚠️ Time mismatch! Expected: ${GlobalVariable.time}, Found: ${actualTime}")
	}
}

Mobile.tap(findTestObject('Object Repository/Home/TitleDataofFirstTask'), 10)

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/CloseApp'), [:], FailureHandling.STOP_ON_FAILURE)


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

GlobalVariable.setDate = setDate

// SET DATE
if (GlobalVariable.setDate) {
    Mobile.tap(findTestObject('Object Repository/AddTask/datePickerSetDate'), 5)

    Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/btnPickaYearinCalendar'), 10)
	
    Mobile.tap(findTestObject('Object Repository/AddTask/btnPickaYearinCalendar'), 5)

    Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/btnYear2025'), 10)
	
    Mobile.tap(findTestObject('Object Repository/AddTask/btnYear2025'), 5)

    Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/date1inCalendar'), 10)
	
    Mobile.tap(findTestObject('Object Repository/AddTask/btnNextinCalendar'), 10)

    Mobile.delay(2)
	
    Mobile.tap(findTestObject('Object Repository/AddTask/date1inCalendar'), 5)
	
    Mobile.tap(findTestObject('Object Repository/AddTask/btnOKinCalendar'), 5)

    Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/datePickerSetDate'), 10)
	
	GlobalVariable.date = Mobile.getText(findTestObject('Object Repository/AddTask/datePickerSetDate'), 10)
}

GlobalVariable.setTime = setTime

// SET TIME
if (GlobalVariable.setTime) {
    Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/timePickerSetTime'), 10)
	
    Mobile.tap(findTestObject('Object Repository/AddTask/timePickerSetTime'), 5)

    Mobile.delay(2)
	
    Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/currentHourinTimePicker'), 10)

    Mobile.tap(findTestObject('Object Repository/AddTask/btnPMinTimePicker'), 5)

    Mobile.delay(2)
	
    Mobile.tapAtPosition(271, 1319) 
	
    Mobile.delay(2)
	
    Mobile.tapAtPosition(732, 1196) 
	
    Mobile.delay(2)
	
    Mobile.tap(findTestObject('Object Repository/AddTask/btnOKinTimePicker'), 5)

    Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/btnResetTime'), 10)
	
	GlobalVariable.time = Mobile.getText(findTestObject('Object Repository/AddTask/timePickerSetTime'), 10)
}


Mobile.tap(findTestObject('Object Repository/AddTask/dropdownCategory'), 5)

GlobalVariable.category = category

switch (GlobalVariable.category) {
    case 'Banking':
        Mobile.tap(findTestObject('Object Repository/AddTask/dropdownCategoryDataBanking'), 5)

        break
    case 'Business':
        Mobile.tap(findTestObject('Object Repository/AddTask/dropdownCategoryDataBusiness'), 5)

        break
    case 'Insurance':
        Mobile.tap(findTestObject('Object Repository/AddTask/dropdownCategoryDataInsurance'), 5)

        break
    case 'Personal':
        Mobile.tap(findTestObject('Object Repository/AddTask/dropdownCategoryDataPersonal'), 5)

        break
    case 'Shopping':
        Mobile.tap(findTestObject('Object Repository/AddTask/dropdownCategoryDataShopping'), 5)

        break
    default:
		Mobile.tapAtPosition(966, 1387)
		
		Mobile.delay(1)
		
        Mobile.tap(findTestObject('Object Repository/AddTask/btnAddNewCategory'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/titleAddCategory'), 10)
		
		Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleAddCategory'), 'Add Category')

        Mobile.setText(findTestObject('Object Repository/AddTask/InputNewCategory'), GlobalVariable.category, 0)

        Mobile.tap(findTestObject('Object Repository/AddTask/btnADDCategory'), 5)
		
		TestObject dynamicCategory = new TestObject("dynamicCategory")
		
		dynamicCategory.addProperty("xpath", ConditionType.EQUALS, "//*[@class = 'android.widget.CheckedTextView' and (@text = '${GlobalVariable.category}' or . = '${GlobalVariable.category}') and @resource-id = 'android:id/text1']")
		
		Mobile.tap(findTestObject('Object Repository/AddTask/dropdownCategory'), 5)
		
		Mobile.tap(dynamicCategory, 5)

        break
}

Mobile.tap(findTestObject('Object Repository/AddTask/btnChecklistinHeader'), 10)

Mobile.delay(2)

Mobile.tap(findTestObject('Object Repository/Home/TitleDataofFirstTask'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/Home/TitleDataofFirstTask'), GlobalVariable.taskTitle)

Mobile.verifyElementText(findTestObject('Object Repository/Home/AvtivityDataofFirstTask'), GlobalVariable.activity)

Mobile.verifyElementText(findTestObject('Object Repository/Home/CategoryDataofFirstTask'), GlobalVariable.category)

if(GlobalVariable.setDate) {
	Mobile.verifyElementText(findTestObject('Object Repository/Home/DateofFirstDataAfterExpand'), GlobalVariable.date)
}

if(GlobalVariable.setTime) {
	Mobile.verifyElementText(findTestObject('Object Repository/Home/TimeofFirstDataAfterExpand'), GlobalVariable.time)
}

Mobile.tap(findTestObject('Object Repository/Home/TitleDataofFirstTask'), 10)

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/CloseApp'), [:], FailureHandling.STOP_ON_FAILURE)


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

Mobile.startApplication(System.getProperty("user.dir") + '/Data Files/' + GlobalVariable.apkPath, false)

if(Mobile.waitForElementPresent(findTestObject('Object Repository/PopUpConfirmation/PopUpConfirmationTitle'), 10)) {
	Mobile.verifyElementText(findTestObject('Object Repository/PopUpConfirmation/PopUpConfirmationMessage'), "This app was built for an older version of Android. It might not work properly and doesn't include the latest security and privacy protections. Check for an update, or contact the app's developer.")
	
	Mobile.tap(findTestObject('Object Repository/PopUpConfirmation/btnOK'), 10)
}

Mobile.waitForElementPresent(findTestObject('Object Repository/SplashScreen/SplashScreenImage1'), 10)

Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/SplashScreen/SplashScreenText1'), 10).replaceAll("\\r?\\n", " ").trim(), 'Create task and Modify,  Add reminder and Specify  category of Task.', false)

int deviceHeight = Mobile.getDeviceHeight()

int deviceWidth = Mobile.getDeviceWidth()

int startX = (int)(deviceWidth * 0.95)

int endX = (int)(deviceWidth * 0.05)

int y = deviceHeight / 2

Mobile.swipe(startX, y, endX, y)

Mobile.waitForElementPresent(findTestObject('Object Repository/SplashScreen/SplashScreenImage2'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/SplashScreen/SplashScreenText2'), 'Create Category, Modify and Manage')

Mobile.swipe(startX, y, endX, y)

Mobile.waitForElementPresent(findTestObject('Object Repository/SplashScreen/SplashScreen3Image1'), 10)

Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/SplashScreen/SplashScreen3Text'), 10).replaceAll("\\r?\\n", " ").trim(), 'Tap on task for more details. Swipe right to finish task and Swipe Right to delete task.', false)

Mobile.swipe(startX, y, endX, y)

Mobile.waitForElementPresent(findTestObject('Object Repository/SplashScreen/SplashScreen4Image'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/SplashScreen/btnGETSTARTED'), 'GET STARTED')

Mobile.tap(findTestObject('Object Repository/SplashScreen/btnGETSTARTED'), 5)

Mobile.waitForElementPresent(findTestObject('Object Repository/Home/LogoText'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/Home/LogoText'), 'Todo')

Mobile.verifyElementText(findTestObject('Object Repository/Home/EmptyStateMessage'), 'No task to show')
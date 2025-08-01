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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/StartApp'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Home/btnBurgerMenu'), 10)

Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/LogoText'), 'Todo')

Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/btnDashboard'), 'Dashboard')

Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/btnCategory'), 'Category')

Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/btnHistory'), 'History')

Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/btnHelp'), 'Help')

Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/btnRateUs'), 'Rate Us')

Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/btnShareApp'), 'Share App')

Mobile.tap(findTestObject('Object Repository/SideBarMenu/btnCategory'), 10)

GlobalVariable.category = category

switch (GlobalVariable.category) {
    case 'Banking':
        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/categoryBanking'), 'Banking')

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnEditBanking'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 
            10)

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 'Update Category')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpUpdateCategory'), 
            'CANCEL')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 
            'UPDATE')
		
		String updatedCategory = 'Financial'

        Mobile.setText(findTestObject('Object Repository/SideBarMenu/Category/inputCategoryInPopUpUpdateCategory'), updatedCategory, 
            0)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/pageTitleCategory'), 10)
		
		String xpath = "//*[@class = 'android.widget.TextView' and (@text = '${updatedCategory}' or . = '${updatedCategory}') and @resource-id = 'com.avinashproduct.todo:id/txtCategoryName']"
		 
		TestObject dynamicCategoryObject = new TestObject('dynamicCategory')
		 
		dynamicCategoryObject.addProperty('xpath', ConditionType.EQUALS, xpath) 

        Mobile.verifyElementText(dynamicCategoryObject, updatedCategory)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDeleteBanking'), 5)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 10)
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 'Delete Category')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/messageInPopUpDeleteCategory'), 'Do you want to delete this category?')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpDeleteCategory'), 'CANCEL')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 'DELETE')

		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 5)
		
        Mobile.waitForElementNotPresent(findTestObject('Object Repository/SideBarMenu/Category/categoryBanking'), 5)

        break
    case 'Business':
        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/categoryBusiness'), 'Business')

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnEditBusiness'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 
            10)

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 'Update Category')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpUpdateCategory'), 
            'CANCEL')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 
            'UPDATE')
		
		String updatedCategory = 'Enterprise'

        Mobile.setText(findTestObject('Object Repository/SideBarMenu/Category/inputCategoryInPopUpUpdateCategory'), updatedCategory, 
            0)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/pageTitleCategory'), 10)
		
		String xpath = "//*[@class = 'android.widget.TextView' and (@text = '${updatedCategory}' or . = '${updatedCategory}') and @resource-id = 'com.avinashproduct.todo:id/txtCategoryName']"
		 
		TestObject dynamicCategoryObject = new TestObject('dynamicCategory')
		 
		dynamicCategoryObject.addProperty('xpath', ConditionType.EQUALS, xpath)

        Mobile.verifyElementText(dynamicCategoryObject, updatedCategory)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDeleteBusiness'), 5)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 10)
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 'Delete Category')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/messageInPopUpDeleteCategory'), 'Do you want to delete this category?')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpDeleteCategory'), 'CANCEL')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 'DELETE')
		
		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 5)

        Mobile.waitForElementNotPresent(findTestObject('Object Repository/SideBarMenu/Category/categoryBusiness'), 5)

        break
    case 'Insurance':
        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/categoryInsurance'), 'Insurance')

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnEditInsurance'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 
            10)

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 'Update Category')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpUpdateCategory'), 
            'CANCEL')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 
            'UPDATE')
		
		String updatedCategory = 'Coverage'

        Mobile.setText(findTestObject('Object Repository/SideBarMenu/Category/inputCategoryInPopUpUpdateCategory'), updatedCategory, 
            0)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/pageTitleCategory'), 10)
		
		String xpath = "//*[@class = 'android.widget.TextView' and (@text = '${updatedCategory}' or . = '${updatedCategory}') and @resource-id = 'com.avinashproduct.todo:id/txtCategoryName']"
		 
		TestObject dynamicCategoryObject = new TestObject('dynamicCategory')
		 
		dynamicCategoryObject.addProperty('xpath', ConditionType.EQUALS, xpath)

		Mobile.verifyElementText(dynamicCategoryObject, updatedCategory)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDeleteInsurance'), 5)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 10)
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 'Delete Category')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/messageInPopUpDeleteCategory'), 'Do you want to delete this category?')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpDeleteCategory'), 'CANCEL')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 'DELETE')
		
		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 5)

        Mobile.waitForElementNotPresent(findTestObject('Object Repository/SideBarMenu/Category/categoryInsurance'), 5)

        break
    case 'Personal':
        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/categoryPersonal'), 'Personal')

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnEditPersonal'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 
            10)

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 'Update Category')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpUpdateCategory'), 
            'CANCEL')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 
            'UPDATE')
		
		String updatedCategory = 'Private'

        Mobile.setText(findTestObject('Object Repository/SideBarMenu/Category/inputCategoryInPopUpUpdateCategory'), updatedCategory, 
            0)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/pageTitleCategory'), 10)

		String xpath = "//*[@class = 'android.widget.TextView' and (@text = '${updatedCategory}' or . = '${updatedCategory}') and @resource-id = 'com.avinashproduct.todo:id/txtCategoryName']"
		 
		TestObject dynamicCategoryObject = new TestObject('dynamicCategory')
		 
		dynamicCategoryObject.addProperty('xpath', ConditionType.EQUALS, xpath)

		Mobile.verifyElementText(dynamicCategoryObject, updatedCategory)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDeletePersonal'), 5)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 10)
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 'Delete Category')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/messageInPopUpDeleteCategory'), 'Do you want to delete this category?')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpDeleteCategory'), 'CANCEL')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 'DELETE')
		
		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 5)

        Mobile.waitForElementNotPresent(findTestObject('Object Repository/SideBarMenu/Category/categoryPersonal'), 5)

        break
    case 'Shopping':
        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/categoryShopping'), 'Shopping')

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnEditShopping'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 
            10)

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 'Update Category')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpUpdateCategory'), 
            'CANCEL')

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 
            'UPDATE')
		
		String updatedCategory = 'Spending'

        Mobile.setText(findTestObject('Object Repository/SideBarMenu/Category/inputCategoryInPopUpUpdateCategory'), 'Spending', 
            0)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/pageTitleCategory'), 10)

		String xpath = "//*[@class = 'android.widget.TextView' and (@text = '${updatedCategory}' or . = '${updatedCategory}') and @resource-id = 'com.avinashproduct.todo:id/txtCategoryName']"
		 
		TestObject dynamicCategoryObject = new TestObject('dynamicCategory')
		 
		dynamicCategoryObject.addProperty('xpath', ConditionType.EQUALS, xpath)

		Mobile.verifyElementText(dynamicCategoryObject, updatedCategory)

        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDeleteShopping'), 5)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 10)
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 'Delete Category')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/messageInPopUpDeleteCategory'), 'Do you want to delete this category?')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpDeleteCategory'), 'CANCEL')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 'DELETE')
		
		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 5)

        Mobile.waitForElementNotPresent(findTestObject('Object Repository/SideBarMenu/Category/categoryShopping'), 5)

        break
    default:
        Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnPlus'), 5)

        Mobile.waitForElementPresent(findTestObject('Object Repository/AddTask/titleAddCategory'), 10)

        Mobile.verifyElementText(findTestObject('Object Repository/AddTask/titleAddCategory'), 'Add Category')

        Mobile.setText(findTestObject('Object Repository/AddTask/InputNewCategory'), GlobalVariable.category, 0)

        Mobile.tap(findTestObject('Object Repository/AddTask/btnADDCategory'), 5)

        Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/newCategoryName'), GlobalVariable.category)
		
		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnEditNewCategory'), 10)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'),
			10)

		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpUpdateCategory'), 'Update Category')

		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpUpdateCategory'),
			'CANCEL')

		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'),
			'UPDATE')

		Mobile.setText(findTestObject('Object Repository/SideBarMenu/Category/inputCategoryInPopUpUpdateCategory'), GlobalVariable.category + 's',
			0)

		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnUPDATEInPopUpUpdateCategory'), 5)

		Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/pageTitleCategory'), 10)

		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/newCategoryName'), GlobalVariable.category + 's')
		
		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDeleteNewCategory'), 10)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 10)
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/titleInPopUpDeleteCategory'), 'Delete Category')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/messageInPopUpDeleteCategory'), 'Do you want to delete this category?')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnCANCELInPopUpDeleteCategory'), 'CANCEL')
		
		Mobile.verifyElementText(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 'DELETE')
		
		Mobile.tap(findTestObject('Object Repository/SideBarMenu/Category/btnDELETEInPopUpDeleteCategory'), 5)
		
		Mobile.waitForElementNotPresent(findTestObject('Object Repository/SideBarMenu/Category/newCategoryName'), 5)

        break
}

WebUI.callTestCase(findTestCase('Blocks/Reusable_TC/CloseApp'), [:], FailureHandling.STOP_ON_FAILURE)


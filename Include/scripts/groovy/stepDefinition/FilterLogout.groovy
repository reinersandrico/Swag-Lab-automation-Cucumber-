package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class FilterLogout {
	@When("User click icon filter dropdown")
	public void user_click_filter_dropdown() {
		WebUI.click(findTestObject('filter page/dropdown_filter'))
		
	}
	
	@When("User choose what kind filter category (.*)")
	public void user_choose_what_kind_filter_category(String filter) {
		if (filter == "name A-Z") {
//			WebUI.selectOptionByLabel(findTestObject('filter page/dropdown_filter'),'Name (A to Z)' ,false)
			WebUI.selectOptionByValue(findTestObject('filter page/dropdown_filter'), 'az', false)
			WebUI.delay(5)
			WebUI.closeBrowser()
			
		}
		else if (filter == "name Z-A") {
//			WebUI.selectOptionByLabel(findTestObject('filter page/dropdown_filter'),'Name (Z to A)' ,false)
			WebUI.selectOptionByValue(findTestObject('filter page/dropdown_filter'), 'za', false)
			WebUI.delay(5)
			WebUI.closeBrowser()
			
		}
		else if (filter == "price low to high") {
//			WebUI.selectOptionByLabel(findTestObject('filter page/dropdown_filter'),'Price (low to high)' ,false)
			WebUI.selectOptionByValue(findTestObject('filter page/dropdown_filter'), 'lohi', false)
			WebUI.delay(5)
			WebUI.closeBrowser()
			
		}
		else if (filter == "price high to low") {
//			WebUI.selectOptionByLabel(findTestObject('filter page/dropdown_filter'),'Price (high to low)' ,false)
			WebUI.selectOptionByValue(findTestObject('filter page/dropdown_filter'), 'hilo', false)
			WebUI.delay(5)
			WebUI.closeBrowser()
			
		}
		
	}
	
	@Given("User already login in account")
	public void user_already_login_in_account() {
		WebUI.verifyElementPresent(findTestObject('home page/icon_cart'), 0)
		
	}
	
	@When("User click menu bar on the top left corner")
	public void user_click_menu_bar_on_the_left_corner() {
		WebUI.click(findTestObject('home page/button_Open Menu'))
		
	}
	
	@When("User choose logout menu")
	public void user_choose_logout_menu() {
		WebUI.click(findTestObject('home page/a_Logout'))
		
	}
	@Then("User successfully logout")
	public void user_successfully_logout() {
		WebUI.verifyElementPresent(findTestObject('login page/btn_login'), 0)
		WebUI.delay(5)
		WebUI.closeBrowser()
		
	}
	
	
}
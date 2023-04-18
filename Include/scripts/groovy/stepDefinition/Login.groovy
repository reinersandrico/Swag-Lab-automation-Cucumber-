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
import com.kms.katalon.core.webui.keyword.builtin.OpenBrowserKeyword

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



class Login {

	@Given("User already open swag lab website")
	public void user_already_open_swag_lab_website() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://www.saucedemo.com/')
	}

	@When("User input fields username with correct credential {string}")
	public void user_input_fields_username_with_correct_credential(String username) {
		WebUI.setText(findTestObject('login page/input_username'), username)
	}

	@When("User input fields password with corret credential {string}")
	public void user_input_fields_password_with_corret_credential(String password) {
		WebUI.setText(findTestObject('login page/input_password'), password)
	}

	@When("User click login button")
	public void user_click_login_button() {
		WebUI.click(findTestObject('login page/btn_login'))
	}

	@Then("User susccesfully login account")
	public void user_susccesfully_login_account() {
		WebUI.verifyElementNotPresent(findTestObject('home page/verify_title'), 0)
	}
}
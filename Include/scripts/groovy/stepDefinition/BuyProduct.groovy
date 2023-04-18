package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.Delayed

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
import com.sun.org.apache.bcel.internal.generic.IFLE

import ch.qos.logback.core.joran.conditional.ElseAction
import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.apache.commons.lang.RandomStringUtils
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

import groovy.json.internal.ArrayUtils
import groovy.json.StringEscapeUtils



class BuyProduct {
	@Given("User already on home page")
	public void user_already_on_home_page() {
		WebUI.verifyElementPresent(findTestObject('home page/verify_home_page'), 0)
	}

	@When("User choose random product and click add to cart")
	public void user_choose_random_product_and_click_add_to_cart() {
		List<String> product = new ArrayList<>()
		product.addAll(Arrays.asList('product/button_product1', 'product/button_product2', 'product/button_product3', 'product/button_product4', 'product/button_product5', 'product/button_product6'))

		Random rand = new Random()
		int randProduct = rand.nextInt(product.size())
		WebUI.click(findTestObject(product.get(randProduct)))
	}


	@When("User click cart list on the top right corner")
	public void user_click_cart_list_on_the_top_right_corner() {
		WebUI.click(findTestObject('home page/icon_cart'))
	}

	@When("User click checkout button")
	public void user_click_checkout_button() {
		WebUI.verifyElementPresent(findTestObject('checkout page/verify_title_checkout'), 0)
		WebUI.click(findTestObject('checkout page/button_checkout'))
	}

	@When("User input first name in the fields")
	public void user_input_first_name_in_the_fields() {
		WebUI.setText(findTestObject('checkout page/input_first_name'), RandomStringUtils.randomAlphabetic(8))
	}

	@When("User input last name in the fields")
	public void user_input_last_name_in_the_fields() {
		WebUI.setText(findTestObject('checkout page/input_last_name'), RandomStringUtils.randomAlphabetic(8))
	}

	@When("User input postal code in the fields")
	public void user_input_postal_code_in_the_fields() {
		WebUI.setText(findTestObject('checkout page/input_postal_code'), RandomStringUtils.randomNumeric(6))
	}

	@When("User click continue button")
	public void user_click_continue_button() {
		WebUI.scrollToElement(findTestObject('checkout page/button_continue'), 0)
		WebUI.click(findTestObject('checkout page/button_continue'))
	}

	@When("User can see a list of product want to buy")
	public void user_can_see_a_list_of_product_want_to_buy() {
		WebUI.verifyElementPresent(findTestObject('checkout page/button_finish'), 0)
	}

	@When("User click finish button for to buy product")
	public void user_click_finish_button_for_to_buy_product() {
		WebUI.scrollToElement(findTestObject('checkout page/button_finish'), 0)
		WebUI.click(findTestObject('checkout page/button_finish'))
	}

	@Then("User successfully buy product")
	public void user_successfully_buy_product() {
		WebUI.verifyElementPresent(findTestObject('checkout page/verify_success_order'), 0)
		WebUI.closeBrowser()
	}


	//	scenario outline by product from detail product
	@Then("User choose product (.*)")
	public void user_choose_product(String product) {
		if (product == "product1") {
			WebUI.click(findTestObject('product/product1'))
		} else if (product == "product2") {
			WebUI.click(findTestObject('product/product2'))
		}
		else if (product == "product3") {
			WebUI.click(findTestObject('product/product3'))
		}
		else if (product == "product4") {
			WebUI.click(findTestObject('product/product4'))
		}
		else if (product == "product5") {
			WebUI.click(findTestObject('product/product5'))
		}
		else if (product == "product6") {
			WebUI.click(findTestObject('product/product6'))
		}else if (product == "empty product"){
			WebUI.verifyElementPresent('home page/icon_art', 0)
		}

	}
	@Then("User click add cart (.*) from details product")
	public void user_click_add_cart_from_details_product(String cart) {
		if (cart == "product1") {
			WebUI.click(findTestObject('product/button_product1'))
		} else if (cart == "product2") {
			WebUI.click(findTestObject('product/button_product2'))
		}
		else if (cart == "product3") {
			WebUI.click(findTestObject('product/button_product3'))
		}
		else if (cart == "product4") {
			WebUI.click(findTestObject('product/button_product4'))
		}
		else if (cart == "product5") {
			WebUI.click(findTestObject('product/button_product5'))
		}
		else if (cart == "product6") {
			WebUI.click(findTestObject('product/button_product6'))
		}


	}


	@Then("User input first name in the fields (.*)")
	public void user_input_first_name_in_the_fields(String first_name) {
		if (first_name == "random") {
			WebUI.setText(findTestObject('checkout page/input_first_name'), RandomStringUtils.randomAlphabetic(8))
		}
		else if (first_name == "empty") {
			WebUI.setText(findTestObject('checkout page/input_first_name'), '')
		}
		else {
			WebUI.setText(findTestObject('checkout page/input_first_name'), first_name)
		}

	}

	@Then("User input last name in the fields (.*)")
	public void user_input_last_name_in_the_fields(String last_name) {
		if (last_name == "random") {
			WebUI.setText(findTestObject('checkout page/input_last_name'), RandomStringUtils.randomAlphabetic(8))
		}
		else if (last_name == "empty") {
			WebUI.setText(findTestObject('checkout page/input_last_name'), '')
		}

		else {
			WebUI.setText(findTestObject('checkout page/input_last_name'), last_name)
		}

	}
	@Then("User input postal code in the fields (.*)")
	public void user_input_postal_code_in_the_fields(String postal_code) {
		if (postal_code == "random") {
			WebUI.setText(findTestObject('checkout page/input_postal_code'), RandomStringUtils.randomNumeric(8))
		}
		else if (postal_code == "empty") {
			WebUI.setText(findTestObject('checkout page/input_postal_code'), '')
		}
		else {
			WebUI.setText(findTestObject('checkout page/input_postal_code'), postal_code)
		}

	}

	@Then("User unsuccessfully buy product and get toast message (.*)")
	public void user_unsuccessfully_buy_product_and_get_toast_message(String warning) {
		if (warning == 'empty fields first name') {
			WebUI.verifyElementPresent(findTestObject('checkout page/warning_error'), 0)
			WebUI.closeBrowser()
		}
		else if (warning == 'empty fields last name') {
			WebUI.verifyElementPresent(findTestObject('checkout page/warning_error'), 0)
			WebUI.closeBrowser()
		}
		else if (warning == 'empty fields postal code') {
			WebUI.verifyElementPresent(findTestObject('checkout page/warning_error'), 0)
			WebUI.closeBrowser()
		}
	}



}
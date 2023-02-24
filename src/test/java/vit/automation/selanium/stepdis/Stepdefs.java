package vit.automation.selanium.stepdis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

	WebDriver driver;
	String url = "https://www.myntra.com";
	WebDriverWait webDriverWait;

	@Given("User is open the browser")
	public void user_is_open_the_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("User is nevigate and landing the e-commerce website page")
	public void user_is_nevigate_and_landing_the_e_commerce_website_page() {
		driver.get(url);
	}

	@When("User type the product name to be search {string}")
	public void user_type_the_product_name_to_be_search(String prodName) {
		WebElement searchProduct = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchProduct.sendKeys(prodName);

		webDriverWait = new WebDriverWait(driver, 20);
	}

	@Then("User click on selected product from the list {string}")
	public void user_click_on_selected_product_from_the_list(String productSelect) {
		System.out.println(productSelect);
		List<WebElement> listOfProducts = driver
				.findElements(By.xpath("//div//ul//li[@class='desktop-suggestion null']"));
		System.out.println(listOfProducts.size());

		for (int i = 0; i < listOfProducts.size(); i++) {
			System.out.println(listOfProducts.get(i).getText());
			webDriverWait = new WebDriverWait(driver, 20);
			if (listOfProducts.get(i).getText().equalsIgnoreCase(productSelect)) {
				listOfProducts.get(i).click();
			}
		}
	}
	
	@Then("User select the product and specification check on new tab")
	public void User_select_the_product_and_specification_check_on_new_tab() {
		WebElement proddisc=driver.findElement(By.xpath("//a//div[@class='product-productMetaInfo']//h4[text()='Men Colourblocked IDP Sneakers']"));
		proddisc.click();
		Set<String> newTab=driver.getWindowHandles();
		Iterator<String> itr=newTab.iterator();
		System.out.println(itr.next());
		System.out.println(itr.next());
	}
	

//	@Then("Search result is displayed {string}")
//	public void search_result_is_displayed(String string) {
//
//	}

	@Then("User close the window")
	public void user_close_the_window() {
		webDriverWait = new WebDriverWait(driver, 20);
		driver.quit();

	}

}

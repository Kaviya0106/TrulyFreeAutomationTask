package testscases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Baseclass;
import locators.Locators;

// This test class contains End-to-End automation test cases
// It validates the complete purchase flow from login to order placement
public class E2EPurchaseFlowTest2 extends Baseclass {

	// Product name that will be searched and added to cart
	String productName = "COOFANDY Mens Muscle";

	// login() method is used to perform user login using phone number and OTP
	public void login() throws InterruptedException {

		// Creating wait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click on Login / Account option
		driver.findElement(Locators.loginAccount).click();

		// Select country code
		wait.until(ExpectedConditions.elementToBeClickable(Locators.countryCodeDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Locators.selectIndia)).click();

		// Click phone number 
		WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginPhoneInput));
		phone.click();

		String number = "9025234653";

		// Enter phone number digit by digit
		for(char c : number.toCharArray())
		{
			phone.sendKeys(String.valueOf(c));
			Thread.sleep(100);
		}

		// Click continue button
		wait.until(ExpectedConditions.elementToBeClickable(Locators.continueBtn)).click();

		// Enter OTP
		List<WebElement> otpField = driver.findElements(Locators.otpFields);
		String otp = "1111";

		for (int i = 0; i < otpField.size(); i++) {
			otpField.get(i).sendKeys(String.valueOf(otp.charAt(i)));
		}
	}
    //Module 1- SignUp 
	// Test case to verify user SignUp functionality
	@Test(priority = 1)
	public void Signup() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click login option
		driver.findElement(Locators.loginAccount).click();

		// Click Create Account
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.createAccountBtn));
		driver.findElement(Locators.createAccountBtn).click();

		// Select country code
		wait.until(ExpectedConditions.elementToBeClickable(Locators.countryCodeDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Locators.selectIndia)).click();

		// Enter phone number
		WebElement phone1 = driver.findElement(Locators.loginPhoneInput);
		WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(phone1));

		phone.click();

		String number = "9025234653";

		for(char c : number.toCharArray())
		{
			phone.sendKeys(String.valueOf(c));
			Thread.sleep(100);
		}

		// Click Continue
		wait.until(ExpectedConditions.elementToBeClickable(Locators.continueBtn)).click();

		// Enter OTP
		List<WebElement> otpField = driver.findElements(Locators.otpFields);
		String otp = "1111";

		for (int i = 0; i < otpField.size(); i++) {
			otpField.get(i).sendKeys(String.valueOf(otp.charAt(i)));
		}

		// Enter user details
		driver.findElement(Locators.firstNameInput).sendKeys("Kaviya");
		driver.findElement(Locators.lastNameInput).sendKeys("Venkat");
		driver.findElement(Locators.emailInput).sendKeys("kaviyavenkat@gmail.com");

		// Submit account creation
		wait.until(ExpectedConditions.elementToBeClickable(Locators.createAccountSubmitBtn)).click();
	}
    // Module 2: Navigate to Brand via Side Menu
	// Test case to navigate to brand section and select a brand
	@Test()
	public void NavigateToBrand() throws InterruptedException {

		// Perform login before navigating
		login();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Enter OTP again if required
		List<WebElement> otpField = driver.findElements(Locators.otpFields);
		String otp = "1111";

		for (int i = 0; i < otpField.size(); i++) {
			otpField.get(i).sendKeys(String.valueOf(otp.charAt(i)));
		}

		// Hover on Brands menu
		WebElement brandsmenu = driver.findElement(Locators.brandsMenu);

		Actions actions = new Actions(driver);
		actions.moveToElement(brandsmenu).build().perform();

		// Select alphabet filter
		List<WebElement> alphabets = driver.findElements(Locators.alphabetList);
		wait.until(ExpectedConditions.visibilityOfAllElements(alphabets));

		for (WebElement alphabet : alphabets) {
			if (alphabet.getText().equals("a")) {
				alphabet.click();
			}
		}

		// Select brand
		List<WebElement> brands = driver.findElements(Locators.brandList);

		for (WebElement brand : brands) {
			if (brand.getText().equals("Adidas")) {
				brand.click();
				break;
			}
		}
	}
     // Module 3: Product Selection
	// Test case to select the required product
	@Test(dependsOnMethods = "NavigateToBrand")
	public void productSelection() throws InterruptedException {

		NavigateToBrand();

		// Get list of products
		List<WebElement> listOfItems = driver.findElements(Locators.productList);

		// Select the required product
		for (WebElement element : listOfItems) {
			if (element.getText().contains(productName)) {
				element.click();
				break;
			}
		}
	}
    //Module 4: Add Product to Cart
	// Test case to add selected product to cart
	@Test
	public void addProductToCart() throws InterruptedException {

		productSelection();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click Add to Cart button
		wait.until(ExpectedConditions.elementToBeClickable(Locators.addToCartBtn)).click();
	}
    //Module 5: Cart Page Validation
	// Test case to validate product in cart page
	@Test
	public void cartPageValidation() throws InterruptedException {

		// Open cart page
		WebElement cartIcon = driver.findElement(Locators.cartIcon);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(cartIcon)).click();

		// Verify product exists in cart
		List<WebElement> cartItems = driver.findElements(Locators.cartItems);

		for (WebElement element : cartItems) {

			if (element.getText().contains(productName)) {
				System.out.println("Product is present in cart");
			}
		}
	}
    // Module 6: Checkout
	// Test case to add shipping address during checkout
	@Test(dependsOnMethods = "cartPageValidation")
	public void addShippingAddress() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Proceed to checkout
		wait.until(ExpectedConditions.elementToBeClickable(Locators.proceedToCheckoutBtn)).click();

		// Click Add Address
		wait.until(ExpectedConditions.elementToBeClickable(Locators.addAddressBtn)).click();

		// Enter address details
		driver.findElement(Locators.addressLine1).sendKeys("24 Battery PI");
		driver.findElement(Locators.cityInput).sendKeys("New York");
		driver.findElement(Locators.stateInput).sendKeys("New York");
		driver.findElement(Locators.countryInput).sendKeys("United States of America");
		driver.findElement(Locators.pincodeInput).sendKeys("10004");

		// Save address
		driver.findElement(Locators.saveAddressBtn).click();

		// Continue to payment
		wait.until(ExpectedConditions.elementToBeClickable(Locators.continueToPaymentBtn)).click();

		System.out.println("Address added successfully");
	}
    //Module 7: Payment & Order Placement
	// Test case to perform payment and place order
	@Test(dependsOnMethods = "addShippingAddress")
	public void paymentAndPlaceOrder() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click Add New Card
		wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewCardBtn)).click();

		// Enter card details
		driver.findElement(Locators.cardNumberInput).sendKeys("4242 4242 4242 4242");
		driver.findElement(Locators.cardExpiryInput).sendKeys("05/28");
		driver.findElement(Locators.cardCvvInput).sendKeys("111");

		// Add card
		driver.findElement(Locators.addCardBtn).click();

		// Confirm order
		wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmOrderBtn)).click();

		Thread.sleep(8000);

		// Verify Thank You page
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.thankYouPage));

		System.out.println("Order placed successfully");
	}
    //Module 8: Order Page Validation
	// Test case to validate order details in My Orders page
	@Test()
	public void orderPageValidation() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Open user profile
		wait.until(ExpectedConditions.elementToBeClickable(Locators.profileIcon)).click();

		// Navigate to My Orders
		wait.until(ExpectedConditions.elementToBeClickable(Locators.myOrdersBtn)).click();

		// Get order ID
		String orderId = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.orderId)).getText();

		System.out.println("Order ID: " + orderId);
	}
    //Module 9:Logout 
	// Test case to verify logout functionality
	@Test(dependsOnMethods = "orderPageValidation")
	public void logout() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click profile icon
		wait.until(ExpectedConditions.elementToBeClickable(Locators.profileIcon)).click();

		// Click Sign Out
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signOutBtn)).click();

		System.out.println("User logged out successfully");
	}
}
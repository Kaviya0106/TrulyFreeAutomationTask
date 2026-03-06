package locators;

import org.openqa.selenium.By;

public class Locators {

	// Login / SignUp Module
	public static final By loginAccount = By.xpath("//div[@data-testid='login-account']");
	public static final By createAccountBtn = By.xpath("//button[text()='Create Account']");
	public static final By countryCodeDropdown = By.xpath("//div[@class='selected-flag']");
	public static final By selectIndia = By.xpath("//ul[@class='country-list']//li//span[text()='India (भारत)']"); 
	public static final By loginPhoneInput = By.id("loginPhoneInput");
	public static final By registerPhoneInput = By.id("regPhoneInput");
	public static final By continueBtn = By.xpath("//button[.='Continue']");
	public static final By continueUpperBtn = By.xpath("//button[.='CONTINUE']");
	public static final By otpFields = By.xpath("//input[@maxlength='1']");
	public static final By firstNameInput = By.xpath("//input[@data-testid='first-name-input']");
	public static final By lastNameInput = By.xpath("//input[@data-testid='last-name-input']");
	public static final By emailInput = By.xpath("//input[@data-testid='email-input']");
	public static final By createAccountSubmitBtn = By.xpath("//button[.='Create Account']");

	// Brands Navigation Module
	public static final By brandsMenu = By.xpath("//div[contains(@class,'megamenu_container')]//nav//ul//li/span");
	public static final By alphabetList = By.xpath("//div[contains(@class,'alphabet_column')]//div");
	public static final By brandList = By.xpath("//div[contains(@class,'brands_list_column')]//div//a//p");

	// Product Selection Module
	public static final By productList = By.xpath("//div[@data-testid='category-products']//div//h2");

	// Add To Cart Module
	public static final By addToCartBtn = By.xpath("//button[@id='add-to-cart-button']");
	public static final By cartIcon = By.xpath("//li[@data-testid='cart-icon']");

	// Cart Validation Module
	public static final By cartItems = By
			.xpath("//div[@class='cart_items_wrapper']//div//div[@class='cart_product_list_grp']//h2");

	// Checkout Page
	public static final By proceedToCheckoutBtn = By.xpath("//button[.='Proceed to Checkout']");

	// Address Module
	public static final By addAddressBtn = By.xpath("//button[.='Add Address']");
	public static final By addressLine1 = By.xpath("//input[@name='addressLine1']");
	public static final By cityInput = By.xpath("//input[@name='city']");
	public static final By stateInput = By.xpath("//input[@name='state']");
	public static final By countryInput = By.xpath("//input[@name='country']");
	public static final By pincodeInput = By.xpath("//input[@name='pincode']");
	public static final By saveAddressBtn = By.xpath("//button[.='Save Address']");
	public static final By continueToPaymentBtn = By.xpath("//button[.='Continue']");

	// Payment Module
	public static final By addNewCardBtn = By.xpath("//button[.='Add New Card']");
	public static final By cardNumberInput = By.xpath("//input[@name='cardNumber']");
	public static final By cardExpiryInput = By.xpath("//input[@name='expiry']");
	public static final By cardCvvInput = By.xpath("//input[@name='cvv']");
	public static final By addCardBtn = By.xpath("//button[.='Add Card']");
	public static final By confirmOrderBtn = By.xpath("//button[.='Confirm Order']");

	// Thank You Page Module
	public static final By thankYouPage = By.xpath("//h1[contains(text(),'Thank You')]");

	// Orders Module
	public static final By profileIcon = By.xpath("//div[@data-testid='profile-icon']");
	public static final By myOrdersBtn = By.xpath("//span[.='My Orders']");
	public static final By orderId = By.xpath("//div[contains(@class,'order_id')]");

	// Logout Module
	public static final By signOutBtn = By.xpath("//span[.='Sign Out']");

}
package es.crd.tests.touring;

public class Constants {

	// Expected data
	static final String STEP_1_EXPECTED_AGE = "25";
	static final String STEP_2_EXPECTED_BM = "0";
	static final String STEP_3_EXPECTED_POSTAL_CODE = "1000";
	static final String STEP_4_EXPECTED_BRAND = "TACK";
	static final String STEP_5_EXPECTED_PRICE = "25000";
	static final String STEP_6_EXPECTED_KM = "Je roule - de 5.000 km";
	static final String STEP_7_MAIL = "king.arthur@spamalot.com";
	static final String STEP_7_EXPECTED_MIN = "526";
	static final String STEP_7_EXPECTED_MED = "870";
	static final String STEP_7_EXPECTED_MAX = "1463";

	// General strings
	static final String TOURING_ULR = "https://www.touring-assurances.be/auto/quick-quote/";
	static final String XPATH_GENERIC = "//a[@class='goBack']//span[@class='val']";

	// Age test strings
	static final String NAME_AGE = "age";
	static final String XPATH_AGE = "//div[@data-target='bm']";

	// BM test strings
	static final String XPATH_BUTTON = "//button[@value='0' and @class='first']";
	static final String XPATH_BM = "//div[@data-target='postalCode']";

	// Postal code test strings
	static final String NAME_POSTAL_CODE = "postalCode";
	static final String XPATH_POSTAL_CODE = "//div[@data-target='brand']";

	// Brand test strings
	static final String CLASS_ALL_BRANDS = "allbrands";
	static final String CLASS_TACK = "TACK";
	static final String XPATH_BRAND = "//div[@data-target='priceVat']";

	// Price test strings
	static final String NAME_PRICE = "priceVat";
	static final String XPATH_PRICE = "//div[@data-target='formuleKm']";

	// Price test strings
	static final String NAME_KM = "F";
	static final String XPATH_KM = "//div[@data-target='driver_email']";

	// Email test strings
	static final String NAME_EMAIL = "driver_email";
	static final String CLASS_EMAIL = "get-tarif";
	static final String XPATH_RC = "//div[@id='formuleRC']//h4//span";
	static final String XPATH_RCPO = "//div[@id='formuleRC_PO']//h4//span";
	static final String XPATH_RCFO = "//div[@id='formuleRC_FO']//h4//span";

}

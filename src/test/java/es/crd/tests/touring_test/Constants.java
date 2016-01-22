package es.crd.tests.touring_test;

public class Constants {

	// Expected data
	static final String STEP_1_EXPECTED_AGE = "25";
	static final String STEP_2_EXPECTED_BM = "0";
	static final String STEP_3_EXPECTED_POSTAL_CODE = "1000";
	static final String STEP_4_EXPECTED_BRAND = "TACK";

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
}

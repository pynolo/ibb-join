package it.burningboots.join.shared;



public class AppConstants {

	public static final String BASE_URL= "http://ibb.tarine.net";
	public static final String EVENT_URL= "http://www.italianburningboots.org";
	public static final String EVENT_EMAIL= "registration@italianburningboots.org";
	public static final String PAYPAL_URL = "https://www.paypal.com/cgi-bin/webscr";
	//public static final String PAYPAL_URL= "https://www.sandbox.paypal.com/cgi-bin/webscr";//SANDBOX
	public static final String PAYPAL_ACCOUNT = "ibb.registration@tarine.net";
	//public static final String PAYPAL_ACCOUNT = "paolo-facilitator@tarine.net";//SANDBOX
	public static final int CODE_LENGHT = 6;
	
	public static final String CONFIG_MAX_TICKET_COUNT = "maxTicketCount";
	public static final String CONFIG_MAX_FOREIGNER_TICKET_COUNT = "maxForeignTicketCount";
	public static final String CONFIG_PRICE_TICKET = "priceFull";
	public static final String CONFIG_PRICE_FOREIGNER_TICKET = "priceForeign";
	public static final String CONFIG_PRICE_REDUCED_TICKET = "priceReduced";
	public static final String CONFIG_SERVICE_OPEN = "serviceOpen";
	
	// CONFIG FILES
	public static final String HIBERNATE_CONFIG_FILE="/hibernate.cfg.xml";
	public static final String APP_PROPERTY_FILE = "/app.properties";
	public static final String TESTING_PROPERTY_FILE = "/testing.properties";
	
	// PARAMS
	public static final String PARAMS_ID = "id";
	
	
	//PARAM VALUES
	public static final String VALUE_WIZARD_REPLACE = "replace";
	
	// FORMATS
	public static final String PATTERN_TIMESTAMP = "dd/MM/yyyy HH:mm:ss z";//"dd/MM/yyyy HH:mm";
	public static final String PATTERN_DAY = "dd/MM/yyyy";
	public static final String PATTERN_MONTH = "MM/yyyy";
	public static final String PATTERN_CURRENCY = "#0.00";
	public static final long HOUR = 3600000L;
	public static final long DAY = HOUR*24;
	public static final long MONTH = DAY*30; //millisecondi in 30 giorni 1000 * 60 * 60 * 24 * 30;
	public static final long YEAR = DAY*365; 

	// LOOKUP: RESALE TYPE
	public static final String RESALE_TYPE_SELLING = "SELL";
	public static final String RESALE_TYPE_BUYING = "BUY";

}

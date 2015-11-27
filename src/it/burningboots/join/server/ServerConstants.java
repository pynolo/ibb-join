package it.burningboots.join.server;

import it.burningboots.join.shared.AppConstants;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


public class ServerConstants {
	
	private static final Logger LOG = Logger.getLogger(ServerConstants.class);

	public static final String PROPERTY_FILE = "/app.properties";
	public static final String UPLOAD_DIRECTORY = System.getProperty("java.io.tmpdir");
	
	//public static final Charset DEFAULT_FILE_CHARSET = Charset.forName("ISO-8859-15");//Now UTF-8

	public static final SimpleDateFormat FORMAT_DAY = new SimpleDateFormat(AppConstants.PATTERN_DAY);
	public static final SimpleDateFormat FORMAT_YEAR = new SimpleDateFormat("yyyy");
	public static final SimpleDateFormat FORMAT_TIMESTAMP = new SimpleDateFormat(AppConstants.PATTERN_TIMESTAMP);
	public static final SimpleDateFormat FORMAT_FILE_NAME_TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	public static final SimpleDateFormat FORMAT_FILE_NAME_DAY = new SimpleDateFormat("yyyy-MM-dd");
	public static final DecimalFormat FORMAT_CURRENCY = new DecimalFormat(AppConstants.PATTERN_CURRENCY);
	public static Date DATE_FAR_PAST;
	public static Date DATE_FAR_FUTURE;
	static {
		try {
			DATE_FAR_PAST = FORMAT_DAY.parse("01/01/1000");
			DATE_FAR_FUTURE = FORMAT_DAY.parse("01/01/3000");
		} catch (ParseException e) {
			LOG.error(e.getMessage(), e);
		}
	}

}

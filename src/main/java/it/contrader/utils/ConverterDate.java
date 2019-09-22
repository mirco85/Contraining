package it.contrader.utils;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ConverterDate {
	/**
	 * Converte un tipo Date da database in stringa nel formato dd/MM/yyyy
	 * @param d
	 * @return
	 */
	public static String dateToString(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String f = sdf.format(d);
		return f;
	}
	
	private static boolean isSQLCorrectFormat(String dateString) {
		SimpleDateFormat sqlCorrect = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sqlCorrect.parse(dateString);
		} catch(ParseException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Prende una stringa data nel formato leggibile dd/MM/yyyy e lo traduce in stringa nel formato ISO
	 * Sql nel formato yyyy-MM-dd
	 * @param dateString
	 * @return
	 */
	public static String toDateString(String dateString) {
		if(isSQLCorrectFormat(dateString)) {
			return dateString;
		}
		
		SimpleDateFormat fromModel = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat toSQL = new SimpleDateFormat("yyyy-MM-dd");
		
		String sqlDateString = "2000-01-01";
		try {
			sqlDateString = toSQL.format(fromModel.parse(dateString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// no format known
		}
		return sqlDateString;
	}
	
	/**
	 *  converte un oggetto di tipo string in oggetto di tipo Date
	 * @param dateString
	 * @return
	 */
	public static Date toDate(String dateString) {
		return Date.valueOf(toDateString(dateString));
	}
	
	
	

}

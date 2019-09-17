package it.contrader.utils;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ConverterDate {
	
	public static String dateToString(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		return sdf.format(d);
	}
	
	public static String toDate(String dateString) {
		SimpleDateFormat fromModel = new SimpleDateFormat("dd/mm/yyyy");
		SimpleDateFormat toSQL = new SimpleDateFormat("yyyy-mm-dd");
		
		String sqlDateString = "2000-01-01";
		try {
			sqlDateString = toSQL.format(fromModel.parse(dateString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDateString;
		
	}
	
	
	

}

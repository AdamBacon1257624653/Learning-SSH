package edu.ecjtu.Converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
	private SimpleDateFormat format;
	{
		format = new SimpleDateFormat("yyyy-MM-dd");
	}

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (toClass == Date.class) {
			try {
				return format.parse(values[0]);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		if (o instanceof Date) {
			return format.format((Date) o);
		}
		return null;
	}

}

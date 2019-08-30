package co.com.jjoc.aspects.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MaskUtils {

	public static void applyMaskRule(Object ob) {

		try {
			Field[] fields = ob.getClass().getDeclaredFields();

			for (Field field : fields) {
				if (field.isAnnotationPresent(Mask.class)) {
					MaskUtils.handleMask(field.getAnnotation(Mask.class), ob, field);

				}
			}

		} catch (Exception e) {
			throw new RuntimeException("error");
		}
	}

	public static void handleMask(Mask mask, Object ob, Field field) throws Exception {

		Object value = null;

		try {

			value = MaskUtils.maskString(MaskUtils.getProperty(ob, field).toString(), mask.from(), mask.end(), mask.charMask());

			MaskUtils.setProperty(ob, field, value);

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String maskString(String strText, int start, int end, String maskChar) throws Exception {

		if(strText == null || strText.equals(""))
			return "";

		if(start < 0)
			start = 0;

		if( end > strText.length() )
			end = strText.length();

		if(start > end)
			throw new Exception("End index cannot be greater than start index");

		int maskLength = end - start;

		if(maskLength == 0)
			return strText;

		StringBuilder sbMaskString = new StringBuilder(maskLength);

		for(int i = 0; i < maskLength; i++){
			sbMaskString.append(maskChar);
		}

		return strText.substring(0, start)
			+ sbMaskString.toString()
			+ strText.substring(start + maskLength);
	}

	public static void setProperty(Object ob, Field field, Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

		PropertyDescriptor pd = new PropertyDescriptor(field.getName(), ob.getClass());
		pd.getWriteMethod().invoke(ob, value);

	}

	public static  Object getProperty(Object ob, Field field) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

		PropertyDescriptor pd = new PropertyDescriptor(field.getName(), ob.getClass());
		return pd.getReadMethod().invoke(ob);

	}

}

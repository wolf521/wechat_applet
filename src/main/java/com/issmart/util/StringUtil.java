package com.issmart.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具类
 */
public class StringUtil {

	// 自增ID范围值，10的倍数
	private static int _iRange = 1000;
	// 用于id生成的自增值
	private static int _iInc = 2;
	
	public static boolean isValidString(String strValue) {
		if (strValue == null || strValue.trim().equals("") || strValue.equalsIgnoreCase("NULL")
				|| strValue.equals("undefined")) {
			return false;
		}
		return true;
	}

	public static boolean isValidValue(String str) {
		if (str == null) {
			return false;
		}
		if (str.trim().equals("")) {
			return false;
		}
		return true;
	}

	public static boolean isEmpty(String strValue) {
		if (strValue == null || strValue.equals("") || strValue.equalsIgnoreCase("NULL")) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String strValue) {
		if (strValue == null || strValue.equals("") || strValue.equalsIgnoreCase("NULL")) {
			return false;
		}
		return true;
	}

	public static boolean isValid(Object strValue) {
		if (strValue == null || "".equals(strValue) || strValue.toString().equalsIgnoreCase("null")) {
			return false;
		}
		return true;
	}

	public static String getBlankString(String strValue) {
		if (strValue == null || strValue.equals("") || strValue.equalsIgnoreCase("NULL")) {
			return "";
		}
		return strValue;
	}

	public static Short getZeroShort(Short strValue) {
		if (strValue == null) {
			return 0;
		}
		return strValue;
	}

	public static boolean checkExists(String[] source, String checkStr) {
		if (source.length > 0 && isValidString(checkStr)) {
			for (int i = 0; i < source.length; i++) {
				if (source[i].equals(checkStr.trim()))
					return true;
			}
		}
		return false;
	}

	/**
	 * 是否为空
	 * 
	 * @param value
	 * @return
	 */
	public static BigDecimal isNull(Double value) {
		if (null == value || value.isNaN()) {
			return BigDecimal.ZERO;
		}
		return BigDecimal.valueOf(value);
	}

	public static Double isNullBigDecimal(BigDecimal value) {
		if (null == value) {
			return new Double("0");
		}
		return value.doubleValue();
	}

	/**
	 * 数值为空验证
	 * 
	 * @param value
	 * @return
	 */
	public static BigDecimal isNullNumber(BigDecimal value) {
		if (null == value) {
			return BigDecimal.ZERO;
		}
		return value;
	}

	/**
	 * email合法验证
	 * 
	 * @param value
	 * @return
	 */
	public static boolean checkEmail(String value) {
		if (null == value || value == "") {
			return false;
		} else {
			return value.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		}
	}

	/**
	 * 验证字符串是否为数字
	 * 
	 * @param value
	 * @return
	 * @date 2015-2-26 下午2:04:44
	 * @author moke
	 */
	public static boolean isNumber(String value) {
		if (StringUtil.isEmpty(value))
			return false;
		return value.trim().matches("^[0-9]+$");
	}

	/**
	 * 验证字符串是否为合法的日期格式
	 * 
	 * @param value
	 * @return
	 * @date 2015-2-26 下午2:14:26
	 * @author moke
	 */
	public static boolean isDate(String value) {
		if (StringUtil.isEmpty(value))
			return false;

		String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\s]?((((0?[13578])|(1[02]))[\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\s]?((((0?[13578])|(1[02]))[\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(value.trim());
		return m.matches();
	}

	/**
	 * 验证字符串是否为合法时间格式
	 * 
	 * @param value
	 *            HH:mm
	 * @return
	 * @date 2015-2-27 下午7:05:00
	 * @author moke
	 */
	public static boolean isTime(String value) {
		if (StringUtil.isEmpty(value))
			return false;

		String eL = "^(([01]{1}(\\d)|2[0-3]{1}):([0-5]{1}(\\d)))$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(value.trim());
		return m.matches();
	}

	/**
	 * 验证字符串是否为双精度浮点型
	 * 
	 * @return 0.00 <= v <= 9999999.99
	 * @date 2015-2-27 下午8:02:21
	 * @author moke
	 */
	public static boolean isDouble(String value) {
		if (StringUtil.isEmpty(value))
			return false;

		String eL = "^([1-9][\\d]{0,7}|0)(\\.[\\d]{1,2})?$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(value.trim());
		return m.matches();
	}

	public static boolean isValidate(String[] values) {
		return (null != values) && (values.length > 0);
	}

	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 截取给定长度的某个字符串, 根据中文字符的长度截取
	 * 
	 * @param _strSource
	 *            要截取的字符串
	 * @param _iSubLength
	 *            要截取的长度
	 * @param _strEnd
	 *            截取后,字符串后边显示的字符串
	 */
	public static String getSubString(String _strSource, int _iSubLength, String _strEnd) {
		String strSource = _strSource;
		String strEnd = _strEnd;
		int iSubLength = _iSubLength * 2;
		int iLength = iSubLength;
		int iSymbol = 0;

		// 参数都不为null值再处理
		if (null != strSource) {
			try {
				if (iSubLength > 0) {
					byte[] byteSource = strSource.getBytes();

					if (iSubLength < byteSource.length) {
						for (int i = 0; i < iSubLength; i++) {
							// 如果当前字节<0,则为中文的其中一个字节,中文标记 + 1
							if (byteSource[i] < 0)
								iSymbol++;

							// 如果是中文第二个字节,则要把中文标记清 0
							if (iSymbol == 2)
								iSymbol = 0;
						}

						if (iSymbol == 1) // 中文字符的前个字节,不截取当前中文,字节位-1
						{
							iLength--;
						} else if (iSymbol == 2) // 中文字符的后个字节,截取在当前中文,字节位+1
						{
							iLength++;
						}

						// 构造新的返回串
						strSource = new String(byteSource, 0, iLength);

						if (null != strEnd)
							strSource += strEnd;

						byteSource = null;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// strSource = "";
		}

		return strSource;
	}

	/**
	 * 替换字符串中的某个子串为另外一个字符串
	 * 
	 * @param _strFind
	 *            要被替换的子串
	 * @param _strReplacement
	 *            要替换的字符串
	 * @param _strOld
	 *            要被处理的字符串
	 */
	public static String regReplace(String strFind, String strReplacement, String strOld) {
		String strNew = strOld;
		try {
			if (strOld != null && strFind != null && strReplacement != null) {
				Pattern p = null;
				Matcher m = null;
				p = Pattern.compile(strFind);
				m = p.matcher(strOld);
				strNew = m.replaceAll(strReplacement);
			}
		} catch (Exception e) {
		}

		return strNew;
	}

	/**
	 * 获取字符串SID
	 * 
	 * @return id字符串
	 */
	public static String getSID() {
		return String.valueOf(getID());
	}

	/**
	 * 获取数字ID
	 * 
	 * @return id数字
	 */
	public static long getID() {
		long result = -1;
		try {
			/*
			 * 暂时不用数据库生成 String sql = " select SEQUENCE_1.nextval from dual ";
			 * Map map = null; map = new HashMap(); map.put("NEXTVAL",
			 * Hibernate.LONG); List list = this.getDao().querySQLObjects(sql,
			 * null, map); if (list != null && !list.isEmpty()) { map = (Map)
			 * list.get(0); if (map != null && map.get("NEXTVAL") != null &&
			 * StringUtils.isNum(map.get("NEXTVAL").toString())) { result =
			 * Long.parseLong(map.get("NEXTVAL").toString()); } }
			 */
			if (result < 0) {
				if (_iInc >= _iRange) {
					_iInc = 2;
				}
				if (_iInc == 2) {
					// 如果是从新开始的自增值，那么就等待1毫秒，以避免新值比旧值小
					// 不睡眠，免得造成死锁
					// Thread.currentThread().wait(5);
				}
				result = System.currentTimeMillis() * _iRange + ++_iInc;
			}
		} catch (Exception e) {
			System.out.println(new Date() + "：获取ID出错。");
			e.printStackTrace();
			// 如果系统出错，就按照正常方式获取id值
			if (_iInc >= _iRange) {
				_iInc = 2;
			}
			result = System.currentTimeMillis() * _iRange + ++_iInc;
		}
		return result;
	}

	/**
	 * Get请求乱码转换为UTF-8
	 * 
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static String convert(String str) throws IOException {
		// 判断当前字符串的编码格式
		if( str == null ){ return null; }
		if (str.equals(new String(str.getBytes("ISO-8859-1"), "ISO-8859-1"))) {
			str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		}
		return str;
	}
	//............新增
	public static boolean isBigDouble(String value) {
		if (StringUtil.isEmpty(value))
			return false;
		
		String eL = "^([1-9][\\d]{0,9}|0)(\\.[\\d]{1,6})?$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(value.trim());
		return m.matches();
	}
	
	/**
	 * 获取16进制字符串取反结果
	 * 
	 * @param str
	 * @return
	 */
	public static StringBuffer getReverse(String str){
		StringBuffer result = new StringBuffer();
		for(int i = 0;i<str.length();i++) {
			result.append(Integer.toString (Integer.parseInt (Integer.toBinaryString(~Integer.parseInt(str.charAt(i)+"", 16)).substring(28), 2), 16).toUpperCase());
		}
		return result;
	}
	
	public static void main(String[] args) {
//		System.out.println(getReverse(convertStr("85962CB74B4F")));
		System.out.println(getIOSBeaconMac("F166250D-070F-0807-0605-FF011A544D53"));
	}
	
	public static String convertStr(String str){ 
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(str.charAt(10));
		stringBuffer.append(str.charAt(11));
		stringBuffer.append(str.charAt(8));
		stringBuffer.append(str.charAt(9));
		stringBuffer.append(str.charAt(6));
		stringBuffer.append(str.charAt(7));
		stringBuffer.append(str.charAt(4));
		stringBuffer.append(str.charAt(5));
		stringBuffer.append(str.charAt(2));
		stringBuffer.append(str.charAt(3));
		stringBuffer.append(str.charAt(0));
		stringBuffer.append(str.charAt(1));
        return stringBuffer.toString();      
    }
	
	/**
	 * 获取扫描到的IOS的beaconMac
	 * 
	 * @param str
	 * @return
	 */
	public static String getIOSBeaconMac(String str){
		return StringUtil.getReverse(convertStr(str.replaceAll("-", "").substring(0, 12))).toString();
	}

	/**
	 * 获取扫描到的Android的beaconMac
	 * 
	 * @param str
	 * @return
	 */
	public static String getAnaroidBeaconMac(String str){
		return str.replaceAll(":", "");
	}
	
	/**
	 * 返回十六进制数字前三维数字之和与运算FF比较结果
	 * 第一个DA= (F0 + F8 + F2 ) & 0xFF
	 * @param verify
	 * @param frontBeaconMac
	 * @return
	 */
	public static Boolean verifyTargetBeaconMac(String verify, String beaconMac) {

		boolean point = false;

		// 转换成10进制
		Integer mb1 = Integer.parseInt(beaconMac.substring(0, 2), 16);
		Integer mb2 = Integer.parseInt(beaconMac.substring(2, 4), 16);
		Integer mb3 = Integer.parseInt(beaconMac.substring(4, 6), 16);
		Integer result = Integer.parseInt(verify, 16);

		// 总和  & 255
		Integer mbs = (mb1 + mb2 + mb3) & 255;

		if (result.equals(mbs)) {
			point = true;
		}

		return point;

	}
	
	//218 第一个DA= (F0 + F8 + F2 ) & 0xFF
//	public static void main(String[] args) {
//		System.out.println((240 + 248 +242) & 255);
//	}
}

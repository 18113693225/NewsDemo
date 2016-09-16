package com.apps.android.news.news.utils.util;

/**
 * 字符串处理工具类，提供了一些对字符串进行处理的静态方法
 */
public final class StringUtils {
	/* 私有的构造方法，保证此类不能外部被实例化 */
	private StringUtils() {
	}

	/**
	 * 如果字符串等于null、空白字符(“”)、空格(“ ”)则返回true,否则返回false
	 * 
	 * @param str
	 *            String 要比较的字符串
	 * @return boolean
	 */
	public static boolean isBlank(String str) {
		boolean b = true;
		if (null == str) {
			return b;
		}

		str = str.trim(); // 去掉空格
		if (!str.equals("")) { // 如果不等于“”空字符则返回值为false
			b = false;
		}
		return b;
	}

	/**
	 * 如果字符串不等于null、空白字符(“”)、空格(“ ”)则返回true,否则返回false
	 * 
	 * @param str
	 *            String 要比较的字符串
	 * @return boolean
	 */
	public static boolean isNotBlank(String str) {
		return (!isBlank(str));
	}

	/**
	 * 如果字符串等于null、空白字符("")、空格(" ")则返回空白字符(""), 否则返回一个将字符串的前后空格去掉的字符串
	 * 
	 * @param str
	 *            String 要处理的字符串
	 * @return String
	 */
	public static String trimToBlank(String str) {
		String s = "";
		if (isBlank(str)) {
			return s;
		}
		s = str.trim();
		return s;
	}

	/**
	 * 如果字符串等于null、空白字符("")、空格(" ")则返回null, 否则返回一个将字符串的前后空格去掉的字符串
	 * 
	 * @param str
	 *            String 要处理的字符串
	 * @return String
	 */
	public static String trimToNull(String str) {
		String s = null;
		if (isBlank(str)) {
			return s;
		}
		s = str.trim();
		return s;
	}

	/**
	 * 将对象使用指定的分隔符转换成一个字符串，
	 * 
	 * @param delimiter
	 *            分隔符
	 * @param ignore
	 *            为true忽略null值
	 * @param objs
	 *            分隔对象
	 * @return
	 */
	public static String join(String delimiter, boolean ignore, Object... objs) {
		if (objs == null || 0 == objs.length) {
			return "";
		}
		StringBuffer bf = new StringBuffer();
		Object obj = null;
		int ind = 0;
		for (int i = 0; i < objs.length; i++) {
			obj = objs[i];
			if (null == obj && true == ignore) {
				continue;
			} else {
				if (0 == ind) {
					bf.append(obj);
				} else {
					bf.append(delimiter).append(obj);
				}
				ind++;
			}
		}
		return bf.toString();
	}

	/**
	 * 使用指定的分隔符将字符串分割成一个字符串数组
	 * 
	 * @param input
	 *            字符串
	 * @param delimiter
	 *            分隔符
	 * @return
	 */
	public static String[] split(String input, String delimiter) {
		String[] values = new String[] { input };
		if (null != input && null != delimiter
				&& -1 != input.indexOf(delimiter)) {
			values = input.split(delimiter);
		}
		return values;
	}

	/**
	 * 将特殊字符(<、>、"、'等)转换成对应的实体
	 * 
	 * @param s
	 *            需要转换的字符串
	 * @return
	 */
	public static final String htmlEncode(String s) {
		return htmlEncode(s, true);
	}

	/**
	 * 将特殊字符(<、>、"、'等)转换成对应的实体
	 * 
	 * @param s
	 *            需要转换的字符串
	 * @param encodeSpecialChars
	 *            对特殊字符进行编码
	 * @return
	 */
	public static final String htmlEncode(String s, boolean encodeSpecialChars) {
		s = trimToBlank(s);
		StringBuffer str = new StringBuffer();
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (c < '\200') {
				switch (c) {
				case 34: // '"'
					str.append("&quot;");
					break;

				case 38: // '&'
					str.append("&amp;");
					break;

				case 60: // '<'
					str.append("&lt;");
					break;

				case 62: // '>'
					str.append("&gt;");
					break;

				default:
					str.append(c);
					break;
				}
				continue;
			}
			if (encodeSpecialChars && c < '\377') {
				String hexChars = "0123456789ABCDEF";
				int a = c % 16;
				int b = (c - a) / 16;
				String hex = (new StringBuilder()).append("").append(
						hexChars.charAt(b)).append(hexChars.charAt(a))
						.toString();
				str.append((new StringBuilder()).append("&#x").append(hex)
						.append(";").toString());
			} else {
				str.append(c);
			}
		}

		return str.toString();
	}

	/**
	 * 在每一个类里面写一个main方法,可以很方便的 对这个类进行测试
	 * 
	 * @param args
	 *            String[]
	 */
	public static void main(String[] args) {
		// String s = null;
		// System.out.println(isBlank(s));
		// System.out.println(isNotBlank(s));
		//
		// s = "";
		// System.out.println(isBlank(s));
		// System.out.println(isNotBlank(s));
		//
		// s = " ";
		// System.out.println(isBlank(s));
		// System.out.println(isNotBlank(s));
		//
		// s = " ";
		// System.out.println("[" + trimToNull(s) + "]");
		// System.out.println("[" + trimToBlank(s) + "]");

		// System.out.println(StringUtils.join(",", "ddd", null, "fff"));

		// String input = "aa , bb, ccc";
		// String[] arr = StringUtils.split(null, "z");
		// System.out.println(StringUtils.join("-", arr));
		// System.out.println(arr.length);
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }
		//
		// System.out.println(StringUtils.join("-", (Object[]) new Integer[] {
		// 11,
		// 22 }));

		// System.out.println(StringUtils.join(",", false, new Object[] { null,
		// "a", 2, 3, null }));

		// String str = "<br>？";
		// System.out.println(htmlEncode(str, true));
		// System.out.println('\377');
	}
}

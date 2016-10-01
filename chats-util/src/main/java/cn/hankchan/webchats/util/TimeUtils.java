package cn.hankchan.webchats.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

	public static final int ONE_MINUTE = 60 * 1000;
	public static final int SIX_MINUTES = 6 * ONE_MINUTE;
	public static final int THIRTY_MINUTES = 30 * ONE_MINUTE;
	public static final int ONE_HOUR = 60 * ONE_MINUTE;
	public static final long ONE_DAY = 24 * ONE_HOUR;

	static final DateFormat ISO8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static class Format {
		DateFormat dateFormat;
		public Format(String format) {
			dateFormat = new SimpleDateFormat(format);
		}
		
		/**
		 * 将当前字符串转成日期对象
		 * @param string： 日期字符串
		 * @return
		 */
		public Date parse(String string) {
			try {
				return dateFormat.parse(string);
			} catch(ParseException x) {
				throw new RuntimeException(x);
			}
		}
		
		/**
		 * 将日期对象转成日期字符串
		 * @param date： 日期对象
		 * @return
		 */
		public String format(Date date) {
			return dateFormat.format(date);
		}
		
		/**
		 * 求出当前多少分钟后的日期字符串
		 * @param string： 当前时间字符串
		 * @param minutes： 间隔的分钟数
		 * @return
		 */
		public String addMinutes(String string, int minutes) {
			try {
				long startMillis = dateFormat.parse(string).getTime();
				return dateFormat.format(new Date(startMillis + minutes * ONE_MINUTE));
			} catch(ParseException x) {
				return null;
			}
		}
		
		/**
		 * 求出当前多少小时后的日期字符串
		 * @param string： 当前时间字符串
		 * @param hours： 间隔的小时数
		 * @return
		 */
		public String addHours(String string, int hours) {
			try {
				long startMillis = dateFormat.parse(string).getTime();
				return dateFormat.format(new Date(startMillis + hours * ONE_HOUR));
			} catch(ParseException x) {
				return null;
			}
		}
		
		/**
		 * 求出当前多少天后的日期字符串
		 * @param string： 当前时间字符串
		 * @param days： 间隔的天数
		 * @return
		 */
		public String addDays(String string, int days) {
			try {
				Date date = dateFormat.parse(string);
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.DATE, days);
				return dateFormat.format(c.getTime());
			} catch(ParseException x) {
				return null;
			}
		}
		
		/**
		 * 求出当前多少月后的日期字符串
		 * @param string： 当前时间字符串
		 * @param days： 间隔的月数
		 * @return
		 */
		public String addMonths(String string, int month) {
			try {
				Date date = dateFormat.parse(string);
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.MONTH, month);
				return dateFormat.format(c.getTime());
			} catch(ParseException x) {
				return null;
			}
		}
		
		/**
		 * 求出当前多少小时后的日历对象
		 * @param string： 当前时间字符串
		 * @param hours： 间隔的小时数
		 * @return
		 */
		public Calendar addHoursAsCalendar(String string, int hours) {
			try {
				Date date = dateFormat.parse(string);
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.HOUR, hours);
				return c;
			} catch(ParseException x) {
				return null;
			}
		}
		
		/**
		 * 计算两个日期之间的小时数
		 * @param currentTime: 当前日期字符串
		 * @param nextTime： 下一个日期字符串
		 * @return： 两个时间之间的小时差
		 */
		public int betweenHours(String currentTime, String nextTime)
		{
			try {
				Date date1 = dateFormat.parse(currentTime);
				Date date2 = dateFormat.parse(currentTime);
				long totalMicroSecond = date1.getTime() - date2.getTime();
				int hours = (int)(totalMicroSecond / ONE_HOUR); 
				return hours;
			} catch(ParseException x) {
				return 0;
			}
		}
		
		/**
		 * 将当前时间字符串转成标准的时间字符串
		 * @param string: 当前时间字符串
		 * @return
		 */
		public String toISO8601(String string) {
			try {
				Date date = dateFormat.parse(string);
				return ISO8601_FORMAT.format(date);
			} catch(ParseException x) {
				return null;
			}
		}
	}
	
	public static Format ISO8601 = new Format("yyyy-MM-dd HH:mm:ss");
	public static Format YYYYMM = new Format("yyyyMM");
	public static Format YYYYMMDD = new Format("yyyyMMdd");
	public static Format YYYYMMDDHH = new Format("yyyyMMddHH");
	public static Format YYYYMMDDHHMM = new Format("yyyyMMddHHmm");
	public static Format YYYYMMDDHHMMSS = new Format("yyyyMMddHHmmss");
	public static Format YYYYMMDDHHMMSSFFF = new Format("yyyyMMddHHmmssSSS");

}

package com.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author:qiulida
 * @Modified Date:
 * @Version:1.0
 */
public class DateHelper {

	public static final String COMMON_DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 得到某天的开始时间
	 * 
	 * @param date
	 *            该天中的任意时间
	 * @return String 一天的起始时间
	 */
	public static String getDayStartDate(Date date, String format) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return DateFormatUtils.format(calendar, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	public static String getDayStartDate(Date date) {
		return getDayStartDate(date, COMMON_DATE_FORMATE);
	}

	/**
	 * 得到某天的开始时间
	 * 
	 * @param dateStr
	 *            该天中的任意时间
	 * @return String 一天的起始时间
	 */
	public static String getDayStartDate(String dateStr, String format) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(parseDate(dateStr, format));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return DateFormatUtils.format(calendar, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	/**
	 * 得到某天的结束时间
	 * 
	 * @param date
	 *            该天中的任意时间
	 * @return String 一天的结束时间
	 */
	public static String getDayEndDate(Date date, String format) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return DateFormatUtils.format(calendar, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	public static String getDayEndDate(Date date) {
		return getDayEndDate(date, COMMON_DATE_FORMATE);
	}

	/**
	 * 得到某天的结束时间
	 * 
	 * @param dateStr
	 *            该天中的任意时间
	 * @return String 一天的结束时间(yyyy-MM-dd HH:mm:ss) E.P 2015-05-21 23:59:59
	 */
	public static String getDayEndDate(String dateStr, String format) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(parseDate(dateStr, format));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return DateFormatUtils.format(calendar, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	/**
	 * 得到昨天的开始时间
	 * 
	 * @param date
	 *            该天中的任意时间
	 * @return String 昨天的起始时间 E.P 2015-05-21 00:00:00
	 */
	public static String getYesterdayStartDate(Date date, String format) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return DateFormatUtils.format(calendar, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	/**
	 * 得到昨天的结束时间
	 * 
	 * @param date
	 *            该天中的任意时间
	 * @return String 昨天的结束时间 E.P 2015-05-21 23:59:59
	 */
	public static String getYesterdayEndDate(Date date, String format) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return DateFormatUtils.format(calendar, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	/**
	 * 得到昨天的时间
	 * 
	 * @param date
	 *            时间
	 * @return Date 昨天的时间 E.P 2015-05-21 12:05:05
	 */
	public static Date getYesterdayDate(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);

		return calendar.getTime();
	}

	/**
	 * 格式化指定格式的日期字符串
	 * 
	 * @param dateStr
	 *            格式 2015/05/26
	 * @return
	 */
	public static Date parseDate(String dateStr, String format) {
		try {
			return DateUtils.parseDate(dateStr, format);
		} catch (ParseException e) {
			return  null;
		}
	}

	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, COMMON_DATE_FORMATE);
	}

	public static String formatDate(Date date) {
		return formatDate(date, null);
	}

	public static String formatDate(Date date, String format) {
		return DateFormatUtils.format(date, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	/**
	 * 得到该月开始的时间
	 * 
	 * @param date
	 *            时间
	 * @return Date 该月初的时间 E.P 2015-05-01 00:00:00
	 */
	public static String getMonthStartDate(String date, String format) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(parseDate(date, format));

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return DateFormatUtils.format(calendar, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	/**
	 * 得到该月结束的时间
	 * 
	 * @param date
	 *            时间
	 * @return Date 该月末的时间 E.P 2015-05-01 23:59:59
	 */
	public static String getMonthEndDate(String date, String format) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(parseDate(date, format));

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return DateFormatUtils.format(calendar, StringUtils.isBlank(format) ? COMMON_DATE_FORMATE : format);
	}

	public static Date getDayStart(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static Date getDayEnd(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	public static Date monthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	public static Date monthStart(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 获取两日期的间隔天数
	 * 
	 * @param from
	 * @param to
	 * @return from-to
	 */
	public static int diffDays(Date from, Date to) {
		try {
			return (int) ((to.getTime() - from.getTime()) / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
            ;return 1;
		}
	}

	/**
	 * 获取两日期的间隔小时数
	 * 
	 * @param from
	 * @param to
	 * @return to-from
	 */
	public static int diffHours(Date from, Date to) {
		try {
			return (int) ((to.getTime() - from.getTime()) / (1000 * 60 * 60));
		} catch (Exception e) {
			;return 1;
		}
	}

	/**
	 * 获取两日期的间隔分钟数
	 * 
	 * @param from
	 * @param to
	 * @return to-from
	 */
	public static int diffMinutes(Date from, Date to) {
		try {
			return (int) ((to.getTime() - from.getTime()) / (1000 * 60));
		} catch (Exception e) {
            ;return 1;
		}
	}

	/**
	 * 获取两日期的间隔秒数
	 * 
	 * @param from
	 * @param to
	 * @return to-from
	 */
	public static int diffSeconds(Date from, Date to) {
		try {
			return (int) ((to.getTime() - from.getTime()) / 1000);
		} catch (Exception e) {
            ;return 1;
		}
	}

	/**
	 * 时间是否在指定时间区间内
	 * 
	 * @param targetDate
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean isRange(Date targetDate, Date startDate, Date endDate) {
		return targetDate.after(startDate) && targetDate.before(endDate);
	}

	/**
	 * 判断日期字符是否是指定日期格式
	 * 
	 * @param str
	 * @param parsePatterns
	 * @return
	 */
	public static boolean isDate(String str, String... parsePatterns) {
		if (StringUtils.isBlank(str) || parsePatterns == null || parsePatterns.length == 0) {
			return false;
		}

		boolean isDate = false;

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setLenient(false);

		for (String pattern : parsePatterns) {
			try {
				sdf.applyPattern(pattern);
				sdf.parse(str);
				isDate = true;

				break;
			} catch (Exception e) {

			}
		}

		return isDate;
	}

	/**
	 * 两个日志在某一维度比较是否一致
	 * 
	 * @param date1
	 * @param date2
	 * @param field
	 * @return
	 */
	public static boolean isSameDate(Date date1, Date date2, int field) {
		return DateUtils.truncatedCompareTo(date1, date2, field) == 0;
	}

	public static Date addSeconds(Date date, int interval) {
		return DateUtils.addSeconds(date, interval);
	}

	public static Date addMinutes(Date date, int interval) {
		return DateUtils.addMinutes(date, interval);
	}

	public static Date addHours(Date date, int interval) {
		return DateUtils.addHours(date, interval);
	}

	public static Date addDays(Date date, int interval) {
		return DateUtils.addDays(date, interval);
	}

	public static Date addMonths(Date date, int interval) {
		return DateUtils.addMonths(date, interval);
	}

	/**
	 * 判断日期字符串是否为指定格式
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	@Deprecated
	public static boolean checkTimeFormat(String dateStr, String... format) {
		try {
			DateUtils.parseDate(dateStr, format);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String args[]) throws ParseException {
		// System.out.println(getDayStart(new Date()));
		// System.out.println(getDayEnd(new Date()));
		// System.out.println(getMonthEndDate("2016-11-08 10:42:22",
		// "yyyy-MM-dd HH:mm:ss"));
		//
		// Date startTime = parseDate("2017-03-14 20:00:00");
		// Date endTime = parseDate("2017-03-16 10:00:00");
		//
		// System.out.println(DateUtils.truncatedCompareTo(endTime, startTime,
		// Calendar.MONTH));
		// System.out.println(diffDays(startTime, endTime));
		// System.out.println(diffHours(startTime, endTime));

		System.out.println(DateUtils.parseDate("002545295957828000000", "yyyyMMddHHmmss"));
		System.out.println(isDate("1545295957828", "yyyyMMddHHmmss"));
		System.out.println(checkTimeFormat("001545295957828000000", "yyyyMMddHHmmss"));
	}

}

package io.naztech.DatePrac;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Converter {

	public static LocalDate FromDateToLocaldate(Date date) {

		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

	}

	public static Date FromLocaldateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static Calendar fromDateToCalenderDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	// calender to date
	public static Date FromCalenderToDate(Calendar calendar) {
		return calendar.getTime();
	}

	// calender to local date
	public static LocalDate FromCalenderToLocalDate(Calendar c) {
		LocalDate ld = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		return ld;

	}

	/// calendar to local time
	public static LocalTime FromCalenderToLocalTime(Calendar c) {
		LocalTime ld = LocalTime.of(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
		return ld;

	}

	/// calender to local timedate
	public static LocalDateTime FromCalenderToLocalDateTime(Calendar c) {
		LocalDateTime ld = LocalDateTime.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),
				c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
		return ld;

	}

	// calendar to time zone
	public static TimeZone FromCalendarToTimezone(Calendar c) {
		TimeZone tZone = c.getTimeZone();
		return tZone;
	}
	

	public static LocalDateTime FromCalendaeDatetoLocalDateTime(Calendar cal) {
		TimeZone tz = cal.getTimeZone();
		ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		return LocalDateTime.ofInstant(cal.toInstant(), zid);
	}
	
	
	public static ZonedDateTime fromCalendarToZonedTime(Calendar c)
	{
		ZoneId zoneid = ZoneId.of("Asia/Tokyo");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(FromCalendaeDatetoLocalDateTime(c), zoneid);
		return zonedDateTime;
	}
	
	public static OffsetDateTime fromLocaldateToOffset(LocalDate localDate)
	{
		ZoneOffset zoneOffSet = ZoneOffset.of("+06:00");
		 return OffsetDateTime.of(LocalDate.now(),LocalTime.now(), zoneOffSet);
		
	}
	
	public static OffsetDateTime localdatetimeToOffset(LocalDateTime localDateTime)
	{
		ZoneOffset zoneOffSet = ZoneOffset.of("+06:00");
		 return OffsetDateTime.of(localDateTime, zoneOffSet);
		
	}
	
	

	public static void main(String[] args) throws ParseException {

		ZoneOffset zoneOffSet = ZoneOffset.of("+06:00");
	    System.out.println(OffsetDateTime.of(LocalDate.now(),LocalTime.now(), zoneOffSet));
		
		

	}
}

package io.naztech.DatePrac;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConverterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void FromDateToLocaldateTest() throws ParseException {
		// Converter converter = new Converter();

		String string = "2019-01-16";
		Date dtDate = new SimpleDateFormat("yyyy-MM-dd").parse(string);
		LocalDate date = Converter.FromDateToLocaldate(dtDate);

		LocalDate datetime = LocalDate.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		assertEquals(date, datetime);
	}

	@Test
	public void FromLocaldateToDateTest() throws ParseException {
		String string = "Wed Jan 16 00:00:00 BDT 2019";

		LocalDate localDate = LocalDate.parse(string, DateTimeFormatter.ofPattern("EE MMM dd hh:mm:ss z yyyy"));
		Date date = Converter.FromLocaldateToDate(localDate);

		Date dtDate = new SimpleDateFormat("EE MMM dd hh:mm:ss z yyyy").parse(string);
		assertEquals(date, dtDate);

	}

	@Test
	public void FromDateToCalenderDateTest() throws ParseException {
		Date date = new Date();
		Calendar cal = Converter.fromDateToCalenderDate(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		sdf.format(cal.getTime());

		String stringDate = "2019 Jan 16 15:06:49";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		formatter.parse(stringDate);

		assertEquals(sdf, formatter);

	}

	@Test
	public void FromCalenderToDateTest() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		Date date = Converter.FromCalenderToDate(calendar);
		SimpleDateFormat sm = new SimpleDateFormat("EE MMM dd z yyyy");
		String strDate = sm.format(date);
		Date dt = sm.parse(strDate);

		String string = "Thu Jan 17 BDT 2019";
		Date dtDate = new SimpleDateFormat("EE MMM dd z yyyy").parse(string);

		assertEquals(dt, dtDate);

	}

	@Test
	public void FromCalenderToLocalDateTest() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 21);
		LocalDate ld = Converter.FromCalenderToLocalDate(cl);
		assertEquals(LocalDate.of(2019, Calendar.FEBRUARY, 21), ld);

	}

	@Test
	public void FromCalenderToLocalTimeTest() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.JANUARY, 16, 16, 20);
		LocalTime lt = Converter.FromCalenderToLocalTime(cl);
		assertEquals(LocalTime.of(16, 20), lt);

	}

	@Test
	public void FromCalenderToLocalDateTimeTest() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 12, 10, 02, 10);
		LocalDateTime ldt = Converter.FromCalenderToLocalDateTime(cl);
		assertEquals(LocalDateTime.of(2019, Calendar.FEBRUARY, 12, 10, 02, 10), ldt);
	}

	@Test
	public void FromCalendarToTimezoneTest() {

		Calendar cl = Calendar.getInstance();
	
		TimeZone tz = Converter.FromCalendarToTimezone(cl);
		assertEquals(TimeZone.getTimeZone("Asia/Dhaka"), tz);
	}
	
	
	

	@Test
	public void FromCalenderDatetoLocalDateTimeTest() {
		Calendar cal = Calendar.getInstance();
        LocalDateTime d1 = LocalDateTime.now();
        
        LocalDateTime lc=Converter.FromCalendaeDatetoLocalDateTime(cal);

		assertEquals(d1.getHour(), lc.getHour());
		assertEquals(d1.getMinute(),lc.getMinute());
}
	
	

	
	@Test
	public void fromCalendarToZonedTimeTest() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 17, 14, 30);
		ZonedDateTime zdtDateTime = Converter.fromCalendarToZonedTime(cl);
		
		LocalDateTime ldt = LocalDateTime.of(2019, Calendar.FEBRUARY, 17, 14, 30);
		ZonedDateTime DateTime = ldt.atZone(ZoneId.of("Asia/Tokyo"));
		
		
		assertEquals(zdtDateTime.getZone(), DateTime.getZone());
		assertEquals(zdtDateTime.getHour(), DateTime.getHour());
		assertEquals(zdtDateTime.getMinute(),DateTime.getMinute());
	}





@Test
public void fromLocalDateToOffsetDateTimeTest() {
	

	LocalDate d1 = LocalDate.now();
	OffsetDateTime o = Converter.fromLocaldateToOffset(d1);
	OffsetDateTime dateTime = OffsetDateTime.now();
	
	assertEquals(dateTime.getOffset(),o.getOffset());
	assertEquals(dateTime.getMinute(),o.getMinute());
	assertEquals(dateTime.getHour(),o.getHour());
	
	
}


@Test
public void fromLocaldateTimeToOffsetTest() {
	LocalDateTime d1 = LocalDateTime.now();
	OffsetDateTime o = Converter.localdatetimeToOffset(d1);
	OffsetDateTime dateTime = OffsetDateTime.now();
	
	assertEquals(dateTime.getOffset(),o.getOffset());
	assertEquals(dateTime.getMinute(),o.getMinute());
	assertEquals(dateTime.getHour(),o.getHour());
	
}



}

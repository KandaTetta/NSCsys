package test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TestScheduleDAO {

	public static void main(String[] args) {
		java.sql.Date event_date = java.sql.Date.valueOf("2022-09-02");
		String start_time = "18:50";
		String end_time = "19:00";
		final String FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

		String date = new SimpleDateFormat("yyyy-MM-dd").format(event_date);
		LocalDateTime startDateTime = LocalDateTime.parse(date + " " + start_time + ":00.001",
				DateTimeFormatter.ofPattern(FORMAT));

		LocalDateTime endDateTime = LocalDateTime.parse(date + " " + end_time + ":00.001",
				DateTimeFormatter.ofPattern(FORMAT));

		LocalDateTime current = LocalDateTime.now();

		System.out.println("start  :" + startDateTime);
		System.out.println("current:" + current);
		System.out.println("end    :" + endDateTime);


		System.out.println("startDateTime.isBefore(current)" + startDateTime.isBefore(current));
		System.out.println("endDateTime.isBefore(current  )" + endDateTime.isBefore(current));
		System.out.println("startDateTime.isAfter(current)" + startDateTime.isAfter(current));
		System.out.println("endDateTime.isAfter(current  )" + endDateTime.isAfter(current));

//		System.out.println("current.isBefore(startDateTime)" + current.isBefore(startDateTime));
//		System.out.println("current.isBefore(endDateTime  )" + current.isBefore(endDateTime));
//		System.out.println("current.isAfter(startDateTime)" + current.isAfter(startDateTime));
//		System.out.println("current.isAfter(endDateTime  )" + current.isAfter(endDateTime));
	}

}

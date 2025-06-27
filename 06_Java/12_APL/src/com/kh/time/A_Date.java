package com.kh.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class A_Date {
	
	/*
	 * Date
	 * - java.util 패키지에서 속한 날짜와 시간을 다룰 목적으로 만들어진 클래스 (JDK 1.0)
	 * - Date 의 메서드는 대부분 deprecated(비권장) 되어있지만 여전히 사용
	 * */
	public void method1() {
		// 기본 생성자로 객체를 생성하면 현재 시스템의 시간에 대한 정보를 가지고 객체 생성
		Date today = new Date();
		System.out.println(today); //Fri Jun 27 15:32:47 KST 2025
		
		Date when = new Date(1000);
		System.out.println(when); // Thu Jan 01 09:00:00 KST 1970
		
		System.out.println("getTime : " + today.getTime()); // getTime : 1751006127970
		
		System.out.println("getyear : " + (today.getYear() + 1900) + "년");
		System.out.println("getMonth : " + (today.getMonth() + 1) + "월");
		System.out.println("getDate : " + today.getDate() + "일");
		System.out.println("getHours : " + today.getHours() + "시");
		System.out.println("getMinutes : " + today.getMinutes() + "분");
		System.out.println("getSeconds : " + today.getSeconds() + "초");
		
		// SimpleDateFormat : 날짜 데이터를 원하는 형태로 출력할 수 있도록
		// 2025년 6월 27일 (금) 오후 3시 40분 0초 (H : 0~23, h : 1~12)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a hh시 mm분 ss초");
		String formatDate = sdf.format(today);
		System.out.println(formatDate);
	}
	
	/*
	 * Calendar
	 * - Date 클래스를 개선한 추상 클래스(JDK 1.1)
	 * - 여전히 단점 존재
	 * 
	 * */
	
	public void method2() {
		/*
		 * 추상클래스는 직접 객체 생성 X
		 * getInstance() 메서드로 Calendar 클래스를 구현한 클래스의 객체 반환
		 * 태국 - BuddhistCalender, 그 외 GregorianCalendar
		 * */
		Calendar today = Calendar.getInstance();
		today = new GregorianCalendar();
		System.out.println(today);
	}

	public static void main(String[] args) {
		A_Date a = new A_Date();
		//a.method1();
		a.method2();
	}

}







































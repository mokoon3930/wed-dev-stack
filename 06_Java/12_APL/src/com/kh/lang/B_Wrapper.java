package com.kh.lang;

public class B_Wrapper {

	public static void main(String[] args) {
		// int -> Integer 
		int iNum = 3;
		// Deprecated : 기능은 있지만 비권장
		Integer int1 = new Integer(iNum); // Boxing : 기본 자료형 -> Wrapper 클래스
		int1 = 3;						  // UnBoxing : Wrapper 클래스 -> 기본 자료형
		
		// double -> Double
		double dNum2 = 3.14;
		Double double2 = new Double(dNum2);
		
		//char -> Character
		char ch3 = 'a';
		Character ch4 = new Character(ch3);
		
		//String과 Wrapper 클래스 간의 변경
		//1. 문자열을 기본 자료형으로 변경 : parseXXX()
		int iNum1 = Integer.parseInt("20");
		double dNum = Double.parseDouble("34.96");
		
		//2. 기본 자료형을 문자열로 변경 - String의 valueOf
		String str1 = String.valueOf(iNum1);
		String str2 = String.valueOf(dNum);
		System.out.println(iNum1 + dNum);
		System.out.println(str1 + str2);
		
		// Wrapper 클래스에서 재공하는 valueOf().toString()
		String str3 = Integer.valueOf(iNum).toString();
		String str4 = Double.valueOf(dNum).toString();
		System.out.println(str3 + str4);
				
	}

}

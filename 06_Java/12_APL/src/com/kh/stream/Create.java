package com.kh.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 스트림(stream)
 * - 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것
 * 
 * * 스트림의 특징
 * - 데이터를 읽기만 할 뿐 변경 하지 않는다
 * - 일회용(필요하면 다시 스트림 생성)
 * - 내부 반복 처리
 * - 별렬로 처리 (빠른 처리)
 * 
 * * 스트림의 종류 
 * java.util.stream 패키지에 존재하고 BaseStream 인터페이스를 부모로 갖고 자식 인터페이스들이 상속 관꼐를 이루고 있다
 * 
 * Stream API 
 * - 스트림은 자바 8 부터 추가된 기능으로 컬랙션 (배열) 의 저장 요소들을 하나씩 참조해서 람다식으로 처리할수 있도록 해주는 반복자
 * - 중간처리(intermediate), 최종 처리(terminal) 작업을 수행
 * 		- 중간처리 : 반복(peek), 매핑(타입 변환), 필터링, 정렬 등
 * 		- 최종처리 : 반복(forEach), 카운팅, 평균, 총합 등의 집계처리
 * - 구분하는 방법은 리턴 타입으로 알 수 있음!
 * 		- 리턴타입이 Stream 이라면 중간처리 메서드
 * 
 * */
public class Create {
	
	// 숫자단위로 스트림 생성 - IntStream, LongStream, DoubldStream
	public void method1() {
		
		// range : 첫번 째 파라미터값 ~ 두번째 파라미터 값 이전까지의 값을 요소로 가지는 스트림 객체
		IntStream stream = IntStream.range(1, 10); // 1 ~ 9 
		int sum = stream.sum();
		System.out.println("range의 sum : " + sum);
		
		// rangeClosed : 첫번째 파라미터 값 ~ 두번째 파라미터 값까지의 값을 요소로 가지는 스트림 객체 생성
		stream = IntStream.rangeClosed(1, 10);
		sum = stream.sum();
		System.out.println("rangeClosed : " + sum);
	}
	
	//배열(컬랙션)로 부터 스트림 객체 생성
	public void method2() {
		String[] names = {"오재덕", "이승민", "이환희", "박기민", "조규상", "이상엽", "성예찬" };
		
		Stream<String> stream =  Arrays.stream(names);
		stream.forEach(name -> System.out.println(name));
		
		List<String> nameList = Arrays.asList(names);
		stream = nameList.stream();
		stream.forEach(name -> System.out.println(name));
	}
	
	public static void main(String[] args) {
		Create c = new Create();
		//c.method1();
		c.method2();
	}	
}























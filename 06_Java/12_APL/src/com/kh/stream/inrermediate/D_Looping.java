package com.kh.stream.inrermediate;

import java.util.Arrays;

/*
 * 반복
 * - 요소 전체를 반복하는 역활
 * - peek : 중간 처리 단계에서 전체의 요소를 반복하면서 추가적인 작업을 하기 위해서 사용
 * - forEach : 최종 처리 단께에서 전체 요소를 반복 하면서 추가적인 작업을 하기 위해 사용
 * */
public class D_Looping {

	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 5};
		
	
		
		// 1 ~ 5 까지 짝수만 출력 (forEach) 하고 짝수의 합계(sum)
	
		int sum = Arrays.stream(values)
			.filter(value -> value % 2 == 0)
			.sum();
		System.out.println("합계 : " + sum);
		
		// peek 같이 사용
		
		 sum = Arrays.stream(values)
				.filter(value -> value % 2 == 0)
				.peek(System.out::println)
				.sum();
			System.out.println("합계 : " + sum);
		}
	}

























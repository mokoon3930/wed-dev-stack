package com.kh.array;

import java.util.Arrays;
import java.util.Collections;

public class C_Sorting {
	
	public void method1() {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		//1. 오름차순 정렬(작은 숫자부터 큰 숫자)
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//2. 내림차순 정렬 - > 원본 배열은 따로 있고 새로운 배열을 생성
		
		int[] copy = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {
			copy[arr.length - 1 - i] = arr[i];
		}
		System.out.println(Arrays.toString(copy));
		
		
	}
	
	public void method2( ) {
		String[] arr = {"사과", "Orange", "키위", "banana", "Lemon"};
		
		//오름 차순 (영문 대문자, 소문자, 한글 순)
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//내림 차순 -> int[] 불가! Integer[] 가능! 안써요! 배영 안써요! 면접..
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
	}
	
	// 최대값과 최소값 구하기
	public void method3() {
		int[] score = {67, 89, 94, 32, 26, 57};
		
		Arrays.sort(score);
		System.out.println(score[0]);
		System.out.println(score[score.length -1]);
		
	}
	
	/*
	 * 정렬 알고리즘 : 선택정렬, 삽입정렬, 버블정렬
	 * 실제로는 Arrays.sort() 같은 내장 정렬이나 Collections.sort()가 훨씬 빠르고
	 * 실용적이기 때문에 몰라도 됩니다...
	 * */
	
	/*
	 * 선택 정렬(Selection Sort)
	 * - 가장 작은 값을 찾아서 현재 위치와 변경
	 * - 전체 배열을 전부 탐색하여 최소값을 고르고 왼쪽부터 체워나가는 방식
	 * - 데이터가 많아질수록 속도 저하
	 * */
	
	public void method4() {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			System.out.println(" i = " + i + "-> " + Arrays.toString(arr));
		}
		
	}
	
	/*
	 * 삽입 정렬(Insertion Sort)
	 * - 정렬 알고리즘에서 가장 기본이 된는 알고리즘
	 * - 필요한 때만 위치를 바꾸므로 이미 데이터가 거의 정렬되었을 때 효율적
	 * 
	 * */
	public void method5() {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j > 0; j --) {
				if(arr[j] < arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
			System.out.println(" i = " + i + "-> " + Arrays.toString(arr));
		}
	}
	
	/*
	 * 버블 정렬(bubble Sort)
	 * - 인접한 두 수를 비교하여 큰 수를 뒤로 보내는 방식
	 * - 가장 느린 정렬 중 하나
	 * */
	public void method6() {
		int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1 -i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			System.out.println(" i = " + i + "-> " + Arrays.toString(arr));
		}
	}
	
	
	
	public static void main(String[] args) {
		C_Sorting c = new C_Sorting();
		c.method4();
		c.method5();
		c.method6();
	}

}































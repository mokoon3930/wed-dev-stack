package com.kh.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kh.list.model.Person;

public class Application {

	public static void main(String[] args) {
		int[]result = new int[4];
		// index : 0 - 2등, 1 - 3등, 2 - 4등, 3 - 5등
		
		// 1등 당첨 기준이 로또 번호 6개
		// 둘 다 랜덤! 로또 번호는 1번!
		// 내 번호는 맞출때까지!! 1 ~ 45
		// 정렬이 딱 맞으면 equals로 비교 가능 <- 1등 당첨 확인
		Set<Integer> lotto = new HashSet<>();
		// 반복문이 오또 번호가 6개 될때까지
		
		//만약 2등 당첨! 보너스 번호가 일치 + 5개가 같은 경우
		//3등 당첨! 5개만 같은 경우
		//4등 당첨! 4개만 같은 경우
		//5등 당첨! 3개만 같은경우
		
		while(lotto.size() < 7) {
			lotto.add((int) (Math.random() * 45) + 1);
		}
		List<Integer> lottoList = new ArrayList<>(lotto); // set -> list
		List<Integer> realLotto = lottoList.subList(0, 6); // 7개중 6개만 뽑기
		int bonus = lottoList.get(6);
		
		int count = 0;
		while(true) {
			count++;
			List<Integer> myLotto = new ArrayList<>();
			while(myLotto.size() < 6) {
				int number = (int) (Math.random() * 45) + 1;
				if(!myLotto.contains(number)){
					myLotto.add(number);
				}
			}
			Collections.sort(realLotto);
			Collections.sort(myLotto);
			System.out.println(realLotto);
			System.out.println(myLotto);
			
			int check = 0;
			for(Integer number : realLotto) {
				if(myLotto.contains(number)) {
					check++;
				}
			}
			
			if(lottoList.equals(myLotto)) {
				System.out.println("1등 당첨까지 걸린 횟수 : " + count);
				for(int i = 0; i < result.length; i++) {
					System.out.println((i+2) + "등 횟수 : " + result[i] + "회 ");
				}
				break;
			}else if(check == 5 && myLotto.contains(bonus)) {
				System.out.println("2등 당첨 보너스 : "+ bonus + "횟수 " + count);
				result[0]++;
			}else if(check == 5) {
				System.out.println("3등 당첨횟수 " + count);
				result[1]++;
			}else if(check == 4) {
				System.out.println("4등 당첨횟수 " + count);
				result[2]++;
			}else if(check == 3) {
				System.out.println("5등 당첨횟수 " + count);
				result[3]++;
			}
		}
		
		
		
		
		/*int max = 45;
		int min = 1;
		int random1 = (int) (Math.random() * (max-min+1) + min);
		int random2 = (int) (Math.random() * (max-min+1) + min);
		int random3 = (int) (Math.random() * (max-min+1) + min);
		int random4 = (int) (Math.random() * (max-min+1) + min);
		int random5 = (int) (Math.random() * (max-min+1) + min);
		int random6 = (int) (Math.random() * (max-min+1) + min);
		
		int random7 = (int) (Math.random() * (max-min+1) + min);
		int random8 = (int) (Math.random() * (max-min+1) + min);
		int random9 = (int) (Math.random() * (max-min+1) + min);
		int random10 = (int) (Math.random() * (max-min+1) + min);
		int random11 = (int) (Math.random() * (max-min+1) + min);
		int random12 = (int) (Math.random() * (max-min+1) + min);*/
		
		/*List<Integer> lotto = new ArrayList<>();
		
		lotto.add(random1);
		lotto.add(random2);
		lotto.add(random3);
		lotto.add(random4);
		lotto.add(random5);
		lotto.add(random6);
		
		List<Integer> mylotto = new ArrayList<>();
		
		mylotto.add(random1);
		mylotto.add(random2);
		mylotto.add(random3);
		mylotto.add(random4);
		mylotto.add(random5);
		mylotto.add(random6);
		
		System.out.println(lotto.equals(mylotto));
		
		int[] number = { random1, random2, random3, random4, random5, random6 };
		System.out.println(Arrays.toString(number));
		
		int[] number2 = { random7, random8, random9, random10, random11, random12 };
		System.out.println(Arrays.toString(number2));*/
		
		
		
		
		
	}

}





















package com.kh.practice3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.kh.practice3.controller.MusicController2;
import com.kh.practice3.model.Music2;

public class Application2<Music, T> {
	
	private Scanner sc = new Scanner(System.in);
	private MusicController2 mc = new MusicController2();
	
	private List<Music2> musics = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.menu();

	}
	
	public void menu() {
		try {
			boolean check = true;
			while(check) {
				System.out.println("===== 메인메뉴 =====");
				System.out.println("1. 특정 곡 추가");
				System.out.println("2. 전체 곡 목록 출력");
				System.out.println("3. 특정 곡 검색");
				System.out.println("4. 특정 곡 수정");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 종료");
				System.out.print("메뉴 번호 입력 : ");
				switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						addList();
						break;
					case 2:
						printAll();
						break;
					case 3:
						searchMusic();
						break;
					case 4:
						updateMusic();
						break;
					case 5:
						removeMusic();
						break;
					case 6:
						System.out.println("종료");
						check = false;
						break;
					case 7: 
						descArtist();
						break;
					default: 
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			menu();
		}
	}
	// 가수명 내림 차순 정렬
	private void descArtist() {
		
		Collections.sort((ArrayList<Muisc>) musics);
	}

	//1. 특정 곡 추가
	public void addList() {
		/*
		 * ****** 특정 곡 추가 ******
		 * 곡명 : 
		 * 가수명 : 
		 * 
		 * 곡 추가 성공하면 "추가 성공"
		 *        실패하면 "추가 실패" -> 기존 쪽같은 곡과 가수가 있을시
		 * */
		System.out.println("****** 특정 곡 추가 ******");
		System.out.println("곡명 : ");
		String song = sc.nextLine();
		System.out.println("가수명 : ");
		String artist = sc.nextLine();
		
		Music2 s = new Music2();
		s.setSong(song);
		s.setArtist(artist);
		musics.add(s);

	}
	
	//2. 전체 곡 목록 출력
	public void printAll() {
		/*
		 * ****** 전체 곡 목록 출력 ******
		 * */
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(musics);
		
	}
	
	//3. 특정 곡 검색
	public void searchMusic() {
		/*
		 * ****** 특정 곡 검색(가수/곡) ******
		 * 검색할 곡명 : 
		 * 
		 * 검색할 곡이 있다면 "(가수 - 곡)을 검색했습니다."
		 *          없다면 "검색할 곡을 찾지 못했습니다."
		 * */
		System.out.println("****** 특정 곡 검색 ******");
		System.out.println("검색할 곡명 : ");
		String sm = sc.nextLine();
		System.out.println("검색할 가수명 : ");
		String sn = sc.nextLine();
		
		for(Music2 music : musics) {
		if(music.getSong().equals(sm)) {
			System.out.println("(가수" + music.getArtist() +  "-" + music.getSong() + " 곡)" + "을 검색했습니다.");
			return;
		}else if(!music.getSong().trim().equalsIgnoreCase(sm)) { // 소문자 대문자 무시 / trim() 뛰어쓰기 오류 잡음
			System.out.println("검색할 곡을 찾지 못했습니다.");
			return;
		}else if(!music.getArtist().toLowerCase().contains(sn.toLowerCase())) { // 일부만 검색 가능 contains / 완전 소문자로 자동 전환 toLowerCase()
			System.out.println("검색할 곡을 찾지 못했습니다.");
			return;
		}
		}
		
		
	}
	
	//4. 특정 곡 수정
	public void updateMusic() {
		/*
		 * ****** 특정 곡 수정 ******
		 * 검색할 곡명 : 
		 * 수정할 곡명 : 
		 * 수정할 가수명 : 
		 * 
		 * 수정에 성공한다면 "(바꾸기 전 가수 - 바꾸기 전 곡)의 값이 변경되었습니다."
		 *       실패한다면 "곡을 수정하지 못했습니다."
		 * */
		
		System.out.println("****** 특정 곡 수정 ******");
		System.out.println("검색할 곡명 : ");
		String sm = sc.nextLine();
		for(Music2 music : musics) {
			if(sm.equals(music.getSong())) {
				System.out.println("수정할 곡명 : ");
				String cm = sc.nextLine();
				System.out.println("수정할 가수명 : ");
				String ca = sc.nextLine();
				music.setSong(cm);
				music.setArtist(ca);
				System.out.println("(" + music.getArtist() + music.getSong() + ")의 값이 변경되었습니다.");
				return;
			}
		
		
		}
		
		
	}
	
	//5. 특정 곡 삭제
	public void removeMusic() {
		/*
		 * ****** 특정 곡 삭제 ******
		 * 삭제할 곡명 : 
		 * 
		 * 삭제에 성공한다면 "(삭제한 가수 - 삭제한 곡)을 삭제했습니다."
		 *      실패한다면 "삭제할 곡이 없습니다."
		 * */
		System.out.println("삭제할 곡명 : ");
		String song = sc.nextLine();
		mc.removeMusic();
		
			}
				

	}



















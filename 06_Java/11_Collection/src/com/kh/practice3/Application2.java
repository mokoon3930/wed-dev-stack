package com.kh.practice3;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice3.controller.MusicController2;
import com.kh.practice3.model.Music;

public class Application2 {
	
	private Scanner sc = new Scanner(System.in);
	private MusicController2 mc = new MusicController2();

	public static void main(String[] args) {
		
		Application2 app = new Application2();
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
				System.out.println("7. 가수명 내림차순");
				System.out.println("8. 곡명 오름차순");
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
					case 8:
						ascSong();
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
	
	//1. 특정 곡 추가
	public void addList() {
		/*
		 * ****** 특정 곡 추가 ******
		 * 곡명 : 
		 * 가수명 : 
		 * 
		 * 곡 추가 성공하면 "추가 성공"
		 *        실패하면 "추가 실패" -> 기존 똑같은 곡과 가수가 있을시
		 * */
		
		System.out.println("****** 특정 곡 추가 ******");
		System.out.print("곡명 : ");
		String song = sc.nextLine();
		System.out.print("가수명 : ");
		String artist = sc.nextLine();
		
		if(mc.addList(artist, song)) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	//2. 전체 곡 목록 출력
	public void printAll() {
		/*
		 * ****** 전체 곡 목록 출력 ******
		 * */
		System.out.println("****** 전체 곡 목록 출력 ******");
		ArrayList<Music> result = mc.printAll();
		if(result.isEmpty()) {
			System.out.println("곡이 하나도 없습니다.");
		} else {
			for(Music music : result) {
				System.out.println(music);
			}
		}
	}
	
	//3. 특정 곡 검색
	public void searchMusic() {
		/*
		 * ****** 특정 곡 검색(가수/곡) ******
		 * 키워드 검색 : 
		 * 
		 * 검색할 곡이 있다면 "(가수 - 곡)을 검색했습니다."
		 *          없다면 "검색할 곡을 찾지 못했습니다."
		 * */
		System.out.println("****** 특정 곡 검색(가수/곡) ******");
		System.out.print("키워드 검색 : ");
		String keyword = sc.nextLine();
		ArrayList<Music> result = mc.searchMusic(keyword);
		if(!result.isEmpty()) {
			for(Music music : result) {
				System.out.println("(" + music.getArtist() + " - "
						+ music.getSong() + ")을 검색했습니다.");
			}
		} else {
			System.out.println("검색할 곡을 찾지 못했습니다.");
		}
	}
	
	//4. 특정 곡 수정
	public void updateMusic() {
		/*
		 * ****** 특정 곡 수정(여러 결과가 나왔을시) ******
		 * 검색할 곡명 : 
		 * 수정할 곡명 : 
		 * 수정할 가수명 : 
		 * 
		 * -> 수정할 곡명/가수명을 입력했을시
		 *     기존 리스트에 있는 경우 수정 X
		 * 수정에 성공한다면 "(바꾸기 전 가수 - 바꾸기 전 곡)의 값이 변경되었습니다."
		 *       실패한다면 "곡을 수정하지 못했습니다."
		 * */
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡명 : ");
		String searchSong = sc.nextLine();
		
		String searchArtist = checkMusic(searchSong);
		
		System.out.print("수정할 곡명 : ");
		String updateSong = sc.nextLine();
		System.out.print("수정할 가수명 : ");
		String updateArtist = sc.nextLine();
		Music update = mc.updateMusic(searchSong, searchArtist, new Music(updateArtist, updateSong));
		if(update!=null) {
			System.out.println(update.getArtist() + " - " + update.getSong() + "을 수정했습니다.");
		} else {
			System.out.println("기존에 이미 있는 곡입니다.");
		}
	}
	
	//5. 특정 곡 삭제
	public void removeMusic() {
		/*
		 * ****** 특정 곡 삭제(여러 결과가 나왔을시) ******
		 * 삭제할 곡명 : 
		 * 
		 * 삭제에 성공한다면 "(삭제한 가수 - 삭제한 곡)을 삭제했습니다."
		 *      실패한다면 "삭제할 곡이 없습니다."
		 * */	
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡명 : ");
		String song = sc.nextLine();
		
		String artist = checkMusic(song);
		
		Music result = mc.removeMusic(song, artist);
		
		if(result!=null) {
			System.out.println("(" + result.getArtist() + " - " + song + ")을 삭제했습니다.");
		} else {
			System.out.println("삭제할 곡이 없습니다.");
		}

	}
	
	// 여러 결과 리스트 확인
	public String checkMusic(String song) {
		ArrayList<Music> result = mc.checkMusic(song);
		String searchArtist = null;
		if(result.size() > 1) {
			for(Music music : result) {
				System.out.println(music);
			}
			System.out.print("가수명 입력 : ");
			searchArtist = sc.nextLine();
		}
		return searchArtist;
	}
	
	// 가수명 내림차순 정렬
	public void descArtist() {
		System.out.println("****** 가수명 내림차순 정렬 ******");
		ArrayList<Music> list = mc.descArtist();
		for(Music music : list) {
			System.out.println(music);
		}
	}
	
	public void ascSong() {
		System.out.println("****** 곡명 오름차순 정렬 ******");
		ArrayList<Music> list = mc.ascSong();
		for(Music music : list) {
			System.out.println(music);
		}
	}

}
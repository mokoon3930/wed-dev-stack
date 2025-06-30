package com.kh.practice3.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.practice3.compare.SongAscending2;
import com.kh.practice3.model.Music;

public class MusicController2 {

	private ArrayList<Music> list = new ArrayList<>();
	// 메서드 리턴타입, 파라미터 받는 부분 자유!
	
	//1. 특정 곡 추가
	public boolean addList(String artist, String song) {
		for(Music music : list) {
			if(music.getSong().equals(song) && music.getArtist().equals(artist)) {
				return false;
			}
		}
		if(artist.trim().equals("") || song.trim().equals("")) {
			return false;
		}
		return list.add(new Music(artist, song));
	}
	
	//2. 전체 곡 목록 출력
	public ArrayList<Music> printAll() {
		return list;
	}
	
	//3. 특정 곡 검색
	public ArrayList<Music> searchMusic(String keyword) {
		ArrayList<Music> result = new ArrayList<>();
		// contains - 문자열
		for(Music music : list) {
			if(music.getSong().toLowerCase().contains(keyword.toLowerCase())
					|| music.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(music);
			}
		}
		return result;
	}
	
	// 곡 검색 시 중복된 경우
	public ArrayList<Music> checkMusic(String song) {
		ArrayList<Music> result = new ArrayList<>();
		for(Music music : list) {
			if(music.getSong().equals(song)) {
				result.add(music);
			}
		}
		return result;
	}
	
	//4. 특정 곡 수정 -> 1개인 경우, 여러개인 경우
	public Music updateMusic(String searchSong, String searchArtist, Music update) {
		// set
		for(Music music : list) {
			
			boolean checkSong = music.getSong().equals(searchSong);
			boolean checkArtist = music.getArtist().equals(searchArtist);

			if(searchArtist==null && checkSong || checkSong && checkArtist) {
				// 기존 리스트에서 수정할 값이 있는 경우 - 수정 못하게!
				if(music.getSong().equals(update.getSong()) 
						&& music.getArtist().equals(update.getArtist())) {
					return null;
				}
				return list.set(list.indexOf(music), update);
			} 
		}
		return null;
	}
	
	//5. 특정 곡 삭제
	public Music removeMusic(String song, String artist) {
		// remove
		for(Music music : list) {
			if(artist==null && music.getSong().equals(song)
						|| music.getSong().equals(song) && music.getArtist().equals(artist)) {
				return list.remove(list.indexOf(music));
			}
		}
		return null;
	}
	
	// 가수명 내림차순
	public ArrayList<Music> descArtist() {
		ArrayList<Music> clone = (ArrayList<Music>) list.clone();
		Collections.sort(clone);
		return clone;
	}
	
	// 곡명 오름차순
	public ArrayList<Music> ascSong() {
		ArrayList<Music> clone = (ArrayList<Music>) list.clone();
		Collections.sort(clone, new SongAscending2());
		return clone;
	}
	
	
	
}
package com.kh.practice3.model;

import com.kh.list.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@AllArgsConstructor
@Data
public class Music2 implements Comparable<Music>{
	
	
	private String artist;
	private String song;
	
	public Music2(String Song) {
		this.artist = artist;
		this.song = song;
	}

	public void remove(String song) {
	}
	
	@Override
	public int compareTo(Music o) {
		//return this.age == o.age ? 0 : this.age > o.age ? 1 : -1;
		return this.artist.compareTo(o.artist);



}
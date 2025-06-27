package com.kh.practice3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Music {

	private String artist;
	private String song;
	
	public Music(String Song) {
		this.artist = artist;
		this.song = song;
	}

}
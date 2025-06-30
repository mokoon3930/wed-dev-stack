package com.kh.practice3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Music2 implements Comparable<Music2> {

	private String artist;
	private String song;
	
	@Override
	public int compareTo(Music2 o) {
		return o.artist.compareTo(this.artist);
	}

}
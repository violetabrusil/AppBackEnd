package com.thesis.catalogmicroservice.utils.finder.impl;

import java.util.ArrayList;
import java.util.List;

import com.thesis.catalogmicroservice.audiobook.AudioBook;
import com.thesis.catalogmicroservice.utils.finder.Finder;

public class GenderFinder extends Finder<AudioBook>{
	
	
	public GenderFinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(AudioBook o1, AudioBook o2) {
		if(o1.getGender().toLowerCase().contains(o2.getGender().toLowerCase())) {
			return 0;
		}
		else{
			return -1;
		}
	}


	@Override
	public List<AudioBook> find(List<AudioBook> audiobookList ,String wordToFind) {
		List<AudioBook> resultList = new ArrayList<AudioBook>();
		AudioBook temp = new AudioBook();
		temp.setGender(wordToFind);
		for (AudioBook audioBook : audiobookList) {
			
			if(this.compare(audioBook, temp) == 0) {
				resultList.add(audioBook);
			}
			
		}
		return resultList;
	}


}
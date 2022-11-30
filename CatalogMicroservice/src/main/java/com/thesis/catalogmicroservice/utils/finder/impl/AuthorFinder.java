package com.thesis.catalogmicroservice.utils.finder.impl;

import java.util.ArrayList;
import java.util.List;

import com.thesis.catalogmicroservice.audiobook.AudioBook;
import com.thesis.catalogmicroservice.utils.finder.Finder;

public class AuthorFinder extends Finder<AudioBook> {

	public AuthorFinder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compare(AudioBook o1, AudioBook o2) {
		if(o1.getAuthor().toLowerCase().contains(o2.getAuthor().toLowerCase())) {
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
		temp.setAuthor(wordToFind);
		for (AudioBook audioBook : audiobookList) {
			
			if(this.compare(audioBook, temp) == 0) {
				resultList.add(audioBook);
			}
			
		}
		return resultList;
	}

	
	

}
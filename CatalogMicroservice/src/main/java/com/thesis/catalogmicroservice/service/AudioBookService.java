package com.thesis.catalogmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesis.catalogmicroservice.audiobook.AudioBook;
import com.thesis.catalogmicroservice.repository.AudioBookRepository;

@Service
public class AudioBookService {
	
	@Autowired
	private AudioBookRepository audioBookRepository;
	
	public AudioBook create (AudioBook audioBook) {
		return audioBookRepository.save(audioBook);
	}
	
	public List<AudioBook> getAllAudioBook() {
		return audioBookRepository.findAll();
		
	}
	
	public Optional<AudioBook> serchByIdAudioBook (Integer idAudioBook) {
		return audioBookRepository.findById(idAudioBook);
		 
	}
	
	public void delete (AudioBook audioBook) {
		audioBookRepository.delete(audioBook);
	}
	
	

}

package com.thesis.catalogmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesis.catalogmicroservice.audiobook.AudioBook;
import com.thesis.catalogmicroservice.repository.AudioBookRepository;
import com.thesis.catalogmicroservice.utils.SearchType;
import com.thesis.catalogmicroservice.utils.finder.impl.AuthorFinder;
import com.thesis.catalogmicroservice.utils.finder.impl.GenderFinder;
import com.thesis.catalogmicroservice.utils.finder.impl.TitleFinder;

@Service
public class AudioBookService {

	@Autowired
	private AudioBookRepository audioBookRepository;

	public AudioBook addAudioBook(AudioBook audioBook) {
		List<AudioBook> listAllAudioBook = audioBookRepository.findAll();
		List<AudioBook> resultList = searchAudioBook(listAllAudioBook, String.valueOf(audioBook.getTitleAudioBook()), SearchType.SEARCH_PER_TITLE);
		if(resultList.size() == 0) {
			audioBookRepository.save(audioBook);
			System.out.println("Audiolibro agregado");
			return audioBook;
		}else {
			System.out.println("Ya existe el audiolibro");
			return null;
		}
	}

	public List<AudioBook> getAllAudioBook() {
		return audioBookRepository.findAll();

	}

	public Optional<AudioBook> serchByIdAudioBook(Integer idAudioBook) {
		return audioBookRepository.findById(idAudioBook);

	}

	public void deleteAudioBook(Integer idAudioBook) {
		Optional<AudioBook> resultList = audioBookRepository.findById(idAudioBook);
		if(resultList.isEmpty()) {
			System.out.println("No se encontro el audiolibro");
		}else {
			audioBookRepository.deleteById(idAudioBook);
			System.out.println("Audiolibro eliminado");
		}
	}
	
	public List<AudioBook> searchAudioBook(List<AudioBook> audioBookList, String wordToSearch, SearchType searchType) {

		switch (searchType) {
		case SEARCH_PER_AUTHOR:

			AuthorFinder authorFinder = new AuthorFinder();
			return authorFinder.find(audioBookList, wordToSearch);

		case SEARCH_PER_TITLE:

			TitleFinder titleFinder = new TitleFinder();
			return titleFinder.find(audioBookList, wordToSearch);

		case SEARCH_PER_GENDER:

			GenderFinder genderFinder = new GenderFinder();
			return genderFinder.find(audioBookList, wordToSearch);

		default:
			return null;
		}

	}

}

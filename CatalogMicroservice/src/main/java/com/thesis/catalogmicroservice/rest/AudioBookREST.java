package com.thesis.catalogmicroservice.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesis.catalogmicroservice.audiobook.AudioBook;
import com.thesis.catalogmicroservice.audiobook.review.Review;
import com.thesis.catalogmicroservice.service.AudioBookService;

@RestController
@RequestMapping ("/api/audioBook/")
public class AudioBookREST {
	
	@Autowired
	private AudioBookService audioBookService;
	
	@PostMapping ("/addAudioBook")
	private ResponseEntity<AudioBook> saveAudioBook (@RequestBody AudioBook audioBook){
		AudioBook temp = audioBookService.addAudioBook(audioBook);
		
		try {
			if(temp == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
			}else {
				return ResponseEntity.created(new URI("/api/audioBook"+ temp.getIdAudioBook())).body(temp);
			}
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	}
	
	@GetMapping ("/getAllAudioBooks")
	private ResponseEntity<List<AudioBook>> listAllAudioBooks (){
		return ResponseEntity.ok(audioBookService.getAllAudioBook());
	}
	
	@DeleteMapping("/deleteAudioBook/{idAudioBook}")
	private ResponseEntity<Void> deleteAudioBook (@PathVariable(name = "idAudioBook") Integer idAudioBook){
		audioBookService.deleteAudioBook(idAudioBook);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = {"/searchById/{idAudioBook}"} , method = RequestMethod.GET)
	private ResponseEntity<Optional<AudioBook>> searchAudioBookById (@PathVariable(name = "idAudioBook") Integer idAudioBook ){
		return ResponseEntity.ok(audioBookService.serchByIdAudioBook(idAudioBook));
	}
	
	@RequestMapping(value = {"/updateAudioBook/{idAudioBook}"} , method = RequestMethod.PUT)
	private void updateAudioBook (@RequestBody AudioBook audioBook, @PathVariable(name = "idAudioBook") Integer idAudioBook ){
		audioBookService.updateAudioBook(idAudioBook, audioBook);
	}
	
	@RequestMapping(value = {"/searchByAuthor/{typeSearch}/{authorName}"} , method = RequestMethod.GET)
	private ResponseEntity<List<AudioBook>> searchAudioBookByAuthor (@PathVariable(name = "typeSearch") String typeSearch,@PathVariable(name = "authorName") String authorName){
		return ResponseEntity.ok(audioBookService.searchAudioBooks(typeSearch,authorName));
	}
	
	@PostMapping ("/addReview/{idAudioBook}")
	private Review addReview (@PathVariable(name = "idAudioBook") Integer idAudioBook, @RequestBody Review review ){
		return audioBookService.addReview(idAudioBook, review);
	
	}

}

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
import com.thesis.catalogmicroservice.service.AudioBookService;

@RestController
@RequestMapping ("/api/audioBook/")
public class AudioBookREST {
	
	@Autowired
	private AudioBookService audioBookService;
	
	@PostMapping ("/saveAudioBook")
	private ResponseEntity<AudioBook> saveAudioBook (@RequestBody AudioBook audioBook){
		AudioBook temp = audioBookService.create(audioBook);
		
		try {
			return ResponseEntity.created(new URI("/api/audioBook"+ temp.getIdAudioBook())).body(temp);
			
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	}
	
	@GetMapping ("/getAllAudioBooks")
	private ResponseEntity<List<AudioBook>> listAllAudioBooks (){
		return ResponseEntity.ok(audioBookService.getAllAudioBook());
	}
	
	@DeleteMapping("/deleteAudioBook")
	private ResponseEntity<Void> deleteAudioBook (@RequestBody AudioBook audioBook){
		audioBookService.delete(audioBook);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = {"/searchById/{idAudioBook}"} , method = RequestMethod.GET)
	private ResponseEntity<Optional<AudioBook>> searchAudioBookById (@PathVariable(name = "idAudioBook") Integer idAudioBook ){
		return ResponseEntity.ok(audioBookService.serchByIdAudioBook(idAudioBook));
	}
	

}

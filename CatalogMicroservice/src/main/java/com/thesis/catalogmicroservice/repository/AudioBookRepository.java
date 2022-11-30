package com.thesis.catalogmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesis.catalogmicroservice.audiobook.AudioBook;

public interface AudioBookRepository extends JpaRepository<AudioBook, Integer> {

}


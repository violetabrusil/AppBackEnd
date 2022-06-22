package com.thesis.catalogmicroservice.audiobook.review;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.thesis.catalogmicroservice.audiobook.AudioBook;

@Entity 
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idReview;
    // Mapping the column of this table
    @ManyToOne
    //Adding the name
    @JoinColumn(name = "idAudioBook")
    @Transient
    private AudioBook audiobook;
	private Integer userId;
    private String comment;
	private String rating;
	


	public Review(Integer idReview, AudioBook audiobook, Integer userId, String comment, String rating) {
		super();
		this.idReview = idReview;
		this.audiobook = audiobook;
		this.userId = userId;
		this.comment = comment;
		this.rating = rating;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdReview() {
		return idReview;
	}

	public void setIdReview(Integer idReview) {
		this.idReview = idReview;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public AudioBook getAudiobook() {
		return audiobook;
	}

	public void setAudiobook(AudioBook audiobook) {
		this.audiobook = audiobook;
	}

	@Override
	public String toString() {
		return "Review [idReview=" + idReview + ", audiobook=" + audiobook + ", userId=" + userId + ", comment="
				+ comment + ", rating=" + rating + "]";
	}


	
}

package com.workshop.entities.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Instant date;
	private AuthorDTO author;
	
	public CommentDTO() {
		
	}

	public CommentDTO(String text, Instant date, AuthorDTO author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDTO other = (CommentDTO) obj;
		return Objects.equals(date, other.date) && Objects.equals(text, other.text) && 
				Objects.equals(author, other.author);
	}

	@Override
	public String toString() {
		return "CommentDTO [text=" + text + ", date=" + date + "]";
	}
}

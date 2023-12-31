package com.workshop.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.workshop.entities.dto.AuthorDTO;
import com.workshop.entities.dto.CommentDTO;

@Component
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Instant moment;
	private String title;
	private String body;
	
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();
	
	public Post() {
		
	}

	public Post(String id, Instant moment, String title, String body, AuthorDTO author) {
		this.id = id;
		this.moment = moment;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}
	
	public void addComment(CommentDTO comment) {
		comments.add(comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, id, moment, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(body, other.body) && Objects.equals(id, other.id) && Objects.equals(moment, other.moment)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + "]";
	}
}

package com.example.ManyToMany.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NaturalId;

@Entity
@Table
public class Tag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7011896299463082608L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@NaturalId
	private String name;

	
	public Tag(long id, @NotBlank String name, Set<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		Posts = posts;
	}
	@ManyToMany( fetch =FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "Tag")
	private Set<Post> Posts = new HashSet<>();
	public Tag() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Post> getPosts() {
		return Posts;
	}
	public void setPosts(Set<Post> Posts) {
		this.Posts = Posts;
	}
	@Override
	public String toString() {
		return "tag [id=" + id + ", name=" + name + ", posts=" + Posts + "]";
	}
	
	
}

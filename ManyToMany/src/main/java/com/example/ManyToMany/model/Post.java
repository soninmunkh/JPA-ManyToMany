package com.example.ManyToMany.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "posts")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Post implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8942493877830650976L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Size(max = 100)
	@Column(unique = true)
	private String title;
	@NotBlank
	@Lob
	private String content;

	@NotBlank
	@Size(max = 300)
	private String description;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "post_tags", 
	joinColumns = { @JoinColumn(name = "post_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "tag_id") })

	private Set<Tag> Tag = new HashSet<>();


	public Post() {
		super();
	}

	public Post(long id, @NotBlank @Size(max = 100) String title, @NotBlank String content,
			@NotBlank @Size(max = 300) String description, Date createdAt, Date updatedAt,
			Set<com.example.ManyToMany.model.Tag> tag) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		Tag = tag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "posts [id=" + id + ", title=" + title + ", content=" + content + ", description=" + description
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	

}

package com.example.demo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Table(name="board")
public class Board {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private Date upsert;
	@Column
	private String title;
	@Column
	private String content;
	@Column
	private String writer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getUpsert() {
		return upsert;
	}
	public void setUpsert(Date upsert) {
		this.upsert = upsert;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
}

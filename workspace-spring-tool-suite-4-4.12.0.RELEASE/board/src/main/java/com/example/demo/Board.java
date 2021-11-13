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
@Data
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
}

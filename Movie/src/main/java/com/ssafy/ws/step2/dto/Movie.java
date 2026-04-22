package com.ssafy.ws.step2.dto;

import java.io.Serializable;

//객체 직렬화 가능하도록 Serializable 인터페이스를 구현한다.
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String director;
	private String genre;
	private int runningTime;

	public Movie() {}

	public Movie(String title, String director, String genre, int runningTime) {
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return id + " | " + title + " | " + director + " | " + genre + " | " + runningTime;
	}
}
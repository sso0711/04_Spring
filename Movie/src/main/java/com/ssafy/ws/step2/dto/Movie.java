package com.ssafy.ws.step2.dto;

import java.io.Serializable;

// DTO
// 데이터 전달 역할, getter,setter만 가진 클래스
// View와 Controller 사이에서 활용
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
	
	// set부분이 없으면 불변객체이다!
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
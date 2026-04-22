package com.ssafy.live.controller;

public class GuguService {

	// TODO Auto-generated method stub
	public String gugu(int dan) {
		StringBuilder builder = new StringBuilder();
		for(int i=1; i<10; i++) {
			builder.append(dan*i + "<br>");
		}
		return builder.toString();
	}

}

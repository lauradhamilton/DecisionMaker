package com.example.decisionmaker.data;

public class Choice {
	
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Choice (String id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
}
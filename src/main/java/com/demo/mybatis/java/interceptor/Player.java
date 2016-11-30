package com.demo.mybatis.java.interceptor;

public class Player {

	private String id;
	private String name;
	private String avgScore;
	private String maxScore;
	private String nowTeam;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}
	public String getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(String maxScore) {
		this.maxScore = maxScore;
	}
	public String getNowTeam() {
		return nowTeam;
	}
	public void setNowTeam(String nowTeam) {
		this.nowTeam = nowTeam;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", avgScore=" + avgScore + ", maxScore=" + maxScore + ", nowTeam=" + nowTeam + "]";
	}
}

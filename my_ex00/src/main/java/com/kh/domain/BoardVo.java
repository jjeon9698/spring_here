package com.kh.domain;

import java.sql.Timestamp;

public class BoardVo {
	private int bno;
	private String title;
	private String content;
	private String password;
	private String writer;
	private Timestamp regdate;
	private int viewcnt;
	
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVo(int bno, String title, String content, String password, String writer, Timestamp regdate,
			int viewcnt) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.password = password;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", title=" + title + ", content=" + content + ", password=" + password
				+ ", writer=" + writer + ", regdate=" + regdate + ", viewcnt=" + viewcnt + "]";
	}	
	
}

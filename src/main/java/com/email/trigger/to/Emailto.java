package com.email.trigger.to;

public class Emailto {
	
	private String to;
	
	private String subject;
	
	private String text;
	
	private String cc;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public Emailto(String to, String subject, String text, String cc) {
		super();
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.cc = cc;
	}

	public Emailto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Emailto [to=" + to + ", subject=" + subject + ", text=" + text + ", cc=" + cc + "]";
	}
	
	

}

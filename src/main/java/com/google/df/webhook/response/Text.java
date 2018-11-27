package com.google.df.webhook.response;

public class Text extends Message {
	private String[] text;

	public Text(String[] text) {
		this.text = text;
	}

	public String[] getText() {
		return text;
	}

	public void setText(String[] text) {
		this.text = text;
	}
}

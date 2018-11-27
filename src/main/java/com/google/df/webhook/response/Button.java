package com.google.df.webhook.response;

public class Button {
	private String text;
	private String title;
 	private String postback;
	private OpenUrlAction openUrlAction;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostback() {
		return postback;
	}

	public void setPostback(String postback) {
		this.postback = postback;
	}

	public OpenUrlAction getOpenUrlAction() {
		return openUrlAction;
	}

	public void setOpenUrlAction(OpenUrlAction openUrlAction) {
		this.openUrlAction = openUrlAction;
	}
}

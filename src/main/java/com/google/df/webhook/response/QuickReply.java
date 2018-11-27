package com.google.df.webhook.response;

public class QuickReply extends Message{
	private String title;
	private String[] quickReplies;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getQuickReplies() {
		return quickReplies;
	}

	public void setQuickReplies(String[] quickReplies) {
		this.quickReplies = quickReplies;
	}
}

package com.google.df.webhook.response;

public abstract class Message {
	private String platform;
	private int type;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
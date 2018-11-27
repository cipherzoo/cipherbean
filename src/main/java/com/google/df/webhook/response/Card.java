package com.google.df.webhook.response;

public class Card extends Message {
	private String title;
	private String subTitle;
	private String imageUrl;
	private Button[] buttons;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Button[] getButtons() {
		return buttons;
	}

	public void setButtons(Button[] buttons) {
		this.buttons = buttons;
	}
}

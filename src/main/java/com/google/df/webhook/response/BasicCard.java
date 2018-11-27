package com.google.df.webhook.response;

public class BasicCard extends Card {
	private String formattedText;
	private Image image;

	public String getFormattedText() {
		return formattedText;
	}

	public void setFormattedText(String formattedText) {
		this.formattedText = formattedText;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}

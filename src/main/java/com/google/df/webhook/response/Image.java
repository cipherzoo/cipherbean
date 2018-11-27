package com.google.df.webhook.response;

public class Image extends Message {
	private String imageUri;
	private String accessibilityText;

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public String getAccessibilityText() {
		return accessibilityText;
	}

	public void setAccessibilityText(String accessibilityText) {
		this.accessibilityText = accessibilityText;
	}

}

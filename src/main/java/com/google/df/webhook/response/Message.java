package com.google.df.webhook.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private String platform;
	private int type;
	private Text text;
	private Card card;
	private Image image;
	private QuickReply simpleResponse;

	public Message() {

	}

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

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public QuickReply getSimpleResponse() {
		return simpleResponse;
	}

	public void setSimpleResponse(QuickReply simpleResponse) {
		this.simpleResponse = simpleResponse;
	}
}
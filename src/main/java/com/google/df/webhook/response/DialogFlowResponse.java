package com.google.df.webhook.response;

public class DialogFlowResponse {

	private String fulfillmentText;
	private Message[] fulfillmentMessages;
	private String source;
	private String payload;
	private OutputContext[] outputContexts;

	public DialogFlowResponse() {

	}

	public DialogFlowResponse(Message message) {
		this.fulfillmentMessages = new Message[] { message };
	}

	public String getFulfillmentText() {
		return fulfillmentText;
	}

	public void setFulfillmentText(String fulfillmentText) {
		this.fulfillmentText = fulfillmentText;
	}

	public Message[] getFulfillmentMessages() {
		return fulfillmentMessages;
	}

	public void setFulfillmentMessages(FulfillmentMessage[] fulfillmentMessages) {
		this.fulfillmentMessages = fulfillmentMessages;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public OutputContext[] getOutputContexts() {
		return outputContexts;
	}

	public void setOutputContexts(OutputContext[] outputContexts) {
		this.outputContexts = outputContexts;
	}

}

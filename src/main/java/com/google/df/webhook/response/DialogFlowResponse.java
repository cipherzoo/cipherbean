package com.google.df.webhook.response;

import java.util.List;
import java.util.Map;

public class DialogFlowResponse {

	private String fulfillmentText;
	private List<Map<String, Message>> fulfillmentMessages;
	private String source;
	private String payload;
	private OutputContext[] outputContexts;

	public DialogFlowResponse() {

	}

	public String getFulfillmentText() {
		return fulfillmentText;
	}

	public void setFulfillmentText(String fulfillmentText) {
		this.fulfillmentText = fulfillmentText;
	}

	public List<Map<String, Message>> getFulfillmentMessages() {
		return fulfillmentMessages;
	}

	public void setFulfillmentMessages(List<Map<String, Message>> fulfillmentMessages) {
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

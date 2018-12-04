package com.google.df.webhook;

import java.util.Map;

import com.google.df.webhook.response.FulfillmentMessage;

public class QueryResult {
	private String queryText;
	private Map<String, Object> parameters;
	private boolean allRequiredParamsPresent;
	private FulfillmentMessage[] fulfillmentMessages;
	private Intent intent;
	private int intentDetectionConfidence;
	private String languageCode;

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public boolean isAllRequiredParamsPresent() {
		return allRequiredParamsPresent;
	}

	public void setAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
		this.allRequiredParamsPresent = allRequiredParamsPresent;
	}

	public FulfillmentMessage[] getFulfillmentMessages() {
		return fulfillmentMessages;
	}

	public void setFulfillmentMessages(FulfillmentMessage[] fulfillmentMessages) {
		this.fulfillmentMessages = fulfillmentMessages;
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	public int getIntentDetectionConfidence() {
		return intentDetectionConfidence;
	}

	public void setIntentDetectionConfidence(int intentDetectionConfidence) {
		this.intentDetectionConfidence = intentDetectionConfidence;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
}

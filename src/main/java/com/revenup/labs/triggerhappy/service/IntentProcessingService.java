package com.revenup.labs.triggerhappy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.df.webhook.Request;
import com.google.df.webhook.response.Message;
import com.google.df.webhook.response.Text;

@Service
public class IntentProcessingService {
	public Message getInsights() {
		return null;
	}

	public Map<String,Message> getCampaignsByCampaignType(Request req) {
		Map<String, String> parameters = req.getQueryResult().getParameters();
		String queryText = req.getQueryResult().getQueryText();
		StringBuilder builder = new StringBuilder();
		String campaignType = parameters.containsKey("camapaign_types") ? parameters.get("campaign_types") : "";
		// TODO
		switch (campaignType) {
		case "product based":
			builder.append(
					"Here are some cherry picked product based campaigns for you. Just enter the corresponding number to go ahead creating the campaign.")
					.append("\n 1. Cross-sell Fixed Deposit, 2. Cross-sell Personal Loan, 3. Cross-sell Credit Card");
			break;
		case "goal based":
			break;
		case "treatment based":
			break;
		default:
			break;
		}
		Text text = new Text(new String[] { builder.toString() });
		Map<String, Message> fulfillmentMessage = new HashMap<>();
		fulfillmentMessage.put("text", text);

		return fulfillmentMessage;
	}

	// public Message
}

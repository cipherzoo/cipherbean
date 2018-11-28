package com.revenup.labs.triggerhappy.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.df.webhook.Request;
import com.google.df.webhook.response.Message;
import com.google.df.webhook.response.Text;

@Service
public class IntentProcessingService {

	private static Logger logger = LoggerFactory.getLogger("IntentProcessingService");

	public Message getInsights() {
		return null;
	}

	public Text getCampaignsByCampaignType(Request req) {
		// Map<String, String> parameters = req.getQueryResult().getParameters();
		// String queryText = req.getQueryResult().getQueryText();
		List<String> textMessages = new ArrayList<>(10);
		String campaignType = req.getQueryResult().getParameters().containsKey("camapaign_types")
				? req.getQueryResult().getParameters().get("campaign_types")
				: "";
		// TODO
		switch (campaignType.toLowerCase()) {
		case "product based":
			logger.info("The Selected campaign type is Product Type");
			//textMessages.add("Here are some cherry picked product based campaigns for you.");
			//textMessages.add("Just enter the corresponding number to go ahead creating the campaign.");
			textMessages.add("1. Cross-sell Fixed Deposit");
			//textMessages.add("2. Cross-sell Personal Loan");
			//textMessages.add("3. Cross-sell Credit Card");
			logger.info("Added Text responses");
			break;
		case "goal based":
			break;
		case "treatment based":
			break;
		default:
			break;
		}
		String[] textValues = new String[textMessages.size()];
		Text text = new Text(textMessages.toArray(textValues));
		return text;
	}

	// public Message
}

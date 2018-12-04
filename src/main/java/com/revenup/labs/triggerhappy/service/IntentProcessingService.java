package com.revenup.labs.triggerhappy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.df.webhook.Request;
import com.google.df.webhook.response.Message;
import com.google.df.webhook.response.Text;
import com.revenup.labs.triggerhappy.dao.ActiveCampaignDAO;
import com.revenup.labs.triggerhappy.dao.ActiveCampaignRepository;
import com.revenup.labs.triggerhappy.dao.CampaignDAO;

@Service
public class IntentProcessingService {

	@Autowired
	private CampaignDAO campaignDAO;

	@Autowired
	private ActiveCampaignDAO activeCampaignDAO;

	private ActiveCampaignRepository activeCampaignrepository;

	private static Logger logger = LoggerFactory.getLogger("IntentProcessingService");

	public Message getInsights() {
		return null;
	}

	public Message getCampaignsByCampaignType(Request req) {
		Map<String, String> parameters = req.getQueryResult().getParameters();
		List<String> textMessages = new ArrayList<>(10);
		String campaignType = parameters.containsKey("campaign_types") ? parameters.get("campaign_types") : "";
		logger.info("Campaign Type : {}", campaignType);
		// TODO
		switch (campaignType.toLowerCase()) {
		case "product based":
			logger.info("The Selected campaign type is Product Type");
			textMessages.add("Here are some cherry picked product based campaigns for you.");
			textMessages.add("Just enter the corresponding number to go ahead creating 			 the campaign.");
			textMessages.add("1. Cross-sell Fixed Deposit");
			textMessages.add("2. Cross-sell Personal Loan");
			textMessages.add("3. Cross-sell Credit Card");
			logger.info("Added Text responses");
			break;
		case "goal based":
			break;
		case "treatment based":
			break;
		default:
			break;
		}
		Text text = new Text(textMessages.toArray(new String[textMessages.size()]));
		return text;
	}

	public Text processSelectedCampaign(Request req) {
		String selection = "1";
		if (selection.equals("1")) {

		} else if (selection.equals("2")) {

		} else if (selection.equals("3")) {

		} else {

		}
		int activeCampaignId = activeCampaignDAO.addCampaign(Integer.parseInt(selection));
		activeCampaignrepository.put(req.getSession(), activeCampaignId);
		Text text = new Text(new String[] { "Great.. I have created a campaign which targets 15000 members.",
				"You wanna apply any filters ?" });
		return text;
	}

	private void showFilters() {

	}

}

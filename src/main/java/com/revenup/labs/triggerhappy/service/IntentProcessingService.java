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
import com.revenup.labs.triggerhappy.dao.CustomerDAO;
import com.revenup.labs.triggerhappy.model.CampaignFilter;

// TODO Challenges : Dynamic filter mappings to campaigns and RFM filter values

@Service
public class IntentProcessingService {

	@Autowired
	private CampaignDAO campaignDAO;

	@Autowired
	private ActiveCampaignDAO activeCampaignDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private ActiveCampaignProcessor activeCampaignProcessor;

	private ActiveCampaignRepository activeCampaignrepository = ActiveCampaignRepository.getInstance();

	private static Logger logger = LoggerFactory.getLogger("IntentProcessingService");

	public Message getInsights() {
		return null;
	}

	public Message getCampaignsByCampaignType(Request req) {
		Map<String, Object> parameters = req.getQueryResult().getParameters();
		List<String> textMessages = new ArrayList<>(10);
		String campaignType = parameters.containsKey("campaign_types") ? (String) parameters.get("campaign_types") : "";
		logger.info("Campaign Type : {}", campaignType);
		// TODO
		switch (campaignType.toLowerCase()) {
		case "product based":
			logger.info("The Selected campaign type is Product Type");
			textMessages.add("Here are some cherry picked product based campaigns for you.");
			textMessages.add("Just enter the corresponding number to go ahead creating the campaign.");
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
		Map<String, Object> parameters = req.getQueryResult().getParameters();
		Double campaignNumber = parameters.containsKey("campaign_number")
				? ((List<Double>) parameters.get("campaign_number")).get(0)
				: 0.0;
		logger.info("Campaign Number : {}", campaignNumber);

		if (campaignNumber.equals(1)) {

		} else if (campaignNumber.equals(2)) {

		} else if (campaignNumber.equals(3)) {

		} else {

		}
		int activeCampaignId = activeCampaignDAO.addCampaign(campaignNumber.intValue());
		int targetCount = customerDAO.getCustomerCount();
		activeCampaignrepository.put(req.getSession(), activeCampaignId);
		Text text = new Text(
				new String[] { "Great.. I have created a campaign which targets " + targetCount + " members.",
						"You wanna apply any filters ?" });
		return text;
	}

	// TODO Filters will be dynamic and not statically attached to all the campaigns
	// (This has to be changed)
	public Text getAttitudeFilter(Request req) {
		Map<String, Object> parameters = req.getQueryResult().getParameters();
		String filter = parameters.containsKey("attitude_filters") ? (String) parameters.get("attitude_filters") : "";
		int rowsAffected = updateActiveCampaignFilters(filter, req.getSession());
		int targetCount = customerDAO.getCustomerCount() * 7 / 8;
		Text text = new Text(new String[] { "Applied Attitude filters ending with " + targetCount + " records",
				"You wanna apply any location filters ?" });
		return text;
	}

	public Text getLocationFilter(Request req) {
		Map<String, Object> parameters = req.getQueryResult().getParameters();
		String filter = parameters.containsKey("location_filters") ? (String) parameters.get("location_filters") : "";
		int rowsAffected = updateActiveCampaignFilters(filter, req.getSession());
		Text text = new Text(new String[] { "Applied Location filters.", "You wanna apply any Value based filters ?" });
		return text;
	}

	public Text getValueFilter(Request req) {
		Map<String, Object> parameters = req.getQueryResult().getParameters();
		String filter = parameters.containsKey("value_filters") ? (String) parameters.get("value_filters") : "";
		int rowsAffected = updateActiveCampaignFilters(filter, req.getSession());
		int count = getCampaignTargetCount(activeCampaignrepository.get(req.getSession()));
		Text text = new Text(new String[] {
				"Applied Value filters. And that resulted in " + count + "records. And that completes all" });
		return text;
	}

	public int updateActiveCampaignFilters(String filter, String sessionId) {
		int activeCampaignId = this.activeCampaignrepository.get(sessionId);
		CampaignFilter campaignFilter = this.campaignDAO.getFilterByFilterName(filter);
		return this.activeCampaignDAO.applyActiveCampaignFilters(activeCampaignId, campaignFilter.getFilterId());
	}

	public Text showPsychographicFilters() {
		return new Text(new String[] { "Choose any one of the following psychographic filters,", "1.Risky", "2.Safe",
				"3.Fence-Sitters", "4.All" });
	}

	public Text showLocationFilters() {
		return new Text(new String[] { "Choose any one of the following location filters,", "1.North", "2.South",
				"3.East", "4.West", "5.ALL" });
	}

	public Text showValueFilters() {
		return new Text(new String[] { "Choose any one of the following Value filters,", "1.Recency", "2.Frequency",
				"3.Monetary", "4.All" });
	}

	public Text completeCampaignCreation(Request req) {
		int activeCampaignId = activeCampaignrepository.get(req.getSession());
		int targetCount = activeCampaignProcessor.getTargetCount(activeCampaignId);
		return new Text(new String[] { "Bingo.. The campaign is all set now targeting " + targetCount + "records" });
	}

	private int getCampaignTargetCount(int activeCampaignId) {
		return 1000;
	}

}

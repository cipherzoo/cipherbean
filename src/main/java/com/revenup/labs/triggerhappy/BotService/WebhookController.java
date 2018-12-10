package com.revenup.labs.triggerhappy.BotService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.df.webhook.Request;
import com.google.df.webhook.response.DialogFlowResponse;
import com.google.df.webhook.response.Message;
import com.google.df.webhook.response.Text;
import com.revenup.labs.triggerhappy.service.IntentProcessingService;

@RestController
@RequestMapping("/")
public class WebhookController {

	@Autowired
	private IntentProcessingService intentProcessingService;

	private static Logger logger = LoggerFactory.getLogger("WebHookController");

	@PostMapping(produces = "application/json")
	public DialogFlowResponse processWebhook(@RequestBody Request request, HttpServletResponse response) {
		DialogFlowResponse dialogFlowResponse = new DialogFlowResponse();
		try {
			String intent = request.getQueryResult().getIntent().getDisplayName();
			logger.info("Intent : {}", intent);
			Map<String, Message> fulfillmentMessage = new HashMap<>();
			switch (intent) {
			case "get_insights":
				fulfillmentMessage.put("text", intentProcessingService.getInsights(request));
				logger.info("get_insights {}", request.getQueryResult().getIntent().getName());
				break;
			case "get_campaign_type":
				fulfillmentMessage.put("text", intentProcessingService.getCampaignsByCampaignType(request));
				break;
			case "selected_campaign_type":
				fulfillmentMessage.put("text", intentProcessingService.processSelectedCampaign(request));
				break;
			case "campaign-get_filters":
				fulfillmentMessage.put("text", intentProcessingService.showPsychographicFilters());
				break;
			case "campaign-no_filters":
				fulfillmentMessage.put("text", intentProcessingService.completeCampaignCreation(request));
			case "campaign-filters-attitude":
				fulfillmentMessage.put("text", intentProcessingService.getAttitudeFilter(request));
			case "campaign-attitude-get_location_filters":
				fulfillmentMessage.put("text", intentProcessingService.showLocationFilters());
				break;
			case "campaign-attitude_complete":
				fulfillmentMessage.put("text", intentProcessingService.completeCampaignCreation(request));
				break;
			case "campaign-filters-attitude-location":
				fulfillmentMessage.put("text", intentProcessingService.getLocationFilter(request));
				break;
			case "campaign-filters-attitude-location-complete":
				fulfillmentMessage.put("text", intentProcessingService.completeCampaignCreation(request));
				break;
			case "campaign-filters-attitude-location-get_value_filters":
				fulfillmentMessage.put("text", intentProcessingService.showValueFilters());
				break;
			case "campaign-filters-attitude-location-value":
				fulfillmentMessage.put("text", intentProcessingService.getValueFilter(request));
				break;
			case "get_campaign_type_from_user-select.number - attitude - location - value - complete":
				fulfillmentMessage.put("text", intentProcessingService.completeCampaignCreation(request));
				break;
			default:
				break;
			}

			List<Map<String, Message>> fulfillementMessages = new ArrayList<>(1);
			fulfillementMessages.add(fulfillmentMessage);
			dialogFlowResponse.setFulfillmentMessages(fulfillementMessages);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dialogFlowResponse;
	}
}

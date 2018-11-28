package com.revenup.labs.triggerhappy.BotService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	private IntentProcessingService intentProcessor;

	@PostMapping(produces = "application/json")
	public DialogFlowResponse processWebhook(@RequestBody Request request, HttpServletResponse response) {
		DialogFlowResponse dialogFlowResponse = new DialogFlowResponse();

		try {
			String intent = request.getQueryResult().getIntent().getDisplayName();
			// String intent = "get_campaign_type_from_user";
			Map<String, Message> fulfillmentMessage = new HashMap<>();
			switch (intent) {
			case "get_insights":
				break;
			case "get_campaign_type_from_user":
				fulfillmentMessage.put("text", intentProcessor.getCampaignsByCampaignType(request));
				// fulfillmentMessage.put("text",
				// new Text(new String[] {
				// request.getQueryResult().getParameters().get("campaign_types") }));
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

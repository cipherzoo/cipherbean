package com.revenup.labs.triggerhappy.BotService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.df.webhook.response.DialogFlowResponse;
import com.google.df.webhook.response.Message;
import com.google.df.webhook.response.Text;

@RestController
@RequestMapping("/")
public class WebhookController {

	@PostMapping(produces = "application/json")
	public DialogFlowResponse processWebhook(HttpServletRequest request, HttpServletResponse response) {
		DialogFlowResponse dialogFlowResponse = new DialogFlowResponse();
		Text text = new Text(new String[] { "Test Response For the activity" });
		Map<String, Message> fulfillmentMessage = new HashMap<>();
		fulfillmentMessage.put("text", text);
		List<Map<String, Message>> fulfillementMessages = new ArrayList<>(1);
		fulfillementMessages.add(fulfillmentMessage);
		dialogFlowResponse.setFulfillmentMessages(fulfillementMessages);
		return dialogFlowResponse;
	}

}

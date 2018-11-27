package com.revenup.labs.triggerhappy.BotService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.df.webhook.response.DialogFlowResponse;
import com.google.df.webhook.response.Text;

@RestController
@RequestMapping("/")
public class WebhookController {

	@PostMapping(produces = "application/json")
	public DialogFlowResponse processWebhook(HttpServletRequest request, HttpServletResponse response) {
		return new DialogFlowResponse(new Text(new String[] { "Test Response from custom webhook" }));
	}

}

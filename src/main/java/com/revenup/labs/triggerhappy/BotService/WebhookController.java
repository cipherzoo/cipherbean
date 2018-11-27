package com.revenup.labs.triggerhappy.BotService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.df.webhook.response.Message;
import com.google.df.webhook.response.Text;

@RestController
@RequestMapping("/")
public class WebhookController {

	@PostMapping(produces = "application/json")
	public Message processWebhook(HttpServletRequest request, HttpServletResponse response) {
		return new Text(new String[] { "Test Response from custom webhook" });
	}

}

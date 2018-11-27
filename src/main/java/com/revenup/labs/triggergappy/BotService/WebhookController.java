package com.revenup.labs.triggergappy.BotService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.df.webhook.response.Message;
import com.google.df.webhook.response.Text;

@Path("/")
public class WebhookController {

	@GET
	public Message processWebhook() {
		return new Text(new String[] { "Test Response from custom webhook" });
	}

}

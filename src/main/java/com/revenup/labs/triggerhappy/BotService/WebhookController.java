package com.revenup.labs.triggerhappy.BotService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.google.df.webhook.response.Message;
import com.google.df.webhook.response.Text;

@Path("/")
@Component
public class WebhookController {

	@POST
	@Produces("application/json")
	public Message processWebhook(HttpServletRequest request, HttpServletResponse response) {
		return new Text(new String[] { "Test Response from custom webhook" });
	}

}

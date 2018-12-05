package com.revenup.labs.triggerhappy.dao;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class ActiveCampaignRepository extends HashMap<String, Integer> {

	private static final long serialVersionUID = 1L;

	private static ActiveCampaignRepository activeCampaignRepository = new ActiveCampaignRepository();

	private ActiveCampaignRepository() {

	}

	public static ActiveCampaignRepository getInstance() {
		return activeCampaignRepository;
	}

}

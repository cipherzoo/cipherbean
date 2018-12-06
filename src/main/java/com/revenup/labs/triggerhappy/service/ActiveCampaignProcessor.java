package com.revenup.labs.triggerhappy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revenup.labs.triggerhappy.dao.ActiveCampaignDAO;
import com.revenup.labs.triggerhappy.dao.CustomerDAO;
import com.revenup.labs.triggerhappy.model.ActiveCampaignFilter;

@Service
public class ActiveCampaignProcessor {

	@Autowired
	ActiveCampaignDAO activeCampaignDAO;

	@Autowired
	CustomerDAO customerDAO;

	public void process() {
		// TODO
		// Get the filters,
		// Build the query,
		// Execute the generated query and store the count in the campaign table and
		// save the output as csv
	}

	public int getTargetCount(int activeCampaignId) {
		List<ActiveCampaignFilter> filters = getFiltersByActiveCampaign(activeCampaignId);
		int count = customerDAO.getCustomerCount();
		// mock
		if (filters.isEmpty())
			count *= ((8-filters.size())/8);
		return count;
	}

	public List<ActiveCampaignFilter> getFiltersByActiveCampaign(int activeCampaignId) {
		return activeCampaignDAO.getActiveCampaignFilters(activeCampaignId);
	}

}

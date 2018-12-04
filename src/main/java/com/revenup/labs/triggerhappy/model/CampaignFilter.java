package com.revenup.labs.triggerhappy.model;

public class CampaignFilter {
	private int campaignId;
	private int filterId;
	private int filterTypeId;
	private String filter;

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public int getFilterId() {
		return filterId;
	}

	public void setFilterId(int filterId) {
		this.filterId = filterId;
	}

	public int getFilterTypeId() {
		return filterTypeId;
	}

	public void setFilterTypeId(int filterTypeId) {
		this.filterTypeId = filterTypeId;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

}

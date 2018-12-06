package com.revenup.labs.triggerhappy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDAO {

	private final String SELECT_CUSTOMER_COUNT = "SELECT count(customer_id) from customer";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String generateQuery() {
		String sql = "";
		// Get Active Campaign Filters
		return sql;
	}

	public int getCustomerCount() {
		return this.jdbcTemplate.queryForObject(SELECT_CUSTOMER_COUNT, Integer.class) * 1000;
	}

	private String buildQuery(int activeCampaignId) {
		// get filters for the active campaign and apply the filter value

		return "";
	}

}

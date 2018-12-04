package com.revenup.labs.triggerhappy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

public class ActiveCampaignDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String INSERT_CAMPAIGN_SQL = "INSERT INTO active_campaign(campaign_id,active_campaign_name) VALUES (?,?)";
	private final String INSERT_ACTIVE_CAMPAIGN_FILTERS = "INSERT INTO active_campaign_filters(active_campaign_id,filter_id) VALUES(?,?)";

	/**
	 * Adds new active campaign based on the user selected campaign template and
	 * returns generated campaign Id
	 * 
	 * @return
	 */
	public int addCampaign(int campaignId) {
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		int rowsAffected = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con.prepareStatement(INSERT_CAMPAIGN_SQL, Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, campaignId);
				stmt.setString(2, "activecampaign_" + campaignId + "_" + new Date().toString());
				return stmt;
			}
		}, keyHolder);
		int activeCampaignId = keyHolder.getKey().intValue();
		return activeCampaignId;
	}

	public int applyActiveCampaignFilters(int activeCampaignId, int filterId) {
		int rowsAffected = this.jdbcTemplate.update(INSERT_ACTIVE_CAMPAIGN_FILTERS,
				new Object[] { activeCampaignId, filterId });
		return rowsAffected;
	}

}

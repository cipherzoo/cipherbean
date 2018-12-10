package com.revenup.labs.triggerhappy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.revenup.labs.triggerhappy.model.ActiveCampaignFilter;

@Component
public class ActiveCampaignDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String INSERT_CAMPAIGN_SQL = "INSERT INTO active_campaign(campaign_id,active_campaign_name) VALUES (?,?)";
	private final String INSERT_ACTIVE_CAMPAIGN_FILTERS = "INSERT INTO active_campaign_filters(active_campaign_id,filter_id) VALUES(?,?)";
	private final String SELECT_ACTIVE_FILTERS = "SELECT * FROM active_campaign_filters WHERE active_campaign_id=?";

	private final Logger logger = LoggerFactory.getLogger("");

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
		logger.debug("Rows Inserted : {}", rowsAffected);
		int activeCampaignId = keyHolder.getKey().intValue();
		return activeCampaignId;
	}

	public int applyActiveCampaignFilters(int activeCampaignId, int filterId) {
		int rowsAffected = this.jdbcTemplate.update(INSERT_ACTIVE_CAMPAIGN_FILTERS,
				new Object[] { activeCampaignId, filterId });
		return rowsAffected;
	}

	public List<ActiveCampaignFilter> getActiveCampaignFilters(int activeCampaignId) {
		List<ActiveCampaignFilter> filters = this.jdbcTemplate.query(SELECT_ACTIVE_FILTERS, (rs, rowNo) -> {
			ActiveCampaignFilter filter = new ActiveCampaignFilter();
			filter.setActiveCampaignId(rs.getInt("active_campaign_id"));
			filter.setFilterId(rs.getInt("filter_id"));
			filter.setFilter(rs.getString("filter"));
			return filter;
		}, new Object[] { activeCampaignId });
		return filters;
	}
}

package com.revenup.labs.triggerhappy.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.revenup.labs.triggerhappy.model.CampaignFilter;

public class CampaignFilterMapper implements RowMapper<CampaignFilter> {

	@Override
	public CampaignFilter mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		CampaignFilter filter = new CampaignFilter();
		filter.setCampaignId(resultSet.getInt("campaign_id"));
		filter.setFilterId(resultSet.getInt("filter_id"));
		filter.setFilterTypeId(resultSet.getInt("filter_type_id"));
		filter.setFilter(resultSet.getString("filter"));
		return filter;
	}
}

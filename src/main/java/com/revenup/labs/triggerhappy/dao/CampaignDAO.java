package com.revenup.labs.triggerhappy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.revenup.labs.triggerhappy.model.CampaignFilter;
import com.revenup.labs.triggerhappy.model.mapper.CampaignFilterMapper;

@Component
public class CampaignDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SELECT_CAMPAIGN_FILERS = "SELECT * FROM campaign_filters where filter_type_id=?";
	private final String SELECT_CAMPAIGN_FILTER_BY_FILTER_NAME = "SELECT * FROM campaign_filters WHERE filter=?";

	public List<CampaignFilter> getCampaignFilters() {
		List<CampaignFilter> filters = this.jdbcTemplate.query(SELECT_CAMPAIGN_FILERS, new CampaignFilterMapper(),
				new Object[] {});
		return filters;
	}

	public CampaignFilter getFilterByFilterName(String filterName) {
		List<CampaignFilter> campaignFilers = this.jdbcTemplate.query(SELECT_CAMPAIGN_FILTER_BY_FILTER_NAME,
				new CampaignFilterMapper(), new Object[] { filterName });
		if (!campaignFilers.isEmpty()) {
			return campaignFilers.get(0);
		}
		return null;
	}
}

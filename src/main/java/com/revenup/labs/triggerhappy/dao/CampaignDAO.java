package com.revenup.labs.triggerhappy.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final String SELECT_CAMPAIGN_TYPE = "Select campaign_type_id from campaign_type where campaign_type_name=?";

	private final Logger logger = LoggerFactory.getLogger("");

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

	public int getCampaignTypeId(String campaignType) {
		logger.info("CampaignDAO campaignType : ", campaignType);
		int campaignTypeId = this.jdbcTemplate.queryForObject(SELECT_CAMPAIGN_TYPE,
				new Object[] { campaignType.toLowerCase() }, Integer.class);
		return campaignTypeId;
	}
}

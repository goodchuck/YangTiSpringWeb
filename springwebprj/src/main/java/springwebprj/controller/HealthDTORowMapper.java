package springwebprj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springwebprj.main.HealthDTO;

public class HealthDTORowMapper implements RowMapper<HealthDTO>{

	@Override
	public HealthDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HealthDTO hd = new HealthDTO();
		hd.setBbsid(rs.getInt("bbsid"));
		hd.setId(rs.getString("id"));
		hd.setTitle(rs.getString("title"));
		hd.setContent(rs.getString("content"));
		hd.setBbsav(rs.getInt("bbsav"));
		hd.setNowtime(rs.getString("nowtime"));
		return hd;
	}

}

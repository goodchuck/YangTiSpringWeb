package springwebprj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springwebprj.main.HealthDTO;
import springwebprj.main.UserDTO;

public class UserDTORowMapper implements RowMapper<UserDTO>{

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO ud = new UserDTO();
		ud.setUserID(rs.getString("userID"));
		ud.setUserPassword(rs.getString("userPassword"));
		ud.setUserName(rs.getString("userName"));
		ud.setUserGender(rs.getString("userGender"));
		ud.setUserEmail(rs.getString("userEmail"));
		return ud;
	}

}

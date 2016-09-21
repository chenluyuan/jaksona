package com.jaksona.app.dao.admin;

import com.jaksona.app.dao.BaseDAO;
import com.jaksona.app.entity.admin.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author jaksona
 */
public interface UserDAO extends BaseDAO<User> {

	int selectByUsername(String username);
}

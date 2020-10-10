/**
 * 
 */
package com.training.ifaces;

import com.training.entity.User;

/**
 * @author manan
 *
 */
public interface Verification {

	boolean verifyAdmin(String userName,String password);
	int verifyUser(String userName,String password) throws Exception;
	boolean registerUser(User user);
}

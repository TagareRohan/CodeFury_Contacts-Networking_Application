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
	boolean verifyUser(String userName,String password);
	boolean registerUser(User user);
}

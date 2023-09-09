package com.doct.service;

import com.doct.entity.LoginDTO;
import com.doct.entity.LoginUUIDKey;
import com.doct.exception.LoginException;

public interface DoctorLoginService {
	
	LoginUUIDKey logIntoAccount(LoginDTO loginDTO) throws LoginException;
	
	String logoutFromAccount(String key) throws LoginException;
	
	Boolean checkUserLoginOrNot(String key) throws LoginException;

}

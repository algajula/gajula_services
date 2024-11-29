package com.gajula.service;

import com.gajula.dto.Address_Info;
import com.gajula.dto.User_Info;
import com.gajula.model.ResponseBean;

public interface UserService {

    public ResponseBean getAllUsers() throws Exception;
    public ResponseBean getUserByUserid(String userid) throws Exception;

    public boolean saveUserInfo(User_Info userinfo) throws Exception;
    public boolean saveAddressInfo(Address_Info addressInfo) throws Exception;
}

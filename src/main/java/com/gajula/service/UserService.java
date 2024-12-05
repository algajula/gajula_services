package com.gajula.service;

import com.gajula.dto.AddressDto;
import com.gajula.dto.UserDto;
import com.gajula.model.ResponseBean;

public interface UserService {

    public ResponseBean getAllUsers() throws Exception;
    public ResponseBean getUserByUserid(String userid) throws Exception;

    public boolean saveUserInfo(UserDto userinfo) throws Exception;
    public boolean saveAddressInfo(AddressDto addressInfo) throws Exception;
}

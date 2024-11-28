package com.gajula.service;

import com.gajula.model.ResponseBean;

public interface UserService {

    public ResponseBean getAllUsers() throws Exception;
    public ResponseBean getUserByUserid(String userid) throws Exception;

}

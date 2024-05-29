package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginMapper loginMapper;

    //로그인
    public UserVo logIn(String email, String password) {
        UserVo dbuser=loginMapper.loginInsert(email,password);
        return dbuser;
    }
}

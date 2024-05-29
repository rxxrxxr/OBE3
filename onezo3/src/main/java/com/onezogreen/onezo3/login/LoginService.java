package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginMapper loginMapper;

    //로그인
    public UserVo logIn(String email, String password) {
        UserVo userVo = new UserVo();
        userVo.setEmail(email);
        userVo.setPassword(password);
        UserVo dbuser=loginMapper.loginSelect(userVo);
        return dbuser;
    }
}

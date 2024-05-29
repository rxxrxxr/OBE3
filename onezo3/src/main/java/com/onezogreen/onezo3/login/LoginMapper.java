package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.user.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.HashMap;
import java.util.Map;

@Mapper
public interface LoginMapper {

    UserVo loginSelect(UserVo userVo);

    void selectUserByEmail(String email);
}

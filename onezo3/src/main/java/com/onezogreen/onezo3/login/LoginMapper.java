package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.user.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    UserVo loginInsert(String email, String password);
}

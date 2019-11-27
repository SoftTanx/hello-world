package com.springboot.sample.mapper;

import com.springboot.sample.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select id,password from t_user where username=#{username}")
    User findByUsername(String username);
}

package com.springboot.sample.mapper;

import com.springboot.sample.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByUsername(){
        String username="root1";
        User user =userMapper.findByUsername(username);
        System.out.println(user);
    }
}

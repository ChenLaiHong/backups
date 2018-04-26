package com.test;

import com.dao.UserMapper;
import com.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testCRUD(){

      userMapper.insert(new User(1,"李四","123456"));

    }

}

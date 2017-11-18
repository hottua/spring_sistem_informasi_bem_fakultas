package com.sibftie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by solo on 26/05/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailServiceTest
{
    @Autowired
    private UserDetailsService userDetailsService;
    @Test
    public void userDetailService()
    {
        userDetailsService.loadUserByUsername("iss14008@students.del.ac.id");
    }
}

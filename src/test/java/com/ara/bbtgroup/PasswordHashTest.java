package com.ara.bbtgroup;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class PasswordHashTest {

    @Test
    public void testMD5Hash(){

        String password = "password";
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String hashedPassword = passwordEncoder.encodePassword(password, null);
        System.out.println(hashedPassword);

        Assert.assertEquals("5f4dcc3b5aa765d61d8327deb882cf99", hashedPassword);
    }
}

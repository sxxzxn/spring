package net.fullstack7.chap1.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class LoginTests {
    private  LoginDAO loginDAO;

    @BeforeEach
    public void setUp() {
        loginDAO = new LoginDAO();
    }

/*    @Test
    public void testLogin() {
        MemberVo member = loginDAO.login("user1","1234");
        Assertions.assertNotNull(member);
    }*/
}

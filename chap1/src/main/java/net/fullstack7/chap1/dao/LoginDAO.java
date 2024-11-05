package net.fullstack7.chap1.dao;

import lombok.Cleanup;
import net.fullstack7.chap1.domain.MemberVO;
import java.sql.Connection;

import java.lang.reflect.Member;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public MemberVO login(String memberId, String pwd) throws Exception {
        String sql = "SELECT memberId, pwd, name, jumin, birthday, addr1, addr2, jobCode, mileage, memberState, regDate, leaveDate, pwdChangeDate ";
        sql += "FROM tbl_member WHERE memberId = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberId);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        MemberVO member = null;
        if (rs.next()) {
            String userPwd = rs.getString("pwd");
            if(userPwd.equals(pwd)) {
                member = MemberVO.builder()
                        .memberId(rs.getString("memberId"))
                        .pwd(rs.getString("pwd"))
                        .name(rs.getString("name"))
                        .jumin(rs.getString("jumin"))
                        .birthday(rs.getString("birthday"))
                        .addr1(rs.getString("addr1"))
                        .addr2(rs.getString("addr2"))
                        .jobCode(rs.getString("jobCode"))
                        .mileage(rs.getInt("mileage"))
                        .memberState(rs.getString("memberState"))
                        .regDate(rs.getTimestamp("regDate").toLocalDateTime())
                        .build();
            }
        }
        return member;

    }

}

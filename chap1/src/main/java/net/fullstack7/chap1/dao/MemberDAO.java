package net.fullstack7.chap1.dao;

import lombok.Cleanup;
import net.fullstack7.chap1.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public int regist(MemberVO vo) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT into tbl_member (");
        sql.append("memberId, pwd, name, jumin, birthday");
        sql.append(", addr1, addr2, mileage, memberState");
        sql.append(", regDate");
        sql.append(") values (");
        sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, now())");
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setString(1, vo.getMemberId());
        ps.setString(2, vo.getPwd());
        ps.setString(3, vo.getName());
        ps.setString(4, vo.getJumin());
        ps.setString(5, vo.getBirthday());
        ps.setString(6, vo.getAddr1());
        ps.setString(7, vo.getAddr2());
        ps.setInt(8, vo.getMileage());
        ps.setString(9, vo.getMemberState());

        return ps.executeUpdate();
    }

    public List<MemberVO> list() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from tbl_member");
        sql.append(" WHERE 1=1");
        sql.append(" order by memberId ASC");
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql.toString());
        @Cleanup ResultSet rs = ps.executeQuery();
        List<MemberVO> list = new ArrayList<MemberVO>();

        while (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .memIdx(rs.getInt("memIdx"))
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
                    .uuid(rs.getString("uuid"))
                    .build();
            list.add(vo);

        }

        return list;
    }

    public MemberVO view(String memberId) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("memIdx,memberId, pwd, name, jumin, birthday");
        sql.append(", addr1, addr2, mileage, memberState");
        sql.append(", regDate, leaveDate, pwdChangeDate, jobCode ");
        sql.append(", uuid");
        sql.append("FROM tbl_member WHERE memberId = ?");
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setString(1, memberId);
        @Cleanup ResultSet rs = ps.executeQuery();
        MemberVO vo = null;
        if (rs.next()) {
            vo = MemberVO.builder()
                    .memIdx(rs.getInt("memIdx"))
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
                    .jobCode(rs.getString("jobCode"))
                    .uuid(rs.getString("uuid"))
                    .build();
        }
        return vo;
    }

    public int modify(MemberVO vo) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  tbl_member SET ");
        sql.append("pwd=?, name=?, jumin=?, birthday=?");
        sql.append(", addr1=?, addr2=?, mileage=?, memberState=? , pwdChangeDate=now()");
        sql.append("WHERE memberId = ?");
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setString(1, vo.getPwd());
        ps.setString(2, vo.getName());
        ps.setString(3, vo.getJumin());
        ps.setString(4, vo.getBirthday());
        ps.setString(5, vo.getAddr1());
        ps.setString(6, vo.getAddr2());
        ps.setInt(7, vo.getMileage());
        ps.setString(8, vo.getMemberState());
        ps.setString(9, vo.getMemberId());
        return ps.executeUpdate();
    }

    public int delete(String memberId) throws Exception {
        String sql = "DELETE FROM tbl_member WHERE memberId = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, memberId);

        return ps.executeUpdate();
    }

    public int totalCount() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) AS total_count FROM tbl_member");
        sql.append(" WHERE 1=1");
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql.toString());
        @Cleanup ResultSet rs = ps.executeQuery();
        return (rs.next()) ? rs.getInt("total_count") : 0;
    }

    public int modifyUuid(String memberId , String uuid) throws Exception {
    String sql = "UPDATE  tbl_member SET uuid = ? WHERE memberId = ?";
    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, uuid);
    ps.setString(2, memberId);
    return ps.executeUpdate();
    }

    public MemberVO viewByUuid(String uuid) throws Exception {
        String sql = "SELECT * FROM tbl_member WHERE memberId = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, uuid);
        @Cleanup ResultSet rs = ps.executeQuery();
        MemberVO vo = null;
        if (rs.next()) {
            vo = MemberVO.builder()
                    .memIdx(rs.getInt("memIdx"))
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
                    .jobCode(rs.getString("jobCode"))
                    .uuid(rs.getString("uuid"))
                    .build();
        }
    return vo;
    }



}

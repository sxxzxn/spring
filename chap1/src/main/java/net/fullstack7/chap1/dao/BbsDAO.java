package net.fullstack7.chap1.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import net.fullstack7.chap1.domain.BbsVO;
import net.fullstack7.chap1.dto.BbsDTO;
import org.checkerframework.checker.units.qual.C;
import sun.security.mscapi.CPublicKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class BbsDAO {
    public String getTime() throws Exception {
        String now = "";
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement ps = conn.prepareStatement("select now()");
                ResultSet rs = ps.executeQuery();
        ) {
            rs.next();
            now = rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error(e);
        }
        return now;
    }


    public String getTime2() throws Exception {
        String now = "";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement("select now()");
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        now = rs.getString(1);

        return now;
    }

    public List<BbsVO> list() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("idx, memberId, title, content, regDate ");
        sb.append("FROM tbl_bbs ");

        List<BbsVO> list = new ArrayList<>();
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement ps = conn.prepareStatement(sb.toString());
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                BbsVO vo = new BbsVO();
                vo.setIdx(rs.getInt("idx"));
                vo.setMemberId(rs.getString("memberId"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setRegDate(rs.getDate("regDate").toLocalDate().atStartOfDay());

                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int regist(BbsVO vo) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tbl_bbs (memberId, title, content, regDate) ");
        sb.append("VALUES (?, ?, ?, ?)");
        int row = 0;
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement ps = conn.prepareStatement(sb.toString());
        ) {
            ps.setString(1, vo.getMemberId());
            ps.setString(2, vo.getTitle());
            ps.setString(3, vo.getContent());
            ps.setString(4, getTime());

            row = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return row;

    }

    public BbsVO view(int idx) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("idx, memberId, title, content, regDate ");
        sb.append("FROM tbl_bbs ");
        sb.append("WHERE idx=?");
        BbsVO vo = new BbsVO();
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement ps = conn.prepareStatement(sb.toString());
        ) {
            ps.setInt(1, idx);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vo.setIdx(rs.getInt("idx"));
                    vo.setMemberId(rs.getString("memberId"));
                    vo.setTitle(rs.getString("title"));
                    vo.setContent(rs.getString("content"));
                    vo.setRegDate(rs.getDate("regDate").toLocalDate().atStartOfDay());

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vo;
    }

    public int modify(BbsVO vo) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE tbl_bbs ");
        sb.append("SET title=?, content=?, modifyDate=? ");
        sb.append("WHERE idx=?");
        int row = 0;
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement ps = conn.prepareStatement(sb.toString());
        ) {
            ps.setString(1, vo.getTitle());
            ps.setString(2, vo.getContent());
            ps.setString(3, getTime());
            ps.setInt(4, vo.getIdx());

            row = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return row;
    }

    public int delete(int idx) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tbl_bbs WHERE idx=?");
        int row = 0;
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement ps = conn.prepareStatement(sb.toString());
        ) {
            ps.setInt(1, idx);

            row = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

}
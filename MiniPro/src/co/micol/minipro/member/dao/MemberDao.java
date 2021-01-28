package co.micol.minipro.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.minipro.common.DAO;
import co.micol.minipro.common.DbInterface;
import co.micol.minipro.member.service.MemberVo;

public class MemberDao extends DAO implements DbInterface<MemberVo> {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private String MEMBERSELECT = "SELECT * FROM MEMBER WHERE MID=?";
	private String MEMBERALLSELECT = "SELECT * FROM MEMBER";
	private String MEMBERSELECTLIST = "SELECT * FROM MEMBER WHERE MID=? AND MPASSWORD=?";
	private String MEMBERINSERT = "INSERT INTO MEMBER(MID,MNAME,MPASSWORD) VALUES(?,?,?)";
	private String MEMBERDELETE = "DELETE FROM MEMBER WHERE MID=?";
	
	@Override
	public ArrayList<MemberVo> selectList() {
		// TODO 회원 전체 리스트 가져오기
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo;
		try {
			psmt = conn.prepareStatement(MEMBERALLSELECT);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setmId(rs.getString("mid"));
				vo.setmName(rs.getString("mname"));
				vo.setmAuth(rs.getString("mauth"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVo select(MemberVo vo) {
		// TODO 한 명의 레코드를 구현
		try {
			psmt = conn.prepareStatement(MEMBERSELECT);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmName(rs.getString("mname"));
				vo.setmAuth(rs.getString("mauth"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int insert(MemberVo vo) {
		int n = 0;
		// TODO Auto-generated method stub
		try {
			psmt = conn.prepareStatement(MEMBERINSERT);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmName());
			psmt.setString(3, vo.getmPassword());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int update(MemberVo vo) {
		// TODO 권한, 비밀번호만 변경한다.
		String sql = null;
		if(vo.getmPassword() != null) {
			sql = "UPDATE MEMBER SET MPASSWORD=? WHERE MID = ?"; // 비밀번호 변경
		}else if(vo.getmAuth() != null) { 
			sql = "UPDATE MEMBER SET MAUTH=? WHERE MID = ?";  // 권한 변경
		}
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			if(vo.getmPassword() != null) {
				psmt.setString(1, vo.getmPassword()); // 비밀번호 변경될 때
			}else {
				psmt.setString(1, vo.getmAuth());  //권한 변경될 때
			}
			psmt.setString(2, vo.getmId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int delete(MemberVo vo) {
		// TODO 회원 한 명 삭제
		int n = 0;
		try {
			psmt = conn.prepareStatement(MEMBERDELETE);
			psmt.setString(1, vo.getmId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	public boolean isIdCheck(String id) {  //id 중복확인을 위한 method(boolean type을 쓰려면 앞에 is를 붙여주는 게 룰)
		boolean bool = true;
		String sql = "select mid from member where mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				bool = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return bool;
	}
	
	public MemberVo login(MemberVo vo) { //로그인에서 사용.
		// TODO 한 명의 레코드를 구현
		try {
			psmt = conn.prepareStatement(MEMBERSELECTLIST);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmId(rs.getString("mid"));
				vo.setmName(rs.getString("mname"));
				vo.setmPassword(rs.getString("mpassword"));
				vo.setmAuth(rs.getString("mauth"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

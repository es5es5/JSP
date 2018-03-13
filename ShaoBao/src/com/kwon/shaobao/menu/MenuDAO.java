package com.kwon.shaobao.menu;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.shaobao.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MenuDAO {
	private ArrayList<Menu> menus;

	private static final MenuDAO MDAO = new MenuDAO();

	private MenuDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MenuDAO getMdao() {
		return MDAO;
	}
	
	public void searchMenu(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();
			
			String sm_name = request.getParameter("sm_name");

			String sql = "select * from shaobao_menu where sm_name like '%'||?||'%' order by sm_name desc";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sm_name);
			rs = pstmt.executeQuery();
			

			menus = new ArrayList<>();
			Menu m = null;
			while (rs.next()) {
				m = new Menu();
				m.setSm_no(rs.getInt("sm_no"));
				m.setSm_name(rs.getString("sm_name"));
				m.setSm_desc(rs.getString("sm_desc"));
				m.setSm_img(rs.getString("sm_img"));
				m.setSm_price(rs.getString("sm_price"));
				menus.add(m);
			}

			if (menus.size() == 0) {
				request.setAttribute("r", "아무 데이터 없음");

				menus.add(null);
				menus.add(null);
				menus.add(null);
			}

			//request.setAttribute("menus", menus);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");

			menus = new ArrayList<>();
			menus.add(null);
			menus.add(null);
			menus.add(null);
			//request.setAttribute("menus", menus);
			// request.setAttribute("comments", comments);

		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	// 페이지 번호 넣으면 그 페이지 해당하는 데이터만 꺼내 주는 메소드
	public void paging(int page, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("curPageNo", page);
		// 전체 페이지 수 계산
		double cnt = 5; // 한 페이지당 나올 후기 수
		int itemSize = menus.size(); // 총 후기 수
		int pageCount = (int) Math.ceil(itemSize / cnt);
		request.setAttribute("pageCount", pageCount);

		int start = itemSize - ((int) cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - ((int) cnt + 1);

		ArrayList<Menu> items2 = new ArrayList<>();

		// 22 21 20 19 18 17 16 15 14 13
		for (int i = start - 1; i > end; i--) {
			items2.add(menus.get(i));
		}

		request.setAttribute("menus", items2);
	}

	public void getAllMenu(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from shaobao_menu " + "order by sm_name desc";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			menus = new ArrayList<>();
			Menu m = null;
			while (rs.next()) {
				m = new Menu();
				m.setSm_no(rs.getInt("sm_no"));
				m.setSm_name(rs.getString("sm_name"));
				m.setSm_desc(rs.getString("sm_desc"));
				m.setSm_img(rs.getString("sm_img"));
				m.setSm_price(rs.getString("sm_price"));
				menus.add(m);
			}

			if (menus.size() == 0) {
				request.setAttribute("r", "아무 데이터 없음");

				menus.add(null);
				menus.add(null);
				menus.add(null);
			}

			//request.setAttribute("menus", menus);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");

			menus = new ArrayList<>();
			menus.add(null);
			menus.add(null);
			menus.add(null);
			//request.setAttribute("menus", menus);
			// request.setAttribute("comments", comments);

		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void reg(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String path = request.getServletContext().getRealPath("img");

			MultipartRequest mr = new MultipartRequest(request, path, 31457280, "euc-kr",
					new DefaultFileRenamePolicy());

			String sm_name = mr.getParameter("sm_name");
			String sm_price = mr.getParameter("sm_price");
			String sm_desc = mr.getParameter("sm_desc");
			sm_desc = sm_desc.replace("\n", "<br>");

			String sm_img = mr.getFilesystemName("sm_img"); // ㅋ ㅋ.png
			sm_img = URLEncoder.encode(sm_img, "euc-kr"); // %2A+%2A.png
			sm_img = sm_img.replace("+", " "); // %2A %2A.png

			String sql = "insert into shaobao_menu " + "values(shaobao_menu_seq.nextval, " + "?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sm_name);
			pstmt.setString(2, sm_desc);
			pstmt.setString(3, sm_price);
			pstmt.setString(4, sm_img);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "메뉴 등록 성공");
			} else {
				request.setAttribute("r", "메뉴 등록 실패");
			}
		} catch (Exception e) {
			request.setAttribute("r", "메뉴 등록 실패");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}

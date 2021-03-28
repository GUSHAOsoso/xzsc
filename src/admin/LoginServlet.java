package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gongda.admin.dao.AdminDao;

import po.User;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		int role = 1;
		AdminDao dao = new AdminDao();
		User admin = dao.selectByLogin(name, password, role);
		if(admin != null) {
			req.setAttribute("adminName", admin);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

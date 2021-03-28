package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tedu.dao.UserDao;

import po.User;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String uname = req.getParameter("uname");
		String upwd = req.getParameter("upwd");
		int role = 0;
		UserDao dao = new UserDao();
		User user = dao.selectByLogin(uname, upwd, role);
		if(user != null) {
			req.getSession().setAttribute("user", user);//记录用户信息到session中
			req.getRequestDispatcher("AllBookServlet").forward(req, resp);
		}else {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

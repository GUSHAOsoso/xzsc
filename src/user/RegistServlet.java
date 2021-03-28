package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.UserDao;

import po.User;

public class RegistServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");

		PrintWriter out = resp.getWriter();

		String uname = req.getParameter("uname");
		String upwd = req.getParameter("upwd");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		UserDao dao = new UserDao();
		User user = new User();
		user.setEmail(email);
		user.setPhone(phone);
		user.setRole(0);
		user.setUname(uname);
		user.setUpwd(upwd);
		dao.insert(user);
		//页面跳转
		resp.sendRedirect("login.jsp");
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

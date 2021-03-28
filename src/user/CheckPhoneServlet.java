package user;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.UserDao;

import po.User;

//检查注册手机号的唯一性
public class CheckPhoneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		UserDao dao = new UserDao();
		User user = dao.ajaxCheckPhone(phone, 0);
		Writer out = resp.getWriter();
		if(user == null) {
			out.write("no");
		}else {
			out.write("yes");
		}
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

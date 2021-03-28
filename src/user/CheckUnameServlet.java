package user;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.UserDao;

import po.User;

//消费者系统：注册页面 ajax校验  校验用户名
public class CheckUnameServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		UserDao dao = new UserDao();
		User user = dao.ajaxCheckUname(uname, 0);
		Writer out = resp.getWriter();
		if(user == null) {
			out.write("no");//该用户不存在
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

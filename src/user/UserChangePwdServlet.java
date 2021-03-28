package user;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.UserDao;

import po.User;

//检查原密码是否正确
public class UserChangePwdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		User user = (User)req.getSession().getAttribute("user");
		
		String upwd = req.getParameter("upwd");
		UserDao dao = new UserDao();
		User result = dao.ajaxCheckUpwd(upwd, user.getPhone(), user.getRole());
		Writer out = resp.getWriter();
		if(result != null) {
			out.write("yes");
		}else {
			out.write("no");
		}
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

package user;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.CollectDao;
import com.tedu.dao.UserDao;

import po.Collect;

//消费者系统：收藏夹按钮 添加收藏,若已收藏，再点击就取消
public class CollectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String uid = req.getParameter("uid");
		String isbn = req.getParameter("isbn");
		System.out.println(uid);
		Collect target = new Collect();
		target.setUid(uid);
		target.setBook(isbn);
		
		CollectDao dao = new CollectDao();
		Collect result = dao.selectByCollect(target);
		
		if(result != null) {
			dao.delete(target);
			req.setAttribute("isCollect", "");
		}else {
			dao.insert(target);
			req.setAttribute("isCollect", "2");
		}
		Writer out = resp.getWriter();
		out.write("yes");
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.CartDao;

//消费者系统：购物车ajax修改数量,购买书本的数量
public class ChangeItemNumServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String itemId = req.getParameter("itemId");
		String num = req.getParameter("num");
		CartDao dao = new CartDao();
		dao.updateCartNumByRid(Integer.parseInt(itemId), Integer.parseInt(num));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

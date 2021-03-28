package user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.CartDao;

import po.CartAndBook;
import po.User;

//消费者系统：购物车页面
public class CartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		User user = (User)req.getSession().getAttribute("user");
		CartDao dao = new CartDao();
		List<CartAndBook> list = dao.selectAllCartAndBook(user);
		req.setAttribute("cartAndBooks", list);
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

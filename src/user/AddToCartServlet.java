package user;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.CartDao;
import com.tedu.dao.UserDao;

import po.Cart;
import po.CartAndBook;
import po.User;

//消费者系统：商品详情页面 添加购物车
public class AddToCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		User user = (User) req.getSession().getAttribute("user");
		String product = req.getParameter("product");
		int count = Integer.parseInt(req.getParameter("count"));
		CartDao dao = new CartDao();
		Cart cart = new Cart();
		cart.setBook(product);
		cart.setCount(count);
		cart.setUid(user.getPhone());
		dao.insert(cart);
		Writer writer = resp.getWriter();
		writer.write("yes");
		writer.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

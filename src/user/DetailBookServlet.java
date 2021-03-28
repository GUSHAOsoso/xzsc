package user;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.BookDao;
import com.tedu.dao.CollectDao;

import po.Book;
import po.Collect;
import po.User;


//消费者系统：商品详情页面
public class DetailBookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String isbn = req.getParameter("isbn");
		BookDao dao = new BookDao();
		Book book = dao.selectByisbn(isbn);
		req.setAttribute("book", book);
		
		//获取当前用户信息
		User user = (User)req.getSession().getAttribute("user");
		//获取页面出入的 商品数量和商品标号
		String product = req.getParameter("isbn");
		Collect target = new Collect();
		target.setBook(product);
		target.setUid(user.getPhone());
		CollectDao cdao = new CollectDao();
		Collect result = cdao.selectByCollect(target);
		System.out.println("222222222222222");
		if(result != null) {
			req.setAttribute("isCollect", "2");
		}else {
			req.setAttribute("isCollect", "");
		}
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

package user;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.OrderltemDao;

public class OrderplacedServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String rid = req.getParameter("rid");
		String uid = req.getParameter("uid");
		String book = req.getParameter("book");
		System.out.println(book);
		Date day = new Date();   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = df.format(day);
		Date str1 = null;
		try {
			str1 = df.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderltemDao orderDao = new OrderltemDao();
		int row = orderDao.insertOrderPlaced(rid,str1,uid);
		int row1 = orderDao.deleteCart(book);
		req.getRequestDispatcher("payment.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

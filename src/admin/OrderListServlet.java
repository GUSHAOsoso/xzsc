package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gongda.admin.dao.OrderListAllServletDao;

import po.OrderStatus;

public class OrderListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//获取要展示商品的状态，待处理，处理中，已发货，已交付
		String sta = req.getParameter("sta");
		OrderListAllServletDao orderListAllServlet = new OrderListAllServletDao();
		List<OrderStatus> list = orderListAllServlet.selectAllOrderList1(sta);
		req.setAttribute("allbooks", list);
		req.getRequestDispatcher("order-list.jsp").forward(req, resp);
	}
	
}

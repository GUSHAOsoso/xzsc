package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gongda.admin.dao.OrderDetailBookDao;

import po.Address;
import po.OrderItem;
import po.OrderStatus;

//到处理界面修改 状态
public class OrderProcessBook extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取到订单编号
		String oid = req.getParameter("oid");
		//获取该订单手机号
		String uid = req.getParameter("uid");
		//地址
		String aid = req.getParameter("aid");
		OrderDetailBookDao orderdetailbookdao = new OrderDetailBookDao();
		//收件人姓名
		//电话
		List<Address> list = orderdetailbookdao.selectAddress(aid,uid);
		
		//创建时间
		//订单总额
		//订单状态
		List<OrderStatus> list1 = orderdetailbookdao.selectOrder(uid,oid);
		//单个商品数量
		//书名
		//商品编号
		//出版社
		//单价
		List<OrderItem> list2 = orderdetailbookdao.selectOrderItem(oid);
		req.setAttribute("list", list);
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.getRequestDispatcher("order-process.jsp").forward(req, resp);
	}
}

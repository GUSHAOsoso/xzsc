package user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.AddressDao;
import com.tedu.dao.OrderltemDao;

import po.Address;
import po.Book;
import po.Cart;
import po.CartAndBook;
import po.OrderItem;
import po.OrderStatus;
import po.User;

//消费者系统：购物车提交订单功能
public class CartToOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String itemIds = req.getParameter("itemIds");
		User user = (User)req.getSession().getAttribute("user");
		//选择收货地址
		AddressDao dao = new AddressDao();
		ArrayList<Address> addresslist = dao.selectAddressByUser(user);
		req.setAttribute("addressList", addresslist);
		//生成订单列表
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String str = df.format(day);
		str = str.trim();//去除前后空格
		String str2 = "";
		if (str != null && !"".equals(str)) {
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) >= 48 && str.charAt(j) <= 57) {
					str2 += str.charAt(j);
				}
			}
		}
		OrderltemDao orderDao = new OrderltemDao();
		ArrayList<CartAndBook> orderItemlist = orderDao.selectAllCartAndBook(itemIds);
		Double price = 0.0;
		for (int i = 0; i <  orderItemlist.size() ; i++) {
			CartAndBook cartbook = orderItemlist.get(i);
			Book book = cartbook.getBook();
			Cart cart = cartbook.getCart();
			//数量
			Integer count = cart.getCount();
			//价格
			price +=count*book.getPrice();
		}
		OrderStatus orderStatus = new OrderStatus();
		for (int i = 0; i <  1 ; i++) {
			CartAndBook cartbook = orderItemlist.get(i);
			Book book = cartbook.getBook();
			Cart cart = cartbook.getCart();
			//手机号
			String uid = cart.getUid();
			//截取手机号后三位
			String uid1 = uid.substring(uid.length()-3);
			//生成订单号
			String oid = uid1+str2;
			//订单状态
			String sta = "待处理";
			orderStatus.setUid(uid);
			orderStatus.setOid(oid);
			orderStatus.setSta(sta);
			orderStatus.setPayment(price);
			int row1 = orderDao.insertOrder(orderStatus);
		}
		for (int i = 0; i <  orderItemlist.size() ; i++) {
			CartAndBook cartbook = orderItemlist.get(i);
			Book book = cartbook.getBook();
			Cart cart = cartbook.getCart();
			//商品编号
			String product = book.getIsbn();
			//价格
			Double price1 = book.getPrice();
			//数量
			Integer count = cart.getCount();
			//手机号
			String uid = cart.getUid();
			//截取手机号后三位
			String uid1 = uid.substring(uid.length()-3);
			//生成订单号
			String oid = uid1+str2;
			//订单状态
			String sta = "待处理";
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(count);
			orderItem.setOid(oid);
			orderItem.setPrice(price1);
			orderItem.setProduct(product);
			int row = orderDao.insertOitem(orderItem);
		}
		req.setAttribute("itemIds", itemIds);
		req.setAttribute("orderItemlist", orderItemlist);
		req.getRequestDispatcher("order-confirm.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

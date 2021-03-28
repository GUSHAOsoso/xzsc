package user;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.AddressDao;

import po.Address;
import po.User;

//消费者系统：修改地址功能 
public class AddressAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String receiver = req.getParameter("receiver");
		String address = req.getParameter("address");
		String receiverPhone = req.getParameter("receiverPhone");
		User user = (User)req.getSession().getAttribute("user");
		String uid = user.getPhone();
		Address add = new Address();
		add.setAddress(address);
		add.setReceiver(receiver);
		add.setRphone(receiverPhone);
		add.setUid(uid);
		add.setAdded(new Date());
		AddressDao dao = new AddressDao();
		dao.insert(add);
		
		Writer out = resp.getWriter();
		out.write("yes");
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

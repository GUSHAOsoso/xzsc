package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.BookDao;

import po.Book;

public class EditBook extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String isbn = req.getParameter("isbn");
		BookDao dao = new BookDao();
		Book book = dao.selectByisbn(isbn);
		req.setAttribute("book", book);
		if(book != null) {
			req.getRequestDispatcher("product-edit.jsp").forward(req, resp);			
		}
	}
}

package po;

//购物车中的书籍,综合信息
public class CartAndBook {
	private Book book;
	private Cart cart;
	
	public CartAndBook() {
		super();
	}

	public CartAndBook(Book book, Cart cart) {
		super();
		this.book = book;
		this.cart = cart;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartAndBook [book=" + book + ", cart=" + cart + "]";
	}
	
}

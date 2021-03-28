package po;

//购物车，数据库t_cart
public class Cart {
	private Integer rid;//主键，自增
	private String uid;
	private String book;
	private Integer count;
	
	public Cart() {
		super();
	}

	public Cart(Integer rid, String uid, String book, Integer count) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.book = book;
		this.count = count;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Cart [rid=" + rid + ", uid=" + uid + ", book=" + book + ", count=" + count + "]";
	}
	
	
}

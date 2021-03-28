package po;

//收藏表  t_collect
public class Collect {
	private Integer rid;
	private String uid;
	private String book;
	
	public Collect() {
		super();
	}

	public Collect(Integer rid, String uid, String book) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.book = book;
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

	@Override
	public String toString() {
		return "Collect [rid=" + rid + ", uid=" + uid + ", book=" + book + "]";
	}
	
}

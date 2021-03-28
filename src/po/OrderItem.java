package po;

//订单条款表
public class OrderItem {
	private Integer rid;//主键，自增
	private String product;//商品编号
	private Double price;//价格
	private Integer count;//数量
	private String oid;//订单编号
	public OrderItem() {
		super();
	}
	public OrderItem(Integer rid, String product, Double price, Integer count, String oid) {
		super();
		this.rid = rid;
		this.product = product;
		this.price = price;
		this.count = count;
		this.oid = oid;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "OrderItem [rid=" + rid + ", product=" + product + ", price=" + price + ", count=" + count + ", oid="
				+ oid + "]";
	}
	
	
}

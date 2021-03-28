package po;

import java.util.Date;

//订单详情，状态等
public class OrderStatus {
	private Integer rid;//主键，自增
	private String uid;//用户手机号
	private String oid;//订单编号
	private String sta;//状态
	private String aid;//地址
	private Double payment;//支付金额
	private Date placed;//创建时间
	private Date receipt;
	private Date deliver;
	private Date handover;
	public OrderStatus() {
		super();
	}
	public OrderStatus(Integer rid, String uid, String oid, String sta, String aid, Double payment, Date placed,
			Date receipt, Date deliver, Date handover) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.oid = oid;
		this.sta = sta;
		this.aid = aid;
		this.payment = payment;
		this.placed = placed;
		this.receipt = receipt;
		this.deliver = deliver;
		this.handover = handover;
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
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Date getPlaced() {
		return placed;
	}
	public void setPlaced(Date placed) {
		this.placed = placed;
	}
	public Date getReceipt() {
		return receipt;
	}
	public void setReceipt(Date receipt) {
		this.receipt = receipt;
	}
	public Date getDeliver() {
		return deliver;
	}
	public void setDeliver(Date deliver) {
		this.deliver = deliver;
	}
	public Date getHandover() {
		return handover;
	}
	public void setHandover(Date handover) {
		this.handover = handover;
	}
	@Override
	public String toString() {
		return "OrderStatus [rid=" + rid + ", uid=" + uid + ", oid=" + oid + ", sta=" + sta + ", aid=" + aid
				+ ", payment=" + payment + ", placed=" + placed + ", receipt=" + receipt + ", deliver=" + deliver
				+ ", handover=" + handover + "]";
	}
	
}

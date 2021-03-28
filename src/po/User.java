package po;

public class User {
	private String uname;
	private String upwd;
	private String email;
	private String phone;
	private int role;
	public User() {
		super();
	}
	public User(String uname, String upwd, String email, String phone, int role) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", upwd=" + upwd + ", email=" + email + ", phone=" + phone + ", role=" + role
				+ "]";
	}
	
}

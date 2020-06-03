package nuc.lb.location.entity;

public class User {
	private String id;
	private String Wechat;
	private String password;
	private String name;
	private String home;
	private String number;
	private int stuid;
	public static String filename;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		
	}
	public User(String id, String wechat, String password, String name, String home, String number, int stuid) {
		super();
		this.id = id;
		Wechat = wechat;
		this.password = password;
		this.name = name;
		this.home = home;
		this.number = number;
		this.stuid = stuid;
	}
	public User(String[] userInfo){
		this.id = userInfo[0];
		//System.out.print(this.id+' ');
		//this.type = userInfo[1];
		//System.out.print(this.type);
		this.password = userInfo[2];
		//System.out.print(this.password);
		this.name = userInfo[3];
		//System.out.print(this.name);
		//this.sex = Byte.parseByte(userInfo[4]);
		//System.out.print(this.sex);
		//this.city = userInfo[5];
		//System.out.print(this.city);
		
	}
	public User(int stuid, String password) {
		super();
		this.stuid = stuid;
		this.password = password;
	}
	public String getWechat() {
		return Wechat;
	}
	public void setWechat(String wechat) {
		Wechat = wechat;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public static String getFilename() {
		return filename;
	}
	public static void setFilename(String filename) {
		User.filename = filename;
	}
	@Override
	public String toString() {
		return id +  ":" + password +":"+ Wechat + ":"  + name + ":" + number + ":" + stuid;
	}

}

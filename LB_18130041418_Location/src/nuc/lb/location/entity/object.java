package nuc.lb.location.entity;

public class object {
      private int uid;
      private String otype;
      private String place;
      private String number;
      private String qq;
      private String description;
      private String uname;
      
	public object(int uid, String otype, String place, String number, String qq, String description, String uname) {
		super();
		this.uid = uid;
		this.otype = otype;
		this.place = place;
		this.number = number;
		this.qq = qq;
		this.description = description;
		this.uname = uname;
	}
	public object() {}
	public object(String[] s) {	
		super();
		this.uid = Integer.parseInt(s[0]);
		this.otype = s[1];
		this.place = s[2];
		this.number = s[3];
		this.qq = s[4];
		this.description = s[5];
		this.uname = s[6];
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getOtype() {
		return otype;
	}
	public void setOtype(String otype) {
		this.otype = otype;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
    public String toString() {
		return uid+":"+otype+":"+place+":"+number+":"+qq+":"+description+":"+uname;
    }
}

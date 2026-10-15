import com.google.gson.annotations.SerializedName;

public class Grup {
	private String id;
	@SerializedName("Descripcio")
	private String desc;
	@SerializedName("Tipus")
	private String tps;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTps() {
		return tps;
	}
	public void setTps(String tps) {
		this.tps = tps;
	}
	@Override
	public String toString() {
		return "Grup [id=" + id + ", desc=" + desc + ", tps=" + tps + "]";
	}
	
	
	

}

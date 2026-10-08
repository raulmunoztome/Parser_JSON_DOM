import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Comida {
	@SerializedName("Descripcio")
	private Descripcio descripcio;
	//simple comentario
	@SerializedName("Grup")
	private Grup grup;
	@SerializedName("Tipus")
	private String tipus;
	
	public Descripcio getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(Descripcio descripcio) {
		this.descripcio = descripcio;
	}
	public Grup getGrup() {
		return grup;
	}
	public void setGrup(Grup grup) {
		this.grup = grup;
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
	
}

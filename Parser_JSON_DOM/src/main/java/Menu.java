import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Menu {
	
	@SerializedName("Menu")
	private List<Comida> comidas;

	public List<Comida> getComidas() {
		return comidas;
	}

	public void setComidas(List<Comida> comidas) {
		this.comidas = comidas;
	}

	@Override
	public String toString() {
		return "Menu [comidas=" + comidas + "]";
	}
	
	
	
}

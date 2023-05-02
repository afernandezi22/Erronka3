
public class Eskari {
	private int ID;
	private int ID_bezero;
	private int ID_egoera;
	private int ID_saltzaile;
	private String eskaera_data;
	private int azken_aldaketa;
	
	public Eskari() {}

	public Eskari(int ID, int ID_bezero, int ID_egoera, int iD_saltzaile, String eskaera_data, int azken_aldaketa) {
		this.ID = ID;
		this.ID_bezero = ID_bezero;
		this.ID_egoera = ID_egoera;
		this.ID_saltzaile = iD_saltzaile;
		this.eskaera_data = eskaera_data;
		this.azken_aldaketa = azken_aldaketa;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_bezero() {
		return ID_bezero;
	}

	public void setID_bezero(int iD_bezero) {
		ID_bezero = iD_bezero;
	}

	public int getID_egoera() {
		return ID_egoera;
	}

	public void setID_egoera(int iD_egoera) {
		ID_egoera = iD_egoera;
	}

	public int getID_saltzaile() {
		return ID_saltzaile;
	}

	public void setID_saltzaile(int iD_saltzaile) {
		ID_saltzaile = iD_saltzaile;
	}

	public String getEskaera_data() {
		return eskaera_data;
	}

	public void setEskaera_data(String eskaera_data) {
		this.eskaera_data = eskaera_data;
	}

	public int getAzken_aldaketa() {
		return azken_aldaketa;
	}

	public void setAzken_aldaketa(int azken_aldaketa) {
		this.azken_aldaketa = azken_aldaketa;
	}

	@Override
	public String toString() {
		return "Eskari [ID=" + ID + ", ID_bezero=" + ID_bezero + ", ID_egoera=" + ID_egoera + ", ID_saltzaile="
				+ ID_saltzaile + ", eskaera_data=" + eskaera_data + ", azken_aldaketa=" + azken_aldaketa + "]";
	}
}

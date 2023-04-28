public class Produktu {
	private int ID;
	private String izena;
	private String deskribapena;
	private double balioa;
	private double salneurria;
	private int ID_kategoria;
	
	public Produktu() {}
	
	public Produktu(int iD, String izena, String deskribapena, double balioa, double salneurria, int iD_kategoria) {
		super();
		ID = iD;
		this.izena = izena;
		this.deskribapena = deskribapena;
		this.balioa = balioa;
		this.salneurria = salneurria;
		ID_kategoria = iD_kategoria;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public double getBalioa() {
		return balioa;
	}

	public void setBalioa(double balioa) {
		this.balioa = balioa;
	}

	public double getSalneurria() {
		return salneurria;
	}

	public void setSalneurria(double salneurria) {
		this.salneurria = salneurria;
	}

	public int getID_kategoria() {
		return ID_kategoria;
	}

	public void setID_kategoria(int iD_kategoria) {
		ID_kategoria = iD_kategoria;
	}

	@Override
	public String toString() {
		return "Produktu [ID=" + ID + ", izena=" + izena + ", deskribapena=" + deskribapena + ", balioa=" + balioa
				+ ", salneurria=" + salneurria + ", ID_kategoria=" + ID_kategoria + "]";
	}
}

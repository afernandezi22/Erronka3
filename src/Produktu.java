/**
 * Produktu baten informazioa gordetzeko klasea.
 * @author Talde3
 * @version 2023/05/05
 *
 */
public class Produktu {
	private int ID;
	private String izena;
	private String deskribapena;
	private double balioa;
	private double salneurria;
	private int ID_kategoria;
	/**
	 * Lehenetsitako sortzailea.
	 */
	public Produktu() {}
	/**
	 * Sortzailea parametroekin
	 * @param iD
	 * @param izena
	 * @param deskribapena
	 * @param balioa
	 * @param salneurria
	 * @param iD_kategoria
	 */
	public Produktu(int iD, String izena, String deskribapena, double balioa, double salneurria, int iD_kategoria) {
		super();
		ID = iD;
		this.izena = izena;
		this.deskribapena = deskribapena;
		this.balioa = balioa;
		this.salneurria = salneurria;
		ID_kategoria = iD_kategoria;
	}
	/**
	 * IDa bueltatzen du
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	/**
	 * IDa aldatzen du
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * Izena bueltatzen du
	 * @return izena
	 */
	public String getIzena() {
		return izena;
	}
	/**
	 * Izena aldatzen du
	 * @param izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}
	/**
	 * Deskribapena bueltatzen du
	 * @return deskribapena
	 */
	public String getDeskribapena() {
		return deskribapena;
	}
	/**
	 * Deskribapen aldatzen du
	 * @param deskribapena
	 */
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	/**
	 * Balioa bueltatzen du.
	 * @return balioa
	 */
	public double getBalioa() {
		return balioa;
	}
	/**
	 * Balioa ladatzen du
	 * @param balioa
	 */
	public void setBalioa(double balioa) {
		this.balioa = balioa;
	}
	/**
	 * Salneurria bueltatzen du.
	 * @return salneurria
	 */
	public double getSalneurria() {
		return salneurria;
	}
	/**
	 * Salneurria aldatzen du.
	 * @param salneurria
	 */
	public void setSalneurria(double salneurria) {
		this.salneurria = salneurria;
	}
	/**
	 * Kategoriaren ID-a bueltatzen du
	 * @return ID_kategoria
	 */
	public int getID_kategoria() {
		return ID_kategoria; 
	}
	/**
	 * Kategoriaren IDa aldatzen du
	 * @param iD_kategoria
	 */
	public void setID_kategoria(int iD_kategoria) {
		ID_kategoria = iD_kategoria;
	}
	/**
	 * Klasearen toString
	 * @return toString osoa
	 */
	@Override
	public String toString() {
		return "Produktu [ID=" + ID + ", izena=" + izena + ", deskribapena=" + deskribapena + ", balioa=" + balioa
				+ ", salneurria=" + salneurria + ", ID_kategoria=" + ID_kategoria + "]";
	}
}

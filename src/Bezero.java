/**
 * Bezero bakarraren informazioa gordetzen duen klasea
 * @author Talde3
 * @version 2023/05/05
 */
public class Bezero {
	private int ID;
	private String izena;
	private String abizena;
	private String helbidea;
	private String emaila;
	private String pasahitza;
	private int VIP;
	/**
	 * Lehenetsitako sortzailea. Ez du ezer egiten.
	 */
		public Bezero() {}
	
		/**
		 * Sortzailea parametroekin
		 * @param iD
		 * @param izena
		 * @param abizena
		 * @param helbidea
		 * @param emaila
		 * @param pasahitza
		 * @param vIP
		 */
		public Bezero(int iD, String izena, String abizena, String helbidea, String emaila, String pasahitza, int vIP) {
			super();
			ID = iD;
			this.izena = izena;
			this.abizena = abizena;
			this.helbidea = helbidea;
			this.emaila = emaila;
			this.pasahitza = pasahitza;
			VIP = vIP;
		}
		/**
		 * ID-aren getterra
		 * @return ID
		 */
		public int getID() {
			return ID;
		}
		/**
		 * ID-aren setterra
		 * @param iD
		 */
		public void setID(int iD) {
			ID = iD;
		}
		/**
		 * Izenaren getterra
		 * @return izena
		 */
		public String getIzena() {
			return izena;
		}
		/**
		 * Izenaren setterra
		 * @param izena
		 */
		public void setIzena(String izena) {
			this.izena = izena;
		}
		/**
		 * Abizearen gettera
		 * @return abizean
		 */
		public String getAbizena() {
			return abizena;
		}
		/**
		 * Abizenaren setterra
		 * @param abizena
		 */
		public void setAbizena(String abizena) {
			this.abizena = abizena;
		}
		/**
		 * Helbidearen getterra
		 * @return helbidea
		 */
		public String getHelbidea() {
			return helbidea;
		}
		/**
		 * Helbidearen setterra
		 * @param helbidea
		 */
		public void setHelbidea(String helbidea) {
			this.helbidea = helbidea;
		}
		/**
		 * Emailaren gettera
		 * @return emaila
		 */
		public String getEmaila() {
			return emaila;
		}
		/**
		 * Emailaren setterra
		 * @param emaila
		 */
		public void setEmaila(String emaila) {
			this.emaila = emaila;
		}
		/**
		 * Pasahitzaren getterra
		 * @return pasahitza
		 */
		public String getPasahitza() {
			return pasahitza;
		}
		/**
		 * Pasahitzaren setterra
		 * @param pasahitza
		 */
		public void setPasahitza(String pasahitza) {
			this.pasahitza = pasahitza;
		}
		/**
		 * VIParen gettera
		 * @return
		 */
		public int getVIP() {
			return VIP;
		}
		/**
		 * VIParen setterra
		 * @param vIP
		 */
		public void setVIP(int vIP) {
			VIP = vIP;
		}


}

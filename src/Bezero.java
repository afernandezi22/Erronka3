
public class Bezero {
	private int ID;
	private String izena;
	private String abizena;
	private String helbidea;
	private String emaila;
	private String pasahitza;
	private int VIP;
		public Bezero() {}
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
		public String getAbizena() {
			return abizena;
		}
		public void setAbizena(String abizena) {
			this.abizena = abizena;
		}
		public String getHelbidea() {
			return helbidea;
		}
		public void setHelbidea(String helbidea) {
			this.helbidea = helbidea;
		}
		public String getEmaila() {
			return emaila;
		}
		public void setEmaila(String emaila) {
			this.emaila = emaila;
		}
		public String getPasahitza() {
			return pasahitza;
		}
		public void setPasahitza(String pasahitza) {
			this.pasahitza = pasahitza;
		}
		public int getVIP() {
			return VIP;
		}
		public void setVIP(int vIP) {
			VIP = vIP;
		}
		
		
}

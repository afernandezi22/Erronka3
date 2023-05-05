
/**
 * Datu Basearen konexioa
 * @author Talde3
 * @version 05/05/2023
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DB {

	private String url;
	private String user;
	private String pass;

	/*
	public DB() {
		this.url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		this.user = "ERRONKA_HIRU";
		this.pass = "ERRONKA_HIRU";
	}*/
	
	/**
	 * Lehenetsitako sortzailea. Aukeratutako datubasera konektatuko da
	 */
	public DB() {
		this.url = "jdbc:oracle:thin:@192.168.106.11:1521/xepdb1";
		this.user = "GAMESTOP";
		this.pass = "GAMESTOP";
	}

	/**
	 * sortzailea parametroekin
	 *
	 * @param url  esteka
	 * @param user erabiltzailea
	 * @param pass pasahitza
	 */
	public DB(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	/**
	 * Konexioa egiten du
	 */
	public Connection konexioa() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}

	/**
	 * Bezeroa datu-basean dagoen edo ez konprobatzeko
	 *
	 * @param String erabiltzailea erabiltzailearen izena
	 * @return ondo boolean moduan ondo badago true bueltatuko du
	 * @see #bezeroLogin(String, String);
	 */
	public boolean bezeroDago(String erabiltzailea) {
		boolean ondo = false;
		String sql = "SELECT EMAILA FROM BEZERO";
		String erabil = "";
		try {
			Connection conn = konexioa();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				erabil = rs.getString("EMAILA");
				if (erabil.equals(erabiltzailea)) {
					ondo = true;
					break;
				}
			}
			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
			ondo = false;
		}

		return ondo;
	}

	/**
	 * Logina. Datu-baseko funtzio bat erabiltzen du
	 *
	 * @param String erabiltzailea erabiltzailearen emaiila
	 * @param String pasahitza erabiltzailearen pasahitza
	 * @boolean ondo boolean moduan ondo badago true bueltatuko du
	 */
	public boolean bezeroLogin(String erabiltzailea, String pasahitza) {
		int ondo = 0;
		try {
			Connection conn = konexioa();
			CallableStatement cstmt = conn.prepareCall("{? = call BEZEROLOGIN(?,?)}"); // call minuskulaz egon behar da,
																						// bestela ez du aurkitzen
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, erabiltzailea);
			cstmt.setString(3, pasahitza);
			cstmt.executeUpdate();
			ondo = cstmt.getInt(1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
			ondo = 0;
		}
		if (ondo == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Saltzailea datu-basean dagoen edo ez konprobatzeko
	 * @param erabiltzailea
	 * @return ondo boolean moduan ondo badago true bueltatuko du
	 * @see #saltzaileLogin(String, String);
	 */
	public boolean saltzaileDago(String erabiltzailea) {
		boolean ondo = false;
		String sql = "SELECT ERABILTZAILEA FROM SALTZAILE";
		String erabil = "";
		try {
			Connection conn = konexioa();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				erabil = rs.getString("ERABILTZAILEA");
				if (erabil.equals(erabiltzailea)) {
					ondo = true;
					break;
				}
			}
			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
			ondo = false;
		}

		return ondo;
	}

	/**
	 * Saltzailearen logina. Datu-basean dagoen funtzioa erabiltzen du
	 * @param erabiltzailea saltzailearen erabiltzailea
	 * @param pasahitza saltzailearen pasahitza
	 * @return ondo boolean moduan ondo badago true bueltatuko du
	 */
	public boolean saltzaileLogin(String erabiltzailea, String pasahitza) {
		int ondo = 0;
		try {
			Connection conn = konexioa();
			CallableStatement cstmt = conn.prepareCall("{? = call SALTZAILELOGIN(?,?)}"); // call minuskulaz egon behar
																							// da, bestela ez du
																							// aurkitzen
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, erabiltzailea);
			cstmt.setString(3, pasahitza);
			cstmt.executeUpdate();
			ondo = cstmt.getInt(1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
			ondo = 0;
		}
		if (ondo == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Datu-basean dagoen produktuen preziorik handiena bueltatzen du
	 * @return handiena preziorik handiena
	 */
	public double prezioHandiena() {
		double handiena = 0;
		String sql = "SELECT MAX(SALNEURRIA) AS HANDIENA FROM PRODUKTU";
		try {
			Connection conn = konexioa();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			handiena = rs.getDouble("HANDIENA");

			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}

		return handiena;
	}

	/**
	 * Datu-basean dauden produktu guztiak lortzeko. Filtro barik
	 *
	 * @return Produktuak produktu guztiak
	 */
	public Produktuak getProduktuak() {
		Produktuak pk = new Produktuak();
		String sql = "SELECT * FROM PRODUKTU";
		try {
			Connection conn = konexioa();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Produktu p = new Produktu(rs.getInt("ID"), rs.getString("IZENA"), rs.getString("DESKRIBAPENA"),
						rs.getDouble("BALIOA"), rs.getDouble("SALNEURRIA"), rs.getInt("ID_KATEGORIA"));
				pk.addProduktu(p);
			}

			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
		return pk;
	}

	/**
	 * Datu-basean dauden produktuak, kategoria kontuan hartuta
	 *
	 * @param int kategoria aukeratutako kategoria
	 * @return Produktuak filtratutako produktuak
	 */
	public Produktuak getKategoriarekin(int kategoria) {
		String sql = "SELECT * FROM PRODUKTU WHERE ID_KATEGORIA = ?";
		Produktuak pk = new Produktuak();
		try {
			Connection conn = konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (kategoria + 1));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produktu p = new Produktu(rs.getInt("ID"), rs.getString("IZENA"), rs.getString("DESKRIBAPENA"),
						rs.getDouble("BALIOA"), rs.getDouble("SALNEURRIA"), rs.getInt("ID_KATEGORIA"));
				pk.addProduktu(p);
			}

			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
		return pk;
	}

	/**
	 * Datu-basean dauden produktuak, filtro guztiekin
	 * @param double  gehienezkoPrezioa prezio maximoaren filtroa
	 * @param double  gutxienezkoPrezioa prezio minimoaren filtroa
	 * @param boolean maxMin handienetik txikiraren filtroa
	 * @param boolean minMax txikienetik handiraren filtroa
	 * @param boolean stock stock-aren filtroa
	 * @param int     lehenengo lehenengo ... -en filtroa
	 * @param int     kategoria kategoriaren filtroa
	 * @return Produktuak filtro guztiekin
	 */
	public Produktuak getFiltroekin(double gehienezkoPrezioa, double gutxienezkoPrezioa, boolean maxMin, boolean minMax,
			boolean stock, int lehenengo, int kategoria) {
		String order = "ASC", stockString = "NOT IN";
		String sql = null;
		if (maxMin) {
			order = "DESC";
		}
		if (minMax) {
			order = "ASC";
		}
		if (stock) {
			stockString = "IN";
		} else {
			stockString = "NOT IN";
		}
		if (kategoria != 5) {
			sql = "SELECT * FROM PRODUKTU WHERE SALNEURRIA > ? AND SALNEURRIA < ? AND ID " + stockString
					+ " (SELECT ID_PRODUKTU FROM INBENTARIO) AND ID_KATEGORIA = ? ORDER BY SALNEURRIA " + order
					+ " FETCH FIRST ? ROWS ONLY";
		} else {
			sql = "SELECT * FROM PRODUKTU WHERE SALNEURRIA > ? AND SALNEURRIA < ? AND ID " + stockString
					+ " (SELECT ID_PRODUKTU FROM INBENTARIO) ORDER BY SALNEURRIA " + order + " FETCH FIRST ? ROWS ONLY";
		}
		Produktuak pk = new Produktuak();
		try {
			Connection conn = konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, gehienezkoPrezioa);
			stmt.setDouble(2, gutxienezkoPrezioa);
			if (kategoria != 5) {
				stmt.setInt(3, (kategoria + 1));
				stmt.setInt(4, lehenengo);
			} else {
				stmt.setInt(3, lehenengo);
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produktu p = new Produktu(rs.getInt("ID"), rs.getString("IZENA"), rs.getString("DESKRIBAPENA"),
						rs.getDouble("BALIOA"), rs.getDouble("SALNEURRIA"), rs.getInt("ID_KATEGORIA"));
				pk.addProduktu(p);
			}

			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
		return pk;
	}

	/**
	 * Bezeroak erregistratzeko
	 *
	 * @param JTextField izenaTF 
	 * @param JTextField abizenaTF 
	 * @param JTextField helbideaTF 
	 * @param JTextField emailaTF 
	 * @param JTextField tFPasahitza 
	 */
	public void erregistratuBezeroa(JTextField izenaTF, JTextField abizenaTF, JTextField helbideaTF,
			JTextField emailaTF, JTextField tFPasahitza) {
		try {
			Connection conn = konexioa();
			CallableStatement cstmt = conn.prepareCall("{call BEZEROERREGISTRO(?, ?, ?, ?, ?)}"); // call minuskulaz
																									// egon behar da,
																									// bestela ez du
																									// aurkitzen
			cstmt.setString(1, izenaTF.getText());
			cstmt.setString(2, abizenaTF.getText());
			cstmt.setString(3, helbideaTF.getText());
			cstmt.setString(4, emailaTF.getText());
			cstmt.setString(5, tFPasahitza.getText());

			cstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Erregistro zuzena!", "ONDO", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	/**
	 * Eskari zehatz bat lortzeko
	 * @param ID
	 * @return Eskari aukeratutako eskaria bueltatzen du
	 */
	public Eskari getEskari(int ID) {
		String sql = "SELECT ID, ID_BEZERO, ID_EGOERA, ID_SALTZAILE, TO_CHAR(ESKAERA_DATA, 'YYYY/MM/DD HH24:MI') AS ESK_DATA, AZKEN_ALDAKETA FROM ESKARI WHERE ID = ?";
		Eskari es = null;
		try {
			Connection conn = konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				es = new Eskari(rs.getInt("ID"), rs.getInt("ID_BEZERO"), rs.getInt("ID_EGOERA"),
						rs.getInt("ID_SALTZAILE"), rs.getString("ESK_DATA"), rs.getInt("AZKEN_ALDAKETA"));
			}

			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
		return es;
	}
	
	/**
	 * Erabiltzaile batek egindako eskari guztiak lortzeko
	 * @param erabiltzaile erabiltzailearen emaila
	 * @return Eskariak erabiltzailearen eskariak
	 */
	public Eskariak bezeroEskariak(String erabiltzaile) {
		Eskariak ee = new Eskariak();
		String sql = "SELECT ID, ID_BEZERO, ID_EGOERA, ID_SALTZAILE, TO_CHAR(ESKAERA_DATA, 'YYYY/MM/DD HH24:MI') AS ESK_DATA, AZKEN_ALDAKETA FROM ESKARI WHERE ID_BEZERO = (SELECT ID FROM BEZERO WHERE EMAILA = ?)";
		try {
			Connection conn = konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, erabiltzaile);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Eskari es = new Eskari(rs.getInt("ID"), rs.getInt("ID_BEZERO"), rs.getInt("ID_EGOERA"),
						rs.getInt("ID_SALTZAILE"), rs.getString("ESK_DATA"), rs.getInt("AZKEN_ALDAKETA"));
				ee.addEskari(es);
			}

			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
		return ee;
	}
	/**
	 * Prezioak aldatzeko horien stocka kontuan hartuta
	 * @param cpuStock CPUaren stocka
	 * @param vcStock Video Card-en stocka
	 * @param ramStock RAM-en stocka
	 * @param mbStock Mother board-en stocka
	 * @param storageStock Storage-en stocka
	 * @param cpuIgo CPU % zenbat igo
	 * @param vcIgo Video card % zenbat igo
	 * @param ramIgo RAM % zenbat igo
	 * @param mbIgo Mother board % zenbat igo
	 * @param storageIgo Storage % zenbat igo
	 */
	public void prezioakAldatu(int cpuStock, int vcStock, int ramStock, int mbStock, int storageStock, int cpuIgo,
			int vcIgo, int ramIgo, int mbIgo, int storageIgo) {
		try {
			Connection conn = konexioa();
			CallableStatement cstmt = conn.prepareCall("{call IGOPREZIOAK(?,?,?,?,?,?,?,?,?,?)}"); // call minuskulaz
																									// egon behar da,
																									// bestela ez du
																									// aurkitzen
			cstmt.setInt(1, cpuStock);
			cstmt.setInt(2, vcStock);
			cstmt.setInt(3, ramStock);
			cstmt.setInt(4, mbStock);
			cstmt.setInt(5, storageStock);
			cstmt.setInt(6, cpuIgo);
			cstmt.setInt(7, vcIgo);
			cstmt.setInt(8, ramIgo);
			cstmt.setInt(9, mbIgo);
			cstmt.setInt(10, storageIgo);
			int zenbat = cstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, zenbat + " lerro eguneratu dira guztira", "ONDO",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Eskari baten egoera aldatzeko, nork egin duen kontuan hartuta
	 * @param egoera nahi duzun egoera datu-basean dagoen ID-a erabiliz
	 * @param erabiltzaile aldaketa egin duen saltzailearen erabiltzailea
	 * @param kodea eskariaren ID-a
	 */
	public void eskariEgoera(int egoera, String erabiltzaile, int kodea) {
		String sql = "UPDATE ESKARI SET ID_EGOERA = ?, AZKEN_ALDAKETA = (SELECT ID FROM SALTZAILE WHERE ERABILTZAILEA = ?) WHERE ID = ?";
		try {
			Connection conn = konexioa();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, egoera + 1);
			statement.setString(2, erabiltzaile);
			statement.setInt(3, kodea);
			statement.executeUpdate();
			conn.close();
			statement.close();
			JOptionPane.showMessageDialog(null, "Ondo eguneratu da " + kodea + " eskariaren egoera.", "ONDO",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Erosketa egiteko funtzioa. Datu-basean dagoen funtzioa erabiltzen du
	 * @param produktuKodea aukeratutako produktuaren kodea
	 * @param erabiltzaile erosketa egin duen bezeroa
	 */
	public void erosi(int produktuKodea, String erabiltzaile) {
		try {
			Connection conn = konexioa();
			CallableStatement cstmt = conn.prepareCall("{call EROSKETAPROZEDURA(?,?)}"); // call minuskulaz egon behar
																							// da, bestela ez du
																							// aurkitzen
			cstmt.setInt(1, produktuKodea);
			cstmt.setString(2, erabiltzaile);
			cstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Erosketa eginda!", "ONDO", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Bezero zehatz bat lortzeko
	 * @param ID bezeroaren ID-a
	 * @return Bezero
	 */
	public Bezero getBezero(int ID) {
		String sql = "SELECT * FROM BEZERO WHERE ID = ?";
		Bezero b = null;
		try {
			Connection conn = konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				b = new Bezero(rs.getInt("ID"), rs.getString("IZENA"), rs.getString("ABIZENA"),
						rs.getString("HELBIDEA"), rs.getString("EMAILA"), rs.getString("PASAHITZA"), rs.getInt("VIP"));
			}

			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
		return b;
	}
	/**
	 * Bezero baten informazioa eguneratzeko
	 * @param izena
	 * @param abizena
	 * @param helbidea
	 * @param emaila
	 * @param VIP
	 * @param ID
	 */
	public void eguneratuBezero(String izena, String abizena, String helbidea, String emaila, int VIP, int ID) {
		String sql;
		if (VIP == 0) {
			sql = "UPDATE BEZERO SET IZENA = ?, ABIZENA = ?, HELBIDEA = ?, EMAILA = ?, VIP = null WHERE ID = ?";
		} else {
			sql = "UPDATE BEZERO SET IZENA = ?, ABIZENA = ?, HELBIDEA = ?, EMAILA = ?, VIP = ? WHERE ID = ?";
		}
		try {
			Connection conn = konexioa();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, izena);
			statement.setString(2, abizena);
			statement.setString(3, helbidea);
			statement.setString(4, emaila);
			if (VIP == 0) {
				statement.setInt(5, ID);
			} else {
				statement.setInt(5, VIP);
				statement.setInt(6, ID);
			}
			statement.executeUpdate();
			conn.close();
			statement.close();
			JOptionPane.showMessageDialog(null, "Ondo eguneratu da " + ID + " bezeroaren informazioa.", "ONDO",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Bezero zehatz bat ezabatzeko
	 * @param ID
	 */
	public void ezabatuBezero(int ID) {
		String sql = "DELETE FROM BEZERO WHERE ID = ?";
		try {
			Connection conn = konexioa();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, ID);
			statement.executeUpdate();
			conn.close();
			statement.close();
			JOptionPane.showMessageDialog(null, "Ondo ezabatu da " + ID + " bezeroa.", "ONDO",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Bezeroen VIP-a eguneratzeko. Programa zabaltzen den bakoitzean automatikoki exekutatzen da. Datu-basean dagoen prozedura erabiltzen du
	 */
	public void vipEguneratu() {
		try {
			Connection conn = konexioa();
			CallableStatement cstmt = conn.prepareCall("{call BEZEROVIP}"); // call minuskulaz egon behar da, bestela ez du aurkitzen
			cstmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Erabiltzaile zehatz batek duen VIP-a bueltatzen du String moduan
	 * @param erabiltzaile
	 * @return VIP String moduan
	 */
	public String zeinVIP(String erabiltzaile) {
		String sql = "SELECT VIP FROM BEZERO WHERE EMAILA = ?";
		String VIP = null;
		try {
			Connection conn = konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, erabiltzaile);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			switch(rs.getInt("VIP")) {
			case 1:
				VIP = "CPU";
				break;
			case 2:
				VIP = "Video card";
				break;
			case 3:
				VIP = "RAM";
				break;
			case 4:
				VIP = "Mother board";
			case 5:
				VIP = "Storage";
				break;
			default:
				VIP = "Ez dago";
				break;
			}

			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
			VIP = "Ez dago";
		}
		return VIP;
	}
}
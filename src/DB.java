
/**
 * @clase Datu Basearen konexioa
 * @author Talde3
 * @param
 * @return
 * @version 02/05/2023
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

	/**
	 * defektuzko sortzailea
	 *
	 * @param ez
	 */
	/*
	public DB() {
		this.url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		this.user = "ERRONKA_HIRU";
		this.pass = "ERRONKA_HIRU";
	}*/
	
	public DB() {
		this.url = "jdbc:oracle:thin:@192.168.106.11:1521/xepdb1";
		this.user = "GAMESTOP";
		this.pass = "GAMESTOP";
	}

	/**
	 * sortzailea parametroekin
	 *
	 * @param url  --> esteka
	 * @param user --> erabiltzailea
	 * @param pass --> pasahitza
	 */
	public DB(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	/**
	 * konexioa egin, bat generikoa balio izango duena konexio guztietarako
	 *
	 * @param ez
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
	 * konexioa produktuekin
	 *
	 * @param ez
	 */
	public void erakutsiProd() {
		try {
			Connection conn = konexioa();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUKTU");
			while (rs.next()) {
				System.out.println(rs.getString("IZENA"));
			}
			// konexioak itxi
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Bezeroa datu-basean dagoen edo ez konprobatzeko
	 *
	 * @param String erabiltzailea --> erabiltzailea+
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
	 * LOGIN BERRIA. DATU-BASEAN DAGOEN FUNTZIOA ERABILTZEN DU
	 *
	 * @param String erabiltzailea --> erabiltzailea
	 * @param String pasahitza --> pasahitza
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
	 * Datu-basean dagoen preziorik handiena lortzeko
	 *
	 * @param ez
	 */

	// Saltzailea datu-basean dagoen edo ez konprobatzeko
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

	// SALTZAILEAREN LOGINA. DATU-BASEAN DAGOEN FUNTZIOA ERABILTZEN DU
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

	// Datu-basean dagoen preziorik handiena lortzeko
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
	 * @param ez
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
	 * @param int kategoria --> kategoria
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
	 *
	 * @param double  gehienezkoPrezioa --> prezio maximoaren filtroa
	 * @param double  gutxienezkoPrezioa --> prezio minimoaren filtroa
	 * @param boolean maxMin --> handienetik txikiraren filtroa
	 * @param boolean minMax --> txikienetik handiraren filtroa
	 * @param boolean stock --> stock-aren filtroa
	 * @param int     lehenengo --> lehenengo ... -en filtroa
	 * @param int     kategoria --> kategoriaren filtroa
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
	 * @param JTextField izenaTF -->
	 * @param JTextField abizenaTF -->
	 * @param JTextField helbideaTF -->
	 * @param JTextField emailaTF -->
	 * @param JTextField tFPasahitza -->
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
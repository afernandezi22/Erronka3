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
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.sql.PreparedStatement;
import javax.swing.*;
public class DB {

   private String url;
   private String user;
   private String pass;
   
   /**  
	 * defektuzko sortzailea 
	 * @param ez
	 */
   public DB (){
      this.url="jdbc:oracle:thin:@localhost:1521/xepdb1";
      this.user="ERRONKA_HIRU";
      this.pass="ERRONKA_HIRU";
   }
   
   /**  
	 * sortzailea parametroekin
	 * @param url --> esteka
	 * @param user --> erabiltzailea
	 * @param pass --> pasahitza
	 */
   public DB (String url, String user, String pass){
      this.url=url;
      this.user=user;
      this.pass=pass;
   }
   
   /**  
	 * konexioa egin, bat generikoa balio izango duena konexio guztietarako
	 * @param ez
	 */
   public Connection konexioa (){
      Connection conn = null;
      try{
         conn = DriverManager.getConnection(url, user, pass);
         return conn;
      } catch (Exception e){
         System.out.println("Konexio errorea: "+e);
      }
      return conn;
   }

   /**  
	 * konexioa produktuekin
	 * @param ez
	 */
    public void erakutsiProd(){
        try {
            Connection conn = konexioa();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUKTU");
            while (rs.next()) {
                System.out.println(rs.getString("IZENA"));
            }
            //konexioak itxi
            conn.close();
            stmt.close();
            rs.close();
         } catch (SQLException e) {
             System.out.println("ERROREA: " + e);
         }
    }
    
    /**  
	 * Bezeroa datu-basean dagoen edo ez konprobatzeko
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
	            if(erabil.equals(erabiltzailea)) {
	            	ondo = true;
	            	break;
	            }
            }
            //konexioak itxi
            conn.close();
            stmt.close();
            rs.close(); 
    	}catch(SQLException e) {
    		System.out.println("Errorea " + e);
    		ondo = false;
    	}
    	
    	return ondo;
    }
    
    /**  
	 * LOGIN BERRIA. DATU-BASEAN DAGOEN FUNTZIOA ERABILTZEN DU
	 * @param String erabiltzailea --> erabiltzailea
	 * @param String pasahitza --> pasahitza
	 */
    public boolean bezeroLogin(String erabiltzailea, String pasahitza) {  
    	int ondo = 0;
    	try{
    		Connection conn = konexioa();
    		CallableStatement cstmt = conn.prepareCall("{? = call BEZEROLOGIN(?,?)}"); //call minuskulaz egon behar da, bestela ez du aurkitzen
        	cstmt.registerOutParameter(1, Types.INTEGER);
        	cstmt.setString(2, erabiltzailea);
        	cstmt.setString(3, pasahitza);
        	cstmt.executeUpdate();
        	ondo = cstmt.getInt(1);
    	}catch(SQLException e) {
    		System.out.println("Errorea "+ e);
    		ondo = 0;
    	}
    	if(ondo == 0) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
    
    /**  
	 * Datu-basean dagoen preziorik handiena lortzeko
	 * @param ez
	 */

  //Saltzailea datu-basean dagoen edo ez konprobatzeko
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
	            if(erabil.equals(erabiltzailea)) {
	            	ondo = true;
	            	break;
	            }
            }
            //konexioak itxi
            conn.close();
            stmt.close();
            rs.close(); 
    	}catch(SQLException e) {
    		System.out.println("Errorea " + e);
    		ondo = false;
    	}
    	
    	return ondo;
    }
    
    //SALTZAILEAREN LOGINA. DATU-BASEAN DAGOEN FUNTZIOA ERABILTZEN DU
    public boolean saltzaileLogin(String erabiltzailea, String pasahitza) {  
    	int ondo = 0;
    	try{
    		Connection conn = konexioa();
    		CallableStatement cstmt = conn.prepareCall("{? = call SALTZAILELOGIN(?,?)}"); //call minuskulaz egon behar da, bestela ez du aurkitzen
        	cstmt.registerOutParameter(1, Types.INTEGER);
        	cstmt.setString(2, erabiltzailea);
        	cstmt.setString(3, pasahitza);
        	cstmt.executeUpdate();
        	ondo = cstmt.getInt(1);
    	}catch(SQLException e) {
    		System.out.println("Errorea "+ e);
    		ondo = 0;
    	}
    	if(ondo == 0) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
    //Datu-basean dagoen preziorik handiena lortzeko
    public double prezioHandiena() {
    	double handiena = 0;
    	String sql = "SELECT MAX(SALNEURRIA) AS HANDIENA FROM PRODUKTU";
    	try {
    		Connection conn = konexioa();
    		Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            handiena = rs.getDouble("HANDIENA");

            //konexioak itxi
            conn.close();
            stmt.close();
            rs.close(); 
    	}catch(SQLException e) {
    		System.out.println("Errorea " + e);
    	}
    	
    	return handiena;
    }
    
    /**  
	 * Datu-basean dauden produktu guztiak lortzeko. Filtro barik
	 * @param ez
	 */
    public Produktuak getProduktuak() {
    	Produktuak pk = new Produktuak();
    	String sql = "SELECT * FROM PRODUKTU";
    	try {
    		Connection conn = konexioa();
    		Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            while(rs.next()) {
            	Produktu p = new Produktu(rs.getInt("ID"), rs.getString("IZENA"), rs.getString("DESKRIBAPENA"), rs.getDouble("BALIOA"), rs.getDouble("SALNEURRIA"), rs.getInt("ID_KATEGORIA"));
            	pk.addProduktu(p);
            }

            //konexioak itxi
            conn.close();
            stmt.close();
            rs.close(); 
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA", JOptionPane.ERROR_MESSAGE);
    	}
    	return pk;
    }
    
    /**  
	 * Datu-basean dauden produktuak, kategoria kontuan hartuta
	 * @param int kategoria --> kategoria
	 */
    public Produktuak getKategoriarekin(int kategoria) {
    	String sql = "SELECT * FROM PRODUKTU WHERE ID_KATEGORIA = ?";
    	Produktuak pk = new Produktuak();
    	try {
    		Connection conn = konexioa();
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setInt(1, (kategoria+1));
            ResultSet rs = stmt.executeQuery();
            rs.next();
            while(rs.next()) {
            	Produktu p = new Produktu(rs.getInt("ID"), rs.getString("IZENA"), rs.getString("DESKRIBAPENA"), rs.getDouble("BALIOA"), rs.getDouble("SALNEURRIA"), rs.getInt("ID_KATEGORIA"));
            	pk.addProduktu(p);
            }

            //konexioak itxi
            conn.close();
            stmt.close();
            rs.close(); 
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA", JOptionPane.ERROR_MESSAGE);
    	}
    	return pk;
    }
    
    /**  
	 * Datu-basean dauden produktuak, filtro guztiekin
	 * @param double gehienezkoPrezioa --> prezio maximoaren filtroa
	 * @param double gutxienezkoPrezioa --> prezio minimoaren filtroa
	 * @param boolean maxMin --> handienetik txikiraren filtroa
	 * @param boolean minMax --> txikienetik handiraren filtroa  
	 * @param boolean stock --> stock-aren filtroa
	 * @param int lehenengo --> lehenengo ... -en filtroa
	 * @param int kategoria --> kategoriaren filtroa
	 */
    public Produktuak getFiltroekin(double gehienezkoPrezioa, double gutxienezkoPrezioa, boolean maxMin, boolean minMax, boolean stock, int lehenengo, int kategoria) {
    	String sql = "SELECT * FROM PRODUKTU WHERE SALNEURRIA > ? AND SALNEURRIA < ? AND ID IN(SELECT ID_PRODUKTU FROM INBENTARIO) AND ID_KATEGORIA = ? ORDER BY SALNEURRIA ASC FETCH FIRST ? ROWS ONLY";
    	Produktuak pk = new Produktuak();
    	String order = "ASC", stockString = "NOT IN";
    	if(maxMin) {
    		order = "DESC";
    	}
    	if(minMax) {
    		order = "ASC";
    	}
    	if(stock) {
    		stockString = "IN";
    	}
    	else {
    		stockString = "NOT IN";
    	}
    	try {
    		Connection conn = konexioa();
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setDouble(1, gehienezkoPrezioa);
    		stmt.setDouble(2, gutxienezkoPrezioa);
    		//stmt.setString(3, stockString);
    		stmt.setInt(3, (kategoria+1));
    		//stmt.setString(4, order);
    		stmt.setInt(4, lehenengo);
    		
            ResultSet rs = stmt.executeQuery();
            rs.next();
            while(rs.next()) {
            	Produktu p = new Produktu(rs.getInt("ID"), rs.getString("IZENA"), rs.getString("DESKRIBAPENA"), rs.getDouble("BALIOA"), rs.getDouble("SALNEURRIA"), rs.getInt("ID_KATEGORIA"));
            	pk.addProduktu(p);
            }

            //konexioak itxi
            conn.close();
            stmt.close();
            rs.close(); 
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, "Errore bat egon da datu-basera konektatzean: \n" + e, "ERROREA", JOptionPane.ERROR_MESSAGE);
    	}
    	return pk;
    } 
    
    /**  
	 * Bezeroak erregistratzeko
	 * @param JTextField izenaTF --> 
	 * @param JTextField abizenaTF --> 
	 * @param JTextField helbideaTF --> 
	 * @param JTextField emailaTF -->  
	 * @param JTextField tFPasahitza --> 
	 */
    public void erregistratuBezeroa(JTextField izenaTF, JTextField abizenaTF, JTextField helbideaTF, JTextField emailaTF, JTextField tFPasahitza) {
    	String sql = "INSERT INTO BEZEROAK VALUES (?, ?, ? , ?, ?)";
    	try{
            Connection conn = konexioa();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, izenaTF.getText());
            statement.setString(1, abizenaTF.getText()); 
            statement.setString(1, helbideaTF.getText()); 
            statement.setString(1, emailaTF.getText()); 
            statement.setString(1, tFPasahitza.getText()); 
            statement.executeUpdate();
            conn.close();
            statement.close();                                                                                 
         }catch(SQLException e){
            System.out.println("ERROREA: " +e);
         }
    }
}
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
   
   //defektuzko sortzailea 
   public DB (){
      this.url="jdbc:oracle:thin:@localhost:1521/xepdb1";
      this.user="ERRONKA_HIRU";
      this.pass="ERRONKA_HIRU";
   }
   
   //sortzailea parametroekin
   public DB (String url, String user, String pass){
      this.url=url;
      this.user=user;
      this.pass=pass;
   }
   
   
   //konexioa egin, bat generikoa balio izango duena konexio guztietarako
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
    
    //Bezeroa datu-basean dagoen edo ez konprobatzeko
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
    
    //LOGIN BERRIA. DATU-BASEAN DAGOEN FUNTZIOA ERABILTZEN DU
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
    
    //Datu-basean dauden produktu guztiak lortzeko. Filtro barik
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
    
    //Datu-basean dauden produktuak, kategoria kontuan hartuta
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
    
    //Datu-basean dauden produktuak, filtro guztiekin
    public Produktuak getFiltroekin(double gehienezkoPrezioa, double gutxienezkoPrezioa, boolean maxMin, boolean minMax, boolean stock, int lehenengo, int kategoria) {
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
    
    //Bezeroak erregistratzeko
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
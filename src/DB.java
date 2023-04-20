import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class DB {

   private String url;
   private String user;
   private String pass;
   
   //defektuzko sortzailea 
   public DB (){
      this.url="jdbc:oracle:thin:@localhost:1521/xepdb1";
      this.user="ERRONKAFROGA";
      this.pass="ERRONKAFROGA";
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
    	String sql = "SELECT EMAIL FROM BEZEROAK";
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
    
    //Bezeroa eta pasahitza ondo dauden jakiteko
    public boolean bezeroLogin(String erabiltzailea, String pasahitza) {
    	boolean ondo = false;
    	String erabil, pasa;
    	String sql = "SELECT EMAILA, PASAHITZA FROM BEZEROAK";
    	try {
    		Connection conn = konexioa();
    		Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
	            erabil = rs.getString("EMAILA");
	            pasa = rs.getString("PASAHITZA");
	            if(erabil.equals(erabiltzailea) && pasa.equals(pasahitza)) {
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
   
   /*
   public void gehituBezero(int bezeroKodea, String bezeroIzena, String kontaktuIzena, String kontaktuAbizena, String telefonoa, String fax, String helbideLerroa1, String helbideLerroa2, String herria, String eskualdea, String herrialdea, String postakodea, int salerosketaLangileKodea, double kredituMuga){
      String sql = "INSERT INTO BEZEROAK(BEZEROKODEA, BEZEROIZENA, KONTAKTUIZENA, KONTAKTUABIZENA, TELEFONOA, FAX, HELBIDELERROA1, HELBIDELERROA2, HERRIA, ESKUALDEA, HERRIALDEA, POSTAKODEA, SALEROSKETALANGILEKODEA, KREDITUMUGA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
      try{
         Connection conn = konexioa();
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setInt(1, bezeroKodea);
         statement.setString(2, bezeroIzena);
         statement.setString(3, kontaktuIzena);         
         statement.setString(4, kontaktuAbizena);
         statement.setString(5, telefonoa);
         statement.setString(6, fax);
         statement.setString(7, helbideLerroa1);
         statement.setString(8, helbideLerroa2);
         statement.setString(9, herria);
         statement.setString(10, eskualdea);
         statement.setString(11, herrialdea);
         statement.setString(12, postakodea);
         statement.setInt(13, salerosketaLangileKodea);
         statement.setDouble(14, kredituMuga);
         statement.executeUpdate();
         conn.close();
         statement.close();                                                                                               
      }catch(SQLException e){
         System.out.println("ERROREA: " +e);
      }  
   }*/
   
   /* 
   public String [] bulegoak(){
      String[] bb = new String[0];
      String bulego;
      try {
         Connection conn = konexioa();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM BULEGOAK");
         while (rs.next()) {
         bulego = rs.getString("BULEGOKODEA") + " " + rs.getString("HERRIA") + " " + rs.getString("HERRIALDEA") + " " + rs.getString("ESKUALDEA") + " " + rs.getString("POSTAKODEA") + " " + rs.getString("TELEFONOA") + " " + rs.getString("HELBIDELERROA1") + " " + rs.getString("HELBIDELERROA2"); 
         bb = Arrays.copyOf(bb, bb.length+1);
         bb[bb.length-1] = bulego;
         }
         //konexioak itxi
         conn.close();
         stmt.close();
         rs.close();
      } catch (SQLException e) {
          System.out.println("ERROREA: " + e);
      }
      return bb;   
   }*/  
}
/**
 * Programa hasieran exekutatzeko
 * @author Talde3
 * @version 2023/05/05
 *
 */
public class main {
	/**
	 * Exekutatuko den main metodoa
	 * 
	 */
	public static void main(String[] args) {
		DB db = new DB();
		db.vipEguneratu(); //VIP diren bezeroak eguneratzen ditu programa zabaltzean
		LoginBezeroGUI log = new LoginBezeroGUI();
	}
}

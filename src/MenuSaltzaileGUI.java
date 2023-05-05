
/**
 * Saltzailearen menuaren GUI
 * @author Talde3
 * @version 2023/05/05
 */

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class MenuSaltzaileGUI extends JFrame {

	private JPanel contentPane;

	private PrezioAldaketaGUI pag;
	private EskariAldatuGUI eag;
	private BezeroakKudeatuGUI bkg;
	private LoginSaltzaileGUI lsg;
	private JTextField erabilTF;

	/**
	 * Sortzailea
	 *
	 * @param erabiltzaile saltzailearen erabiltzailea mantentzeko
	 */
	public MenuSaltzaileGUI(String erabiltzaile) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(erabiltzaileM);

		JMenuItem aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.add(aldatuerabiltzaileMI);

		JMenuItem itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		itxisaioaMI.setHorizontalAlignment(SwingConstants.LEFT);
		itxisaioaMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton eskariEgoeraButton = new JButton("ESKARI EGOERA ALDATU");
		eskariEgoeraButton.setBounds(104, 119, 222, 31);
		contentPane.add(eskariEgoeraButton);

		JButton bezeroKudeatuButton = new JButton("BEZEROAK KUDEATU");
		bezeroKudeatuButton.setBounds(269, 77, 155, 31);
		contentPane.add(bezeroKudeatuButton);

		JButton produktuPrezioButton = new JButton("PRODUKTU PREZIOA");
		produktuPrezioButton.setBounds(10, 77, 155, 31);
		contentPane.add(produktuPrezioButton);

		erabilTF = new JTextField();
		erabilTF.setFont(new Font("Tahoma", Font.BOLD, 10));
		erabilTF.setEditable(false);
		erabilTF.setBounds(0, 211, 177, 29);
		contentPane.add(erabilTF);
		erabilTF.setColumns(10);
		erabilTF.setText(erabiltzaile);

		// Action listenerrak
		eskariEgoeraButton.addActionListener(e -> sortuEskariAldatu(erabiltzaile));
		bezeroKudeatuButton.addActionListener(e -> sortuBezeroakKudeatu(erabiltzaile));
		produktuPrezioButton.addActionListener(e -> sortuPrezioAldaketa(erabiltzaile));

		// Menua
		itxisaioaMI.addActionListener(e -> itxi());
		aldatuerabiltzaileMI.addActionListener(e -> loginBueltatu());

		setTitle("Bezeroak kudeatu");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/**
	 * Eskaria aldatzeko GUI-a irekitzen du
	 * @param erabiltzaile saltzailearen erabiltzailea mantentzeko
	 */
	public void sortuEskariAldatu(String erabiltzaile) {
		this.eag = new EskariAldatuGUI(erabiltzaile);
		this.dispose();
	}
	/**
	 * Bezeroak kudatzeko GUI-a irekitzen du
	 * @param erabiltzaile saltzailearen erabiltzailea mantentzeko
	 */
	public void sortuBezeroakKudeatu(String erabiltzaile) {
		this.bkg = new BezeroakKudeatuGUI(erabiltzaile);
		this.dispose();
	}
	/**
	 * Prezioa aldatzeko GUI-a irekitzen du
	 * @param erabiltzaile saltzailearen erabiltzailea mantentzeko
	 */
	public void sortuPrezioAldaketa(String erabiltzaile) {
		this.pag = new PrezioAldaketaGUI(erabiltzaile);
		this.dispose();
	}
	
	/**
	 * Menuaren funtzio bat da. Loginera bueltatzen du.
	 */
	private void loginBueltatu() {
		lsg = new LoginSaltzaileGUI();
		this.dispose();
	}
	/**
	 * Menuaren funtzio bat da. Programa ixten du.
	 */
	private void itxi() {
		if (JOptionPane.showConfirmDialog(null, "Programa itxi nahi duzu?", "KONTUZ!",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
}


/**
 * @clase Saltzailearen menuaren GUI
 * @author Talde3
 * @param
 * @return 
 * @version 02/05/2023
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class MenuSaltzaileGUI extends JFrame {

	private JPanel contentPane;

	private PrezioAldaketaGUI pag;
	private EskariAldatuGUI eag;
	private BezeroakKudeatuGUI bkg;
	private LoginSaltzaileGUI lsg;

	/**
	 * Sortzailea
	 * 
	 * @param ez
	 */
	public MenuSaltzaileGUI(String erabiltzaile) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	public void sortuEskariAldatu(String erabiltzaile) {
		this.eag = new EskariAldatuGUI(erabiltzaile);
		this.dispose();
	}

	public void sortuBezeroakKudeatu(String erabiltzaile) {
		this.bkg = new BezeroakKudeatuGUI(erabiltzaile);
		this.dispose();
	}

	public void sortuPrezioAldaketa(String erabiltzaile) {
		this.pag = new PrezioAldaketaGUI(erabiltzaile);
		this.dispose();
	}

	private void loginBueltatu() {
		lsg = new LoginSaltzaileGUI();
		this.dispose();
	}

	private void itxi() {
		if (JOptionPane.showConfirmDialog(null, "Programa itxi nahi duzu?", "KONTUZ!",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

}

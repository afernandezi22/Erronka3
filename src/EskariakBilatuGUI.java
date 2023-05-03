
/**
 * @clase Eskariak bilatzen duen pantailaren GUI
 * @author Talde3
 * @param
 * @return
 * @version 02/05/2023
 */

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class EskariakBilatuGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu erabiltzaileM;
	private JMenuItem aldatuerabiltzaileMI;
	private JMenuItem itxisaioaMI;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private LoginBezeroGUI lbg;
	private MenuBezeroGUI mbg;
	private JMenuItem mnMenu;
	private Eskariak ee;
	private Eskari[] es;
	private DB db;
	private JTextArea info;

	/**
	 * Sortzailea
	 *
	 * @param ez
	 */
	public EskariakBilatuGUI(String erabiltzaile) {
		// Datubaserako konexioa
		db = new DB();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(erabiltzaileM);

		aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(aldatuerabiltzaileMI);

		mnMenu = new JMenuItem("Menura bueltatu");
		erabiltzaileM.add(mnMenu);
		mnMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));

		itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		itxisaioaMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itxisaioaMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Eskari ID-a");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 23, 79, 20);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("BILATU");
		btnNewButton.setBounds(273, 38, 111, 31);
		contentPane.add(btnNewButton);

		comboBox = new JComboBox();
		comboBox.setBounds(48, 38, 102, 31);
		contentPane.add(comboBox);

		info = new JTextArea();
		info.setFont(new Font("Tahoma", Font.PLAIN, 12));
		info.setEditable(false);
		info.setBounds(92, 87, 242, 128);
		contentPane.add(info);
		kargatuEskariak(erabiltzaile);

		// Menua
		itxisaioaMI.addActionListener(e -> itxi());
		aldatuerabiltzaileMI.addActionListener(e -> loginBueltatu());
		mnMenu.addActionListener(e -> menuraBueltatu(erabiltzaile));
		btnNewButton.addActionListener(e -> kargatuInfo(erabiltzaile, comboBox.getSelectedIndex()) );

		setTitle("Eskariak bilatu");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void loginBueltatu() {
		lbg = new LoginBezeroGUI();
		this.dispose();
	}

	private void itxi() {
		if (JOptionPane.showConfirmDialog(null, "Programa itxi nahi duzu?", "KONTUZ!",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	private void menuraBueltatu(String erabiltzaile) {
		this.mbg = new MenuBezeroGUI(erabiltzaile);
		this.dispose();
	}

	private void kargatuEskariak(String erabiltzaile) {
		ee = db.bezeroEskariak(erabiltzaile);
		es = ee.getEskari();
		for (int i = 0; i < es.length; i++) {
			comboBox.addItem(es[i].getID());
		}
	}

	private void kargatuInfo(String erabiltzaile, int x) {
		ee = db.bezeroEskariak(erabiltzaile);
		es = ee.getEskari();
		
		info.setText("");

		info.append("Eskari ID: " + es[x].getID() + "\n");
		switch (es[x].getID_egoera()) {
		case 1:
			info.append("Egoera: bidaltzeke \n");
			break;
		case 2:
			info.append("Egoera: ezeztatuta \\n");
			break;
		case 3:
			info.append("Egoera: bidalita \\n");
			break;
		default:
			info.append("Egoera: ezezaguna \\n");
			break;
		}
		info.append("Saltzailearen ID: " + es[x].getID_saltzaile() + "\n");
		info.append("Eskariaren data: " + es[x].getEskaera_data() + "\n");
	}
}

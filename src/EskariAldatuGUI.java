
/**
 * Eskariaren egoera aldatzen duen pantailaren GUI
 * @author Talde3
 * @version 05/05/2023
 */
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class EskariAldatuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField eskariIdTF;
	private DB db;
	private Eskari es;
	private JTextArea eskariJTA;
	private LoginSaltzaileGUI lsg;
	private MenuSaltzaileGUI msg;
	private JComboBox egoerarenCB;
	private JTextField erabilTF;

	/**
	 * Sortzailea
	 *
	 * @param erabiltzaile Saltzailearen emaila mantentzeko
	 */
	public EskariAldatuGUI(String erabiltzaile) {
		// Datu-baserako konexioa
		db = new DB();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(erabiltzaileM);

		JMenuItem aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(aldatuerabiltzaileMI);

		JMenuItem mnMenu = new JMenuItem("Menura bueltatu");
		mnMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.add(mnMenu);

		JMenuItem itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		itxisaioaMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itxisaioaMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Eskari ID-a");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(47, 10, 79, 20);
		contentPane.add(lblNewLabel);

		eskariIdTF = new JTextField();
		eskariIdTF.setBounds(47, 36, 86, 20);
		contentPane.add(eskariIdTF);
		eskariIdTF.setColumns(10);

		JButton bilatuButton = new JButton("BILATU");
		bilatuButton.setBounds(272, 25, 111, 31);
		contentPane.add(bilatuButton);
		JButton gordeButton = new JButton("GORDE");
		gordeButton.setBounds(272, 184, 111, 31);
		contentPane.add(gordeButton);

		egoerarenCB = new JComboBox();
		egoerarenCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		egoerarenCB.setModel(new DefaultComboBoxModel(new String[] { "Egiteke",  "Ezeztatuta", "Bidalita"}));
		egoerarenCB.setBounds(44, 188, 138, 27);
		contentPane.add(egoerarenCB);

		eskariJTA = new JTextArea();
		eskariJTA.setEditable(false);
		eskariJTA.setForeground(new Color(0, 0, 0));
		eskariJTA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		eskariJTA.setBounds(86, 67, 263, 106);
		contentPane.add(eskariJTA);

		erabilTF = new JTextField();
		erabilTF.setFont(new Font("Tahoma", Font.BOLD, 10));
		erabilTF.setEditable(false);
		erabilTF.setBounds(0, 220, 177, 20);
		contentPane.add(erabilTF);
		erabilTF.setColumns(10);
		erabilTF.setText(erabiltzaile);

		// Action listenerra
		bilatuButton.addActionListener(e -> bilatu());
		gordeButton.addActionListener(e -> eguneratu(erabiltzaile));

		// Menua
		itxisaioaMI.addActionListener(e -> itxi());
		aldatuerabiltzaileMI.addActionListener(e -> loginBueltatu());
		mnMenu.addActionListener(e -> menuraBueltatu(erabiltzaile));

		setTitle("Eskariak kudeatu");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Idatzitako eskari baten informazioa textarean kargatzen du.
	 */
	public void bilatu() {
		try {
			es = db.getEskari(Integer.parseInt(eskariIdTF.getText()));
			eskariJTA.setText("");
			eskariJTA.append("Eskari ID: " + es.getID() + "\n");
			eskariJTA.append("ID bezero: " + es.getID_bezero() + "\n");
			if (es.getID_saltzaile() == 0) {
				eskariJTA.append("ID saltzaile: EZ DAGO SALTZAILERIK \n");
			} else {
				eskariJTA.append("ID saltzaile: " + es.getID_saltzaile() + "\n");
			}
			switch (es.getID_egoera()) {
			case 1:
				eskariJTA.append("Egoera: EGITEKE \n");
				break;
			case 2:
				eskariJTA.append("Egoera: EZEZTATUTA \n");
				break;
			case 3:
				eskariJTA.append("Egoera: BIDALITA \n");
				break;
			default:
				eskariJTA.append("Egoera: ezezaguna \n");
				break;
			}
			eskariJTA.append("Eskaera data: " + es.getEskaera_data() + "\n");
			if (es.getAzken_aldaketa() == 0) {
				eskariJTA.append("Azken aldaketa: EZ DAGO SALTZAILERIK");
			} else {
				eskariJTA.append("Azken aldaketa: " + es.getAzken_aldaketa());
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ez dago eskaririk zenbaki horrekin", "ERROREA",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Saltzailearen erabiltzailea eta aukeratutako egoera kontuan hartuta eskari bat aldatzen du.
	 * @param erabiltzaile Saltzailearen erabiltzailea
	 */
	private void eguneratu(String erabiltzaile) {
		String testu = eskariJTA.getText();
		if (JOptionPane.showConfirmDialog(null, "Ziur zaude?", "KONTUZ!",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if(testu.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ez dago eskaririk", "ERROREA",
						JOptionPane.ERROR_MESSAGE);
			}else {
				db.eskariEgoera(egoerarenCB.getSelectedIndex(), erabiltzaile, Integer.parseInt(eskariIdTF.getText()));
			}
		}
	}
	
	/**
	 * Manuaren funtzio bat da. Loginera bueltatzen du.
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
	/**
	 * Menuaren funtzio bat da. Aukera-menura bueltatzen du saltzailearen erabiltzailea mantenduz.
	 * @param erabiltzaile
	 */
	private void menuraBueltatu(String erabiltzaile) {
		this.msg = new MenuSaltzaileGUI(erabiltzaile);
		this.dispose();
	}
}
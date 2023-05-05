
/**
 * @clase Bezeroak kudeazteko pantailaren GUI
 * @author Talde3
 * @param
 * @return
 * @version 02/05/2023
 */

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class BezeroakKudeatuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField idbilatuTF;
	private JTextField bezeroIdTF;
	private JTextField izenaTF;
	private JTextField abizenaTF;
	private JTextField helbideaTF;
	private JTextField emailTF;
	private JMenuBar menuBar;
	private JMenu erabiltzaileM;
	private JMenuItem aldatuerabiltzaileMI, itxisaioaMI;
	private LoginSaltzaileGUI lsg;
	private MenuSaltzaileGUI msg;
	private Bezero b;
	private DB db;
	private JTextField VIPTF;
	private JTextField erabilTF;

	/**
	 * Sortzailea
	 *
	 * @param ez
	 */
	public BezeroakKudeatuGUI(String erabiltzaile) {
		//Datubaserako konexioa
		db = new DB();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 400);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(erabiltzaileM);

		aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.add(aldatuerabiltzaileMI);

		JMenuItem mnMenu = new JMenuItem("Menura bueltatu");
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

		JButton garbituButton = new JButton("GARBITU");
		garbituButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		garbituButton.setBounds(345, 101, 115, 29);
		contentPane.add(garbituButton);

		JButton eguneratuButton = new JButton("EGUNERATU");
		eguneratuButton.setBounds(345, 141, 115, 29);
		contentPane.add(eguneratuButton);

		idbilatuTF = new JTextField();
		idbilatuTF.setBounds(80, 48, 146, 29);
		contentPane.add(idbilatuTF);
		idbilatuTF.setColumns(10);

		bezeroIdTF = new JTextField();
		bezeroIdTF.setEditable(false);
		bezeroIdTF.setColumns(10);
		bezeroIdTF.setBounds(109, 101, 146, 29);
		contentPane.add(bezeroIdTF);

		izenaTF = new JTextField();
		izenaTF.setColumns(10);
		izenaTF.setBounds(109, 141, 146, 29);
		contentPane.add(izenaTF);

		abizenaTF = new JTextField();
		abizenaTF.setColumns(10);
		abizenaTF.setBounds(109, 181, 146, 29);
		contentPane.add(abizenaTF);

		helbideaTF = new JTextField();
		helbideaTF.setColumns(10);
		helbideaTF.setBounds(109, 221, 215, 29);
		contentPane.add(helbideaTF);

		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(109, 261, 215, 29);
		contentPane.add(emailTF);

		JLabel lblAbizena = new JLabel("Bezero ID-a:");
		lblAbizena.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAbizena.setBounds(20, 108, 79, 19);
		contentPane.add(lblAbizena);

		JLabel lblIzena = new JLabel("ID:");
		lblIzena.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblIzena.setBounds(46, 55, 24, 19);
		contentPane.add(lblIzena);

		JLabel lblHelbidea = new JLabel("Izena:");
		lblHelbidea.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblHelbidea.setBounds(20, 148, 61, 19);
		contentPane.add(lblHelbidea);

		JLabel lblEmaila = new JLabel("Abizena:");
		lblEmaila.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEmaila.setBounds(20, 188, 61, 19);
		contentPane.add(lblEmaila);

		JLabel lblPasahitza = new JLabel("Helbidea:");
		lblPasahitza.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza.setBounds(20, 228, 61, 19);
		contentPane.add(lblPasahitza);

		JLabel lblPasahitza_1 = new JLabel("Emaila:");
		lblPasahitza_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza_1.setBounds(20, 268, 61, 19);
		contentPane.add(lblPasahitza_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 88, 503, 2);
		contentPane.add(separator);

		JButton bilatuButton = new JButton("BILATU");
		bilatuButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bilatuButton.setBounds(290, 48, 115, 29);
		contentPane.add(bilatuButton);

		JButton ezabatuButton = new JButton("EZABATU");
		ezabatuButton.setBounds(345, 181, 115, 29);
		contentPane.add(ezabatuButton);
		
		JLabel lblPasahitza_1_1 = new JLabel("VIP:");
		lblPasahitza_1_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza_1_1.setBounds(20, 308, 61, 19);
		contentPane.add(lblPasahitza_1_1);
		
		VIPTF = new JTextField();
		VIPTF.setColumns(10);
		VIPTF.setBounds(109, 301, 73, 29);
		contentPane.add(VIPTF);
		
		erabilTF = new JTextField();
		erabilTF.setFont(new Font("Tahoma", Font.BOLD, 10));
		erabilTF.setEditable(false);
		erabilTF.setBounds(360, 311, 177, 29);
		contentPane.add(erabilTF);
		erabilTF.setColumns(10);
		erabilTF.setText(erabiltzaile);

		// Menua
		itxisaioaMI.addActionListener(e -> itxi());
		aldatuerabiltzaileMI.addActionListener(e -> loginBueltatu());
		mnMenu.addActionListener(e -> menuraBueltatu(erabiltzaile));
		
		//Action listenerrak
		bilatuButton.addActionListener(e -> bilatu());
		garbituButton.addActionListener(e -> garbitu());
		eguneratuButton.addActionListener(e -> eguneratu());
		ezabatuButton.addActionListener(e -> ezabatu());


		setTitle("Bezeroak kudeatu");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void loginBueltatu() {
		lsg = new LoginSaltzaileGUI();
		this.dispose();
	}

	private void itxi() {
		if  (JOptionPane.showConfirmDialog(null, "Programa itxi nahi duzu?", "KONTUZ!",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	private void menuraBueltatu(String erabiltzaile) {
		this.msg = new MenuSaltzaileGUI(erabiltzaile);
		this.dispose();
	}
	
	private void bilatu() {
		try{
			b = db.getBezero(Integer.parseInt(idbilatuTF.getText()));
			bezeroIdTF.setText(""+b.getID());
			izenaTF.setText(b.getIzena());
			abizenaTF.setText(b.getAbizena());
			helbideaTF.setText(b.getHelbidea());
			emailTF.setText(b.getEmaila());
			VIPTF.setText(""+b.getVIP());
		}catch(Exception e) {
     		JOptionPane.showMessageDialog(null, "Errore bat egon da. Idatzi duzun ID-a ez da zuzena", "ERROREA", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void garbitu() {
		bezeroIdTF.setText("");
		izenaTF.setText("");
		abizenaTF.setText("");
		helbideaTF.setText("");
		emailTF.setText("");
		VIPTF.setText("");
	}
	
	private void ezabatu() {
		if  (JOptionPane.showConfirmDialog(null, "Ziur zaude??", "KONTUZ!",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if(!bezeroIdTF.getText().equals(idbilatuTF.getText())) {
	     		JOptionPane.showMessageDialog(null, "Bilatu bezeroa ezer egin baino lehen", "ERROREA", JOptionPane.ERROR_MESSAGE);
			}else {
				db.ezabatuBezero(Integer.parseInt(idbilatuTF.getText()));
			}
		}
	}
	
	private void eguneratu() {
		if  (JOptionPane.showConfirmDialog(null, "Ziur zaude??", "KONTUZ!",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if(!bezeroIdTF.getText().equals(idbilatuTF.getText())) {
	     		JOptionPane.showMessageDialog(null, "Bilatu bezeroa ezer egin baino lehen", "ERROREA", JOptionPane.ERROR_MESSAGE);
			}else {
				db.eguneratuBezero(izenaTF.getText(), abizenaTF.getText(), helbideaTF.getText(), emailTF.getText(), Integer.parseInt(VIPTF.getText()), Integer.parseInt(idbilatuTF.getText()));
			}
		}
	}
}

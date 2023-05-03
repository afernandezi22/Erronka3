
/**
 * @clase Bezeroak erregistroaren pantailaren GUI
 * @author Talde3
 * @param
 * @return 
 * @version 02/05/2023
 */

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Font;

public class BezeroarenErregistroaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField izenaTF;
	private JTextField abizenaTF;
	private JTextField helbideaTF;
	private JTextField emailaTF;
	private JTextField tFPasahitza;
	private JTextField tFPasahitza_1;
	private DB db;
	private LoginBezeroGUI lbg;

	/**
	 * Sortzailea
	 * 
	 * @param ez
	 */
	public BezeroarenErregistroaGUI() {
		db = new DB();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		menuBar.add(erabiltzaileM);

		JMenuItem aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		erabiltzaileM.add(aldatuerabiltzaileMI);

		JMenuItem itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton garbituButton = new JButton("GARBITU");
		garbituButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		garbituButton.setBounds(291, 151, 115, 29);
		contentPane.add(garbituButton);

		JButton erregistratuButton = new JButton("ERREGISTRATU");
		erregistratuButton.setBounds(291, 205, 115, 29);
		contentPane.add(erregistratuButton);

		izenaTF = new JTextField();
		izenaTF.setBounds(26, 11, 146, 29);
		contentPane.add(izenaTF);
		izenaTF.setColumns(10);

		abizenaTF = new JTextField();
		abizenaTF.setColumns(10);
		abizenaTF.setBounds(26, 51, 146, 29);
		contentPane.add(abizenaTF);

		helbideaTF = new JTextField();
		helbideaTF.setColumns(10);
		helbideaTF.setBounds(26, 91, 146, 29);
		contentPane.add(helbideaTF);

		emailaTF = new JTextField();
		emailaTF.setColumns(10);
		emailaTF.setBounds(26, 131, 146, 29);
		contentPane.add(emailaTF);

		tFPasahitza = new JTextField();
		tFPasahitza.setColumns(10);
		tFPasahitza.setBounds(26, 171, 146, 29);
		contentPane.add(tFPasahitza);

		tFPasahitza_1 = new JTextField();
		tFPasahitza_1.setColumns(10);
		tFPasahitza_1.setBounds(26, 211, 146, 29);
		contentPane.add(tFPasahitza_1);

		JLabel lblAbizena = new JLabel("Abizena");
		lblAbizena.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAbizena.setBounds(182, 58, 61, 19);
		contentPane.add(lblAbizena);

		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblIzena.setBounds(182, 18, 61, 19);
		contentPane.add(lblIzena);

		JLabel lblHelbidea = new JLabel("Helbidea");
		lblHelbidea.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblHelbidea.setBounds(182, 98, 61, 19);
		contentPane.add(lblHelbidea);

		JLabel lblEmaila = new JLabel("Emaila");
		lblEmaila.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEmaila.setBounds(182, 138, 61, 19);
		contentPane.add(lblEmaila);

		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza.setBounds(182, 178, 61, 19);
		contentPane.add(lblPasahitza);

		JLabel lblPasahitza_1 = new JLabel("Pasahitza");
		lblPasahitza_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza_1.setBounds(182, 215, 61, 19);
		contentPane.add(lblPasahitza_1);
		
		//Action listenerrak
		garbituButton.addActionListener(e -> garbitu());
		erregistratuButton.addActionListener(e -> erregistratu());


		// Menua
		itxisaioaMI.addActionListener(e -> itxi());
		aldatuerabiltzaileMI.addActionListener(e -> loginBueltatu());

		setTitle("Produktuak erosi");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Garbitzeko botoia sakatzean testu guztia kentzen da
	 * 
	 * @param ez
	 */
	public void garbitu() {

		izenaTF.setText("");
		abizenaTF.setText("");
		helbideaTF.setText("");
		emailaTF.setText("");
		tFPasahitza.setText("");
		tFPasahitza_1.setText("");
	}

	/**
	 * Erregistroa egitean pasahitza bi alditan jartzean berdina dela zihurtatzeko
	 * 
	 * @param ez
	 */
	public void erregistratu() {
		String pasahitza1 = tFPasahitza.getText();
		String pasahitza2 = tFPasahitza_1.getText();

		if (pasahitza1.equals(pasahitza2)) {
			db.erregistratuBezeroa(izenaTF, abizenaTF, helbideaTF, emailaTF, tFPasahitza);
		} else {
			JOptionPane.showMessageDialog(null, "Pasahitzak ez dira berdinak.", "PASAHITZ DESBERDINAK",
					JOptionPane.WARNING_MESSAGE);
		}
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
}

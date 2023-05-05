import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Bezeroek logina egiteko GUI
 * 
 * @author Talde3
 * @version 2023/05/05
 *
 */
public class LoginBezeroGUI {

	private JFrame frame;
	private JPasswordField pasahitzaF;
	private JTextField erabiltzaileF;
	private DB db;
	private MenuBezeroGUI mbg;
	private JButton saltzaileButton, erregistratuButton, sartuButton;
	private BezeroarenErregistroaGUI beGUI;
	private LoginSaltzaileGUI slg;

	/**
	 * Lehenetsitako sortzailea. GUI-a sortzen du
	 */
	public LoginBezeroGUI() {
		initialize();
	}

	/**
	 * GUI guztia eta hasierako egoera ezartzen duena
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Vladimir Script", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 401, 529);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		pasahitzaF = new JPasswordField();
		pasahitzaF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pasahitzaF.setBounds(160, 190, 179, 27);
		frame.getContentPane().add(pasahitzaF);

		erabiltzaileF = new JTextField();
		erabiltzaileF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		erabiltzaileF.setBounds(160, 152, 179, 27);
		frame.getContentPane().add(erabiltzaileF);
		erabiltzaileF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Erabiltzailea");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 152, 89, 27);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pasahitza");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(61, 196, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ONGI ETORRI");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_2.setBounds(96, 64, 232, 59);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ez duzu konturik? Sortu bat.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(107, 285, 179, 27);
		frame.getContentPane().add(lblNewLabel_3);

		sartuButton = new JButton("SARTU");
		sartuButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sartuButton.setBounds(143, 243, 113, 31);
		frame.getContentPane().add(sartuButton);

		erregistratuButton = new JButton("ERREGISTRATU");
		erregistratuButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		erregistratuButton.setBackground(new Color(255, 255, 255));
		erregistratuButton.setForeground(new Color(0, 0, 0));
		erregistratuButton.setBounds(132, 330, 124, 35);
		frame.getContentPane().add(erregistratuButton);

		saltzaileButton = new JButton("Saltzailea zara?");
		saltzaileButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		saltzaileButton.setBounds(132, 376, 124, 35);
		frame.getContentPane().add(saltzaileButton);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Datu basearekin konektatu
		db = new DB();
		// Datubaserako konexioa egiteko goiko konexioa komentatu eta behekoa
		// deskomentatu
		// db = new DB("jdbc:oracle:thin:@192.168.106.11:1521/xepdb1", "GAMESTOP",
		// "GAMESTOP");

		// listenerrak
		sartuButton.addActionListener(e -> login(erabiltzaileF.getText(), pasahitzaF.getPassword()));
		erregistratuButton.addActionListener(e -> zabaldu(erregistratuButton));
		saltzaileButton.addActionListener(e -> zabaldu(saltzaileButton));
		pasahitzaF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login(erabiltzaileF.getText(), pasahitzaF.getPassword());
				}
			}
		});
		erabiltzaileF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login(erabiltzaileF.getText(), pasahitzaF.getPassword());
				}
			}
		});
	}

	/**
	 * Bezeroaren logina egiten du.
	 * 
	 * @param erabiltzaile Bezeroaren emaila
	 * @param pasahitza    Bezeroaren pasahitza
	 */
	private void login(String erabiltzaile, char[] pasahitza) {
		String pass = String.valueOf(pasahitza);

		if (db.bezeroDago(erabiltzaile)) {
			if (db.bezeroLogin(erabiltzaile, pass)) {
				JOptionPane.showMessageDialog(null, "Kaixo " + erabiltzaile + " !", "LOGIN ZUZENA",
						JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				mbg = new MenuBezeroGUI(erabiltzaile);
			} else {
				JOptionPane.showMessageDialog(null, "Pasahitza ez da egokia.", "LOGIN OKERRA",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Erabiltzaile hori ez da existitzen.", "ERABILTZAILE OKERRA",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Sakatzen duen botoiaren arabera erregistroko GUI-a zabaltzen du edo saltzaileen logina.
	 * @param botoi Sakatzen duen botoia
	 */
	public void zabaldu(JButton botoi) {
		if (botoi == erregistratuButton) {
			beGUI = new BezeroarenErregistroaGUI();
			frame.dispose();
		}
		if (botoi == saltzaileButton) {
			slg = new LoginSaltzaileGUI();
			frame.dispose();
		}
	}
}

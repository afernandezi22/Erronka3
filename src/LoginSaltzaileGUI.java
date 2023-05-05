import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * Saltzailearen loginaren GUI
 * @author Talde3
 * @version 2023/05/05
 */
public class LoginSaltzaileGUI {

	private JFrame frame;
	private JPasswordField pasahitzaTF;
	private JTextField erabiltzaileTF;
	private DB db;
	private MenuSaltzaileGUI msg;
	private LoginBezeroGUI lbg;


	/**
	 * Lehenetsitako sortzailea. Guztia kargatzen duen funtzioa deitzen du.
	 * @param ez
	 */
	public LoginSaltzaileGUI() {
		initialize();
	}

	/**
	 * Diseinu guztia daukan funtzioa.
	 * 
	 */

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Vladimir Script", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 401, 529);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		pasahitzaTF = new JPasswordField();
		pasahitzaTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pasahitzaTF.setBounds(154, 209, 179, 27);
		frame.getContentPane().add(pasahitzaTF);

		erabiltzaileTF = new JTextField();
		erabiltzaileTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		erabiltzaileTF.setBounds(154, 171, 179, 27);
		frame.getContentPane().add(erabiltzaileTF);
		erabiltzaileTF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Erabiltzailea");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(55, 171, 89, 27);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pasahitza");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(55, 215, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ONGI ETORRI");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_2.setBounds(90, 83, 232, 59);
		frame.getContentPane().add(lblNewLabel_2);

		JButton sartuButton = new JButton("SARTU");
		sartuButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sartuButton.setBounds(137, 262, 113, 31);
		frame.getContentPane().add(sartuButton);

		JButton bezeroButton = new JButton("BEZERO");
		bezeroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		bezeroButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bezeroButton.setBackground(new Color(255, 255, 255));
		bezeroButton.setForeground(new Color(0, 0, 0));
		bezeroButton.setBounds(132, 330, 124, 35);
		frame.getContentPane().add(bezeroButton);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		//Datu basearekin konektatu
		db = new DB();

		//Action listenerrak
		sartuButton.addActionListener(e -> login(erabiltzaileTF.getText(), pasahitzaTF.getPassword()));
		bezeroButton.addActionListener(e -> bezeroZabaldu());
		pasahitzaTF.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	login(erabiltzaileTF.getText(), pasahitzaTF.getPassword());
	            }
	        }
		});
		erabiltzaileTF.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	login(erabiltzaileTF.getText(), pasahitzaTF.getPassword());
	            }
	        }
		});
	}
	/**
	 * Saltzailearen logina egiten du.
	 * @param erabiltzaile saltzailearen erabiltzailea
	 * @param pasahitza saltzailearen pasahitza
	 */
	private void login(String erabiltzaile, char[] pasahitza) {
		String pass = String.valueOf(pasahitza);

		if(db.saltzaileDago(erabiltzaile)) {
			if(db.saltzaileLogin(erabiltzaile, pass)) {
				JOptionPane.showMessageDialog(null, "Kaixo " + erabiltzaile + " !", "LOGIN ZUZENA", JOptionPane.INFORMATION_MESSAGE);
				msg = new MenuSaltzaileGUI(erabiltzaile);
				frame.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Pasahitza ez da egokia.", "LOGIN OKERRA", JOptionPane.WARNING_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Erabiltzaile hori ez da existitzen.", "ERABILTZAILE OKERRA", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Bezeroaren logina zabaltzen du.
	 */
	private void bezeroZabaldu() {
		lbg = new LoginBezeroGUI();
		frame.dispose();
	}
}

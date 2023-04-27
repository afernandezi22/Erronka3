import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginSaltzaileGUI {

	private JFrame frame;
	private JPasswordField pasahitzaTF;
	private JTextField erabiltzaileTF;
	private DB db;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginBezeroGUI window = new LoginBezeroGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public LoginSaltzaileGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Vladimir Script", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 401, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	}
}

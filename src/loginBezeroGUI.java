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

public class loginBezeroGUI {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginBezeroGUI window = new loginBezeroGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginBezeroGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 401, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 227, 118, 27);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(180, 189, 118, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Erabiltzailea");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(84, 189, 66, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitza");
		lblNewLabel_1.setBounds(84, 233, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ONGI ETORRI");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_2.setBounds(98, 63, 187, 59);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ez duzu konturik? Sortu bat.");
		lblNewLabel_3.setBounds(123, 314, 135, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SARTU");
		btnNewButton.setBounds(145, 280, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ERREGISTRATU");
		btnNewButton_1.setBounds(133, 353, 113, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Saltzailea zara?");
		btnNewButton_2.setBounds(133, 387, 113, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class BezeroarenErregistroaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroarenErregistroaGUI frame = new BezeroarenErregistroaGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the frame.
	 */
	public BezeroarenErregistroaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("GARBITU");
		btnNewButton.setBounds(291, 151, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnErregistratu = new JButton("ERREGISTRATU");
		btnErregistratu.setBounds(291, 205, 115, 29);
		contentPane.add(btnErregistratu);
		
		textField = new JTextField();
		textField.setBounds(26, 11, 146, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(26, 51, 146, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(26, 91, 146, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(26, 131, 146, 29);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(26, 171, 146, 29);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(26, 211, 146, 29);
		contentPane.add(textField_5);
		
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
		
		setVisible(true);
	}
}

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
	private JTextField tFIzena;
	private JTextField tFAbizena;
	private JTextField tFHelbidea;
	private JTextField tFEmaila;
	private JTextField tFPasahitza;
	private JTextField tFPasahitza_1;

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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(291, 151, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnErregistratu = new JButton("ERREGISTRATU");
		btnErregistratu.setBounds(291, 205, 115, 29);
		contentPane.add(btnErregistratu);
		
		tFIzena = new JTextField();
		tFIzena.setBounds(26, 11, 146, 29);
		contentPane.add(tFIzena);
		tFIzena.setColumns(10);
		
		tFAbizena = new JTextField();
		tFAbizena.setColumns(10);
		tFAbizena.setBounds(26, 51, 146, 29);
		contentPane.add(tFAbizena);
		
		tFHelbidea = new JTextField();
		tFHelbidea.setColumns(10);
		tFHelbidea.setBounds(26, 91, 146, 29);
		contentPane.add(tFHelbidea);
		
		tFEmaila = new JTextField();
		tFEmaila.setColumns(10);
		tFEmaila.setBounds(26, 131, 146, 29);
		contentPane.add(tFEmaila);
		
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
		
		setVisible(true);
	}
}

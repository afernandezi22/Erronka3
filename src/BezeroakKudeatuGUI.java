import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class BezeroakKudeatuGUI extends JFrame {

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
	public BezeroakKudeatuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("GARBITU");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(319, 151, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnErregistratu = new JButton("ERREGISTRATU");
		btnErregistratu.setBounds(319, 205, 115, 29);
		contentPane.add(btnErregistratu);
		
		tFIzena = new JTextField();
		tFIzena.setBounds(54, 11, 146, 29);
		contentPane.add(tFIzena);
		tFIzena.setColumns(10);
		
		tFAbizena = new JTextField();
		tFAbizena.setColumns(10);
		tFAbizena.setBounds(54, 51, 146, 29);
		contentPane.add(tFAbizena);
		
		tFHelbidea = new JTextField();
		tFHelbidea.setColumns(10);
		tFHelbidea.setBounds(54, 91, 146, 29);
		contentPane.add(tFHelbidea);
		
		tFEmaila = new JTextField();
		tFEmaila.setColumns(10);
		tFEmaila.setBounds(54, 131, 146, 29);
		contentPane.add(tFEmaila);
		
		tFPasahitza = new JTextField();
		tFPasahitza.setColumns(10);
		tFPasahitza.setBounds(54, 171, 146, 29);
		contentPane.add(tFPasahitza);
		
		tFPasahitza_1 = new JTextField();
		tFPasahitza_1.setColumns(10);
		tFPasahitza_1.setBounds(54, 211, 146, 29);
		contentPane.add(tFPasahitza_1);
		
		JLabel lblAbizena = new JLabel("Abizena");
		lblAbizena.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAbizena.setBounds(210, 58, 61, 19);
		contentPane.add(lblAbizena);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblIzena.setBounds(210, 18, 61, 19);
		contentPane.add(lblIzena);
		
		JLabel lblHelbidea = new JLabel("Helbidea");
		lblHelbidea.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblHelbidea.setBounds(210, 98, 61, 19);
		contentPane.add(lblHelbidea);
		
		JLabel lblEmaila = new JLabel("Emaila");
		lblEmaila.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEmaila.setBounds(210, 138, 61, 19);
		contentPane.add(lblEmaila);
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza.setBounds(210, 178, 61, 19);
		contentPane.add(lblPasahitza);
		
		JLabel lblPasahitza_1 = new JLabel("Pasahitza");
		lblPasahitza_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza_1.setBounds(210, 215, 61, 19);
		contentPane.add(lblPasahitza_1);
		
		setVisible(true);
	}
}

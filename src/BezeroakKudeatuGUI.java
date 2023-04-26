import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

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
		setBounds(100, 100, 551, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Erabiltzaile");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Aldatu erabiltzaile");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Itxi saioa eta itxi programa");
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("GARBITU");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(352, 128, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnErregistratu = new JButton("EGUNERATU");
		btnErregistratu.setBounds(352, 168, 115, 29);
		contentPane.add(btnErregistratu);
		
		tFIzena = new JTextField();
		tFIzena.setBounds(80, 48, 146, 29);
		contentPane.add(tFIzena);
		tFIzena.setColumns(10);
		
		tFAbizena = new JTextField();
		tFAbizena.setColumns(10);
		tFAbizena.setBounds(116, 128, 146, 29);
		contentPane.add(tFAbizena);
		
		tFHelbidea = new JTextField();
		tFHelbidea.setColumns(10);
		tFHelbidea.setBounds(116, 168, 146, 29);
		contentPane.add(tFHelbidea);
		
		tFEmaila = new JTextField();
		tFEmaila.setColumns(10);
		tFEmaila.setBounds(116, 208, 146, 29);
		contentPane.add(tFEmaila);
		
		tFPasahitza = new JTextField();
		tFPasahitza.setColumns(10);
		tFPasahitza.setBounds(116, 248, 215, 29);
		contentPane.add(tFPasahitza);
		
		tFPasahitza_1 = new JTextField();
		tFPasahitza_1.setColumns(10);
		tFPasahitza_1.setBounds(116, 288, 215, 29);
		contentPane.add(tFPasahitza_1);
		
		JLabel lblAbizena = new JLabel("Bezero ID-a:");
		lblAbizena.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAbizena.setBounds(27, 135, 79, 19);
		contentPane.add(lblAbizena);
		
		JLabel lblIzena = new JLabel("ID:");
		lblIzena.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblIzena.setBounds(46, 55, 24, 19);
		contentPane.add(lblIzena);
		
		JLabel lblHelbidea = new JLabel("Izena:");
		lblHelbidea.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblHelbidea.setBounds(27, 175, 61, 19);
		contentPane.add(lblHelbidea);
		
		JLabel lblEmaila = new JLabel("Abizena:");
		lblEmaila.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEmaila.setBounds(27, 215, 61, 19);
		contentPane.add(lblEmaila);
		
		JLabel lblPasahitza = new JLabel("Helbidea:");
		lblPasahitza.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza.setBounds(27, 255, 61, 19);
		contentPane.add(lblPasahitza);
		
		JLabel lblPasahitza_1 = new JLabel("Emaila:");
		lblPasahitza_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPasahitza_1.setBounds(27, 295, 61, 19);
		contentPane.add(lblPasahitza_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 88, 503, 2);
		contentPane.add(separator);
		
		JButton btnBilatu = new JButton("BILATU");
		btnBilatu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBilatu.setBounds(290, 48, 115, 29);
		contentPane.add(btnBilatu);
		
		JButton btnEzabatu = new JButton("EZABATU");
		btnEzabatu.setBounds(352, 208, 115, 29);
		contentPane.add(btnEzabatu);
		
		setVisible(true);
	}
}

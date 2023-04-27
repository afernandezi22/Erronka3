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
	private JTextField idbilatuTF;
	private JTextField bezeroIdTF;
	private JTextField izenaTF;
	private JTextField abizenaTF;
	private JTextField helbideaTF;
	private JTextField emailTF;

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
		
		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(erabiltzaileM);
		
		JMenuItem aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.add(aldatuerabiltzaileMI);
		
		JMenuItem itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		itxisaioaMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itxisaioaMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton garbituButton = new JButton("GARBITU");
		garbituButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		garbituButton.setBounds(352, 128, 115, 29);
		contentPane.add(garbituButton);
		
		JButton eguneratuButton = new JButton("EGUNERATU");
		eguneratuButton.setBounds(352, 168, 115, 29);
		contentPane.add(eguneratuButton);
		
		idbilatuTF = new JTextField();
		idbilatuTF.setBounds(80, 48, 146, 29);
		contentPane.add(idbilatuTF);
		idbilatuTF.setColumns(10);
		
		bezeroIdTF = new JTextField();
		bezeroIdTF.setColumns(10);
		bezeroIdTF.setBounds(116, 128, 146, 29);
		contentPane.add(bezeroIdTF);
		
		izenaTF = new JTextField();
		izenaTF.setColumns(10);
		izenaTF.setBounds(116, 168, 146, 29);
		contentPane.add(izenaTF);
		
		abizenaTF = new JTextField();
		abizenaTF.setColumns(10);
		abizenaTF.setBounds(116, 208, 146, 29);
		contentPane.add(abizenaTF);
		
		helbideaTF = new JTextField();
		helbideaTF.setColumns(10);
		helbideaTF.setBounds(116, 248, 215, 29);
		contentPane.add(helbideaTF);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(116, 288, 215, 29);
		contentPane.add(emailTF);
		
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
		
		JButton bilatuButton = new JButton("BILATU");
		bilatuButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bilatuButton.setBounds(290, 48, 115, 29);
		contentPane.add(bilatuButton);
		
		JButton ezabatuButton = new JButton("EZABATU");
		ezabatuButton.setBounds(352, 208, 115, 29);
		contentPane.add(ezabatuButton);
		
		setVisible(true);
	}
}

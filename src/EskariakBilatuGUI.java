
/**
 * @clase Eskariak bilatzen duen pantailaren GUI
 * @author Talde3
 * @param
 * @return 
 * @version 02/05/2023
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class EskariakBilatuGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu erabiltzaileM;
	private JMenuItem aldatuerabiltzaileMI;
	private JMenuItem itxisaioaMI;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JTextPane textPane;
	private JComboBox comboBox;
	private LoginBezeroGUI lbg;
	private MenuBezeroGUI mbg;
	private JMenuItem mnMenu;


	/**
	 * Sortzailea
	 * 
	 * @param ez
	 */
	public EskariakBilatuGUI(String erabiltzaile) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(erabiltzaileM);

		aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(aldatuerabiltzaileMI);
		
		mnMenu = new JMenuItem("Menura bueltatu");
		erabiltzaileM.add(mnMenu);
		mnMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));

		itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		itxisaioaMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itxisaioaMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Eskari ID-a");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 23, 79, 20);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("BILATU");
		btnNewButton.setBounds(273, 38, 111, 31);
		contentPane.add(btnNewButton);

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(82, 80, 261, 135);
		contentPane.add(textPane);

		comboBox = new JComboBox();
		comboBox.setBounds(48, 38, 102, 31);
		contentPane.add(comboBox);

		// Menua
		itxisaioaMI.addActionListener(e -> itxi());
		aldatuerabiltzaileMI.addActionListener(e -> loginBueltatu());
		mnMenu.addActionListener(e -> menuraBueltatu(erabiltzaile));


		
		setTitle("Eskariak bilatu");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void loginBueltatu() {
		lbg = new LoginBezeroGUI();
		this.dispose();
	}

	private void itxi() {
		if  (JOptionPane.showConfirmDialog(null, "Programa itxi nahi duzu?", "KONTUZ!",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
	
	private void menuraBueltatu(String erabiltzaile) {
		this.mbg = new MenuBezeroGUI(erabiltzaile);
		this.dispose();
	}

}

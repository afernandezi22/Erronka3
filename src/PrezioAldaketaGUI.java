/**
 * @clase Prezio aldaketen pantailaren GUI
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
import javax.swing.SwingConstants;

public class PrezioAldaketaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField cpuTF;
	private JTextField cpuPortzTF;
	private JTextField vcTF;
	private JTextField vcPortzTF;
	private JTextField ramTF;
	private JTextField ramPortzTF;
	private JTextField mbTF;
	private JTextField mbPortzTF;
	private JTextField stoTF;
	private JTextField dtoPortzTF;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EskariAldatuGUI frame = new EskariAldatuGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/




	/**  
	 * Sortzailea
	 * @param ez
	 */
	public PrezioAldaketaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 326);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(erabiltzaileM);
		
		JMenuItem aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(aldatuerabiltzaileMI);
		
		JMenuItem itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		itxisaioaMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itxisaioaMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPU");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(118, 50, 39, 20);
		contentPane.add(lblNewLabel);
		
		JButton igoButton = new JButton("IGO");
		igoButton.setBounds(167, 222, 111, 31);
		contentPane.add(igoButton);
		
		cpuTF = new JTextField();
		cpuTF.setBounds(167, 48, 111, 20);
		contentPane.add(cpuTF);
		cpuTF.setColumns(10);
		
		cpuPortzTF = new JTextField();
		cpuPortzTF.setBounds(288, 48, 44, 20);
		contentPane.add(cpuPortzTF);
		cpuPortzTF.setColumns(10);
		
		JLabel lblVc = new JLabel("VC");
		lblVc.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblVc.setBounds(118, 83, 39, 20);
		contentPane.add(lblVc);
		
		vcTF = new JTextField();
		vcTF.setColumns(10);
		vcTF.setBounds(167, 81, 111, 20);
		contentPane.add(vcTF);
		
		vcPortzTF = new JTextField();
		vcPortzTF.setColumns(10);
		vcPortzTF.setBounds(288, 81, 44, 20);
		contentPane.add(vcPortzTF);
		
		JLabel lblRam = new JLabel("RAM");
		lblRam.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblRam.setBounds(118, 114, 39, 20);
		contentPane.add(lblRam);
		
		ramTF = new JTextField();
		ramTF.setColumns(10);
		ramTF.setBounds(167, 112, 111, 20);
		contentPane.add(ramTF);
		
		ramPortzTF = new JTextField();
		ramPortzTF.setColumns(10);
		ramPortzTF.setBounds(288, 112, 44, 20);
		contentPane.add(ramPortzTF);
		
		JLabel lblMb = new JLabel("MB");
		lblMb.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblMb.setBounds(118, 147, 39, 20);
		contentPane.add(lblMb);
		
		mbTF = new JTextField();
		mbTF.setColumns(10);
		mbTF.setBounds(167, 145, 111, 20);
		contentPane.add(mbTF);
		
		mbPortzTF = new JTextField();
		mbPortzTF.setColumns(10);
		mbPortzTF.setBounds(288, 145, 44, 20);
		contentPane.add(mbPortzTF);
		
		JLabel lblSto = new JLabel("STO.");
		lblSto.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSto.setBounds(118, 180, 39, 20);
		contentPane.add(lblSto);
		
		stoTF = new JTextField();
		stoTF.setColumns(10);
		stoTF.setBounds(167, 178, 111, 20);
		contentPane.add(stoTF);
		
		dtoPortzTF = new JTextField();
		dtoPortzTF.setColumns(10);
		dtoPortzTF.setBounds(288, 178, 44, 20);
		contentPane.add(dtoPortzTF);
		
		JLabel lblPreziotikAurrera = new JLabel("_preziotik aurrera");
		lblPreziotikAurrera.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPreziotikAurrera.setBounds(167, 17, 111, 20);
		contentPane.add(lblPreziotikAurrera);
		
		JLabel lblNewLabel_6 = new JLabel("%");
		lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(300, 17, 19, 20);
		contentPane.add(lblNewLabel_6);
		
		setVisible(true);
	}
}

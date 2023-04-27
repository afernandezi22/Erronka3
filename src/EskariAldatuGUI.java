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

public class EskariAldatuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField eskariIdTF;

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
	 * Create the frame.
	 */
	public EskariAldatuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(erabiltzaileM);
		
		JMenuItem aldatueabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatueabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aldatueabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(aldatueabiltzaileMI);
		
		JMenuItem itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		itxisaioaMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itxisaioaMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eskari ID-a");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 23, 79, 20);
		contentPane.add(lblNewLabel);
		
		eskariIdTF = new JTextField();
		eskariIdTF.setBounds(48, 49, 86, 20);
		contentPane.add(eskariIdTF);
		eskariIdTF.setColumns(10);
		
		JButton bilatuButton = new JButton("BILATU");
		bilatuButton.setBounds(273, 38, 111, 31);
		contentPane.add(bilatuButton);
		
		JTextPane eskariarenTP = new JTextPane();
		eskariarenTP.setEditable(false);
		eskariarenTP.setBounds(110, 80, 195, 98);
		contentPane.add(eskariarenTP);
		
		JButton gordeButton = new JButton("GORDE");
		gordeButton.setBounds(273, 197, 111, 31);
		contentPane.add(gordeButton);
		
		JComboBox egoerarenCB = new JComboBox();
		egoerarenCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		egoerarenCB.setModel(new DefaultComboBoxModel(new String[] {"Egiteke", "Bidalita", "Ezeztatuta"}));
		egoerarenCB.setBounds(45, 201, 138, 27);
		contentPane.add(egoerarenCB);
		
		setVisible(true);
	}
}

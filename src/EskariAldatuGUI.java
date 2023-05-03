/**
 * @clase Eskariaren egoera aldatzen duen pantailaren GUI
 * @author Talde3
 * @param
 * @return
 * @version 02/05/2023
 */
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class EskariAldatuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField eskariIdTF;
	private DB db;
	private Eskari es;
	private JTextArea eskariJTA;
	private LoginSaltzaileGUI lsg;
	private MenuSaltzaileGUI msg;


	/**
	 * Sortzailea
	 * @param ez
	 */
	public EskariAldatuGUI(String erabiltzaile) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(erabiltzaileM);

		JMenuItem aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		erabiltzaileM.add(aldatuerabiltzaileMI);

		JMenuItem mnMenu = new JMenuItem("Menura bueltatu");
		mnMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.add(mnMenu);

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

		JButton gordeButton = new JButton("GORDE");
		gordeButton.setBounds(273, 197, 111, 31);
		contentPane.add(gordeButton);

		JComboBox egoerarenCB = new JComboBox();
		egoerarenCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		egoerarenCB.setModel(new DefaultComboBoxModel(new String[] {"Egiteke", "Bidalita", "Ezeztatuta"}));
		egoerarenCB.setBounds(45, 201, 138, 27);
		contentPane.add(egoerarenCB);

		eskariJTA = new JTextArea();
		eskariJTA.setEditable(false);
		eskariJTA.setForeground(new Color(0, 0, 0));
		eskariJTA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		eskariJTA.setBounds(87, 80, 263, 106);
		contentPane.add(eskariJTA);

		//Datu-baserako konexioa
		db = new DB();

		//Action listenerra
		bilatuButton.addActionListener(e -> bilatu());

		// Menua
		itxisaioaMI.addActionListener(e -> itxi());
		aldatuerabiltzaileMI.addActionListener(e -> loginBueltatu());
		mnMenu.addActionListener(e -> menuraBueltatu(erabiltzaile));



		setTitle("Eskariak kudeatu");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void bilatu() {
		try {
			es = db.getEskari(Integer.parseInt(eskariIdTF.getText()));
			 eskariJTA.setText("");
			 eskariJTA.append("Eskari ID: " + es.getID() + "\n");
			 eskariJTA.append("ID bezero: " + es.getID_bezero() + "\n");
			 if(es.getID_saltzaile() == 0) {
				 eskariJTA.append("ID saltzaile: EZ DAGO SALTZAILERIK \n");
			 }else {
				 eskariJTA.append("ID saltzaile: " + es.getID_saltzaile() + "\n");
			 }
			 eskariJTA.append("Eskaera data: " + es.getEskaera_data() + "\n");
			 if(es.getAzken_aldaketa() == 0) {
				 eskariJTA.append("Azken aldaketa: EZ DAGO SALTZAILERIK");
			 }else {
				 eskariJTA.append("Azken aldaketa: " + es.getAzken_aldaketa());
			 }

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ez dago eskaririk zenbaki horrekin: \n" + e, "ERROREA", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void loginBueltatu() {
		lsg = new LoginSaltzaileGUI();
		this.dispose();
	}

	private void itxi() {
		if  (JOptionPane.showConfirmDialog(null, "Programa itxi nahi duzu?", "KONTUZ!",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	private void menuraBueltatu(String erabiltzaile) {
		this.msg = new MenuSaltzaileGUI(erabiltzaile);
		this.dispose();
	}

}

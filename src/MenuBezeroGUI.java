import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
/**
 * Bezeroaren menuaren GUI
 * @author Talde3
 * @version 2023/05/05
 */
public class MenuBezeroGUI extends JFrame {

	private JPanel contentPane;
	private ErosketaGUI eg;
	private JButton erosiButton, bilatuButton;
	private EskariakBilatuGUI eb;
	private LoginBezeroGUI lbg;
	private JMenuBar menuBar;
	private JMenu erabiltzaileM;
	private JMenuItem aldatuerabiltzaileMI;
	private JMenuItem itxisaioaMI;
	private JTextField erabilTF;


	/**
	 * Sortzailea
	 *
	 * @param erabiltzaile Bezeroaren emaila mantentzeko
	 */
	public MenuBezeroGUI(String erabiltzaile) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 441);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		erabiltzaileM = new JMenu("Erabiltzaile");
		menuBar.add(erabiltzaileM);

		aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		erabiltzaileM.add(aldatuerabiltzaileMI);

		itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Zer egin nahi duzu?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(72, 96, 186, 41);
		contentPane.add(lblNewLabel);

		erosiButton = new JButton("Produktuak erosi");
		erosiButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		erosiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		erosiButton.setBounds(90, 165, 144, 47);
		contentPane.add(erosiButton);

		bilatuButton = new JButton("Eskariak bilatu");
		bilatuButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bilatuButton.setBounds(90, 223, 144, 47);
		contentPane.add(bilatuButton);

		erabilTF = new JTextField();
		erabilTF.setEditable(false);
		erabilTF.setFont(new Font("Tahoma", Font.BOLD, 10));
		erabilTF.setBounds(0, 353, 177, 29);
		contentPane.add(erabilTF);
		erabilTF.setColumns(10);
		erabilTF.setText(erabiltzaile);

		// Listenerrak
		erosiButton.addActionListener(e -> zabaldu(erosiButton, erabiltzaile));
		bilatuButton.addActionListener(e -> zabaldu(bilatuButton, erabiltzaile));

		// Menua
		itxisaioaMI.addActionListener(e -> itxi());
		aldatuerabiltzaileMI.addActionListener(e -> loginBueltatu());

		setTitle("Menu - Bezeroak");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Beste pantaila batera mugitzeko
	 *
	 * @param JButton botoi botoiak sakatzean bere pantailara mugitzeko
	 */
	public void zabaldu(JButton botoi, String erabiltzaile) {
		if (botoi == erosiButton) {
			eg = new ErosketaGUI(erabiltzaile);
			this.dispose();
		} else if (botoi == bilatuButton) {
			eb = new EskariakBilatuGUI(erabiltzaile);
			this.dispose();
		}
	}
	
	/**
	 * Menuaren funtzio bat da. Loginera bueltatzen du.
	 */
	private void loginBueltatu() {
		lbg = new LoginBezeroGUI();
		this.dispose();
	}
	/**
	 * Menuaren funtzio bat da. Programa ixten du.
	 */
	private void itxi() {
		if (JOptionPane.showConfirmDialog(null, "Programa itxi nahi duzu?", "KONTUZ!",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
}

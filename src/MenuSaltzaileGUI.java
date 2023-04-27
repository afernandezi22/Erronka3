import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class MenuSaltzaileGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSaltzaileGUI frame = new MenuSaltzaileGUI();

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
	public MenuSaltzaileGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(erabiltzaileM);
		
		JMenuItem aldatuerabiltzaileMI = new JMenuItem("Aldatu erabiltzaile");
		aldatuerabiltzaileMI.setHorizontalAlignment(SwingConstants.LEFT);
		aldatuerabiltzaileMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.add(aldatuerabiltzaileMI);
		
		JMenuItem itxisaioaMI = new JMenuItem("Itxi saioa eta itxi programa");
		itxisaioaMI.setHorizontalAlignment(SwingConstants.LEFT);
		itxisaioaMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		erabiltzaileM.add(itxisaioaMI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ekariegoeraButton = new JButton("ESKARI EGOERA ALDATU");
		ekariegoeraButton.setBounds(10, 77, 155, 31);
		contentPane.add(ekariegoeraButton);
		
		JButton bezerokudeatuButton = new JButton("BEZEROAK KUDEATU");
		bezerokudeatuButton.setBounds(269, 77, 155, 31);
		contentPane.add(bezerokudeatuButton);
		
		JButton produktuprezioButton = new JButton("PRODUKTU PREZIOA");
		produktuprezioButton.setBounds(142, 119, 155, 31);
		contentPane.add(produktuprezioButton);
		setVisible(true);
	}
}

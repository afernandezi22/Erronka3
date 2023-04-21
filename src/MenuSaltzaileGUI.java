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
		
		JMenu mnNewMenu = new JMenu("Erabiltzaile");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnNewMenu.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Aldatu erabiltzaile");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Itxi saioa eta itxi programa");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ESKARI EGOERA ALDATU");
		btnNewButton.setBounds(10, 77, 155, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBezeroakKudeatu = new JButton("BEZEROAK KUDEATU");
		btnBezeroakKudeatu.setBounds(269, 77, 155, 31);
		contentPane.add(btnBezeroakKudeatu);
		
		JButton btnProduktuPrezio = new JButton("PRODUKTU PREZIOA");
		btnProduktuPrezio.setBounds(142, 119, 155, 31);
		contentPane.add(btnProduktuPrezio);
		setVisible(true);
	}
}

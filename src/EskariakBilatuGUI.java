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

public class EskariakBilatuGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JTextPane textPane;
	private JComboBox comboBox; 

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
	public EskariakBilatuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Erabiltzaile");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Aldatu erabiltzaile");
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Itxi saioa eta itxi programa");
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem_1);
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
		
		setVisible(true);
	}
}

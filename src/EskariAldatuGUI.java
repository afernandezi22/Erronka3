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
	private JTextField textField;

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
		
		JMenu mnNewMenu = new JMenu("Erabiltzaile");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Aldatu erabiltzaile");
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Itxi saioa eta itxi programa");
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eskari ID-a");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 23, 79, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(48, 49, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("BILATU");
		btnNewButton.setBounds(273, 38, 111, 31);
		contentPane.add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(110, 80, 195, 98);
		contentPane.add(textPane);
		
		JButton btnGorde = new JButton("GORDE");
		btnGorde.setBounds(273, 197, 111, 31);
		contentPane.add(btnGorde);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Egiteke", "Bidalita", "Ezeztatuta"}));
		comboBox.setBounds(45, 201, 138, 27);
		contentPane.add(comboBox);
		
		setVisible(true);
	}
}

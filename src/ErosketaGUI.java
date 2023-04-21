import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ErosketaGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErosketaGUI frame = new ErosketaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ErosketaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setBounds(166, 29, 200, 26);
		contentPane.add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBounds(166, 66, 200, 26);
		contentPane.add(slider_1);
		
		JLabel lblNewLabel = new JLabel("Gehienezko prezioa");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 29, 136, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblGutxienezkoPrezioa = new JLabel("Gutxienezko prezioa");
		lblGutxienezkoPrezioa.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblGutxienezkoPrezioa.setBounds(20, 66, 136, 26);
		contentPane.add(lblGutxienezkoPrezioa);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(376, 29, 28, 26);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(376, 66, 28, 26);
		contentPane.add(textPane_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Garestienetik merkeenera");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(20, 119, 200, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Merkeenatik garestienera");
		rdbtnNewRadioButton_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(20, 145, 185, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("STOCK BAKARRIK");
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tglbtnNewToggleButton.setBounds(288, 97, 129, 36);
		contentPane.add(tglbtnNewToggleButton);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		textPane_1_1.setText("5");
		textPane_1_1.setBounds(422, 138, 49, 26);
		contentPane.add(textPane_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Atera bakarrik lehenengo...");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(244, 142, 185, 26);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CPU", "Video Card", "RAM", "Mother Board", "Storage", "Guztiak"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setBounds(20, 193, 112, 26);
		contentPane.add(comboBox);
		
		JToggleButton tglbtnFiltroakAktibatu = new JToggleButton("FILTROAK AKTIBATU");
		tglbtnFiltroakAktibatu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tglbtnFiltroakAktibatu.setBounds(288, 188, 144, 36);
		contentPane.add(tglbtnFiltroakAktibatu);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_1.setBounds(20, 282, 479, 26);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("EROSI");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(352, 319, 136, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("FILTRATU");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setBounds(339, 235, 90, 36);
		contentPane.add(btnNewButton_1);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

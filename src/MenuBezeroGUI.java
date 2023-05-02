/**
 * @clase Bezeroaren menuaren GUI
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBezeroGUI extends JFrame {

	private JPanel contentPane;
	private ErosketaGUI eg;
	private JButton erosiButton, bilatuButton;
	private EskariAldatuGUI ea;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBezeroGUI frame = new MenuBezeroGUI();
					frame.setVisible(true);
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
	public MenuBezeroGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 441);
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
			public void actionPerformed(ActionEvent e) {
			}
		});
		erosiButton.setBounds(90, 165, 144, 47);
		contentPane.add(erosiButton);
		
		bilatuButton = new JButton("Eskariak bilatu");
		bilatuButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bilatuButton.setBounds(90, 223, 144, 47);
		contentPane.add(bilatuButton);
		
		//Listenerrak
		erosiButton.addActionListener(e -> zabaldu(erosiButton));
		bilatuButton.addActionListener(e-> zabaldu(bilatuButton));
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**  
	 * Beste pantaila batera mugitzeko
	 * @param JButton botoi --> botoiak sakatzean bere pantailara mugitzeko
	 */
	public void zabaldu(JButton botoi) {
		if(botoi == erosiButton) {
			eg = new ErosketaGUI();
			this.dispose();
		} else if(botoi == bilatuButton) {
			ea = new EskariAldatuGUI();
			this.dispose();
		}
	}
}

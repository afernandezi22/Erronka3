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
	private JButton erosi, bilatu;
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
	 * Create the frame.
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
		
		erosi = new JButton("Produktuak erosi");
		erosi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		erosi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		erosi.setBounds(90, 165, 144, 47);
		contentPane.add(erosi);
		
		bilatu = new JButton("Eskariak bilatu");
		bilatu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bilatu.setBounds(90, 223, 144, 47);
		contentPane.add(bilatu);
		
		//Listenerrak
		erosi.addActionListener(e -> zabaldu(erosi));
		bilatu.addActionListener(e-> zabaldu(bilatu));
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void zabaldu(JButton botoi) {
		if(botoi == erosi) {
			eg = new ErosketaGUI();
			this.dispose();
		} else if(botoi == bilatu) {
			ea = new EskariAldatuGUI();
			this.dispose();
		}
	}
}

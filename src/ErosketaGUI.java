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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.ButtonGroup;


public class ErosketaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField ateralehenengoTF;
	private DB db;
	private JSlider gehienezkoPSli, gutxinezkoPSli;
	private JTextPane gehiPPane, gutxPPane;
	private JRadioButton maxMinB, minMaxB;
	private ButtonGroup maxMin;
	private JToggleButton strockbakarrikButton, filtroaktibatuButton;
	private JComboBox <String> produktuCB;
	private JButton erosiButton, filtratuButton;
	private Produktuak pk;
	private Produktu [] p;
	private JComboBox filtroCB;
	


	public ErosketaGUI() {
		//Datu-baserako konexioa
		db = new DB();
		
		//FRAMEAN DAGOEN GUZTIA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 440);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu erabiltzaileM = new JMenu("Erabiltzaile");
		erabiltzaileM.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		
		//Sliderrak
		gehienezkoPSli = new JSlider();
		gehienezkoPSli.setSnapToTicks(true);
		gehienezkoPSli.setMajorTickSpacing(150);
		gehienezkoPSli.setBounds(166, 29, 200, 26);
		contentPane.add(gehienezkoPSli);
		
		gutxinezkoPSli = new JSlider();
		gutxinezkoPSli.setMajorTickSpacing(150);
		gutxinezkoPSli.setSnapToTicks(true);
		gutxinezkoPSli.setBounds(166, 66, 200, 26);
		contentPane.add(gutxinezkoPSli);
		
		JLabel lblNewLabel = new JLabel("Gehienezko prezioa");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 29, 136, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblGutxienezkoPrezioa = new JLabel("Gutxienezko prezioa");
		lblGutxienezkoPrezioa.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblGutxienezkoPrezioa.setBounds(20, 66, 136, 26);
		contentPane.add(lblGutxienezkoPrezioa);
		
		//TextPane
		gehiPPane = new JTextPane();
		gehiPPane.setEditable(false);
		gehiPPane.setBounds(376, 29, 41, 26);
		contentPane.add(gehiPPane);
		gehiPPane.setText(""+(int)db.prezioHandiena()/2);
		
		gutxPPane = new JTextPane();
		gutxPPane.setEditable(false);
		gutxPPane.setBounds(376, 66, 41, 26);
		contentPane.add(gutxPPane);
		gutxPPane.setText(""+(int)db.prezioHandiena()/2);

		//RadioButton
		maxMinB = new JRadioButton("Garestienetik merkeenera");
		maxMinB.setSelected(true);
		maxMinB.setFont(new Font("Calibri", Font.PLAIN, 15));
		maxMinB.setBounds(20, 119, 200, 23);
		contentPane.add(maxMinB);
		
		minMaxB = new JRadioButton("Merkeenatik garestienera");
		minMaxB.setFont(new Font("Calibri", Font.PLAIN, 15));
		minMaxB.setBounds(20, 145, 185, 23);
		contentPane.add(minMaxB);
		
		//Botoiak batu
		maxMin = new ButtonGroup();
		maxMin.add(maxMinB);
		maxMin.add(minMaxB);
		
		//ToggleButton
		strockbakarrikButton = new JToggleButton("STOCK BAKARRIK");
		strockbakarrikButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		strockbakarrikButton.setBounds(288, 97, 129, 36);
		contentPane.add(strockbakarrikButton);
		
		filtroaktibatuButton = new JToggleButton("FILTROAK AKTIBATU");
		filtroaktibatuButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		filtroaktibatuButton.setBounds(288, 188, 144, 36);
		contentPane.add(filtroaktibatuButton);
		
		JLabel lblNewLabel_1 = new JLabel("Atera bakarrik lehenengo...");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(244, 142, 185, 26);
		contentPane.add(lblNewLabel_1);
		
		//ComboBoxak
		filtroCB = new JComboBox();
		filtroCB.setModel(new DefaultComboBoxModel(new String[] {"CPU", "Video Card", "RAM", "Mother Board", "Storage", "Guztiak"}));
		filtroCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		filtroCB.setBounds(20, 193, 112, 26);
		contentPane.add(filtroCB);
		
		produktuCB = new JComboBox();
		produktuCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		produktuCB.setBounds(20, 282, 479, 26);
		contentPane.add(produktuCB);
		kargatuProduktuGuztiak();//Produktu guztiak kargatzen ditu. Filtro barik
		
		//JButtonak
		erosiButton = new JButton("EROSI");
		erosiButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		erosiButton.setBounds(352, 319, 136, 36);
		contentPane.add(erosiButton);
		
		filtratuButton = new JButton("FILTRATU");
		filtratuButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		filtratuButton.setBounds(339, 235, 90, 36);
		contentPane.add(filtratuButton);
		
		ateralehenengoTF = new JTextField();
		ateralehenengoTF.setBounds(421, 142, 41, 22);
		contentPane.add(ateralehenengoTF);
		ateralehenengoTF.setColumns(10);
		
		//******************Funtzionaltasuna******************************
		
		//Sliderren parametroak zehaztu
		gehienezkoPSli.setMaximum((int)db.prezioHandiena());
		gehienezkoPSli.setValue((int)db.prezioHandiena()/2);
		gutxinezkoPSli.setMaximum((int)db.prezioHandiena());
		gutxinezkoPSli.setValue((int)db.prezioHandiena()/2);
		
		//Sliderraren aktzion listenerrak
		gehienezkoPSli.addChangeListener(e -> gehiPPane.setText(Integer.toString(gehienezkoPSli.getValue())));
		gutxinezkoPSli.addChangeListener(e -> gutxPPane.setText(Integer.toString(gutxinezkoPSli.getValue())));
		
		//Filtratu botoiaren listenerra
		filtratuButton.addActionListener(e -> filtratu());
		

		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new ErosketaGUI();
	}
	
	public void kargatuProduktuGuztiak() {
		pk = db.getProduktuak(); //Produktuak objektua lortzeko
		p = pk.getP(); //Barruan daukan arraya lortzeko
		
		produktuCB.removeAllItems();
		
		for (int i = 0; i < p.length; i++) {
			produktuCB.addItem(p[i].getIzena());
		}
	}
	
	public void kargatuKategoria(int x) {
		pk = db.getKategoriarekin(x);
		p = pk.getP();
		
		produktuCB.removeAllItems();

		for (int i = 0; i < p.length; i++) {
			produktuCB.addItem(p[i].getIzena());
		}
	}
	
	public void kargatuFiltroekin() {
		pk = db.getFiltroekin(Double.parseDouble(gehiPPane.getText()), Double.parseDouble(gutxPPane.getText()), maxMinB.isSelected(), minMaxB.isSelected(), strockbakarrikButton.isSelected(), Integer.parseInt(ateralehenengoTF.getText()), filtroCB.getSelectedIndex());
		p = pk.getP();
		
		produktuCB.removeAllItems();
		
		for (int i = 0; i < p.length; i++) {
			produktuCB.addItem(p[i].getIzena());
		}
	}
	
	public void filtratu() {
		if(filtroaktibatuButton.isSelected()) {
			kargatuFiltroekin();
		} else {
			if(filtroCB.getSelectedIndex() == 5) {
				kargatuProduktuGuztiak();
			}else {
				kargatuKategoria(filtroCB.getSelectedIndex());

			}
		}
	}
	
}

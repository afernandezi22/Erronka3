import javax.swing.*;
public class Erosketa extends JFrame{
    private JTextField gehienezko, gutxienezko, lehenengo;
    private JComboBox <String> kategoriak, produktuak;
    private JButton filtratu, erosi;
    private JToggleButton filtroak;
    private JSlider gehien, gutxien;
    private DB db;

    public Erosketa(){
        
    }

    public static void main(String[]args){
        new Erosketa();
    }
}

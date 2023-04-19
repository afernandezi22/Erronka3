import javax.swing.*;

public class bezeroLoginGUI extends JFrame {
    JTextField jtfErabiltzailea;
    JTextField jtfPasahitza;
    JButton jbLogin;
    JButton jbErregistratu;
    JButton jbSaltzaile;

    public bezeroLoginGUI() {
        jtfErabiltzailea = new JTextField(20);
        jtfPasahitza = new JTextField(20);
        jbLogin = new JButton("Login");
        jbErregistratu = new JButton("Erregistratu");
        jbSaltzaile = new JButton("Saltzaile");

        JPanel jp = new JPanel();
        jp.add(jtfErabiltzailea);
        jp.add(jtfPasahitza);
        jp.add(jbLogin);
        jp.add(jbErregistratu);
        jp.add(jbSaltzaile);

        getContentPane().add(jp);
        setVisible(true);
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        bezeroLoginGUI bLGUI = new bezeroLoginGUI();
    }
}
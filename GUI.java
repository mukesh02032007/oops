package oops;
import javax.swing.*;
import java.awt.event.*;
public class Gui extends JFrame implements ActionListener {
    JTextField t1;
    JLabel l1;
    JButton b1, b2;
    Gui() {
        setTitle("Temperature Converter");
        setSize(350, 200);
        setLayout(null);
        JLabel l = new JLabel("Enter Temperature:");
        l.setBounds(30, 30, 150, 25);
        add(l);
        t1 = new JTextField();
        t1.setBounds(180, 30, 100, 25);
        add(t1);
        b1 = new JButton("To Celsius");
        b1.setBounds(30, 70, 120, 30);
        add(b1);
        b2 = new JButton("To Fahrenheit");
        b2.setBounds(160, 70, 130, 30);
        add(b2);
        l1 = new JLabel("Result: ");
        l1.setBounds(30, 120, 250, 25);
        add(l1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            double temp = Double.parseDouble(t1.getText());
            if (e.getSource() == b1) {
                double c = (temp - 32) * 5 / 9;
                l1.setText("Result: " + String.format("%.2f", c) + " °C");
            } else if (e.getSource() == b2) {
                double f = (temp * 9 / 5) + 32;
                l1.setText("Result: " + String.format("%.2f", f) + " °F");
            }
        } catch (Exception ex) {
            l1.setText("Error: Invalid input!");
        }
    }
    public static void main(String[] args) {
    	System.out.println("Mukesh p\n2117240070193");
        new Gui();
    }
}

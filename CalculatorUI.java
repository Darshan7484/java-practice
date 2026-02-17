import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorUI extends JFrame implements ActionListener {

    JTextField display;
    String operator = "";
    int num1 = 0, num2 = 0;

    CalculatorUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String buttons[] = {
                "7", "8", "9", "-",
                "4", "5", "6", "+",
                "1", "2", "3", "=",
                "C", "0", "", ""
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            display.setText(display.getText() + command);
        } 
        else if (command.equals("+") || command.equals("-")) {
            num1 = Integer.parseInt(display.getText());
            operator = command;
            display.setText("");
        } 
        else if (command.equals("=")) {
            num2 = Integer.parseInt(display.getText());
            int result = 0;

            if (operator.equals("+"))
                result = num1 + num2;
            else if (operator.equals("-"))
                result = num1 - num2;

            display.setText(String.valueOf(result));
        } 
        else if (command.equals("C")) {
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorUI();
    }
}

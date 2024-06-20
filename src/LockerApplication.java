import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame implements ActionListener {
    private JTextField lockerTextField;
    private JTextField passwordTextField;
    private JLabel statusLabel;
    private String savedPassword;

    JButton clearButton;
    JButton enterButton;
    JTextField textField;

    JLabel enterLabel;

    private JButton[] numberButtons;

    public LockerApplication() {
        setTitle("Locker Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(600, 600));
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Dimension buttonSize = new Dimension(80, 30);
        JPanel lockerPanel = new JPanel(new GridLayout(3, 3, 0, 0));

        numberButtons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i + 1));
            numberButtons[i].setPreferredSize(buttonSize);
            numberButtons[i].addActionListener(this);
            lockerPanel.add(numberButtons[i]);
        }


        mainPanel.add(lockerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(mainPanel);


        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);
        enterButton = new JButton("ENTER");
        enterButton.addActionListener(this);

        textField = new JTextField(10);

        enterLabel = new JLabel("Enter Password");

        bottomPanel.add(clearButton);
        bottomPanel.add(textField);
        bottomPanel.add(enterButton);
        bottomPanel.add(enterLabel);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == clearButton) {
            textField.setText("");
        } else if (source == enterButton) {
            if (savedPassword == null) {
                savedPassword = textField.getText();
                textField.setText("");
                enterLabel.setText("Password Set");
            } else {
                if (textField.getText().equals(savedPassword)) {
                    textField.setText("");
                    enterLabel.setText("Password Correct");
                } else {
                    textField.setText("");
                    enterLabel.setText("Password Incorrect");
                }
            }
        }else {
            for (int i = 0; i < numberButtons.length; i++) {
                if (source == numberButtons[i]) {
                    textField.setText(textField.getText() + (i + 1));
                    break;
                }
            }
        }
    }
}

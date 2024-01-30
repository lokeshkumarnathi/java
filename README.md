/* Program to create a Simple Calculator */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {

    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalButton, clearButton;

    private double firstNum, secondNum, result;
    private char operator;

    public CalculatorApp() {
        initializeUI();
        initializeButtons();
        addComponentsToFrame();
        attachButtonListeners();
    }

    private void initializeUI() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4));
    }

    private void initializeButtons() {
        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");
    }

    private void addComponentsToFrame() {
        add(inputField);
        for (int i = 1; i < 10; i++) {
            add(numberButtons[i]);
        }
        add(numberButtons[0]);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(equalButton);
        add(clearButton);
    }

    private void attachButtonListeners() {
        for (int i = 0; i < 10; i++) {
            int num = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    inputField.setText(inputField.getText() + num);
                }
            });
        }

        addButton.addActionListener(e -> setOperator('+'));
        subtractButton.addActionListener(e -> setOperator('-'));
        multiplyButton.addActionListener(e -> setOperator('*'));
        divideButton.addActionListener(e -> setOperator('/'));

        equalButton.addActionListener(e -> calculateResult());

        clearButton.addActionListener(e -> {
            inputField.setText("");
            firstNum = secondNum = result = 0;
            operator = '\0';
        });
    }

    private void setOperator(char op) {
        firstNum = Double.parseDouble(inputField.getText());
        inputField.setText("");
        operator = op;
    }

    private void calculateResult() {
        secondNum = Double.parseDouble(inputField.getText());
        try {
            switch (operator) {
                case '+':
                    result = firstNum + secondNum;
                    break;
                case '-':
                    result = firstNum - secondNum;
                    break;
                case '*':
                    result = firstNum * secondNum;
                    break;
                case '/':
                    if (secondNum == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = firstNum / secondNum;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
            inputField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            inputField.setText("Error");
        } catch (ArithmeticException ex) {
            inputField.setText("Error: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            inputField.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
  
            CalculatorApp calculator = new CalculatorApp();
            calculator.setVisible(true);
        
    }
}

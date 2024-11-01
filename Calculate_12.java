/* 최종 코드 */
package cheonhun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 기본 산술 연산을 제공하는 간단한 계산기 애플리케이션.
 * 덧셈, 뺄셈, 곱셈, 나눗셈, 제곱, 제곱근, 역수 및 기타 연산을 지원한다.
 */
public class Calculate_12 extends JFrame implements ActionListener {
    private JTextField display;
    private String operator;
    private double num1, num2, result;
    private boolean isOperatorClicked;

    /**
     * 계산기의 GUI를 생성하는 생성자.
     * 디스플레이 필드와 다양한 연산자 및 숫자 버튼을 초기화한다.
     */
    public Calculate_12() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons = {
                "%", "CE", "C", "Delete",
                "1/x", "x²", "²√x", "/",
                "7", "8", "9", "x",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        operator = "";
        isOperatorClicked = false;
    }

    /**
     * 버튼 클릭 이벤트를 처리하는 메서드.
     * 연산자와 숫자를 구분하여 계산을 수행하며, "=", "C", "CE" 등의 특별한 버튼도 처리한다.
     *
     * @param e 클릭된 버튼의 이벤트 정보
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "C":
                    // 모든 값 초기화
                    display.setText("");
                    operator = "";
                    num1 = num2 = result = 0;
                    isOperatorClicked = false;
                    break;
                case "CE":
                    // 현재 입력값 초기화
                    display.setText("");
                    break;
                case "Delete":
                    // 마지막 문자 삭제
                    String text = display.getText();
                    if (!text.isEmpty()) {
                        display.setText(text.substring(0, text.length() - 1));
                    }
                    break;
                case "+/-":
                    // 양수/음수 전환
                    if (!display.getText().isEmpty()) {
                        double value = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(value * -1));
                    }
                    break;
                case "1/x":
                    // 역수 계산
                    if (!display.getText().isEmpty()) {
                        double value = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(1 / value));
                    }
                    break;
                case "x²":
                    // 제곱 계산
                    if (!display.getText().isEmpty()) {
                        double value = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(value * value));
                    }
                    break;
                case "²√x":
                    // 제곱근 계산
                    if (!display.getText().isEmpty()) {
                        double value = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(Math.sqrt(value)));
                    }
                    break;
                case "+":
                case "-":
                case "x":
                case "/":
                    // 연산자 입력 처리
                    num1 = Double.parseDouble(display.getText());
                    operator = command;
                    display.setText("");
                    isOperatorClicked = true;
                    break;
                case "=":
                    // 결과 계산
                    if (isOperatorClicked) {
                        num2 = Double.parseDouble(display.getText());
                        switch (operator) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "x":
                                result = num1 * num2;
                                break;
                            case "/":
                                if (num2 != 0) result = num1 / num2;
                                else JOptionPane.showMessageDialog(this, "0으로 나눌 수 없습니다");
                                break;
                        }
                        display.setText(String.valueOf(result));
                        isOperatorClicked = false;
                    }
                    break;
                default: // 숫자 버튼 처리
                    display.setText(display.getText() + command);
                    break;
            }
        } catch (Exception ex) {
            display.setText("Error");
            isOperatorClicked = false;
        }
    }

    /**
     * 프로그램의 진입점. 계산기 애플리케이션을 실행한다.
     *
     * @param args 명령줄 인수 (사용되지 않음)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Calculate_12 calculator = new Calculate_12();
            calculator.setVisible(true);
        });
    }
}
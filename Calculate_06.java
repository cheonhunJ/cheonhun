/* 초기화 메서드 작성  */
package cheonhun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 기본 산술 연산을 제공하는 간단한 계산기 애플리케이션
public class Calculate_06 extends JFrame implements ActionListener {
    private JTextField display; // 디스플레이 필드 추가

    private String operator; // 연산자 변수
    private double num1, num2, result; // 숫자와 결과 변수
    private boolean isOperatorClicked; // 연산자 클릭 여부

    public Calculate_06() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 디스플레이 필드 설정
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // 버튼 패널 생성
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
        add(buttonPanel, BorderLayout.CENTER);

        // 버튼 배열 생성
        String[] buttons = {
            "C", "CE", "Delete", "1/x", 
            "x²", "²√x", "/", 
            "7", "8", "9", "x", 
            "4", "5", "6", "-", 
            "1", "2", "3", "+", 
            "+/-", "0", ".", "="
        };

        // 버튼 생성 및 패널에 추가
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this); // ActionListener 추가
            buttonPanel.add(button);
        }

        operator = ""; // 초기화
        isOperatorClicked = false; // 초기화
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // 이후 단계에서 명령어 처리 추가
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculate_06 calculator = new Calculate_06();
            calculator.setVisible(true);
        });
    }
}

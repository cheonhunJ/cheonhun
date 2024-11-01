/* 버튼 패널 생성  */
package cheonhun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 기본 산술 연산을 제공하는 간단한 계산기 애플리케이션
public class Calculate_03 extends JFrame {
    private JTextField display; // 디스플레이 필드 추가

    public Calculate_03() {
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculate_03 calculator = new Calculate_03();
            calculator.setVisible(true);
        });
    }
}

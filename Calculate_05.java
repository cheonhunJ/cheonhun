/* ActionListener 추가   */
package cheonhun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 기본 산술 연산을 제공하는 간단한 계산기 애플리케이션
public class Calculate_05 extends JFrame implements ActionListener {
    private JTextField display; // 디스플레이 필드 추가

    public Calculate_05() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 이벤트 처리 로직은 다음 단계에서 추가
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculate_05 calculator = new Calculate_05();
            calculator.setVisible(true);
        });
    }
}

/* 프로젝트 생성  */
package cheonhun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 기본 산술 연산을 제공하는 간단한 계산기 애플리케이션
public class Calculate_01 extends JFrame {
    public Calculate_01() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculate_01 calculator = new Calculate_01();
            calculator.setVisible(true);
        });
    }
}

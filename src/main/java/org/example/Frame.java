package org.example;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        JTextArea auto_excels = new JTextArea();

        setSize(300, 200); //크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("프레임 작성예시");

        setLayout(new FlowLayout()); //배치 관리자 설정
        JButton button = new JButton("버튼");

        //컴포넌트 생성 및 추가
        this.add(button);
        setVisible(true);
    }


}

package org.sp.projectChatting.chatting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.sp.projectChatting.main.Page;

//채팅 가능한 사람들의 목록이 뜨는 가장 기본적인 홈화면
public class ChatHome extends Page {
	JPanel p_main;

	
	public ChatHome() {
		p_main = new JPanel();

		
		//디자인과 사이즈 조정
		p_main.setBackground(null); //디자인중에는잠시 막아두기	
		p_main.setPreferredSize(new Dimension(300,450));

		add(p_main);

		
		
	}
	
	
	
}

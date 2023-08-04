package org.sp.projectChatting.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

//부서이름을 가지고 있는 네이바패널 클릭하면 하단의 리스트 배널이 변환된다
public class NaviPanel extends JPanel{
	JLabel la_title;
	
	public NaviPanel(String title) {
		la_title = new JLabel();
		la_title.setText(title);

		add(la_title);
		setPreferredSize(new Dimension(52,30));
		setBackground(Color.LIGHT_GRAY);
		
		addMouseListener(new MouseAdapter() {
			//마우스 클릭했을때
			public void mouseClicked(MouseEvent e) {
				//아래 리스트 화면 전환 메서드 호출
				System.out.println("화면바뀜");
			}
			//마우스 올라갔을때
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(230,242,223));
			}
			//마우스 내려갔을때
			public void mouseExited(MouseEvent e) {
				setBackground(Color.WHITE);
			}

		});
	}
	
	
}

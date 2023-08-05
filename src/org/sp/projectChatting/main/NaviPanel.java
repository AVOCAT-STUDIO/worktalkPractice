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
	HomePage homePage;
	Integer [] deptList = {11,22,33,44,55};
	
	public NaviPanel( HomePage homePage, String title) {
		this.homePage = homePage; 
		la_title = new JLabel();
		la_title.setText(title);

		add(la_title);
		setPreferredSize(new Dimension(48,30));
		setBackground(null);
		

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object obj = e.getSource();
				homePage.listPanel.removeAll();
				homePage.createEmpList(deptList[0]);

			}
		});
	}
	
	
}

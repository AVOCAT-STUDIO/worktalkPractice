package org.sp.projectChatting.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//스케줄 추가할때 날짜를 선정하기 위한 달력이 모양이 포함된 팝업창
public class CalendarFrame extends JFrame{
	JPanel p_main;// 모든 패널을 다 담을 가장 큰 랩퍼패널
	JPanel p_north;//화살표와 년월타이틀을 가질 상단 패널
	JPanel p_center;// 달력과 시간 셀렉트 박스를 가질센터 패널
	JPanel p_south;//선택한 결과물과  등록 버튼을 가질 하단 패널
	JPanel p_calendar;
	JPanel p_time;
	JButton bt_prev,bt_next,bt_regist;
	JLabel la_title, la_finalDate;
	JComboBox box;
	
	String[] dayTitle = {"일","월","화","수","목","금","토"};
	ArrayList<NumCell> numList = new ArrayList<NumCell>();
	
	
	
	
	
	
	
	public CalendarFrame() {
		p_main = new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		p_calendar = new JPanel();
		p_time = new JPanel();
		
		bt_prev = new JButton("◀");
		bt_next = new JButton("▶");
		la_title = new  JLabel("2023년 8월");
		box = new JComboBox();
		for(int i=8;i<20;i++) {
			box.addItem(i+" :00");
		}
		

		
		
		


		
		//디자인 사이즈
		p_main.setPreferredSize(new Dimension(380,380));
		p_north.setPreferredSize(new Dimension(360,50));
		p_center.setPreferredSize(new Dimension(360,250));
		p_south.setPreferredSize(new Dimension(360,50));
		
		p_calendar.setPreferredSize(new Dimension(200,240));
		p_time.setPreferredSize(new Dimension(140,240));
		
		Dimension d1 = new Dimension(30,30);
		bt_prev.setPreferredSize(d1);
		bt_next.setPreferredSize(d1);
		la_title.setPreferredSize(new Dimension(80,40));
		box.setPreferredSize(new Dimension(130,20));
		
		Font f = new Font("arial", Font.BOLD, 5);
		bt_prev.setFont(f);
		bt_next.setFont(f);
		
		
		
		
		p_main.setBackground(new Color(230,242,223));
		p_north.setBackground(Color.WHITE);
		p_center.setBackground(Color.WHITE);
		p_south.setBackground(Color.WHITE);
		
		
		//붙이기
		
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		
		p_time.add(box);
		
		p_center.add(p_calendar);
		p_center.add(p_time);
		p_main.add(p_north, BorderLayout.NORTH);
		p_main.add(p_center);
		p_main.add(p_south, BorderLayout.SOUTH);
		add(p_main);
		
		
		
		p_center.add(p_calendar);
		p_center.add(p_time);
		
		
		p_main.add(p_north, BorderLayout.NORTH);
		p_main.add(p_center);
		p_main.add(p_south, BorderLayout.CENTER);
		
		add(p_main);
		
		
		createCell();
		
		setVisible(true);
		setSize(400,410);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 창만 닫는 걸로 수정해야함.
		
	}
	
	public void createCell() {
		//요일셀 반복문으로 만들기
		for(int i=0; i<dayTitle.length;i++) {
<<<<<<< HEAD
			DayCell dayCell = new DayCell(Color.LIGHT_GRAY);
=======
			DayCell dayCell = new DayCell(Color.LIGHT_GRAY, 23, 28);
>>>>>>> refs/remotes/origin/master
			dayCell.setTitle(dayTitle[i]);
			p_calendar.add(dayCell);
		}
		//날짜셀 이중반복문으로 돌리기(7*6)
		for(int a=0; a<6;a++) {
			for(int i=0; i<7;i++) {
<<<<<<< HEAD
				NumCell numCell = new NumCell(Color.WHITE);
=======
				NumCell numCell = new NumCell(Color.WHITE, 23, 28);
>>>>>>> refs/remotes/origin/master
				numCell.setTitle("12");
				numList.add(numCell);
				p_calendar.add(numCell);
			}
		}
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> refs/remotes/origin/master

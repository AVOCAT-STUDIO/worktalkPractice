package org.sp.projectChatting.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomePage extends Page{
	Main main;
	JPanel p_main;//디자인을 위해 두페널을 감싼 페널
	JPanel p_north,p_center,p_south;
	JTextField txt_search;
	JPanel p_mine; //나의 정보를 보여주는 패널을 담고있는 패널
	JButton bt_search;//검색버튼
	JButton bt_status, bt_schedule;
	
	String[] naviTitle = {"회계부","영업부","총무부","인사부","마케팅부"};
	JPanel naviPanel; // 이것도 배열로 가야함. 상위패널 필요함
	JPanel listPanel;//이건 배열로 가야함 화면 전환때문에 최상위 패널이 필요함
	
	
	


	
	

	
	public HomePage(Main main) {
		this.main = main;
		p_main =  new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		
		txt_search = new JTextField();
		p_mine = new JPanel();
		bt_search = new JButton("검색");
		p_mine = new JPanel();
		bt_status = new JButton("상태수정");
		bt_schedule = new JButton("스케줄관리");
		


		p_mine.setBackground(Color.RED);
		


		p_main.setPreferredSize(new Dimension(300,500));
		p_north.setPreferredSize(new Dimension(290,90));
		p_center.setPreferredSize(new Dimension(290,350));
		p_south.setPreferredSize(new Dimension(290,40));
		txt_search.setPreferredSize(new Dimension(240,30));
		bt_search.setPreferredSize(new Dimension(40,30));
		p_mine.setPreferredSize(new Dimension(290,50));
		bt_status.setPreferredSize(new Dimension(130,30));
		bt_schedule.setPreferredSize(new Dimension(130,30));
		

		
		p_main.setBackground(new Color(230,242,223));
		p_north.setBackground(Color.WHITE);
		p_center.setBackground(Color.WHITE);
		p_south.setBackground(Color.WHITE);
		
		createMyPanel();
		createNaviPanel();
		createListPanel();
		

		
		
		//붙이기
		
		
		p_north.add(txt_search);
		p_north.add(bt_search);
		p_north.add(p_mine);
		
		p_south.add(bt_status);
		p_south.add(bt_schedule);
		
		p_main.add(p_north);
		p_main.add(p_center);
		p_main.add(p_south);
		
		add(p_main);

		bt_status.addMouseListener(new MouseAdapter() {
			//마우스를 클릭하면 상태페이지로 이동한다
			public void mouseClicked(MouseEvent e) {
				//누르면 팝업창이 뜨고 나의 현재 상태를 수정할수 있다
				StatusChangeFrame stausChangeFrame = new StatusChangeFrame();
			}
		});
		bt_schedule.addMouseListener(new MouseAdapter() {
			//마우스를 클릭하면 스케줄홈으로 이동한다
			public void mouseClicked(MouseEvent e) {
				main.showHide(main.SCHEDULE);
			
			}
		});
		
	}

	public void createMyPanel(){
		EmpPanel empPanel = new EmpPanel();
		p_mine.add(empPanel);
	}
	
	public void createNaviPanel() {
		for(int i=0; i<naviTitle.length;i++) {	
			naviPanel = new NaviPanel(naviTitle[i]);
			p_center.add(naviPanel);
			
		}
		
	}
	
	public void createListPanel() {
		for(int i=0; i<naviTitle.length;i++) {	
			listPanel = new ListPanel();
			p_center.add(listPanel);
			
		}
	}
}

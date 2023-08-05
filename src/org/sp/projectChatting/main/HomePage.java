package org.sp.projectChatting.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sp.projectChatting.DTO.EmployeeDTO;
import org.sp.projectChatting.Model.EmployeeDAO;
import org.sp.projectChatting.util.DBManager;

public class HomePage extends Page{
	Main main;
	JPanel p_main;//디자인을 위해 두페널을 감싼 페널
	JPanel p_north,p_center,p_south;
	JTextField txt_search;
	JPanel p_mine; //나의 정보를 보여주는 패널을 담고있는 패널
	JLabel la_search;//검색버튼이미지
	JButton bt_status, bt_schedule;
	
	String[] naviTitle = {"회계부","영업부","총무부","인사부","마케팅부"};
	Integer [] deptList = {11,22,33,44,55};
	
	int index ;
	
	JPanel naviPanel; // 이것도 배열로 가야함. 상위패널 필요함
	JPanel listPanel;//이건 배열로 가야함 화면 전환때문에 최상위 패널이 필요함
	Image img_search;
	//DriverManager보유
	DBManager dbManager;
	//DAO, DTO 보유하기
	EmployeeDAO employeeDAO;
	EmployeeDTO employeeDTO;
	
	
	


	
	

	
	public HomePage(Main main) {
		this.main = main;
		p_main =  new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		
		txt_search = new JTextField();
		p_mine = new JPanel();
		p_mine = new JPanel();
		bt_status = new JButton("상태수정");
		bt_schedule = new JButton("스케줄관리");
		
		listPanel = new ListPanel(); //직원들 목록 나오는 영역 
		
		dbManager = new DBManager();
		employeeDAO = new EmployeeDAO(dbManager);
		
		
		
		

		p_mine.setBackground(new Color(230,242,223));
		


		p_main.setPreferredSize(new Dimension(270,470));
		p_north.setPreferredSize(new Dimension(270,90));
		p_center.setPreferredSize(new Dimension(270,300));
		p_south.setPreferredSize(new Dimension(270,40));
		txt_search.setPreferredSize(new Dimension(210,30));
		p_mine.setPreferredSize(new Dimension(270,50));
		bt_status.setPreferredSize(new Dimension(130,30));
		bt_schedule.setPreferredSize(new Dimension(130,30));
		

		
		p_main.setBackground(new Color(230,242,223));
		p_north.setBackground(Color.WHITE);
		p_center.setBackground(Color.WHITE);
		p_south.setBackground(Color.WHITE);
		
		//createMyPanel();
		createNaviPanel();
		//createListPanel();
		createIcon();
		
		//붙이기
		
		p_center.add(listPanel);
		
		p_north.add(txt_search);
		p_north.add(la_search);
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
		
		la_search.addMouseListener(new MouseAdapter() {
			//마우스로 클릭하면 검색이 가능한 기능
			public void mouseClicked(MouseEvent e) {
				//아직 무슨 기능인지 잘 모르겠음 ㅋㅋㅋㅋㅋㅋ
			}
		});
		
		createEmpList(33); //33번 부서 디폴트값으로 정함 
	}

	
	public void createIcon() {
		try {
			BufferedImage buffImg = ImageIO.read(new File("res/search.png"));
			Image image = buffImg;
			image = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			la_search = new JLabel(new ImageIcon(image));
			//그외 아이콘들 추가로 만들면 됨
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	//각부서마다 모든 직원패널이 나열되어야한다.
	public void createEmpList(int x) {//부서 번호를 넣을 매게 변수

		
		List<EmployeeDTO> empList = employeeDAO.selectallemployee(x);
		
		for(int i=0;i<empList.size();i++) {
			EmployeeDTO emp=empList.get(i); //사원의 dTO 
			EmpPanel empPanel = new EmpPanel(emp); //사원을 담게될 셀 
			listPanel.add(empPanel);
		}
		listPanel.updateUI();		
	}
	
	public void createMyPanel(){
		
		EmpPanel empPanel = new EmpPanel(main.employeeDTO);
		p_mine.add(empPanel);
		
	}
	
	
	
	public void createNaviPanel() {
		for(int i=0; i<naviTitle.length;i++) {	
			naviPanel = new NaviPanel(this,naviTitle[i]);
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

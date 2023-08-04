package org.sp.projectChatting.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

//패널하나에 오롯이 한 직원의 정보만 포함한다
//클릭하면 직원의 상세 페이지로 전환된다.
public class EmpPanel extends JPanel{
	JPanel photo; //사람사진이 들어갈 패널
	JPanel p_dname,p_job,p_name;
	JLabel la_dname; //부서이름이 적힐 라벨
	JLabel la_job;//직급이 적힐 라벨
	JLabel la_name;//이름이 적힐 라벨
	JPanel icon; //상태 아이콘이 보여질 라벨
	
	public EmpPanel() {
		photo = new JPanel();
		la_dname = new JLabel();
		la_job = new JLabel();
		la_name = new JLabel();
		icon = new JPanel();
		p_dname = new JPanel();
		p_job = new JPanel();
		p_name = new JPanel();
		
		photo.setPreferredSize(new Dimension(30,30));
		icon.setPreferredSize(new Dimension(30,30));
		
		p_dname.setPreferredSize(new Dimension(55,30));
		p_job.setPreferredSize(new Dimension(55,30));
		p_name.setPreferredSize(new Dimension(55,30));
		
		la_dname.setText("영업부");
		la_job.setText("팀장");
		la_name.setText("이수지");
		
		

		p_dname.add(la_dname);
		p_job.add(la_job);
		p_name.add(la_name);
		
		add(photo);
		add(p_dname);
		add(p_job);
		add(p_name);
		add(icon);
		
		setPreferredSize(new Dimension(270,40));
		setBackground(Color.YELLOW);
		
		
	}
}

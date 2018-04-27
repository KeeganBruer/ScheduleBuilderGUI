package com.bracketTechnologies/scheduleBuilder.GUI;

public class MainFrame {
	private JFrame mainFrame;
	private JFrame debugFrame;
	private JPanel leftSidePanel;
	private BScrollableList unselectedClassesList;
	private JButton addClassButton;
	private BScrollableList selectedClassesList;
	public MainFrame() {
		mainFrame = new JFrame("Schedule Builder");
		mainFrame.setSize(600, 700);
		mainFrame.setLocation(50, 50);
		mainFrame.setVisible(true);
		debugFrame = new JFrame("Debug Menu");
		debugFrame.setSize(400, mainFrame.getHeight());
		debugFrame.setLocation(mainFrame.getX() + mainFrame.getWidth(), mainFrame.getY());
		debugFrame.setVisisble(false);
		setupLeftSide();
	}
	public void setupLeftSide() {
		//---------------------------------SETUP LEFTSIDE PANEL---------------------
		leftSidePanel = new JPanel();
		mainFrame.add(leftSidePanel);
		leftSidePanel.setLayout(null);
		leftSidePanel.setSize((mainFrame.getWidth()/2) -75, mainFrame.getHeight());
		//---------------------------------END SETUP LEFTSIDE PANEL-----------------
		
		//---------------------------------SETUP UNSELECTED CLASS LIST--------------
		unselectedClassesList = BScrollableList();
		leftSidePanel.add(unselectedClassesList);
		//---------------------------------END SETUP UNSELECTED CLASS LIST----------
		
		//---------------------------------SETUP ADD CLASS BUTTON-------------------
		addClassButton = new JButton("+");
		
		//---------------------------------END SETUP ADD CLASS BUTTON---------------
		
		//---------------------------------SETUP SELECTED CLASS LIST----------------
		selectedClassesList = BScrollableList();
		leftSidePanel.add(selectedClassesList);
		//---------------------------------END SETUP SELECTED CLASS LIST------------
		
		
	}
	
	public void setClassesInList(String[] list) {
		unselectedClassesList.setList(list);
	}
}

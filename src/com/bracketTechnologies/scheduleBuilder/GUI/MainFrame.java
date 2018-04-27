package com.bracketTechnologies/scheduleBuilder.GUI;

public class MainFrame {
	private JFrame mainFrame;
	private JFrame debugFrame;
	private JPanel leftSidePanel;
	private BScrollableList unselectedClassesList;
	private JButton addClassButton;
	private JButton removeClassButton;
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
		unselectedClassesList.setSize(200, 400);
		unselectedClassesList.setLocation(0, 0);
		//---------------------------------END SETUP UNSELECTED CLASS LIST----------
		
		//---------------------------------SETUP ADD CLASS BUTTON-------------------
		addClassButton = new JButton("+");
		leftSidePanel.add(addClassButton);
		addClassButton.setSize(50, 50);
		addClassButton.setLocation(unselectedClassesList.getX() + unselectedClassesList.getWidth() + 10, unselectedClassesList.getY() + (unselectedClassesList.getHeight()/2) -(addClassButton.getHeight()/2));
		addClassButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {ButtonFunctions.addClassButtonListener.onClick()}});
		//---------------------------------END SETUP ADD CLASS BUTTON---------------
		
		//---------------------------------SETUP REMOVE CLASS BUTTON----------------
		removeClassButton = new JButton("-");
		leftSidePanel.add(removeClassButton);
		removeClassButton.setSize(50, 50);
		removeClassButton.setLocation(unselectedClassesList.getX() + unselectedClassesList.getWidth() + 10, unselectedClassesList.getY() + (unselectedClassesList.getHeight()/2) + (addClassButton.getHeight()/2));
		removeClassButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {ButtonFunctions.removeClassButtonListener.onClick()}});
		//---------------------------------END SETUP REMOVE CLASS BUTTON------------
		
		//---------------------------------SETUP SELECTED CLASS LIST----------------
		selectedClassesList = BScrollableList();
		leftSidePanel.add(selectedClassesList);
		selectedClassesList.setSize(200, 400);
		selectedClassesList.setLocation(unselectedClassesList.getX() + unselectedClassesList.getWidth() + 20 + addClassButton.getWidth(), 0);
		//---------------------------------END SETUP SELECTED CLASS LIST------------
		
		
	}
	
	public void setClassesInList(String[] list) {
		unselectedClassesList.setList(list);
	}
	
	private class ButtonFunctions {
		public static ButtonClickListener addClassButtonListener = new ButtonClickListener() {
			public void onClick() {
				String[] picked = unselectedClassesList.getSelectedItems();
				unselectedClassesList.removeFromList(picked);
				selectedClassesList.addToList(picked);
			}
		};
		public static ButtonClickListener removeClassButtonListener = new ButtonClickListener() {
			public void onClick() {
				String[] picked = selectedClassesList.getSelectedItems();
				selectedClassesList.removeFromList(picked);
				unselectedClassesList.addToList(picked);
			}
		};
	}
}

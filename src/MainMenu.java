import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener{

	JButton button1 = new JButton("Insert Menu Baru");
	JButton button2 = new JButton("View Menu");
	JButton button3 = new JButton("Update Menu");
	JButton button4 = new JButton("Delete Menu");
	JButton exitButton = new JButton("Exit");
	
	public MainMenu() {
		initFrame();
	}
	
	public void initFrame() {
		setTitle("BobaCool Menu");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
		
		addText();
		addMenus();
		addBottomButton();
	}
	
	public void addText() {
		JLabel text1 = new JLabel("BobaCool Menu");
		text1.setHorizontalAlignment(JLabel.CENTER);
		text1.setFont(new Font(null, Font.BOLD, 20));
		
		add(text1, BorderLayout.NORTH);
	}
	
	public void addMenus() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		add(panel);
	}
	
	public void addBottomButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		exitButton.setBackground(Color.red);
		exitButton.setForeground(Color.white);
		exitButton.addActionListener(this);
		
		panel.add(exitButton);
		
		add(panel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exitButton)) {
			System.exit(0);
		}else if(e.getSource().equals(button1)) {
			new InsertMenu();
			setVisible(false);
		}else if(e.getSource().equals(button2)) {
			new ViewMenu();
			setVisible(false);
		}else if(e.getSource().equals(button3)) {
			new UpdateMenu();
			setVisible(false);
		}else if(e.getSource().equals(button4)) {
			new DeleteMenu();
			setVisible(false);
		}
	}

}

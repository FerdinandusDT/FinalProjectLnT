import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;

import dao.MenuDAO;

public class InsertMenu extends JFrame implements ActionListener {

	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	
	JTextField namaMenu = new JTextField();
	JTextField hargaMenu = new JTextField();
	JTextField stockMenu = new JTextField();
	
	JMenuItem exit = new JMenuItem("Exit");
	
	public InsertMenu() {
		initMenuBar();
		initFrame();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");
		
		exit.addActionListener(this);
		menu1.add(exit);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Insert Menu Baru");
		setSize(400, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(new GridLayout(0,2));
		setResizable(false);
		setVisible(true);
		
		initComponent();
	}
	
	public void initComponent() {
		JLabel nama = new JLabel("Nama Menu :");
		add(nama);
		add(namaMenu);
		
		JLabel harga = new JLabel("Harga Menu :");
		add(harga);
		add(hargaMenu);
		
		JLabel stock = new JLabel("Stock Menu :");
		add(stock);
		add(stockMenu);
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		add(save);
		add(cancel);
	}
	

	public boolean validateData() {
		if(namaMenu.getText().isEmpty() || hargaMenu.getText().isEmpty() || stockMenu.getText().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			if(validateData() == false) {
				JOptionPane.showMessageDialog(null, "Please fill all input");
			}else {
				String kode;
				Random random = new Random();
				int x = random.nextInt(900) + 100;
				kode = "BC-" + x;

				MenuDAO menuDAO = new MenuDAO();
				menuDAO.insertData(kode,namaMenu.getText(), hargaMenu.getText(), stockMenu.getText());
				
				JOptionPane.showMessageDialog(null, "Menu Added!");
			}
		}else if(e.getSource().equals(cancel)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(exit)) {
			System.exit(0);
		}
	}

}
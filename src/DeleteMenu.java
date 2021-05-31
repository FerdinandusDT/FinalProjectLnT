import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

import dao.MenuDAO;

public class DeleteMenu extends JFrame implements ActionListener, MouseListener {

	JMenuItem back, exitMenu;
	JTable table;
	JLabel namaMenu, hargaMenu, stockMenu;
	JButton delete;
	String id = "";
	
	public DeleteMenu() {
		initMenuBar();
		initFrame();
		addDeleteButton();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");

		back = new JMenuItem("Back to main menu");
		exitMenu = new JMenuItem("Exit");
		
		back.addActionListener(this);
		exitMenu.addActionListener(this);

		menu1.add(back);
		menu1.add(exitMenu);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Delete Data");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(new GridLayout(3,1));
		setResizable(false);
		setVisible(true);
		
		initTable();
	}
	
	public void initTable() {
		Vector<String> column = new Vector<>();
		column.add("Code");
		column.add("Nama");
		column.add("Harga");
		column.add("Stock");
		
		MenuDAO menuDAO = new MenuDAO();
		
		table = new JTable(menuDAO.getData(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		table.addMouseListener(this);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 500, 500);
		
		add(scroll);
	}
	
	public void addDeleteButton() {
		delete = new JButton("Delete Menu");
		delete.addActionListener(this);
		add(delete);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectRowIndex = table.getSelectedRow();
		id = table.getValueAt(selectRowIndex, 0).toString();
		String nama = table.getValueAt(selectRowIndex, 1).toString();
		String harga = table.getValueAt(selectRowIndex, 2).toString();
		String stock = table.getValueAt(selectRowIndex, 3).toString();
		
		namaMenu.setText(nama);
		hargaMenu.setText(harga);
		stockMenu.setText(stock);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(exitMenu)) {
			System.exit(0);
		}else if(e.getSource().equals(delete)) {
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "You have to choose data first!");
			}else {
				MenuDAO menuDAO = new MenuDAO();
				menuDAO.deleteData(id);
				JOptionPane.showMessageDialog(null, "Menu Deleted!");
				new DeleteMenu();
				setVisible(false);
			}
		}
	}

}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class HRdep extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRdep frame = new HRdep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refreshTable()
	{
		try {
			String query="select Name,Employee_Number from department";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Connection conn=null;
	private JScrollPane scrollPane;
	private JTextField searchtext;
	private JLabel label;
	private JLabel label1;
	/**
	 * Create the frame.
	 */
	public HRdep() {
		conn = SQLcon.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 282, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03BD\u03AD\u03BF\u03C5 \u03C4\u03BC\u03AE\u03BC\u03B1\u03C4\u03BF\u03C2");
		button.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\add-icon.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRdepNew hrd=new HRdepNew();
				hrd.setVisible(true);
				dispose();
			}
		});
		button.setBounds(302, 154, 232, 70);
		contentPane.add(button);
		
		JButton button1 = new JButton("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1 \u03C4\u03BC\u03AE\u03BC\u03B1\u03C4\u03BF\u03C2");
		button1.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Actions-document-edit-icon.png"));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRdepEdit hrd=new HRdepEdit();
				hrd.setVisible(true);
				dispose();
				
			}
		});
		button1.setBounds(302, 235, 232, 70);
		contentPane.add(button1);
		
		searchtext = new JTextField();
		searchtext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String selection=(String)comboBox.getSelectedItem();
					String query="select * from department where "+selection+"=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,searchtext.getText() );
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		searchtext.setBounds(159, 72, 133, 33);
		contentPane.add(searchtext);
		searchtext.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Employee_Number"}));
		comboBox.setBounds(10, 72, 139, 33);
		contentPane.add(comboBox);
		
		JButton button2 = new JButton("\u03A0\u03AF\u03C3\u03C9");
		button2.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\23.png"));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRpage hrd=new HRpage();
				hrd.setVisible(true);
				dispose();
			}
		});
		button2.setBounds(10, 4, 115, 40);
		contentPane.add(button2);
		
		label = new JLabel("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7:");
		label.setBounds(10, 47, 64, 14);
		contentPane.add(label);
		
		label1 = new JLabel("");
		label1.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\ecorpssmall2.png"));
		label1.setBounds(362, 4, 115, 105);
		contentPane.add(label1);
		
		refreshTable();
	}
}

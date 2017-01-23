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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
public class ChiefDep extends JFrame {

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
					ChiefDep frame = new ChiefDep();
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
			String query="select * from department";
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
	private JButton button2;
	private JTextField ratetext;
	private JButton button1;
	private JTextField nametext;
	private JLabel label;
	private JLabel label1;
	private JLabel label2;
	/**
	 * Create the frame.
	 */
	public ChiefDep() {
		conn = SQLcon.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 282, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row=table.getSelectedRow();
					String Name_=(table.getModel().getValueAt(row, 0)).toString();
					String query="select * from department where Name='"+Name_+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						ratetext.setText(rs.getString("Rating"));
						nametext.setText(rs.getString("Name"));
					}
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
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
		searchtext.setBounds(122, 67, 170, 36);
		contentPane.add(searchtext);
		searchtext.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Employee_Number", "Rating"}));
		comboBox.setBounds(10, 67, 102, 36);
		contentPane.add(comboBox);
		
		button2 = new JButton("\u03A0\u03AF\u03C3\u03C9");
		button2.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\23.png"));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChiefPage chd=new ChiefPage();
				chd.setVisible(true);
				dispose();
			}
		});
		button2.setBounds(10, 11, 96, 36);
		contentPane.add(button2);
		
		ratetext = new JTextField();
		ratetext.setBounds(398, 176, 150, 51);
		contentPane.add(ratetext);
		ratetext.setColumns(10);
		
		button1 = new JButton("\u0395\u03BD\u03B7\u03BC\u03AD\u03C1\u03C9\u03C3\u03B7");
		button1.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Actions-document-edit-icon.png"));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Update department set Name='"+nametext.getText()+"', Rating='"+ratetext.getText()+"' where Name='"+nametext.getText()+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Επιτυχής ενημέρωση!");
					refreshTable();
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		button1.setBounds(333, 249, 150, 56);
		contentPane.add(button1);
		
		nametext = new JTextField();
		nametext.setBounds(398, 114, 150, 51);
		contentPane.add(nametext);
		nametext.setColumns(10);
		
		label = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B9\u03C3\u03B7:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(302, 176, 86, 51);
		contentPane.add(label);
		
		label1 = new JLabel("<html>\u038C\u03BD\u03BF\u03BC\u03B1<br>\u03C4\u03BC\u03AE\u03BC\u03B1\u03C4\u03BF\u03C2:</html>");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(302, 114, 86, 51);
		contentPane.add(label1);
		
		label2 = new JLabel("");
		label2.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\ecorpssmall2.png"));
		label2.setBounds(428, 11, 120, 92);
		contentPane.add(label2);
		
		refreshTable();
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;

public class HRdepEdit extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JTextField numtext;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRdepEdit frame = new HRdepEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	
	public void fillComboBox()
	{
		try {
			String query="select * from department";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				comboBox.addItem(rs.getString("Name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public HRdepEdit() {
		conn = SQLcon.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		nametext = new JTextField();
		nametext.setColumns(10);
		nametext.setBounds(131, 102, 173, 35);
		panel.add(nametext);
		
		numtext = new JTextField();
		numtext.setColumns(10);
		numtext.setBounds(131, 169, 173, 35);
		panel.add(numtext);
		
		JButton button2 = new JButton("\u0395\u03BD\u03B7\u03BC\u03AD\u03C1\u03C9\u03C3\u03B7");
		button2.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Actions-document-edit-icon.png"));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Update department set Name='"+nametext.getText()+"', Employee_Number='"+numtext.getText()+"' where Name='"+nametext.getText()+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Επιτυχής ενημέρωση!");
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		button2.setBounds(10, 236, 151, 59);
		panel.add(button2);
		
		JButton button3 = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE");
		button3.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Close-2-icon.png"));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action=JOptionPane.showConfirmDialog(null, "Είστε σίγουρος/η ότι θέλετε να διαγράψετε το τμήμα;","Delete",JOptionPane.YES_NO_OPTION);
				if(action==0){
				try {
					String query="delete from department where Name='"+nametext.getText()+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Επιτυχής διαγραφή!");
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
			}
		});
		button3.setBounds(171, 236, 133, 59);
		panel.add(button3);
		
		JButton btnNewButton = new JButton("\u03A0\u03AF\u03C3\u03C9");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\23.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRdep frame = new HRdep();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 109, 35);
		panel.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.insertItemAt("", 0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from department where Name=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, (String)comboBox.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						nametext.setText(rs.getString("Name"));
						numtext.setText(rs.getString("Employee_Number"));
					}
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		comboBox.setBounds(131, 56, 173, 35);
		panel.add(comboBox);
		
		JLabel label = new JLabel("<html>\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2<br>\u03B5\u03C1\u03B3\u03B1\u03B6\u03BF\u03BC\u03AD\u03BD\u03C9\u03BD:</html>");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(22, 169, 99, 35);
		panel.add(label);
		
		JLabel label1 = new JLabel("<html>\u038C\u03BD\u03BF\u03BC\u03B1<br>\u03C4\u03BC\u03AE\u03BC\u03B1\u03C4\u03BF\u03C2:</html>");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(19, 102, 80, 35);
		panel.add(label1);
		
		fillComboBox();
	}
}

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

public class HRemployeeEdit extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private JTextField nametext;
	private JTextField surtext;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRemployeeEdit frame = new HRemployeeEdit();
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
			String query="select * from employee";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				comboBox.addItem(rs.getString("Surname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public HRemployeeEdit() {
		conn = SQLcon.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label1 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(46, 112, 75, 25);
		panel.add(label1);
		
		JLabel label2 = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF:");
		label2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label2.setBounds(46, 168, 75, 25);
		panel.add(label2);
		
		JLabel label3 = new JLabel("ID:");
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setBounds(46, 61, 75, 25);
		panel.add(label3);
		
		idtext = new JTextField();
		idtext.setColumns(10);
		idtext.setBounds(191, 51, 173, 35);
		panel.add(idtext);
		
		nametext = new JTextField();
		nametext.setColumns(10);
		nametext.setBounds(191, 109, 173, 35);
		panel.add(nametext);
		
		surtext = new JTextField();
		surtext.setColumns(10);
		surtext.setBounds(191, 158, 173, 35);
		panel.add(surtext);
		
		JButton button2 = new JButton("\u0395\u03BD\u03B7\u03BC\u03AD\u03C1\u03C9\u03C3\u03B7");
		button2.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Actions-document-edit-icon.png"));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Update employee set ID='"+idtext.getText()+"', Name='"+nametext.getText()+"', Surname='"+surtext.getText()+"' where ID='"+idtext.getText()+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Επιτυχής ενημέρωση!");
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		button2.setBounds(10, 236, 171, 59);
		panel.add(button2);
		
		JButton button3 = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE");
		button3.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Actions-list-remove-user-icon.png"));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action=JOptionPane.showConfirmDialog(null, "Είστε σίγουρος/η ότι θέλετε να διαγράψετε τον χρήστη;","Delete",JOptionPane.YES_NO_OPTION);
				if(action==0){
				try {
					String query="delete from employee where ID='"+idtext.getText()+"'";
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
		button3.setBounds(191, 236, 173, 59);
		panel.add(button3);
		
		JButton btnNewButton = new JButton("\u03A0\u03AF\u03C3\u03C9");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\23.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRemployee frame = new HRemployee();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 111, 39);
		panel.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.insertItemAt("", 0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query="select * from employee where Surname=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, (String)comboBox.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						idtext.setText(rs.getString("ID"));
						nametext.setText(rs.getString("Name"));
						surtext.setText(rs.getString("Surname"));
					}
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		comboBox.setBounds(191, 11, 173, 23);
		panel.add(comboBox);
		
		fillComboBox();
	}

}

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
public class ChiefEmployee extends JFrame {

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
					ChiefEmployee frame = new ChiefEmployee();
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
			String query="select * from employee";
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
	private JTextField idtext;
	private JLabel lblId;
	private JLabel label;
	private JLabel label1;
	/**
	 * Create the frame.
	 */
	public ChiefEmployee() {
		conn = SQLcon.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 282, 195);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row=table.getSelectedRow();
					String ID_=(table.getModel().getValueAt(row, 0)).toString();
					String query="select * from employee where ID='"+ID_+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						ratetext.setText(rs.getString("Rating"));
						idtext.setText(rs.getString("ID"));
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
					String query="select * from employee where "+selection+"=? ";
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
		searchtext.setBounds(122, 62, 170, 41);
		contentPane.add(searchtext);
		searchtext.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "Name", "Surname", "Rating"}));
		comboBox.setBounds(10, 62, 102, 41);
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
		button2.setBounds(10, 11, 112, 40);
		contentPane.add(button2);
		
		ratetext = new JTextField();
		ratetext.setBounds(409, 179, 150, 56);
		contentPane.add(ratetext);
		ratetext.setColumns(10);
		
		button1 = new JButton("\u0395\u03BD\u03B7\u03BC\u03AD\u03C1\u03C9\u03C3\u03B7");
		button1.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Actions-document-save-as-icon.png"));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Update employee set ID='"+idtext.getText()+"', Rating='"+ratetext.getText()+"' where ID='"+idtext.getText()+"' ";
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
		button1.setBounds(333, 253, 170, 56);
		contentPane.add(button1);
		
		idtext = new JTextField();
		idtext.setBounds(409, 114, 150, 54);
		contentPane.add(idtext);
		idtext.setColumns(10);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(302, 134, 46, 14);
		contentPane.add(lblId);
		
		label = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B9\u03C3\u03B7:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(302, 200, 97, 23);
		contentPane.add(label);
		
		label1 = new JLabel("");
		label1.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\ecorpssmall2.png"));
		label1.setBounds(447, 11, 112, 92);
		contentPane.add(label1);
		
		refreshTable();
	}
}

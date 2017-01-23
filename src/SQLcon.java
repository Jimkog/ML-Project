import java.sql.*;
import javax.swing.*;
public class SQLcon {
	Connection conn=null;

	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:/Users/Jimkog/workspace/ML Project/ems.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection successful");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}

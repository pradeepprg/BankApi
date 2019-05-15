import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tester {

	public static void main(String[] args) {
		String QUERY = "INSERT INTO STUDENTS_1111 "+
	               "  VALUES (student_seq.NEXTVAL,"+
	               "         'Harry', 'harry@hogwarts.edu', '31-July-1980')";

	// load oracle driver


	// prepare statement to execute insert query
	// note the 2nd argument passed to prepareStatement() method
	// pass name of primary key column, in this case student_id is
	// generated from sequence
	

	// execute the insert statement, if success get the primary key value
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// get database connection from connection string
		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@intvmoradb04:1521:ORAJAVADB", "TVM1718_TVM32_TJA171_DEV", "tcstvm32");
		PreparedStatement ps = connection.prepareStatement(QUERY,
				new String[] { "student_id" });

		// local variable to hold auto generated student id
		Long studentId = null;
		if (ps.executeUpdate() > 0) {

			// getGeneratedKeys() returns result set of keys that were auto
			// generated
			// in our case student_id column
			ResultSet generatedKeys;
			try {
				generatedKeys = ps.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {

					// voila! we got student id which was generated from sequence
					studentId = generatedKeys.getLong(1);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// if resultset has data, get the primary key value
			// of last inserted record
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	
}

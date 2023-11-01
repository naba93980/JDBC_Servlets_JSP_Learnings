import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionDAO {
	public static void main(String[] args) throws Exception {

		Connection con = null;
		Statement stm = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "12345678");
			stm = con.createStatement();
			
			// ----------------------TRANSACTION--------------------------
			con.setAutoCommit(false);
			stm.executeUpdate("update account set bal=bal-500 where accno=1");

			// --------------- manually throwing exception-----------------
			int i = 0;
			if (i < 10)
				throw new Exception("manually thrown");
			// ---------------------------------------------

			stm.executeUpdate("update account set bal=bal+500 where accno=2");
			con.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			con.rollback();
		} finally {
			con.setAutoCommit(true); // Restore auto-commit mode
			con.close();
		}
	}
}

// control transactions using:

// commit
// rollback
// savepoint


/*
* Rollback is important even if commit failed, according to the Java 1.6 JDBC docs:
* It is strongly recommended that an application explicitly commits or rolls back an active 
* transaction prior to calling the close method. If the close method is called and there is an active transaction, the results are implementation-defined.
* This means that if you do not explicitly invoke rollback, some JDBC implementation might invoke commit before closing the connection.
*/


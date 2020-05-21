package in.universityadmission.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import in.universityadmission.jdbc.Client;

public class testJDBCCases {

	@Test
	public void testInsert() throws SQLException {
		Client client = new Client();
		assertEquals("created", client.createTable());
	}
	
}

package cl.duoc.crudweb.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GenericDAO {

	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	protected void close(Object obj) {
		try {

			if (obj instanceof Connection) {

				((Connection) obj).close();

			} else if (obj instanceof PreparedStatement) {

				((PreparedStatement) obj).close();

			} else if (obj instanceof ResultSet) {

				((ResultSet) obj).close();

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

}

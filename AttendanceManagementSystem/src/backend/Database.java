package backend;

import java.sql.*;
import java.net.*;

public class Database {
	public static Database db;

	private Connection conn;
	private Statement stmt;
	private String sql;
	private ResultSet result;

	// Statement getters and setters
	public void setStatement(String sql) {
		this.sql = sql;
	}
	public String getStatement() {
		return this.sql;
	}

	// Connection getter
	public Connection getConnection() {
		return this.conn;
	}
	// ResultSet getter
	public ResultSet getResult() {
		return this.result;
	}

	// Constructor
	public Database(String url) {
		conn = null;
		try {
			System.out.println("Connecting to database...");
			Class.forName("org.postgresql.Driver");
			this.conn = getConnection(url);
			System.out.println("Postgresql database connected");

		} catch (Exception e) {
			System.out.println("Error while creating Database object");
			e.printStackTrace();
		}

		stmt = null;
		try {
			this.stmt = conn.createStatement();
			this.sql = "";
			System.out.println("Statement object created");
		} catch (Exception e) {
			System.out.println("Error while creating Statement object");
			e.printStackTrace();
		}
	}


	private static Connection getConnection(String url) throws URISyntaxException, SQLException {
	    URI dbUri = new URI(url);

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];

	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}

	public void createTable(String name, String[] rows) {
		// Does not return a ResultSet
		this.sql = "CREATE TABLE " + name + "(";
		this.sql += String.join(", ", rows);
		this.sql += ");";
		System.out.println(this.sql);
		try {
			stmt.executeUpdate(this.sql);
		} catch (Exception e) {
			System.out.println("Error while creating table " + name);
			e.printStackTrace();
		}
	};
	public void dropTable(String name) {
		// Does not return a ResultSet
		this.sql = "DROP TABLE " + name + ";";
		try {
			stmt.executeUpdate(this.sql);
		} catch (Exception e) {
			System.out.println("Error while dropping table " + name);
			e.printStackTrace();
		}
	}

	public void insertRow(String table, String schema, String values) {
		this.sql = "INSERT INTO " + table + " (" + schema + ") VALUES (" + values + ");";
		System.out.println(this.sql);

		try {
			System.out.println(stmt.executeUpdate(this.sql));
		} catch (Exception e) {
			System.out.println("Error while inserting row into table " + table);
			e.printStackTrace();
		}
	}

	public ResultSet getRows(String table) {
		ResultSet result = null;
		this.sql =
			"SELECT * FROM " + table +";";
		try {
			result = stmt.executeQuery(this.sql);
		} catch (Exception e) {
			System.out.println("Error while getting rows from " + table);
			e.printStackTrace();
		}

		this.result = result;
		return result;
	};
	public ResultSet getRows(String table, String conditions[]) {
		String arr[] = {};
		return this.getRows(table, conditions, arr, "NONE");
	}
	public ResultSet getRows(String table, String sort[], String sortDir) {
		String arr[] = {};
		return this.getRows(table, arr, sort, sortDir);
	}

	public ResultSet getRows(String table, String conditions[], String sort[], String sortDir) {
		ResultSet result = null;

		this.sql = "SELECT * FROM " + table;
		if (conditions.length > 0) {
			this.sql += " WHERE " + String.join(" AND ", conditions);
		}
		if (sort.length > 0) {
			this.sql += " ORDER BY " + String.join(", ", sort) + " " + sortDir;
		}
		this.sql += ";";

		System.out.println(this.sql);

		try {
			result = stmt.executeQuery(this.sql);
		} catch (Exception e) {
			System.out.println("Error while getting rows from " + table + " with " + conditions);
			e.printStackTrace();
		}

		this.result = result;
		return result;
	}

	public void updateRow(String table, String conditions[], String id) {
		this.sql = "UPDATE " + table + " SET ";
		this.sql +=  String.join(", ", conditions);
		this.sql += " WHERE " + id + " ;";

		System.out.println(this.sql);

		try {
			stmt.execute(this.sql);
		} catch (Exception e) {
			System.out.println("Error while updating rows from " + table + " with id" + id);
			e.printStackTrace();
		}
	}

	public void deleteRow(String table, String id) {
		this.sql = "DELETE FROM " + table;
		this.sql += " WHERE " + id + " ;";

		System.out.println(this.sql);

		try {
			stmt.execute(this.sql);
		} catch (Exception e) {
			System.out.println("Error while updating rows from " + table + " with id" + id);
			e.printStackTrace();
		}
	}
}

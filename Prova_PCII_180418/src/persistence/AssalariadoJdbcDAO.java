package persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Assalariado;

public class AssalariadoJdbcDAO {
	private Connection conn;
	
	public AssalariadoJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Assalariado a) throws SQLException{
		String sql = "insert into assalariado (salario) values ('" + a.getSalario() + "')";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Assalariado> listar(){
		String sql = "select * from assalariado";
		System.out.println(sql);
		List<Assalariado> assalariados = new ArrayList<Assalariado>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				float salario = rs.getFloat("salario");
				Assalariado assalariado = new Assalariado();
				assalariado.setSalario(salario);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assalariados;
	}
}

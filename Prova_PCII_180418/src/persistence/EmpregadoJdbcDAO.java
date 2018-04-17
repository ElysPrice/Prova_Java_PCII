package persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empregado;

public class EmpregadoJdbcDAO {
		private Connection conn;
		
		public EmpregadoJdbcDAO(Connection conn) {
			this.conn = conn;
		}
		
		public void salvar(Empregado m) throws SQLException{
			String sql = "insert into empregado (nome, sobrenome, cpf) values ('" + m.getNome() + "', '" + m.getSobrenome + "', '" + m.getCpf + "')";
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
		
		public List<Empregado> listar(){
			String sql = "select * from empregado";
			System.out.println(sql);
			List<Empregado> empregados = new ArrayList<Empregado>();
			
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					String nome = rs.getString("nome");
					String sobrenome = rs.getString("sobrenome");
					String cpf = rs.getString("cpf");
				    Empregado empregado = new Empregado();
					empregado.setNome(nome);
					empregado.setSobrenome(sobrenome);
					empregado.setCpf(cpf);
				}
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return empregados;
		}
	}

}

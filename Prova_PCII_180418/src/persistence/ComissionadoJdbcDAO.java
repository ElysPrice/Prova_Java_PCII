package persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Assalariado;
import model.Comissionado;

public class ComissionadoJdbcDAO {

private Connection conn;
	
	public ComissionadoJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Comissionado c) throws SQLException{
		String sql = "insert into comissionado (totalVenda, taxaComissao) values ('" + c.getTotalVenda() + "', '" + c.getTaxaComissao + "')";
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
	
	public List<Comissionado> listar(){
		String sql = "select * from comissionado";
		System.out.println(sql);
		List<Comissionado> comissionados = new ArrayList<Comissionado>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				float totalVenda = rs.getFloat("totalVenda");
				float taxaComissao = rs.getFloat("taxaComissao");
				Comissionado comissionado = new Comissionado();
				comissionado.setTotalVenda(totalVenda);
				comissionado.setTaxaComissao(taxaComissao);
				
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comissionados;
	}
}

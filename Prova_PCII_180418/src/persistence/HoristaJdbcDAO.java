package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Horista;

public class HoristaJdbcDAO {
	private Connection conn;
	
	public HoristaJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Horista h) throws SQLException{
		String sql = "insert into horista (precoHora, horasTrabalhadas) values ('" + h.getPrecoHora() + "', '" + h.getHorasTrabalhadas() +"')";
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
	
	public List<Horista> listar(){
		String sql = "select * from horista";
		System.out.println(sql);
		List<Horista> horistas = new ArrayList<Horista>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				float precoHora = rs.getFloat("precoHora");
				float horasTrabalhadas = rs.getFloat("horasTrabalhadas");
				Horista horista = new Horista();
				horista.setPrecoHora(precoHora);
				horista.setHorasTrabalhadas(horasTrabalhadas);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horistas;
	}
}

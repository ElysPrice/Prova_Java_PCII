package view;

import java.sql.Connection;

import model.Horista;
import persistence.HoristaJdbcDAO;
import persistence.JdbcUtil;

public class HoristaExec {
	public static void main (String args[]) {
		Horista horista = new Horista();
		
		try {
			horista.setPrecoHora(15);
			horista.setHorasTrabalhadas(600);
			
			Connection connection = JdbcUtil.getConnection();
			HoristaJdbcDAO horistaJdbcDao = new HoristaJdbcDAO(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

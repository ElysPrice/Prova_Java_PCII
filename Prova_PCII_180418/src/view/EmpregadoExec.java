package view;

import java.sql.Connection;

import model.Empregado;
import persistence.EmpregadoJdbcDAO;
import persistence.JdbcUtil;

public class EmpregadoExec {
	public static void main (String args[]) {
		Empregado empregado = new Empregado();
		
		try {
			empregado.setNome("Tatiane");
			empregado.setSobrenome("Gonsevski");
			empregado.setCpf("123.444.555/66");
			
			Connection connection = JdbcUtil.getConnection();
			EmpregadoJdbcDAO empregadoJdbcDao = new EmpregadoJdbcDAO(connection);
			
			empregadoJdbcDao.salvar(empregado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

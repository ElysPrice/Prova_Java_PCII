package view;

import java.sql.Connection;

import model.Assalariado;

import persistence.AssalariadoJdbcDAO;
import persistence.JdbcUtil;

public class AssalariadoExec {
	public static void main (String args[]) {
		Assalariado assalariado = new Assalariado();
		try {
			assalariado.setSalario(1500);

			
			Connection connection = JdbcUtil.getConnection();
			AssalariadoJdbcDAO assalariadoJdbcDao = new AssalariadoJdbcDAO(connection);
			
			assalariadoJdbcDao.salvar(assalariado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package view;

import java.sql.Connection;

import model.Comissionado;
import persistence.ComissionadoJdbcDAO;
import persistence.JdbcUtil;

public class ComissionadoExec {
	public static void main (String args[]) {
		Comissionado comissionado = new Comissionado();
		
		try {
			comissionado.setTotalVenda(5000);
			comissionado.setTaxaComissao(14);
			
			Connection connection = JdbcUtil.getConnection();
			ComissionadoJdbcDAO comissionadoJdbcDao = new ComissionadoJdbcDAO(connection);
			
			comissionadoJdbcDao.salvar(comissionado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

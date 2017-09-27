package br.com.sistemaaberturaprocessos.controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.sistemaaberturaprocessos.jdbc.ConnectionFactory;
import br.com.sistemaaberturaprocessos.model.Processo;

public class ProcessoBDD {
	// a conexÃ£o com o banco de dados
	private Connection connection;
	
	public ProcessoBDD() {
		this.setConnection(new ConnectionFactory().getConnection());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Processo processo) {
	    String sql = "insert into requerimento " +
	            "(ID_OPCAO,EXTRA,ARQUIVO,Id,ESCLARECIMENTOS,Cpf,dataAtual)" +
	            " values (?,?,?,?,?,?,?)";

	    try {
	        // prepared statement para inserção
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        // seta os valores

	        stmt.setInt(1,processo.getId_opcao());
	        stmt.setString(2,processo.getExtra());
	        stmt.setString(3,processo.getArquivo());
	        stmt.setLong(4,processo.getId());
	        stmt.setString(5,processo.getEsclarecimentos());
	        stmt.setLong(6,processo.getCpf());
	        stmt.setDate(7, (java.sql.Date) new Date(
	        		processo.getDataAtual().getTimeInMillis()));

	        // executa
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<Processo> getLista() {
	     try {
	         List<Processo> processos = new ArrayList<Processo>();
	         PreparedStatement stmt = this.connection.
	                 prepareStatement("select * from requerimento");
	         ResultSet rs = stmt.executeQuery();
	 
	         
	         while (rs.next()) {
	             // criando o objeto Contato
	        	 Processo processo = new Processo();
	        	 processo.setId_opcao(rs.getInt("id_opcao"));
	        	 processo.setExtra(rs.getString("extra"));
	        	 processo.setArquivo(rs.getString("arquivo"));
	        	 processo.setId(rs.getLong("id"));
	        	 processo.setEsclarecimentos(rs.getString("esclarecimentos"));
	        	 processo.setCpf(rs.getLong("cpf"));
	 
	             // montando a data através do Calendar
	             Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataAtual"));
	             processo.setDataAtual(data);
	 
	             // adicionando o objeto à lista
	             processos.add(processo);
	         }
	         rs.close();
	         stmt.close();
	         return processos;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
}
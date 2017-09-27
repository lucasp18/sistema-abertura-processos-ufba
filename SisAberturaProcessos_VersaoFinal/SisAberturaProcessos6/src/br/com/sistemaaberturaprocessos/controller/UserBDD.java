package br.com.sistemaaberturaprocessos.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaaberturaprocessos.jdbc.ConnectionFactory;
import br.com.sistemaaberturaprocessos.model.User;

public class UserBDD {
	// a conexÃ£o com o banco de dados
	private Connection connection;
	
	public UserBDD() {
		this.setConnection(new ConnectionFactory().getConnection());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(User usuario) {
	    String sql = "insert into pessoa " +
	            "(Cpf, Matricula, Nome, Email, Endereco, Bairro, Telefone, CEP, Curso, Senha)" +
	            " values (?,?,?,?,?,?,?,?,?,?)";

	    try {
	        // prepared statement para inserção
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        // seta os valores

	        stmt.setLong(1,usuario.getCpf());
	        stmt.setLong(2,usuario.getMatricula());
	        stmt.setString(3,usuario.getNome());
	        stmt.setString(4,usuario.getEmail());
	        stmt.setString(5,usuario.getEndereco());
	        stmt.setString(6,usuario.getBairro());
	        stmt.setLong(7,usuario.getTelefone());
	        stmt.setLong(8,usuario.getCEP());
	        stmt.setString(9,usuario.getCurso());
	        stmt.setString(10,usuario.getPassword());

	        // executa
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<User> getLista() {
	     try {
	         List<User> usuarios = new ArrayList<User>();
	         PreparedStatement stmt = this.connection.
	                 prepareStatement("select * from pessoa");
	         ResultSet rs = stmt.executeQuery();
	 
	         
	         while (rs.next()) {
	             // criando o objeto Contato
	             User usuario = new User();
	             usuario.setCpf(rs.getLong("Cpf"));
	             usuario.setMatricula(rs.getLong("Matricula"));
	             usuario.setNome(rs.getString("Nome"));
	             usuario.setEmail(rs.getString("Email"));
	             usuario.setEndereco(rs.getString("Endereco"));
	             usuario.setBairro(rs.getString("Bairro"));
	             usuario.setTelefone(rs.getLong("Telefone"));
	             usuario.setCEP(rs.getLong("CEP"));
	             usuario.setCurso(rs.getString("Curso"));
	             usuario.setPassword(rs.getString("Senha"));

	             // adicionando o objeto à lista
	             usuarios.add(usuario);
	         }
	         rs.close();
	         stmt.close();
	         return usuarios;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
}
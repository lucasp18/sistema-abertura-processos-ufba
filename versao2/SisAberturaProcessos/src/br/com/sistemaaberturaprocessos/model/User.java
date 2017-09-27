package br.com.sistemaaberturaprocessos.model;

public class User {
	
	private String cpf;
	private String password;
	private boolean valido;
	
	public User(String cpf,String password){
		this.cpf=cpf;
		this.password=password;
		this.valido=false;
	}
	
	public boolean getValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

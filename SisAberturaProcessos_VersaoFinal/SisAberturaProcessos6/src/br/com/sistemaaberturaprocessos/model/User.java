package br.com.sistemaaberturaprocessos.model;

public class User {
	
	
	private long cpf;
	private long matricula;
	private String nome;
	private String email;
	private String endereco;
	private String bairro;
	private long telefone;
	private long CEP;
	private String curso;
	private String password;
	private boolean valido;
	
	public User(long cpf, long matricula, String nome, String email, String endereco, String bairro, long telefone, long CEP, String curso, String password){
		this(cpf,password);
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.bairro = bairro;
		this.telefone = telefone;
		this.CEP = CEP;
		this.curso = curso;

	}
	
	
	public User(long cpf,String password){
		this.cpf=cpf;
		this.password=password;
		this.valido=false;
	}
	
	public User(){
		this.valido=false;
	}
	
	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public long getCEP() {
		return CEP;
	}

	public void setCEP(long cEP) {
		CEP = cEP;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}
	

}

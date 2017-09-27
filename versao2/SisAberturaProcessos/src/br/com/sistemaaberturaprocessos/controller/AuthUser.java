package br.com.sistemaaberturaprocessos.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaaberturaprocessos.model.User;

public class AuthUser extends HttpServlet {
	
	
	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws  IOException{
		doPost(request,response);
	}*/
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String cpf,senha;
		cpf=request.getParameter("cpf");
		senha=request.getParameter("senha");
		User user = new User(cpf,senha);
		//System.out.println(user.getValido());
		validarUser(user);
		//System.out.println(user.getValido());
		if(user.getValido() == false){
			response.sendRedirect("../view/index.html");
		}else{
			System.out.println("teste");
			response.sendRedirect("../view/processos_aluno.html");
		}
	} 		

	private static void validarUser(User user){
		//System.out.println("passou na validar user");
		String[] numerosMatriculas = {"12345"}; // numero de matricula futuramente sera em um banco
		String[] senhas = {"12345"}; //  futuramente sera em um banco
		for (int i = 0; i < numerosMatriculas.length; i++) {
			if(user.getCpf().equals(numerosMatriculas[i]) && user.getPassword().equals(senhas[i]))
				user.setValido(true);
		}
		//return user;
	}
}

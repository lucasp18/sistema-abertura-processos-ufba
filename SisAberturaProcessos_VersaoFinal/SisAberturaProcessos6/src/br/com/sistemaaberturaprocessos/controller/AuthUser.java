package br.com.sistemaaberturaprocessos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistemaaberturaprocessos.model.ListaDeProcessos;
import br.com.sistemaaberturaprocessos.model.Processo;
import br.com.sistemaaberturaprocessos.model.User;

@WebServlet("/view/processos_aluno")
public class AuthUser extends HttpServlet {
	
	
	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws  IOException{
		doPost(request,response);
	}*/
	
	//@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long cpf = 11213231 ;
		String CPF = null;
		String senha = null;
		System.out.println("inicio da servlet");
		try {
			CPF= (String)request.getParameter("cpf");
			System.out.println("cpf"+CPF);
			senha= (String)request.getParameter("senha");
			if(CPF.trim().isEmpty() || senha.trim().isEmpty())
				 cpf = 00000;
			else	
				cpf = Long.parseLong(CPF);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		//cpf = Long.parseLong(CPF);
		User user = new User(cpf,senha);
		//System.out.println(user.getValido());
		validarUser(user);
		List<Processo> processosUser = obterProcessoCpf(cpf);
		//System.out.println(user.getValido());
		//HttpSession session =  new Http
		 
		System.out.println("processosUser.isEmpty()" + processosUser.isEmpty());
		System.out.println("testando");
		 //user = null;
		
			System.out.println("nao esta vazio");
			//cpf = Long.parseLong(CPF);
			user = new User(cpf,senha);
		
		//System.out.println(user.getValido());
		validarUser(user);
		//List<Processo> processosUser = obterProcessoCpf(cpf);
		
		if((user == null)||(user.isValido() == false) || CPF.isEmpty() || senha.isEmpty() ){
			response.sendRedirect("../view/index.html");
			System.out.println("fail");
		}else{
			
			//System.out.println(user.getValido());
			//HttpSession session =  new Http
			
			System.out.println("teste");
			HttpSession session = request.getSession(); 
			session.setAttribute("User", user);
			
			ListaDeProcessos listaDeProcessos = new ListaDeProcessos();
			
			if(processosUser.isEmpty()){
				Processo processo = new Processo(0," "," "," ",0, null);  // processo falso pra view não dá erro.
				listaDeProcessos.setListagemFalsa("");
				processosUser.add(processo);
				listaDeProcessos.setListaDeProcessosUser(processosUser);
			}else{
				listaDeProcessos.setListagemFalsa("t");
				listaDeProcessos.setListaDeProcessosUser(processosUser);
			}
			//RequestDispatcher rd;
			/*
			if(processosUser.isEmpty()){
				//Processo processo = new Processo(0," "," "," ",0, null);  // processo falso pra view não dá erro.
				//processosUser.add(processo);
				//listaDeProcessos.setListaDeProcessosUser(processosUser);
				response.sendRedirect("../view/processos_aluno2.jsp"); 
			}else{
				listaDeProcessos.setListaDeProcessosUser(processosUser);
				request.setAttribute("listaDeProcessos", listaDeProcessos);
				rd = getServletContext().getRequestDispatcher("/view/processos_aluno.jsp"); 
				rd.forward(request, response); 
			} */
			
			//session.setAttribute("processosUser", processosUser);
			System.out.println("processosUser.get(0).getId() :" + processosUser.get(0).getId());
			
			
			//request.setAttribute("processosUser", processosUser);
			RequestDispatcher rd;
			
			request.setAttribute("listaDeProcessos", listaDeProcessos);
			rd = getServletContext().getRequestDispatcher("/view/processos_aluno.jsp"); 
			rd.forward(request, response); 
		}
	} 		

	private static long validarUser(User user){
		UserBDD banco = new UserBDD();
		
		List<User> usuarios = banco.getLista();

		for (User usuario : usuarios ) {

			if(user.getCpf() == usuario.getCpf() && user.getPassword().equals(usuario.getPassword()))
				user.setValido(true);
		}
		return user.getCpf();
	}
	
	private static List<Processo> obterProcessoCpf(long cpfUser) {
		ProcessoBDD processbdd = new ProcessoBDD();
		List<Processo> todosProcessos = processbdd.getLista();
		List<Processo> processoUser = new ArrayList<Processo>();
		for (Processo  processo : todosProcessos) {

			if(cpfUser == processo.getCpf()){
				System.out.println("cpfUser: "+ cpfUser);
				processoUser.add(processo);
			}
		}
		
			return processoUser;
	}
}

package br.com.sistemaaberturaprocessos.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/view/processos_aluno.html") 
public class MeuFiltro implements Filter { 
	  public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException, ServletException { 
	     System.out.println("caiu aqui");
	     if(request.getParameter("cpf")!=null && request.getParameter("senha")!= null && request.getParameter("cpf").equals("12345") && request.getParameter("senha").equals("12345")){
	    	 chain.doFilter(request, response);
	     }else{
	    	 //Locale  locale = new Locale();
	    	 //response.setLocale("http://localhost:8080/SisAberturaProcessos/view/index.html");
	    	System.out.println(request.getAttribute(""));
	    	request.getRequestDispatcher("/view/index.html").forward(request,response);
	    	//request.getRequestDispatcher("/view/index.html").;
	     }
	  }

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}

@Override
public void init(FilterConfig arg0) throws ServletException {
	// TODO Auto-generated method stub
	
} 
}
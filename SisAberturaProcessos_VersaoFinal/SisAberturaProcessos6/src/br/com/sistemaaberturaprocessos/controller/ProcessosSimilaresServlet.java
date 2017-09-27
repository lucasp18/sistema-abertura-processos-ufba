package br.com.sistemaaberturaprocessos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistemaaberturaprocessos.model.Processo;
import br.com.sistemaaberturaprocessos.model.User;

@WebServlet("/view/processosSimilares")
public class ProcessosSimilaresServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int opcao,cont=0;
		opcao =Integer.valueOf((String)request.getParameter("tipoprocesso"));
		HttpSession sessao = request.getSession();
		User user = (User)sessao.getAttribute("User");
		if(user == null){
			 response.getWriter().write("Realizar login novamente");
			 return;
		}
		List<Processo> listProcessos = new ArrayList<Processo>();
		listProcessos = obterProcessoCpfOpcao(user.getCpf(),opcao);
		if(listProcessos == null){
			response.getWriter().write("Nenhum processo cadastrado para essa op&ccedil;&atildeo");	
		}else{
			response.getWriter().write("<table class='table table-striped' id='table1'>");	
			response.getWriter().write("<thead>");
			response.getWriter().write("<tr>");
			response.getWriter().write("<th>C&oacute;digo</th>");
			response.getWriter().write("<th>Data de abertura</th>");
			response.getWriter().write("<th>Resultado</th>");
			response.getWriter().write("<th>Esclarimento</th>");
			response.getWriter().write("<th>Usar Processo</th>");
			response.getWriter().write("</tr>");
			response.getWriter().write("</thead>");
			response.getWriter().write("<tbody>");
			//System.out.println("listaProcessos:"+ listProcessos);
			for (Processo processo : listProcessos) {
				cont++;
				response.getWriter().write("<tr id="+cont +">");
				response.getWriter().write("<td>"+processo.getId()+"</td>");
				response.getWriter().write("<td>"+processo.getDataAtual().getTime()+"</td>");
				response.getWriter().write("<td>Em andamento</td>");
				response.getWriter().write("<td>"+processo.getEsclarecimentos()+"</td>");
				
				response.getWriter().write("<td><a href='javascript:usarProcesso("+cont+");'> usar esse processo para criar outro</a></td>");
				response.getWriter().write("</tr>"); 
			}
			response.getWriter().write("</tbody></table>");
			
			/*
			String javascript =" <script type='text/javascript'> "
					+ "function usarProcesso(i){"
					+ "						table = document.getElementById('table1'); "
					+ "						alert(table);   "
					+ "}      "
					+ "</script>";
			response.getWriter().write("<script type='text/javascript'>");
			response.getWriter().write("function usarProcesso(i){");
			response.getWriter().write("table = document.getElementById('table1');");
			response.getWriter().write("alert(table); ");
			response.getWriter().write("} </script> ");
			
			response.getWriter().write(javascript); */
		}
			
	}

	
	private static List<Processo> obterProcessoCpfOpcao(long cpfUser,int opcao) {
		ProcessoBDD processbdd = new ProcessoBDD();
		List<Processo> todosProcessos = processbdd.getLista();
		List<Processo> processoUser = new ArrayList<Processo>();
		for (Processo  processo : todosProcessos) {

			if(cpfUser == processo.getCpf() && processo.getId_opcao() == opcao){
				//System.out.println("cpfUser: "+ cpfUser);
				processoUser.add(processo);
			}
		}
		
		if(processoUser.isEmpty())	
			return null;
		return processoUser;
	}
	
}

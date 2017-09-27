package br.com.sistemaaberturaprocessos.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.sistemaaberturaprocessos.model.Processo;
import br.com.sistemaaberturaprocessos.model.User;
import br.com.sistemaaberturaprocessos.pdf.GeraPDF;

@WebServlet("/view/adicionar_processo")
public class AdicionaProcesso extends HttpServlet {
	private String local_arquivo = "C:\\Users\\lukas_000\\Documents\\Workspace\\projeto-master\\SisAberturaProcessos4\\WebContent\\arquivos_anexos\\";
	//private String local_arquivo = "C:\\Users\\LUCAS\\workspace4\\SisAberturaProcessos5\\WebContent\\arquivos_anexos";
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String esclarecimento = (String) request.getParameter("esclarecimento");
		System.out.println("esclarecimento0: " + esclarecimento);
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");

		GregorianCalendar calendar = new GregorianCalendar();

		int mes = calendar.get(Calendar.DAY_OF_MONTH);
		int hora = calendar.get(Calendar.HOUR_OF_DAY);
		int minutos = calendar.get(Calendar.MINUTE);
		int milisegundos = calendar.get(Calendar.MILLISECOND);
		String nomefile = String.valueOf(mes) + String.valueOf(hora)
				+ String.valueOf(minutos) + String.valueOf(user.getCpf());

		String nome_arquivo = dadosFormulario(request, response, nomefile,
				user, calendar);
		/*
		 * //doPost(request,response); String esclarecimento =
		 * (String)request.getParameter("esclarecimento"); //String
		 * esclarecimento2 = (String)request.getAttribute("esclarecimento");
		 * System.out.println("esclarecimento: "+ esclarecimento);
		 * //System.out.println("esclarecimento2: "+ esclarecimento2); String
		 * file = (String)request.getParameter("arquivo"); String opcao =
		 * (String)request.getParameter("optionsRadios");
		 * System.out.println("opcao "+ opcao); System.out.println("file "+
		 * file); String extra; if(opcao != null && (opcao.equals(4) ||
		 * opcao.equals(29))) extra =
		 * (String)request.getParameter("tipo_homologacao"); else extra = null;
		 * 
		 * GregorianCalendar calendar = new GregorianCalendar(); //Calendar
		 * calendar = new Calendar(); int mes =
		 * calendar.get(Calendar.DAY_OF_MONTH); int hora =
		 * calendar.get(Calendar.HOUR_OF_DAY); int minutos =
		 * calendar.get(Calendar.MINUTE); int milisegundos =
		 * calendar.get(Calendar.MILLISECOND);
		 * 
		 * //System.out.println("file "+ file);
		 * //System.out.println("hora_Atual " + hora);
		 * //System.out.println("opcao " + opcao); HttpSession session =
		 * request.getSession(); User user = (User)session.getAttribute("User");
		 * String nomefile =
		 * String.valueOf(mes)+String.valueOf(hora)+String.valueOf
		 * (minutos)+String.valueOf(user.getCpf()); Long cpf = user.getCpf();
		 * System.out.println("cpf "+ cpf);
		 * 
		 * //String nome_arquivo = arquivo(request,response,nomefile); //opcao =
		 * 2; Processo processo = new
		 * Processo(Integer.valueOf(opcao),extra,nomefile
		 * ,esclarecimento,user.getCpf(),calendar); ProcessoBDD processbdd = new
		 * ProcessoBDD(); processbdd.adiciona(processo);
		 * //arquivo(request,response);
		 * //response.sendRedirect("../view/adicionar_processo.jsp");
		 */
		response.sendRedirect("../view/adicionar_processo.jsp");
	}

	public void colocarBDD(int opcao, String extra, String esclarecimento,
			User user, Calendar calendar, String nomefile) {
		Processo processo = new Processo(opcao, extra, nomefile,
				esclarecimento, user.getCpf(), calendar);
		ProcessoBDD processbdd = new ProcessoBDD();
		processbdd.adiciona(processo);
	}

	public String dadosFormulario(HttpServletRequest req,
			HttpServletResponse resp, String nomefile, User user,
			Calendar calendar) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		String esclarecimento = null;
		String extra = null;
		String nome_arquivo = "";
		int opcao = 0;
		boolean colocarBanco = false;
		if (isMultipart) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = (List<FileItem>) upload
						.parseRequest(req);
				for (FileItem item : items) {
					if (item.isFormField()) {
						colocarBanco = true;
						// se for um campo normal de form
						System.out.println("Form field");
						System.out.println("Name:" + item.getFieldName());
						System.out.println("Value:" + item.getString());
						if (item.getFieldName().equals("optionsRadios")) {
							opcao = Integer.valueOf(item.getString());
						}
						System.out.println("item.getFieldName() :"+ item.getFieldName());
						if (item.getFieldName().equals("tipo_homologacao") || item.getFieldName().equals("tipo_certidao")) {
							System.out.println("eh certidao");
							if (item.getString() != null && !item.getString().isEmpty() && extra == null){
								System.out.println("extra recebeu valor");
								extra = item.getString();
								System.out.println("extra: "+ extra);
							}
							
						}// else
							// extra = null;

						System.out.println("aqui111");
						if (item.getFieldName().equals("esclarecimento")) {
							if (item.getString() != null)
								esclarecimento = item.getString();
							else
								esclarecimento = null;
						}

						System.out.println("aqui2222");
						// caso seja um campo do tipo file
					} else {
						// System.out.println("NOT Form field");
						//System.out.println("Name:"+item.getFieldName());
						//System.out.println("FileName:"+item.getName());
						//System.out.println("Size:"+item.getSize());
						//System.out.println("ContentType:"+item.getContentType());
						//System.out.println("tem arquivo");
						if(item.getSize()!= 0){
						nome_arquivo = this.local_arquivo + nomefile + "_"
								+ item.getName();
						File uploadedFile = new File(nome_arquivo);
						item.write(uploadedFile);
						}else
							nomefile=null;
					}
					System.out.println("aquii 3333");
				}
				
				System.out.println("aquiii 444");
				System.out.println("colocarBanco: " + colocarBanco);
				System.out.println("extra:" + extra);
				if (colocarBanco) {
					colocarBDD(opcao, extra, esclarecimento, user, calendar,nomefile);
					System.out.println("Dados USUARIO");
					UserBDD userBanco = new UserBDD();
					List<User> usuarios = userBanco.getLista();	
					User user1 = new User();
					for (User usuario : usuarios ) {
						if(usuario.getCpf() == user.getCpf() ){
						user1.setNome(usuario.getNome());
						user1.setBairro(usuario.getBairro());
						user1.setCEP(usuario.getCEP());
						user1.setCurso(usuario.getCurso());
						user1.setEmail(usuario.getEmail());
						user1.setMatricula(usuario.getMatricula());
						user1.setTelefone(usuario.getTelefone());
							
						}						
					}
							
							
					System.out.println(user1.getNome() + "\n" + user1.getBairro() + "\n" + user1.getCpf() + "\n");
					GeraPDF.gerar(opcao, user1.getNome(), user1.getBairro(), user1.getCEP(), user1.getCurso(), user.getCpf(), user1.getEmail(), user1.getMatricula(), 318271294, user1.getTelefone(), esclarecimento);	
				}
					

			} catch (Exception e) {
				System.out.println(
						"ocorreu um problema ao fazer o upload: "
								+ e.getMessage());
			}

			
			
		}
		return nome_arquivo;
	}

}

/*
 * public class AdicionaContatoServlet extends HttpServlet { protected void
 * service(HttpServletRequest request, HttpServletResponse response) throws
 * IOException, ServletException {
 * 
 * PrintWriter out = response.getWriter();
 * 
 * // pegando os parâmetros do request
 * 
 * String dataEmTexto = request.getParameter("dataNascimento"); Calendar
 * dataNascimento = null;
 * 
 * // fazendo a conversão da data try { Date date = new
 * SimpleDateFormat("dd/MM/yyyy") .parse(dataEmTexto); dataNascimento =
 * Calendar.getInstance(); dataNascimento.setTime(date); } catch (ParseException
 * e) { out.println("Erro de conversão da data"); return; //para a execução do
 * método }
 * 
 * // monta um objeto Processo private int id_opcao; private String extra;
 * private String arquivo; private long id; private String esclarecimentos;
 * private long cpf; private Calendar dataAtual; Processo processo = new
 * Processo(); processo.setId_opcao(id_opcao); processo.setExtra(extra);
 * processo.setArquivo(arquivo); processo.setId(id);
 * processo.setEsclarecimentos(esclarecimentos); processo.setCpf(cpf);
 * 
 * // salva o contato ProcessoBDD banco = new ProcessoBDD();
 * banco.adiciona(processo);
 * 
 * } }
 * 
 * /* ContatoDao dao = new ContatoDao();
 * 
 * List<Contato> contatos = dao.getLista();
 * 
 * for (Contato contato : contatos ) {
 * 
 * 
 * <td><%=contato.getNome() %></td> <td><%=contato.getEmail() %></td>
 * <td><%=contato.getEndereco() %></td>
 * <td><%=contato.getDataNascimento().getTime() %></td> }
 */
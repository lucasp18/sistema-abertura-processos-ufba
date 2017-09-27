package br.com.sistemaaberturaprocessos.pdf;

import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
  

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.ServletOutputStream;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import br.com.sistemaaberturaprocessos.controller.UserBDD;
import br.com.sistemaaberturaprocessos.model.User;

@WebServlet("/view/Exibir")
public class ExibirPDF extends HttpServlet {  
  
    byte[] arquivo = null;  
    long matricula;
    File file;
    protected void service(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
    	HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		UserBDD userBanco = new UserBDD();
		List<User> usuarios = userBanco.getLista();	
		User user1 = new User();
		for (User usuario : usuarios ) {
			if(usuario.getCpf() == user.getCpf() ) 
				matricula = usuario.getMatricula();
		}
		file = new File("C:\\Users\\lukas_000\\Documents\\Workspace\\projeto-master\\SisAberturaProcessos4\\processos\\"+ matricula + ".pdf");  
	       
        try {  
            arquivo = fileToByte(file);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        response.setContentType("application/pdf");  
        response.setContentLength(arquivo.length);  
        ServletOutputStream ouputStream = response.getOutputStream();  
        ouputStream.write(arquivo, 0, arquivo.length);  
        ouputStream.flush();  
        ouputStream.close();  
    }  
    

    public static InputStream byteToInputStream(byte[] bytes) throws Exception {  
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);  
        return bais;  
    }  
  
    public static byte[] fileToByte(File imagem) throws Exception {  
        FileInputStream fis = new FileInputStream(imagem);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        byte[] buffer = new byte[8192];  
        int bytesRead = 0;  
        while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {  
            baos.write(buffer, 0, bytesRead);  
        }  
        return baos.toByteArray();  
    }  
}  


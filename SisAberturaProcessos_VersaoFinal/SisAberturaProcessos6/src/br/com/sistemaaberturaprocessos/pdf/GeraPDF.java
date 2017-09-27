package br.com.sistemaaberturaprocessos.pdf;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeraPDF{
	
	public GeraPDF()
	{
		
	}
 

	public static void gerar(int id, String nome, String bairro, long cep, String curso, long cpf, String email, long matricula, long numeroprocesso, long telefone, String esclarecimento) {
	
		System.out.println("Gerando relatório...");
		List<ProcessosPdf> lista = new ArrayList<ProcessosPdf>();
		ProcessosPdf processos = new ProcessosPdf(" "," ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "," ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
		//ProcessosPdf processos = new ProcessosPdf();
		
		String CEP = String.valueOf(cep);
		String CPF = String.valueOf(cpf);
		String MAT = String.valueOf(matricula);
		String NUM = String.valueOf(numeroprocesso);
		String TEL = String.valueOf(telefone);
		
		processos.setNome(nome);
		processos.setBairro(bairro);
		processos.setCep(CEP);
		processos.setCurso(curso);
		processos.setDocumentoID(CPF);
		processos.setEmail(email);
		processos.setMatricula(MAT);
		processos.setNumeroProcesso(NUM);
		processos.setTipoDoc("CPF");
		processos.setTelefone(TEL);
		processos.setEsclarecimentos(esclarecimento);
		System.out.println(CEP + "\n" + CPF + "\n" + MAT + "\n" +NUM + "\n" + TEL  + "\n" + nome + "\n" +bairro + "\n" +curso + "\n" +email);
		switch(id){
			case 1:
				processos.setObjetoRequerimento("Aproveitamento de Cursos e Programas Institucionais");
				processos.setUm("X");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			
			case 2:
				processos.setObjetoRequerimento("Aproveitamento de Estudos");
				processos.setUm(" ");
				processos.setDois("X");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco("");
				break;
			case 3:
				processos.setObjetoRequerimento("Avaliação Curricular");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres("X");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 5:
				processos.setObjetoRequerimento("Certidão de Estudos de Aluno Especial");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco("X");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 6:
				processos.setObjetoRequerimento("Certificado de Aluno Especial da Pós-Graduação");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis("X");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 7:
				processos.setObjetoRequerimento("Certificado de Especialização");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete("X");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 8:
				processos.setObjetoRequerimento("Desistência definitiva de Curso");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito("X");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 10:
				processos.setObjetoRequerimento("Dispensa de Pré-requisito");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez("X");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 11:
				processos.setObjetoRequerimento("Dispensa de Tirocínio Docente");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze("X");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 12:
				processos.setObjetoRequerimento("Homologação e autorização emissão de diploma");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze("X");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 14:
				processos.setObjetoRequerimento("Matrícula Aluno Especial");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze("X");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 15:
				processos.setObjetoRequerimento("Matrícula Aluno Intercâmbio (Acordo Cultural)");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze("X");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 18:
				processos.setObjetoRequerimento("Permanência no Curso");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito("X");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 19:
				processos.setObjetoRequerimento("Reconsideração de despacho/Recurso");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove("X");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 20:
				processos.setObjetoRequerimento("Retificação de Histórico");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte("X");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 21:
				processos.setObjetoRequerimento("Revalidação de Diploma ou Certificado");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm("X");
				processos.setVinteTres(" ");
				processos.setVinteCinco(" ");
				break;
			case 23:
				processos.setObjetoRequerimento("Transferência Interna de Caráter Especial");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres("X");
				processos.setVinteCinco(" ");
				break;
			case 25:
				processos.setObjetoRequerimento("Trancamento de disciplinas");
				processos.setUm(" ");
				processos.setDois(" ");
				processos.setTres(" ");
				processos.setCinco(" ");
				processos.setSeis(" ");
				processos.setSete(" ");
				processos.setOito(" ");
				processos.setDez(" ");
				processos.setOnze(" ");
				processos.setDoze(" ");
				processos.setQuatorze(" ");
				processos.setQuinze(" ");
				processos.setDezoito(" ");
				processos.setDezenove(" ");
				processos.setVinte(" ");
				processos.setVinteUm(" ");
				processos.setVinteTres(" ");
				processos.setVinteCinco("X");
				break;
		
		}
		
		
		lista.add(processos);
	
		JasperReport requerimento = null;
		try {
			requerimento = JasperCompileManager.compileReport("C:\\Users\\lukas_000\\Documents\\Workspace\\projeto-master\\SisAberturaProcessos4\\processos\\requerimento.jrxml");
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		JasperPrint PDF = null;
		try {
			PDF = JasperFillManager.fillReport(requerimento, null, new JRBeanCollectionDataSource(lista));
		} catch (JRException e) {
			e.printStackTrace();
		}
	
		try {
			JasperExportManager.exportReportToPdfFile(PDF, "C:\\Users\\lukas_000\\Documents\\Workspace\\projeto-master\\SisAberturaProcessos4\\processos\\"+processos.getMatricula()+".pdf");
		} catch (JRException e) {
			e.printStackTrace();
		}

		System.out.println("Relatório gerado.");
		}
}



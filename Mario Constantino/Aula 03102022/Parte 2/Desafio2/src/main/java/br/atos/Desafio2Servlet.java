package br.atos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Desafio2Servlet
 */
@WebServlet("/Desafio2Servlet")
public class Desafio2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Desafio2Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter(); //cria objeto que utiliza response para enviar varias strings
		saida.println("<!DOCTYPE html>");
		saida.println("<html>");
		saida.println("<head>");
		saida.println("<meta charset=\"ISO-8859-1\">");
		saida.println("<title>Dados do Aluno</title>");
		saida.println("</head>");
		saida.println("<body>");
		saida.println("<h2>Dados do aluno</h2>");
		saida.println("<h1>Nome:</h1>");
		saida.println("<p>Mario Constantino Junior</p>");
		saida.println("<h1>Email:</h1>");
		saida.println("<p>mconstantinojr@gmail.com</p>");
		saida.println("<h1>Idade:</h1>");
		saida.println("<p>46</p>");
		saida.println("<h2>Como se enxerga daqui 5 anos dentro do universo java</h2>");
		saida.println("<p>Hoje sou analista senior e daqui 5 anos me enxergo como arquiteto ou lider tecnico</p>");
		saida.println("</body>");
		saida.println("</html>");
	}

}

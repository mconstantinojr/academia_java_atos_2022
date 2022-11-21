package atos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atos.dao.UsuarioDao;
import atos.model.Usuario;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao usuarioDao = new UsuarioDao();
    	
		String nome = request.getParameter("name");
    	String email = request.getParameter("email");
    	String pass = request.getParameter("pass");
    	String re_pass = request.getParameter("pass");
    	String contato = request.getParameter("contact");
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome(nome);
    	usuario.setEmail(email);
    	usuario.setSenha(pass);
    	usuario.setTelefone(contato);
    	
    	RequestDispatcher dispatcher = null;
    	
    	PrintWriter saida = response.getWriter();
    	
    	dispatcher = request.getRequestDispatcher("registration.jsp");
    	
    	/*if (!pass.isEmpty() && !re_pass.isEmpty() && pass.equals(re_pass)) {
    		if (usuarioDao.validaSeUsuarioExiste(usuario)) {
    			response.sendRedirect("usuarioExiste.jsp");
    		} else {
    			if (usuarioDao.salvaUsuarioNoBanco(usuario)) {
    				response.sendRedirect("cadastroSucesso.jsp");	
    			} else {
    				response.sendRedirect("cadastroErro.jsp");
    			}
    		}
    	} else {
    		response.sendRedirect("senhaNaoConfere.jsp");
    	}*/
    	
    	if (usuarioDao.salvaUsuarioNoBanco(usuario)) {
    		request.setAttribute("statusDispacher", "sucesso");
    	} else {
    		request.setAttribute("statusDispacher", "falha");
    	}
    	
    	dispatcher.forward(request, response);
	}

}

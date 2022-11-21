package br.atos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.atos.dataBase.LoginDao;
import br.atos.model.LoginEntidade;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/cadastro")
public class cadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LoginDao loginDao = new LoginDao();
    	
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String confirmepassword = request.getParameter("confirmepassword");
    	
    	LoginEntidade loginEntidade = new LoginEntidade();
    	loginEntidade.setUsername(username);
    	loginEntidade.setPassword(password);
    	
    	if (!password.isEmpty() && !confirmepassword.isEmpty() && password.equals(confirmepassword)) {
    		if (loginDao.validaSeUsuarioExiste(loginEntidade)) {
    			response.sendRedirect("usuarioExiste.jsp");
    		} else {
    			if (loginDao.salvaUsuarioNoBanco(loginEntidade)) {
    				response.sendRedirect("cadastroSucesso.jsp");	
    			} else {
    				response.sendRedirect("cadastroErro.jsp");
    			}
    		}
    	} else {
    		response.sendRedirect("senhaNaoConfere.jsp");
    	}
    	
  
    	
    }

}

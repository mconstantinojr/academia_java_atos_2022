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
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LoginDao loginDao = new LoginDao();
    	
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	LoginEntidade loginEntidade = new LoginEntidade();
    	loginEntidade.setUsername(username);
    	loginEntidade.setPassword(password);
    	
    	if (loginDao.validaLogin(loginEntidade)) {
    			response.sendRedirect("loginSucesso.jsp");
    	} else {
    		response.sendRedirect("loginInvalido.jsp");
    	}
    	
    	
    }

}

package atos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atos.dao.UsuarioDao;
import atos.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario usuario = new Usuario();
			
			usuario.setNome(request.getParameter("username"));
			usuario.setSenha(request.getParameter("password"));
			HttpSession session = request.getSession();
			RequestDispatcher dispatcher = null;
			
			if (usuarioDao.validaLogin(usuario)) {
				session.setAttribute("nome", usuario.getNome());
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				request.setAttribute("statusDispacher", "falha");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
			
	}

}

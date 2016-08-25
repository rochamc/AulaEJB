package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.LivrosBeanRemote;
import br.com.fiap.entity.Livros;

@WebServlet("/livros")
public class ServletLivros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLivros() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			InitialContext ctx = new InitialContext();
			LivrosBeanRemote service = (LivrosBeanRemote) ctx
					.lookup("ejb:/03_LivrosEJB/LivrosBean!br.com.fiap.bean.LivrosBeanRemote");
			List<Livros> lista = service.getAll();
			
			request.setAttribute("lista", lista); //coincidencia, vale o nome do atributo
			request.getRequestDispatcher("lista.jsp").forward(request, response);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			InitialContext ctx = new InitialContext();
			LivrosBeanRemote service = (LivrosBeanRemote) ctx
					.lookup("ejb:/03_LivrosEJB/LivrosBean!br.com.fiap.bean.LivrosBeanRemote");
			
			Livros livro = new Livros();
			
			livro.setTitulo(request.getParameter("titulo")) ;
			livro.setAutor(request.getParameter("autor"));
			livro.setPreco(Double.parseDouble(request.getParameter("preco")));
			service.add(livro);
			
			doGet(request, response);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}

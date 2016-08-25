package br.com.fiap.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.entity.Livros;

@WebServlet("/livrosmdb")
public class ServletLivrosMdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(mappedName = "java:/queue/ExemploQueue")
	private Queue fila;
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	public ServletLivrosMdb() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println(getClass() + "Inicio........");
			Connection connection = connectionFactory.createConnection();
			try {
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				MessageProducer messageProducer = session.createProducer(fila);

				// 1. Enviando objeto TextMessage
				TextMessage message = session.createTextMessage();
				message.setText("Exemplo EJB3 MDB Queue!!!");
				messageProducer.send(message);

				// 2. Enviando objeto ObjectMessage
				ObjectMessage objMessage = session.createObjectMessage();
				Livros livros = new Livros();
				livros.setTitulo(request.getParameter("titulo"));
				livros.setAutor(request.getParameter("autor"));
				livros.setPreco(Double.parseDouble(request.getParameter("preco")));

				objMessage.setObject(livros);
				messageProducer.send(objMessage);

				messageProducer.close();
			} finally {
				connection.close();
			}
			System.out.println(getClass() + "Enviado com sucesso");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

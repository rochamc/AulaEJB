package br.com.fiap.mdb;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import br.com.fiap.mdb.classes.Cliente;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/ExemploQueue") })
public class QueueListenerMDB implements MessageListener {

	public QueueListenerMDB() {
	}

	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				System.out.println("Queue: TextMessage recebida em " + new Date());
				TextMessage msg = (TextMessage) message;
				System.out.println("Message is : " + msg.getText());
			} else if (message instanceof ObjectMessage) {
				System.out.println("Queue: ObjectMessage recebida em " + new Date());
				ObjectMessage msg = (ObjectMessage) message;
				Cliente cliente = (Cliente) msg.getObject();
				System.out.println("Detalhes do cliente: ");
				System.out.println(cliente.getId());
				System.out.println(cliente.getNome());
				System.out.println(cliente.getTelefone());
				System.out.println(cliente.getEmail());
			} else {
				System.out.println("Nenhuma mensagem válida!");
			}

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

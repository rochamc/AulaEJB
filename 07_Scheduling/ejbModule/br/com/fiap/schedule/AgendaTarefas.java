package br.com.fiap.schedule;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class AgendaTarefas {
	public AgendaTarefas() {
		// TODO Auto-generated constructor stub
	}

	@Schedule(second = "*/5", minute = "*", hour = "*")
	public void agendar() {
		System.out.println("[" + new Date() + "]");
	}
}
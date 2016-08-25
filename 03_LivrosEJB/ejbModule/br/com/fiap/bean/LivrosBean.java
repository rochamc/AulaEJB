package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Livros;
import br.com.fiap.interceptor.MonitorInterceptor;

@Stateless
@Interceptors({MonitorInterceptor.class}) 
public class LivrosBean implements LivrosBeanRemote {
	
	@PersistenceContext(unitName = "fiapPU")
	private EntityManager em;

	@Override
	public void add(Livros livro) {
		em.persist(livro);
	}

	@Override
	public List<Livros> getAll() {
		TypedQuery<Livros> query = em.createQuery("select u from Livros u", Livros.class);
		return query.getResultList();
	}
	@Schedule(second="*/2", minute="*", hour="*")
	public void cont(){
		System.out.println("Total de livros: " + getAll().size());
	}
	
	
}

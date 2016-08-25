package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.entity.Livros;

@Remote
public interface LivrosBeanRemote {
	void add(Livros livro);
	List<Livros> getAll(); 
}

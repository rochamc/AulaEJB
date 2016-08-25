package br.com.fiap.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.bean.LivrosBeanRemote;
import br.com.fiap.entity.Livros;

public class LivrosService implements LivrosServiceRemote {

/*	@Override
	public List<Livros> listarLivros(){
		List<Livros> lista = new ArrayList<>();
		try {
			InitialContext ctx = new InitialContext();
			LivrosBeanRemote service = (LivrosBeanRemote) ctx.lookup(name)
				
			lista = service.getAll();
		} catch(NamingException e){
			e.printStackTrace();
		}
		return lista;
	}*/
}

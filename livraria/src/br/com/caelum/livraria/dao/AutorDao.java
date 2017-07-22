package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@Inject
	private Banco banco;

	@PostConstruct
	void aposCriacao(){
		System.out.println("autor dao foi criado...");
	}
	
	public void salva(Autor autor) {
		
		System.out.println("salvando autor..." + autor.getNome());
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
		
		banco.save(autor);
		System.out.println("Gravado..." + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}

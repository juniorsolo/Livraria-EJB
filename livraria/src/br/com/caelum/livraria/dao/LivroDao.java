package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager em;
	
	public void salva(Livro livro) {
		em.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return em.createQuery("select li from Livro li", Livro.class).getResultList();
	}

	public List<Livro> buscaPeloNome(String nome) {
		
		TypedQuery<Livro> query = this.em.createQuery("select l from Livro l where l.titulo like :ptitulo", Livro.class);
		query.setParameter("ptitulo", "%" + nome + "%");
		return query.getResultList();
	}
	
}

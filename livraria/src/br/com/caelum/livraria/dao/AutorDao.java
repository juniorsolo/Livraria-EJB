package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.interceptador.LogInterceptador;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) // opcional
@Interceptors({LogInterceptador.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	void aposCriacao(){
		System.out.println("autor dao foi criado...");
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY) // madatoria estar numa transacao para chamar por isso criado o service
	public void salva(Autor autor) throws LivrariaException {
		
		System.out.println("salvando autor..." + autor.getNome());
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
		
		manager.persist(autor);
		System.out.println("Gravado..." + autor.getNome());
		
		//Teste de erro, ao observar a pilha de erro no console vemos o rollback do persist
		//throw new  RuntimeException("Servico exter deu erro!");
		
		//throw new LivrariaException();
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}

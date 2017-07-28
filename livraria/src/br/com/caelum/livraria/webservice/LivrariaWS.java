package br.com.caelum.livraria.webservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService

public class LivrariaWS implements Serializable{

	@Inject
	private LivroDao dao;
	
	
	private static final long serialVersionUID = -721850303121687085L;

	@WebResult(name="Autores")
	public List<Livro> getLivrosPeloNome(@WebParam(name="titulo") String nome){
		List<Livro> l = new ArrayList<Livro>();
		System.out.println("LivrariaWS: procurando pelo nome " + nome);
		l= dao.buscaPeloNome(nome);
		return l;
	}
}

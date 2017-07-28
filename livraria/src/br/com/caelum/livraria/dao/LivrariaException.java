package br.com.caelum.livraria.dao;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)//Esta anotação reconfigura o padrao caso estenda de exception somente, habilitando o rollback em caso de erro
public class LivrariaException extends RuntimeException {

}

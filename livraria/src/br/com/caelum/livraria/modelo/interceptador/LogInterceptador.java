package br.com.caelum.livraria.modelo.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception{
		
		long millis = System.currentTimeMillis();
		
		//Chama o objeto dao
		Object o = context.proceed();
		
		String metodo = context.getMethod().getName();
		String classe = context.getClass().getSimpleName();
		
		System.out.println(classe);
		System.out.println(metodo);
		System.out.println("O tempo gasto foi: " + (System.currentTimeMillis() - millis));
		
		return o;
	}
}

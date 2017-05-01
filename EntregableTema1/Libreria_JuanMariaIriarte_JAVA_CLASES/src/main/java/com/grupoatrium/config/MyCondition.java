package com.grupoatrium.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// Aqui se evalua una expresion que devolverá un valor boleano
		// Si es true hara que el bean se genere
		// Si es false no se creará
		System.out.println("Evalua la condici�n a true");
		return true;
	}

}

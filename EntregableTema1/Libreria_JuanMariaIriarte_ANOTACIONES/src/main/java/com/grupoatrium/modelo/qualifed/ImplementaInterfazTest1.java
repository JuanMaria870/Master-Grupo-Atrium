package com.grupoatrium.modelo.qualifed;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ImplementaInterfazTest1 implements InterfazTest {

	@Override
	public void metodo1() {
		System.out.println("ImplementaInterfazTest1");

	}

}

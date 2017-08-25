package com.grupoatrium.cliente;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.grupoatrium.persistencia.impl.AutorDaoTestImpl;
import com.grupoatrium.persistencia.impl.DireccionDaoTestImpl;
import com.grupoatrium.persistencia.impl.EditorialDaoTestImpl;
import com.grupoatrium.persistencia.impl.LibroDaoTestImpl;

public class AppMainTest {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(DireccionDaoTestImpl.class, EditorialDaoTestImpl.class, AutorDaoTestImpl.class, LibroDaoTestImpl.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(new StringBuffer("Resultado del test: ").append(result.wasSuccessful()));
	}

}

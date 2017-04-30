package com.grupoatrium.modelo.qualifed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UsaObjetoQImplementaInt {

	@Autowired
	@Qualifier("implementaInterfazTest1")
	InterfazTest test;

	@Autowired
	@Qualifier("implementaInterfazTest2")
	InterfazTest test2;

	/**
	 * 
	 */
	public UsaObjetoQImplementaInt() {
		super();
	}

	/**
	 * @param test
	 * @param test2
	 */
	public UsaObjetoQImplementaInt(InterfazTest test, InterfazTest test2) {
		super();
		this.test = test;
		this.test2 = test2;
	}

	/**
	 * @return the test
	 */
	public InterfazTest getTest() {
		return test;
	}

	/**
	 * @param test
	 *            the test to set
	 */
	public void setTest(InterfazTest test) {
		this.test = test;
	}

	/**
	 * @return the test2
	 */
	public InterfazTest getTest2() {
		return test2;
	}

	/**
	 * @param test2
	 *            the test2 to set
	 */
	public void setTest2(InterfazTest test2) {
		this.test2 = test2;
	}

}

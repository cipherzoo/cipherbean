package com.google.df.webhook.response;

public class OutputContext {

	private String name;
	private int lifespanCount;
	private Object parameter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifespanCount() {
		return lifespanCount;
	}

	public void setLifespanCount(int lifespanCount) {
		this.lifespanCount = lifespanCount;
	}

	public Object getParameter() {
		return parameter;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}

}

package Beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "editor")
public class MyBean {

	private String value = "PLEASE";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
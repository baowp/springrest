package com.iteye.baowp.springrest.pojo;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.iteye.baowp.springrest.constraints.HasEnCn;

public class Apple implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Size(min = 6, message = "名字不可为空")
	private String name;
	@NotNull
	@Min(100)
	private Float price;
	@NotNull
	@Min(50)
	private Integer price2;
	@HasEnCn
	// @Pattern(regexp = "\\s*\\S+\\s*", message = "用户名不为空")
	private String username;

	private Users user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPrice2() {
		return price2;
	}

	public void setPrice2(Integer price2) {
		this.price2 = price2;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}

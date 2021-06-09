package com.grocery.store.ws.util;

import java.math.BigDecimal;

import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;

public abstract class Builder {

	private String pn;

	private BigDecimal pv;

	private String pd;

	private String tofp;

	public Builder withProductName(String pn) {
		this.pn = pn;
		return this;
	}

	public Builder withProductValue(BigDecimal pv) {
		this.pv = pv;
		return this;
	}

	public Builder withProductDescription(String pd) {
		this.pd = pd;
		return this;
	}

	public Builder withTypeOfProduct(String tofp) {
		this.tofp = tofp;
		return this;
	}

	public GroceryProductEntity build() {
		GroceryProductEntity entity = new GroceryProductEntity();
		entity.setProductName(this.pn);
		entity.setProductValue(this.pv);
		entity.setProductDescription(this.pd);
		entity.setTypeOfProduct(this.tofp);
		return entity;
	}

}

package com.qf.domain;

public class LinkMan {

	private Integer link_id;
	private String linkman_name;
	
	private Customer customer;
	public Integer getLink_id() {
		return link_id;
	}
	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}
	public String getLinkman_name() {
		return linkman_name;
	}
	public void setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "LinkMan [link_id=" + link_id + ", linkman_name=" + linkman_name + ", customer=" + customer + "]";
	}
	
	
}

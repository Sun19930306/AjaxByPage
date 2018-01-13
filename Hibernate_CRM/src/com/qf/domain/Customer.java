package com.qf.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer cust_id;
	private  String cust_name;
	private  String cust_level;
	private  String cust_source;
	private  String cust_phone;
	private  String cust_mobile;
	private  String cust_address;
	private  String cust_Zip;
	private  String cust_Fax;
	private  String cust_Website;

   private Set<LinkMan> linkMans=new HashSet<>();

public Integer getCust_id() {
	return cust_id;
}

public void setCust_id(Integer cust_id) {
	this.cust_id = cust_id;
}

public String getCust_name() {
	return cust_name;
}

public void setCust_name(String cust_name) {
	this.cust_name = cust_name;
}

public String getCust_level() {
	return cust_level;
}

public void setCust_level(String cust_level) {
	this.cust_level = cust_level;
}

public String getCust_source() {
	return cust_source;
}

public void setCust_source(String cust_source) {
	this.cust_source = cust_source;
}

public String getCust_phone() {
	return cust_phone;
}

public void setCust_phone(String cust_phone) {
	this.cust_phone = cust_phone;
}

public String getCust_mobile() {
	return cust_mobile;
}

public void setCust_mobile(String cust_mobile) {
	this.cust_mobile = cust_mobile;
}

public String getCust_address() {
	return cust_address;
}

public void setCust_address(String cust_address) {
	this.cust_address = cust_address;
}

public String getCust_Zip() {
	return cust_Zip;
}

public void setCust_Zip(String cust_Zip) {
	this.cust_Zip = cust_Zip;
}

public String getCust_Fax() {
	return cust_Fax;
}

public void setCust_Fax(String cust_Fax) {
	this.cust_Fax = cust_Fax;
}

public String getCust_Website() {
	return cust_Website;
}

public void setCust_Website(String cust_Website) {
	this.cust_Website = cust_Website;
}

public Set<LinkMan> getLinkMans() {
	return linkMans;
}

public void setLinkMans(Set<LinkMan> linkMans) {
	this.linkMans = linkMans;
}

@Override
public String toString() {
	return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_level=" + cust_level + ", cust_source="
			+ cust_source + ", cust_phone=" + cust_phone + ", cust_mobile=" + cust_mobile + ", cust_address="
			+ cust_address + ", cust_Zip=" + cust_Zip + ", cust_Fax=" + cust_Fax + ", cust_Website=" + cust_Website
			+ "]";
}
   
   
   
}

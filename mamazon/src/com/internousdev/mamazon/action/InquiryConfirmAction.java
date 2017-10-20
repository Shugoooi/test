package com.internousdev.mamazon.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 問い合わせ内容を確認
 * @author internousdev
 *
 */
public class InquiryConfirmAction extends ActionSupport implements SessionAware {

	private String inquiry;

	private Map<String, Object> session = new HashMap<>();

	/**
	 * 問い合わせ内容を確認
	 */
	public String execute() {

		session.put("inquiry",  inquiry);
		return SUCCESS;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

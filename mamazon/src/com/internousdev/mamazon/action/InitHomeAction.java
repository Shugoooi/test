/**
 *
 */
package com.internousdev.mamazon.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ホーム画面の初期設定
 * @author internousdev
 *
 */
public class InitHomeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session = new HashMap<>();

	private Map<String, String> categoryMap = new HashMap<>();

	public String execute() {

		categoryMap.put("fire_extinguisher",  "消火器");
		categoryMap.put("flame_thrower",  "火炎放射器");
		categoryMap.put("seedling",  "苗木");
		session.put("categoryMap",  categoryMap);
		return SUCCESS;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return categoryMap
	 */
	public Map<String, String> getCategoryMap() {
		return categoryMap;
	}

}

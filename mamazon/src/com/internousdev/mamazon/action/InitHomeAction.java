/**
 *
 */
package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ホーム画面の初期設定
 * @author internousdev
 *
 */
public class InitHomeAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * カテゴリ一覧
	 */
	private Map<String, String> categoryMap = new HashMap<>();

	/**
	 * ホーム画面の初期設定
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		//現存するカテゴリの追加
		categoryMap.put("fire_extinguisher",  "消火器");
		categoryMap.put("flame_thrower",  "火炎放射器");
		categoryMap.put("seedling",  "苗木");
		if (!session.containsKey("categoryMap")) {
			session.put("categoryMap",  categoryMap);
		}

		//一時カートの初期化
		CartInfoDAO dao = new CartInfoDAO();
		dao.delCartTMP();
		return SUCCESS;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param categoryMap セットする categoryMap
	 */
	public void setCategoryMap(Map<String, String> categoryMap) {
		this.categoryMap = categoryMap;
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

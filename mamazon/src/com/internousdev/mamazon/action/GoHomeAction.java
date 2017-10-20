package com.internousdev.mamazon.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ホーム画面に戻るクラス
 * @author internousdev
 *
 */
public class GoHomeAction extends ActionSupport {

	/**
	 * ホーム画面に戻るメソッド
	 */
	public String execute() {
		return SUCCESS;
	}
}

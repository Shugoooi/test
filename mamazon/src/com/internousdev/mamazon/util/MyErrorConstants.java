package com.internousdev.mamazon.util;

/**
 * 入力エラーをまとめて管理
 * @author internousdev
 *
 */
public abstract interface MyErrorConstants {

	public static final String LOGIN_ERROR_MESSAGE = "ログイン失敗しました";

	public static final String LOGIN_REQUIRED_MESSAGE = "ログインしてください";

	public static final String ID_DUPLICATION_MESSAGE = "そのIDは既に使われています";

	public static final String ID_ERROR_MESSAGE = "IDは半角英数字で4文字以上のものを使用してください";

	public static final String PASSWORD_ERROR_MESSAGE = "パスワードは半角英字と数字共に含めて6文字以上のものを使用してください";

	public static final String TEL_ERROR_MESSAGE = "電話番号を正しく入力してください";

	public static final String MAIL_ERROR_MESSAGE = "メールアドレスを正しく入力してください";



}

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

	public static final String INPUT_ERROR_MESSAGE = "入力漏れがありませんか？";

	public static final String GOODSNAME_ERROR_MESSAGE = "その商品名は既に使われています";

	public static final String ADD_GOODS_ERROR_MESSAGE = "商品情報の登録が失敗しました";

	public static final String FILE_SAVE_ERROR_MESSAGE = "商品画像の保存に失敗しました";

	public static final String CHANGE_GOODS_ERROR_MESSAGE = "商品情報の変更が失敗しました";

	public static final String DELETE_GOODS_FROM_CART_ERROR_MESSAGE = "正常に商品を削除できませんでした";



}

package jp.alhinc.m.takizawa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//状態をもたず、同じ入力なら常に同じ値を返すメソッド = ユーティリティメソッド
public class StringUtils {
	public static String toSnakeCase(String text) {
		//nullだったら、""内のメッセージを表示する
		if (text == null) throw new NullPointerException("text == null.");
		String snake = text;
		//Patternクラス　引数にはパターンをあらわす文字列を指定
		//引数に複数指定する場合は、"(¥d+)(y)" /この場合、group(1):d, group(2):y / (の出現の順番できめる
		Pattern p = Pattern.compile("([A-Z])");
		for (;;) {
			//pとsnakeがマッチしてれば、mに入れられる
			Matcher m = p.matcher(snake);
			//mになにかはいっていなければ、終了。
			if (!m.find()) break;
			//mの文字列の中で最初に一致したもののみ、_にかえる（複数の場合、２個目以降は変わらない）
			//
			snake = m.replaceFirst("_" + m.group(1).toLowerCase());
		}
		return snake.replaceFirst("^_", "");
	}
}

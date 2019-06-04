package jp.sou4j.microsoft.cognitive.luis.util;

import java.util.ArrayList;
import java.util.List;

import jp.sou4j.util.Objects;
import jp.sou4j.util.StringUtils;

public class StringListUtils {

	/**
	 * <p>指定された文字列を要素とするリストから、空文字・NULLの要素を削除した文字列リストを返却します。</p>
	 * @param strings
	 * @return
	 */
	public static List<String> slim(List<String> strings) {
		Objects.requireNonNull(strings, "Method argument 'strings' is null.");
		ArrayList<String> result = new ArrayList<String>();
		for(String string : strings) {
			if( !StringUtils.isNullOrEmpty(string) ) {
				result.add(string);
			}
		}
		return result;
	}
}

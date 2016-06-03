package com.zhangshan.guibai.tutupictest.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangshan on 2016/4/7 16:45.
 */
public class Json2Map {
	/**
	 * Json 转成 Map<>
	 * 
	 * @param jsonStr
	 */
	public static Map<String, Object> transJsonToMap(String jsonStr) {
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(jsonStr);

			Iterator<String> keyIter = jsonObject.keys();
			String key;
			Object value;
			Map<String, Object> valueMap = new HashMap<>();
			while (keyIter.hasNext()) {
				key = keyIter.next();
				value = jsonObject.get(key);
				valueMap.put(key, value);
			}
			return valueMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Json 转成 List<Map<>>
	 * 
	 * @param jsonStr
	 */
	public static List<Map<String, Object>> transJsonToList(String jsonStr) {
		List<Map<String, Object>> list = null;
		try {
			JSONArray jsonArray = new JSONArray(jsonStr);
			JSONObject jsonObj;
			list = new ArrayList<>();
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObj = (JSONObject) jsonArray.get(i);
				list.add(transJsonToMap(jsonObj.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

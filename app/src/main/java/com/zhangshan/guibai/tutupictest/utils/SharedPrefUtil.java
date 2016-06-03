package com.zhangshan.guibai.tutupictest.utils;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefUtil {

	public static void putBoolean(Context context, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		sp.edit().putBoolean(key, value).commit();
	}

	public static void putInt(Context context, String key, int value) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		sp.edit().putInt(key, value).commit();
	}

	public static int getInt(Context context, String key, int defValue) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getInt(key, defValue);
	}

	public static boolean getBoolean(Context context, String key, boolean defValue) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getBoolean(key, defValue);
	}

	public static void putString(Context context, String key, String value) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		sp.edit().putString(key, value).commit();
	}

	public static String getString(Context context, String key, String defValue) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getString(key, defValue);
	}

	/**
	 * 移除sp
	 * 
	 * @param context
	 * @param key
	 */
	public static void removeString(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		sp.edit().remove(key);
	}

	/**
	 * 保存list
	 */
	public static boolean saveArray(Context context , ArrayList<String> list , String key , String key2) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor mEdit1 = sp.edit();
		mEdit1.putInt(key , list.size()); /* list is an array */

		for (int i = 0; i < list.size(); i++) {
			mEdit1.remove(key2 + i);
			mEdit1.putString(key2 + i, list.get(i));
		}

		return mEdit1.commit();
	}
	/**
	 * 取值list
	 * @return 
	 */
	public static ArrayList<String> loadArray(Context mContext , String key , String key2) {
		SharedPreferences mSharedPreference1 = PreferenceManager
				.getDefaultSharedPreferences(mContext);
		ArrayList<String> list = new ArrayList<String>();
		list.clear();
		int size = mSharedPreference1.getInt(key , 0);

		for (int i = 0; i < size; i++) {
			list.add(mSharedPreference1.getString(key2 + i, null));

		}
		return list;
	}

}

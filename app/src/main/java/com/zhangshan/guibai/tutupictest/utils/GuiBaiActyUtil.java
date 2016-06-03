/*    
 * 
 * @author		: WangLin  
 * @Company: 	：FCBN
 * @date		: 2015年5月13日 
 * @version 	: V1.0
 */
package com.zhangshan.guibai.tutupictest.utils;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

/**
 * Activity 相关操作 工具类
 */
public class GuiBaiActyUtil
{

	/**
	 * 存储打开的Activity的列表
	 */
	private static ArrayList<Activity>	ACTIVITY_LIST	= new ArrayList<Activity>();

	/**
	 * 添加Activity到集合
	 * 
	 * @param acty
	 */
	public static void addActivityToList(Activity acty)
	{
		ACTIVITY_LIST.add(acty);
	}

	/**
	 *  将Activity从集合移除
	 * 
	 * @param acty
	 */
	public static void removeFromList(Activity acty)
	{
		ACTIVITY_LIST.remove(acty);
	}

	/**
	 * 结束所有Activity
	 */
	public static void finishAllActivity()
	{
		for (Activity acty : ACTIVITY_LIST)
		{
			if (acty != null && !acty.isFinishing())
			{
				acty.finish();
			}
		}

		ACTIVITY_LIST.clear();
	}

	/**
	 * 结束某个Activity
	 * 
	 * @param classObj	Activity的class对象
	 */
	public static void finishActivity(Class<?>... classObj)
	{
		for (Class<?> obj : classObj)
		{
			for (Activity acty : ACTIVITY_LIST)
			{
				if (acty != null && acty.getClass() == obj && !acty.isFinishing())
				{
					acty.finish();
					break;
				}
			}
		}
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 */
	public static void startActivity(Context context, Class<?> cls)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		context.startActivity(intent);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivity(Context context, Class<?> cls, String paramName, boolean value)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		context.startActivity(intent);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivity(Context context, Class<?> cls, String paramName, String value)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		context.startActivity(intent);
	}
	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivity(Context context, Class<?> cls, String paramName, String value , String paramName2, String value2 , String paramName3, String value3)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		intent.putExtra(paramName2, value2);
		intent.putExtra(paramName3, value3);
		context.startActivity(intent);
	}
	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivity(Context context, Class<?> cls, String paramName, String value , String paramName2, String value2)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		intent.putExtra(paramName2, value2);
		context.startActivity(intent);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivity(Context context, Class<?> cls, String paramName, int value)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		context.startActivity(intent);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivity(Context context, Class<?> cls, String paramName, Parcelable value)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		context.startActivity(intent);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 */
	public static void startActivity(Context context, Class<?> cls, String paramName, Bundle bundle)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, bundle);
		context.startActivity(intent);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 */
	public static void startActivityForResult(Activity context, Class<?> cls, int requestCode)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		context.startActivityForResult(intent, requestCode);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivityForResult(Activity context, Class<?> cls, int requestCode, String paramName,
			Parcelable value)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		context.startActivityForResult(intent, requestCode);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivityForResult(Activity context, Class<?> cls, int requestCode, String paramName,
			boolean value)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		context.startActivityForResult(intent, requestCode);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivityForResult(Activity context, Class<?> cls, int requestCode, String paramName,
			int value)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		context.startActivityForResult(intent, requestCode);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 * @param value
	 */
	public static void startActivityForResult(Activity context, Class<?> cls, int requestCode, String paramName,
			String value)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, value);
		context.startActivityForResult(intent, requestCode);
	}

	/**
	 *  开启新的Activity 
	 * 
	 * @param context
	 * @param cls			
	 * @param paramName
	 */
	public static void startActivityForResult(Activity context, Class<?> cls, int requestCode, String paramName,
			Bundle bundle)
	{
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtra(paramName, bundle);
		context.startActivityForResult(intent, requestCode);
	}
}

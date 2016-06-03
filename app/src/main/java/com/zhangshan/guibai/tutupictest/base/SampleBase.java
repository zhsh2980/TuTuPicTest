/** 
 * TuSdkDemo
 * SimpleBase.java
 *
 * @author 		Clear
 * @Date 		2015-4-21 下午12:52:59 
 * @Copyright 	(c) 2015 tusdk.com. All rights reserved.
 * 
 */
package com.zhangshan.guibai.tutupictest.base;

import android.app.Activity;

import org.lasque.tusdk.modules.components.TuSdkHelperComponent;

/**
 * 范例接口，封装好的组件示例
 * 
 * @author Clear
 */
public abstract class SampleBase
{

	/** 组件帮助方法 */
	public TuSdkHelperComponent componentHelper;


	/** 显示范例 */
	public abstract void showSample(Activity activity);
}
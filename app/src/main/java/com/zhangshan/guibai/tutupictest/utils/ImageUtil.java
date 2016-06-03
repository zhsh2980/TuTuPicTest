package com.zhangshan.guibai.tutupictest.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


public class ImageUtil {
	private static HashMap<String, SoftReference<Bitmap>> imageCache = new HashMap<String, SoftReference<Bitmap>>();

	/**
	 * JPG图片缓存
	 * 
	 * @param imagePath
	 * @param bitmap
	 * @throws IOException
	 */
	public static void saveImageJpeg(String imagePath, Bitmap bitmap)
			throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
		byte[] b = bos.toByteArray();
		saveImage(imagePath , b);
		bos.flush();
		bos.close();
	}

	/**
	 * PNG图片缓存
	 * 
	 * @param imagePath
	 * @throws IOException
	 */

	public static void saveImagePng(String imagePath, Bitmap bitmap)
			throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
		byte[] b = bos.toByteArray();
		saveImage(imagePath, b);
		bos.flush();
		bos.close();
	}

	/**
	 * 缓存图片
	 * 
	 * @param imagePath
	 * @param buffer
	 * @throws IOException
	 */
	public static void saveImage(String imagePath, byte[] buffer)
			throws IOException {
		File f = new File(imagePath);
		if (f.exists()) {
			return;
		} else {
			File parentFile = f.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(imagePath);
			LogUtils.i("图片保存的路径是 : "+imagePath);
			fos.write(buffer);
			fos.flush();
			fos.close();
		}
	}

	/**
	 * 从本地获取图片
	 * 
	 * @param imagePath
	 * @return Bitmap
	 */
	public static Bitmap getImageFromLocal(String imagePath) {
		File file = new File(imagePath);
		LogUtils.i("图片获取的路径是 : "+imagePath);
		if (file.exists()) {
			Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
			file.setLastModified(System.currentTimeMillis());
			return bitmap;
		}
		return null;
	}


	public static int computeSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		int initialSize = computeInitialSampleSize(options, minSideLength,
				maxNumOfPixels);

		int roundedSize;
		if (initialSize <= 8) {
			roundedSize = 1;
			while (roundedSize < initialSize) {
				roundedSize <<= 1;
			}
		} else {
			roundedSize = (initialSize + 7) / 8 * 8;
		}

		return roundedSize;
	}

	private static int computeInitialSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		double w = options.outWidth;
		double h = options.outHeight;

		int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math
				.sqrt(w * h / maxNumOfPixels));
		int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(
				Math.floor(w / minSideLength), Math.floor(h / minSideLength));

		if (upperBound < lowerBound) {
			// return the larger one when there is no overlapping zone.
			return lowerBound;
		}

		if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
			return 1;
		} else if (minSideLength == -1) {
			return lowerBound;
		} else {
			return upperBound;
		}
	}

	/**
	 * 获取指定路径的Byte[]数据-通用
	 * 
	 * @param urlpath
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] getUrlBytes(String urlpath) throws Exception {
		InputStream in_s = getUrlInputStream(urlpath);
		return readStream(in_s);
	}

	/**
	 * 获取指定路径的InputStream数据-通用
	 * 
	 * @param urlpath
	 * @return byte[]
	 * @throws Exception
	 */
	public static InputStream getUrlInputStream(String urlpath)
			throws Exception {
		URL url = new URL(urlpath);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// conn.setRequestMethod("GET");
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(15 * 1000);// 10秒超时
		int responseCode = conn.getResponseCode();
		Log.i("image", responseCode + "");
		System.out.println(responseCode + "");
		if (responseCode == HttpURLConnection.HTTP_OK) {// 返回码200等于返回成功
			InputStream inputStream = conn.getInputStream();
			return inputStream;
		}
		return null;
	}

	/**
	 * 从InputStream中读取数据-通用
	 * 
	 * @param inStream
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] readStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		byte[] buffer = new byte[128];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outstream.write(buffer, 0, len);
		}
		outstream.close();
		inStream.close();
		return outstream.toByteArray();
	}

	/**
	 * 获取缓存路径
	 * 
	 * @return sd卡路径
	 */
	public static String getCacheImgPath() {
		return Environment.getExternalStorageDirectory().getPath()
				+ "/ambow/cache/";
	}

	/**
	 * 类功能描述：给网络上获取的图片设置的回调
	 * 
	 * @author mwqi
	 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
	 */
	public interface ImageCallback {
		public void onStart();

		public void loadImage(Bitmap bitmap, String imagePath);

		public void onFailed();
	}

}

package com.ifidc.traffic.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;




import com.ifidc.traffic.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

public class ImageCache {
	private String TAG = "imageCache";
	private Stack<clsTask> mTasks = new Stack<clsTask>();
	private String msHome;
	private static ImageCache instance = null;

	public static ImageCache getInstance(Context context) {
		if (instance == null) {
			synchronized (ImageCache.class) {
				if (null == instance) {
					instance = new ImageCache("/sdcard/"+context.getString(R.string.app_name));
				}
			}
		}
		return instance;
	}

	private class clsTask {
		public String mURL;
		public String mFilename;
		public ImageView mImageView;
	}

	private ImageCache(String asHome) {
		msHome = asHome;

		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message message) {
				clsTask theTask = (clsTask) message.obj;
				if (theTask.mURL.compareTo((String) (theTask.mImageView
						.getTag())) == 0)
					loadImageFile(theTask.mImageView, theTask.mFilename);
			}
		};

		Thread thread = new Thread() {
			@Override
			public void run() {
				for (; true;) {
					if (mTasks.empty()) {
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						clsTask theTask = mTasks.pop();
						if (theTask != null && theTask.mURL != null) {
							Log.d(TAG, theTask.mURL);
							if (theTask.mURL
									.compareTo((String) (theTask.mImageView
											.getTag())) == 0) {
								theTask.mFilename = fetchDrawable(theTask.mURL,
										msHome);
								if (theTask.mFilename != null) {
									File cachedFile = new File(
											theTask.mFilename);
									if (cachedFile.exists()) {
										Message message = handler
												.obtainMessage(1, theTask);
										handler.sendMessage(message);
									}
								}
							}
						}
					}
				}
			}
		};
		thread.start();
	}

	private String fetchDrawable(String urlString, String asHome) {
		String cachedFileName = null;
		cachedFileName = getCacheFileName(urlString);
		Log.d(TAG, cachedFileName);
		File cachedFile = new File(cachedFileName);
		cachedFile.getParentFile().mkdirs();
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(urlString);
		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response != null && response.getStatusLine().getStatusCode() == 200) {
			HttpEntity theEntity = response.getEntity();
			FileOutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(cachedFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if (outputStream != null) {
				try {
					theEntity.writeTo(outputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return cachedFileName;
		} else {
			return null;
		}
	}

	private void loadImageFile(ImageView imageView, String cachedFileName) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inDensity = DisplayMetrics.DENSITY_DEFAULT;
		Bitmap bm = BitmapFactory.decodeFile(cachedFileName, opt);
		BitmapDrawable bd = new BitmapDrawable(bm);
		imageView.setBackgroundDrawable(bd);
	}

	public void fetchDrawableOnThread(String urlString, ImageView imageView,
			Integer defaultResourceId) {
		String myurlString = urlString;
		String cachedFileName = null;
		File cachedFile = null;
		if (urlString == null) {
			imageView.setBackgroundResource(defaultResourceId);
			return;
		}
		if (myurlString != null) {
			cachedFileName = getCacheFileName(myurlString);
			cachedFile = new File(cachedFileName);
		}
		if (cachedFile != null && cachedFile.exists()) {
			loadImageFile(imageView, cachedFileName);
			if (cachedFile.lastModified() + 3600L * 8 * 1000 > System
					.currentTimeMillis()) {
				return;
			}
		} else {
			imageView.setBackgroundResource(defaultResourceId);
			clsTask newTask = new clsTask();
			newTask.mURL = myurlString;
			newTask.mImageView = imageView;
			imageView.setTag(myurlString);
			mTasks.push(newTask);
		}
	}

	public void fetchDrawableOnThread_setDrawable(String urlString,
			ImageView imageView, Drawable drawable) {
		String myurlString = urlString;
		String cachedFileName = null;
		File cachedFile = null;
		if (urlString == null) {
			imageView.setBackgroundDrawable(drawable);
			return;
		}
		if (myurlString != null) {
			cachedFileName = getCacheFileName(myurlString);
			cachedFile = new File(cachedFileName);
		}
		if (cachedFile != null && cachedFile.exists()) {
			loadImageFile(imageView, cachedFileName);
			if (cachedFile.lastModified() + 3600L * 8 * 1000 > System
					.currentTimeMillis()) {
				return;
			}
		} else {
			imageView.setBackgroundDrawable(drawable);
			clsTask newTask = new clsTask();
			newTask.mURL = myurlString;
			newTask.mImageView = imageView;
			imageView.setTag(myurlString);
			mTasks.push(newTask);
		}
	}

	public void fetchDrawableOnThread_setlayoutParams(String urlString,
			ImageView imageView, Integer defaultResourceId) {
		String myurlString = urlString;
		String cachedFileName = null;
		File cachedFile = null;
		if (urlString == null) {
			imageView.setBackgroundResource(defaultResourceId);
			return;
		}
		if (myurlString != null) {
			cachedFileName = getCacheFileName(myurlString);
			cachedFile = new File(cachedFileName);
		}
		if (cachedFile != null && cachedFile.exists()) {
			loadImageFile(imageView, cachedFileName);
			android.view.ViewGroup.LayoutParams layoutParams = imageView
					.getLayoutParams();
			layoutParams.width = imageView.getBackground().getIntrinsicWidth();
			layoutParams.height = imageView.getBackground()
					.getIntrinsicHeight();
			imageView.setLayoutParams(layoutParams);
			if (cachedFile.lastModified() + 3600L * 8 * 1000 > System
					.currentTimeMillis()) {
				return;
			}
		} else {
			imageView.setBackgroundResource(defaultResourceId);
			clsTask newTask = new clsTask();
			newTask.mURL = myurlString;
			newTask.mImageView = imageView;
			imageView.setTag(myurlString);
			mTasks.push(newTask);
		}
	}

	private String getCacheFileName(String url) {
		if (url != null) {
			return msHome + "/cache/image/" + hex(url) + suffix(url);
		} else {
			return null;
		}
	}

	public static String getExtension(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i);
			}
		}
		return defExt;
	}

	public static final String ENCODE_MD5 = "MD5";

	/**
	 * 转换为十六进制
	 * 
	 * @param s
	 *            密码
	 * @return 密码
	 */
	public static String hex(String str) {
		return hex(str, ENCODE_MD5);
	}

	/**
	 * 转换为十六进制
	 * 
	 * @param s
	 *            密码
	 * @return 密码
	 */
	public static String hex(String str, String method) {
		MessageDigest md = null;
		String dstr = null;
		try {
			md = MessageDigest.getInstance(method);
			md.update(str.getBytes());
			dstr = new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return dstr;
	}

	public static String suffix(String filename) {
		int index = filename.lastIndexOf('.');
		String st = filename.substring(index, filename.length());
		return st;
	}

	public interface LoadLiatener {
		public void LoadEnd();
	}
}

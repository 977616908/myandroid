package com.ifidc.router.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ifidc.router.data.ListViewData;
import com.ifidc.router.data.ListViewList;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class HttpUtils {
	public static void CopyStream(InputStream is, OutputStream os) {
		final int buffer_size = 1024;
		try {
			byte[] bytes = new byte[buffer_size];
			for (;;) {
				int count = is.read(bytes, 0, buffer_size);
				if (count == -1)
					break;
				os.write(bytes, 0, count);
			}
		} catch (Exception ex) {
		}
	}
	
	/** get方式传参 */
	public static String getDataGet(String url) throws Exception {
		StringBuilder sb = new StringBuilder();
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(httpGet);
		HttpEntity httpEntity = httpResponse.getEntity();
		if (httpEntity != null) {
			InputStream instream = httpEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					instream));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		}
		return null;
	}

	/** post方式传参 */
	public static String getDataPost(String url) {
		int res = 0;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			res = httpClient.execute(httpPost).getStatusLine().getStatusCode();
			System.out.println("res" + res);
			if (res == 200) {
				/*
				 * 当返回码为200时，做处理 得到服务器端返回json数据，并做处理
				 */
				HttpResponse httpResponse = httpClient.execute(httpPost);
				StringBuilder builder = new StringBuilder();
				BufferedReader bufferedReader2 = new BufferedReader(
						new InputStreamReader(httpResponse.getEntity()
								.getContent()));
				for (String s = bufferedReader2.readLine(); s != null; s = bufferedReader2
						.readLine()) {
					builder.append(s);
				}
				return builder.toString();
			}
			} catch (Exception e) {
		}
		return null;
	}
	
	/** 解析加载更多的数据 */
	public static ListViewList parseJSON(String resule,
			ListViewList List) {
		System.out.println("======result====="+resule);
		List = new ListViewList();
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(resule).getJSONObject("xinwenList");
			JSONArray jsonArray = jsonObject.getJSONArray("xinwenInfoList");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject2 = (JSONObject) jsonArray.opt(i);
				ListViewData item = new ListViewData();

				item.setId(jsonObject2.getString("id"));
				item.setTitle(jsonObject2.getString("title"));
				item.setPic(jsonObject2.getString("pic"));
				item.setIntro(jsonObject2.getString("intro"));
				item.setUpdatetime(jsonObject2.getString("updatetime"));
				item.setContAdd(jsonObject2.getString("ContAdd"));
								
				List.addItem(item);				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return List;
	}
	
	/** 检测网络是否连通  */
	public static boolean isNetwork(final Activity activity) {
		// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
		try {
			ConnectivityManager connectivity = (ConnectivityManager) activity
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				// 获取网络连接管理的对象
				NetworkInfo info = connectivity.getActiveNetworkInfo();
				if (info != null && info.isConnected()) {
					// 判断当前网络是否已经连接
					if (info.getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}else{
						return false;
					}
				}
			}
		} catch (Exception e) {
		}
		return false;
	}
	
	
}
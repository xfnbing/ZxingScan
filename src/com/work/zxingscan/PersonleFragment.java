package com.work.zxingscan;
 
import com.work.zxingscan.R; 
 
import android.os.Bundle;
import android.support.v4.app.Fragment; 
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup; 

/**
 *  显示: 识别过的数据/生成过的  --- 数据、 时间  、 二维码图像
 *  @see
 *  1、用户注册登录登陆
 *  2、生成历史记录   
 *  3、识别历史记录
 *  4、分享到社交网络
 * 
*/
public class PersonleFragment extends Fragment implements View.OnClickListener {
 

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View vontainView = inflater.inflate(R.layout.activity_personle, null);
		 
		return vontainView;

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		 
		}
	}

}
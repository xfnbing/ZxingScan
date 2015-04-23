package com.work.zxingscan;

import com.work.zxingscan.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 1、设定 是否震动
 * 2、是否有提示音
 * 3、清空历史记录等等
 * 
*/
public class SetupFragment extends Fragment implements View.OnClickListener {
 

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View vontainView = inflater.inflate(R.layout.activity_setup, null); 
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
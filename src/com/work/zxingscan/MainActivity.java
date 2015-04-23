package com.work.zxingscan;

import java.util.ArrayList;
import java.util.List;

import com.work.zxingscan.widget.BidirSlidingLayout;
import com.zbar.lib.CaptureActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		View.OnClickListener {

	private DrawerLayout drawerLayout;
	private List<Fragment> fragments = new ArrayList<Fragment>();
	private static final String[] TITLES = { "扫描", "生成", "个人页面", "设置" };
	private RelativeLayout mMenuLayoutLeft;// 左边抽屉
	private BidirSlidingLayout bidirSldingLayout;
	private ListView contentList;
	private TextView tvTitle;
	private FrameLayout content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvTitle = (TextView) findViewById(R.id.tv_title);
		tvTitle.setText(TITLES[0]);
	
		fragments.add(new CaptureActivity());
		fragments.add(new ScanFragment());
		fragments.add(new PersonleFragment());
		fragments.add(new SetupFragment());

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.fragment_layout, fragments.get(0));
		ft.commit();
		
		content = (FrameLayout) findViewById(R.id.fragment_layout);
		bidirSldingLayout = (BidirSlidingLayout) findViewById(R.id.bidir_sliding_layout);
		bidirSldingLayout.setScrollEvent(content);
	
		contentList = (ListView) findViewById(R.id.contentList);
		contentList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, TITLES));				
		contentList.setOnItemClickListener(new DrawerItemClickListenerLeft());
		
		findViewById(R.id.show_left_button).setOnClickListener(this);
	}

	private void setVisiable() {
		if (bidirSldingLayout.isLeftLayoutVisible()) {
			bidirSldingLayout.scrollToContentFromLeftMenu();
		} else {
			bidirSldingLayout.initShowLeftState();
			bidirSldingLayout.scrollToLeftMenu();
		}
	}

	/**
	 * 左侧列表点击事件
	 * 
	 * @author busy_boy
	 * 
	 */
	public class DrawerItemClickListenerLeft implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (fragments.size() > position && position >= 0) {
				tvTitle.setText(TITLES[position]);
				FragmentTransaction ft = getSupportFragmentManager()
						.beginTransaction();
				Fragment fragment = null;
				fragment = fragments.get(position);
				ft.replace(R.id.fragment_layout, fragment);
				ft.commit();
			}
			setVisiable();
		}

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.show_left_button:
			setVisiable();
			break;
		}
	}

}

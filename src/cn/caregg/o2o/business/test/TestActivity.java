package cn.caregg.o2o.business.test;

import java.util.ArrayList;

import me.maxwin.view.XListView.IXListViewListener;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.BusinessTask;
import cn.caregg.o2o.business.engine.parse.JsonParse;
import cn.caregg.o2o.business.engine.parse.ResultPaser;
import cn.caregg.o2o.business.engine.vo.NoticeInfo;
import cn.caregg.o2o.business.engine.vo.NoticePage;
import cn.caregg.o2o.business.engine.vo.PageModel;
import cn.caregg.o2o.business.ui.activity.LoginActivity;
import cn.caregg.o2o.business.ui.activity.NavigationManagerActivity;
import cn.caregg.o2o.business.ui.activity.NoticeActivity;
import cn.caregg.o2o.business.ui.activity.UserSearchActivity;
import cn.caregg.o2o.business.ui.adapter.MessageAdapter;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.ui.view.CommonListView;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.ResourceUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

@ContentView(R.layout.test_ativity)
public class TestActivity extends BaseActivity implements IXListViewListener{

	private ArrayList<String> items = new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

	}


	@SuppressWarnings("unchecked")
	private void testAPI() {
//		testdata();
		ActivityStartUtil.start(TestActivity.this, LoginActivity.class);
	}


	public void testdata() {
		String fileName="API/message_notice.txt";
		String result = getResult(fileName);
		NoticePage page = ResultPaser.paserObject(result, NoticePage.class);
		CommonListView  listView = (CommonListView) findViewById(R.id.commonListView1);
		listView.setPullLoadEnable(true);
//		for(NoticeInfo info:page.getDataList()){
//			System.out.println(info.getNoticeInfoTitle());
//		}
		listView.setAdapter(new MessageAdapter(TestActivity.this, page.getDataList()));
//		for(int i=0;i<10;i++)
//			   items.add("test"+i);
//	    listView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, items));
		listView.setXListViewListener(this);
	}


	public String getResult(String fileName) {
		String source = ResourceUtils.getFileFromAssets(fileName);
		JSONObject  json = null;
		String   result = null;
		try{
			json = new JSONObject(source);
			if(json.get("state").equals("0")){
				  throw new JSONException("data paser excption!");
			}
			 result  = json.getString("data");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void test(View view){
//		ActivityStartUtil.start(TestActivity.this, NavigationManagerActivity.class);
		testAPI();
	}


	@Override
	public void onRefresh() {
		System.out.println("刷新");
		
	}


	@Override
	public void onLoadMore() {
		System.out.println("更多");
	}
}

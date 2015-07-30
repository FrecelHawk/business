package cn.caregg.o2o.business.test;

import android.os.Bundle;
import android.view.View;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.UserTask;
import cn.caregg.o2o.business.engine.parse.JsonParse;
import cn.caregg.o2o.business.engine.parse.ResultPaser;
import cn.caregg.o2o.business.engine.vo.NoticeInfo;
import cn.caregg.o2o.business.engine.vo.PageModel;
import cn.caregg.o2o.business.ui.activity.LoginActivity;
import cn.caregg.o2o.business.ui.activity.NavigationManagerActivity;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.ResourceUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

@ContentView(R.layout.test_ativity)
public class TestActivity extends BaseActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

	}


	@SuppressWarnings("unchecked")
	private void testAPI() {
		String fileName="API/message_notice.txt";
		String result = ResourceUtils.getFileFromAssets(fileName);
		TestEntity paserObject = ResultPaser.paserObject(result, TestEntity.class);
		/*if(paserObject!=null&&paserObject.getState().equals("1")){
			PageModel<NoticeInfo> pageModel  = ResultPaser.paserObject(paserObject.getData(), PageModel.class);
			for(NoticeInfo info: pageModel.getDataList()){
				System.out.println(info.getNoticeInfoContent2());
			}
		}*/
	}
	
	
	public void test(View view){
//		ActivityStartUtil.start(TestActivity.this, NavigationManagerActivity.class);
		testAPI();
	}
}

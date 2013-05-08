package gaobq.android.easyslidingmenu;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/***
 * 
 * @author gaobiaoqing
 *
 */
public class SlidingTestActivity extends FragmentActivity implements IDataChange{
	ListView mainlist ;
	SlidingMenu menu ;
	List<SampleItem> mlist ;
	SlidingAdapter mAdapter ;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.setContentView(R.layout.content_view);
		mainlist = (ListView) this.findViewById(R.id.mainlist);
		
		mlist = new ArrayList<SampleItem>();
		generateList(-1);
		mAdapter = new SlidingAdapter(this,mlist) ;
		mainlist.setAdapter(mAdapter);
		
		//set about sliding menu
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		//attach to your activity
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		//create a fragment
		SampleSlidingListFragment fragment = new SampleSlidingListFragment(this);
		
		String[] items = new String[]{"item1","item2","itme3","item4","item5","itme6","item7","item8","itme9","item10","item11","itme12"};
		ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, android.R.id.text1, items);
		fragment.setListAdapter(itemAdapter);
		//we should invoke setMenu and the parameter is a layout ,framelayout best
		menu.setMenu(R.layout.menu_frame_two);
		
		//use the fragment to replace layout
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame_two, fragment)
		.commit();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
		//sliding menu is hide default,so when activity resume,invoke toggle() to show it
		menu.toggle();
	}
	
	/**
	 * generate data for list
	 * @param id
	 */
	public void generateList(int id ){
		id += 1 ;
		mlist.clear();
		for(int i=0;i<20;i++){
			SampleItem item = new SampleItem("item_"+id+"-->"+i, android.R.drawable.ic_menu_search);
			mlist.add(item);
		}
	}

	@Override
	public void dataChange(int id) {
		generateList(id);
		mAdapter.setList(mlist);
		mAdapter.notifyDataSetChanged();
		menu.toggle();
	}
	
}

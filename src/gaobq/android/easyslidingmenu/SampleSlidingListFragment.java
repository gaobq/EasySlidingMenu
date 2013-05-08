package gaobq.android.easyslidingmenu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("ValidFragment")
public class SampleSlidingListFragment extends ListFragment{
	
	String TAG =SampleSlidingListFragment.class.getName();
	IDataChange mCallback ;
	
	public SampleSlidingListFragment(IDataChange ie){
		mCallback = ie ;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		this.getListView().setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.d(TAG, "position ==="+arg2);
				mCallback.dataChange(arg2);
			}
			
		});
	}
	
}

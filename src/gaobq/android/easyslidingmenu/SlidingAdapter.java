package gaobq.android.easyslidingmenu;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class SlidingAdapter extends BaseAdapter{
	
	List<SampleItem> mList ;
	Context mContext ;
	
	
	
	public SlidingAdapter(Context context,List<SampleItem> list){
		mList = list;
		mContext = context ;
	}
	
	public void setList(List<SampleItem> list){
		mList = list;
	}
	
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public SampleItem getItem(int arg0) {
		return mList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.row, null);
		}
		ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
		icon.setImageResource(getItem(position).iconRes);
		TextView title = (TextView) convertView.findViewById(R.id.row_title);
		title.setText(getItem(position).tag);

		return convertView;
	}
	
	 
}



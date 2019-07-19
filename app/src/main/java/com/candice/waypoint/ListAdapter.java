package com.candice.waypoint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * <br>
 * <p>
 * <p>
 * com.candice.waypoint
 * <p>
 * FUXI
 */
public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mStringList;

    public ListAdapter(Context context, ArrayList<String> stringList) {
        this.mContext = context;
        mStringList = stringList;

    }

    @Override
    public int getCount() {
        return mStringList == null ? 0 : mStringList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, null, false);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
          viewHolder = (ViewHolder) convertView.getTag();
        }
        String s = mStringList.get(position);
        viewHolder.tvTitle.setText(s);
        return convertView;
    }

    public static class ViewHolder{
        private TextView tvTitle;


        public ViewHolder(View convertView) {
            tvTitle = (TextView) convertView.findViewById(R.id.tv_title);

        }
    }
}

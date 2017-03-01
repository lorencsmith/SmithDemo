package com.example.lorensmith.smithdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lorensmith.smithdemo.R;

import java.util.ArrayList;

/**
 * Created by Loren Smith on 2/22/2017.
 */

public class ImageViewAdapter extends BaseAdapter {
    private Context mContext;
    private final LayoutInflater mInflater;
    private final ArrayList<String> listResult;


    public ImageViewAdapter(Context context, ArrayList<String> listResult){
        this.mContext = context;
        this.listResult = listResult;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return listResult.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = new View(mContext);
//        view.setText(String.valueOf(position));
//        return view;

        ViewHolder holder;
        if(convertView== null){
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.textView2 = (TextView) convertView.findViewById(R.id.list_view_tv2);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView2.setText(listResult.get(position));




        return convertView;
    }
}
class ImageHolder{

    TextView textView2;

    RelativeLayout.LayoutParams lp = new
            RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
}



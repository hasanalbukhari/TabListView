package com.ws_adv.tabslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by appleuser on 8/3/15.
 */
public class ArticlesAdapter extends ArrayAdapter<Article> {

    int mod;

    public ArticlesAdapter(Context context, int resource, ArrayList<Article> teams) {
        super(context, resource, teams);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        int resource = R.layout.single_item;
        if (position % 2 == 0)
            resource = R.layout.double_item;
        if (position == getCount()-1 && mod == 1)
            resource = R.layout.single_item;

        if (view == null || view.getTag() != resource)
        {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(resource, null);
            view.setTag(resource);
        }

        TextView tv1 = (TextView)view.findViewById(R.id.textView1);
        ImageView iv1 = (ImageView)view.findViewById(R.id.imageView1);

        int index1 = (position * 3 / 2) + (position * 3) % 2;
        Article article1 = getItem(index1);

        tv1.setText(article1.getDesc());
        iv1.setImageResource(article1.getImageUrl());

        if (resource == R.layout.double_item)
        {
            TextView tv2 = (TextView)view.findViewById(R.id.textView2);
            ImageView iv2 = (ImageView)view.findViewById(R.id.imageView2);

            int index2 = index1 + 1;
            Article article2 = getItem(index2);

            tv2.setText(article2.getDesc());
            iv2.setImageResource(article2.getImageUrl());
        }

        return view;
    }

    @Override
    public int getCount() {
        int count = super.getCount();
        mod = count % 3;
        count = count / 3 * 2;
        return count + (mod > 0 ? 1 : 0);
    }
}

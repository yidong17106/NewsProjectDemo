package com.example.projectdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.TreeSet;


/**
 * A simple {@link Fragment} subclass.
 */
public class friendsFragment extends Fragment {
    private String data[]={"小甜甜","刹那","Dedoioi","番茄姐","晨晨","小敏",
            "大熊","大美","呦呦奶奶","笑笑笑脸","橘子","Fac","07","jiaDe","脸大不是错",};
    String nData[];
    private ListView listView;
    MyAdapter adapter;

    public friendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View addressView = inflater.inflate(R.layout.fragment_friends, container,false);
        sortIndex();
        listView = (ListView) addressView.findViewById(R.id.listView1);
        adapter = new MyAdapter();
        listView.setAdapter(adapter);
        return addressView;
    }
    public void  sortIndex(){
        TreeSet<String> set=new TreeSet<String>();
        for (String string:data){
            set.add(String.valueOf(string.charAt(0)));
        }
        nData=new String[data.length+set.size()];
        int i=0;
        for (String string:set){
            nData[i]=string;
            i++;
        }
        System.arraycopy(data,0,nData,set.size(),data.length);
        Arrays.sort(nData, String.CASE_INSENSITIVE_ORDER);
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return nData.length;
        }

        @Override
        public Object getItem(int position) {
            return nData[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            String item=nData[position];
            if (item.length()==1){
                convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.addresslist_index,null);
            }
            else {
                convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.addresslist_item,null);

            }
            TextView tv=(TextView)convertView.findViewById(R.id.textView1);
            tv.setText(item);

            return convertView;
        }
    }
}



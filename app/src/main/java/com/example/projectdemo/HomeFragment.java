package com.example.projectdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private ViewFlipper viewFlipper;
    private int[]picData;
    private List<Map<String, Object>> mylistList;
    private SimpleAdapter mysimAdapter;
    private ListView listView;
    private TextView tv_car,tv_news,tv_js;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tv_car=(TextView)view.findViewById(R.id.tv_car);
        tv_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),CarActivity.class);
                startActivity(intent);
            }
        });

        tv_news=(TextView)view.findViewById(R.id.tv_news);
        tv_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),NewsActivity.class);
                startActivity(intent);
            }
        });
        tv_js=(TextView)view.findViewById(R.id.tv_js);
        tv_js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),JsActivity.class);
                startActivity(intent);
            }
        });



        picData=new int []{R.drawable.news_1,R.drawable.news_2,R.drawable.news_3,R.drawable.nesw_4,R.drawable.news_5};
        viewFlipper=(ViewFlipper)view.findViewById(R.id.vf_video);
        for (int i=0;i<picData.length;i++){
            ImageView imageView=new ImageView(getContext());
            imageView.setImageResource(picData[i]);
            viewFlipper.addView(imageView);
        }

        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();

        mylistList = new ArrayList<Map<String, Object>>();
        Map<String,Object> m1=new HashMap<String, Object>();
        m1.put("logo",R.drawable.home_new1);
        m1.put("title","韩媒热议双宋离婚指宋慧乔“出轨” 网友：一大早被吓到");
        mylistList.add(m1);

        Map<String,Object> m2=new HashMap<String, Object>();
        m2.put("logo",R.drawable.home_new2);
        m2.put("title","不到40万的平民超跑，275马力+8AT，比野马名气更大");
        mylistList.add(m2);

        Map<String,Object> m3=new HashMap<String, Object>();
        m3.put("logo",R.drawable.home_new3);
        m3.put("title","华盛顿的彻底失败！俄罗斯宣布首批S400防空导弹将开始交付土");
        mylistList.add(m3);

        Map<String,Object> m4=new HashMap<String, Object>();
        m4.put("logo",R.drawable.home_new4);
        m4.put("title","李沁深夜飞国外当伴娘 穿t恤牛仔裤又美又飒 ");
        mylistList.add(m4);


        Map<String,Object> m5=new HashMap<String, Object>();
        m5.put("logo",R.drawable.home_new5);
        m5.put("title","高招会上“孤独的清华北大”引网友热议 ");
        mylistList.add(m5);



        Map<String,Object> m6=new HashMap<String, Object>();
        m6.put("logo",R.drawable.home_new6);
        m6.put("title","刘昊然方回应未能如期毕业:完成手头工作后去补课");
        mylistList.add(m6);



        mysimAdapter = new SimpleAdapter(getContext(), mylistList, R.layout.home_list,
                new String[]{"logo", "title" }, new int[]{R.id.im_rc_logo, R.id.tv_rc_title});
        listView = (ListView) view.findViewById(R.id.lv_home_news);
        listView.setAdapter(mysimAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(getContext(),NewsActivity.class);
                    startActivity(intent);
                }

                if (position==1){
                    Intent intent=new Intent(getContext(),CarActivity.class);
                    startActivity(intent);
                }
                if (position==2){
                    Intent intent=new Intent(getContext(),JsActivity.class);
                    startActivity(intent);
                }


            }
        });


        return view;

    }

}

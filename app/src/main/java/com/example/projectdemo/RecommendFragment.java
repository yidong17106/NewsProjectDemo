package com.example.projectdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {
    private ImageView rc_login;
    private Button btn_find;
    private EditText ed;
    private TextView tv_title, tv_date, tv_rc_author_name;
    private ImageView img_1, img_2;

    List<Map<String,Object>> myList;
    SimpleAdapter simpleAdapter;
    private ListView lv_product;
    private SwipeRefreshLayout swrfreshlayout;


    public RecommendFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);

        btn_find = (Button) view.findViewById(R.id.btn_find);
        ed = (EditText) view.findViewById(R.id.ed);
        tv_title = (TextView) view.findViewById(R.id.tv_rc_title);
        tv_date = (TextView) view.findViewById(R.id.tv_rc_date);
        tv_rc_author_name = (TextView) view.findViewById(R.id.tv_rc_author_name);
        img_1 = (ImageView) view.findViewById(R.id.img_1);
        img_2 = (ImageView) view.findViewById(R.id.img_2);
        rc_login = (ImageView) view.findViewById(R.id.rc_login);
        lv_product = (ListView)view.findViewById(R.id.lv_product);
        swrfreshlayout = (SwipeRefreshLayout)view.findViewById(R.id.swrfreshlayout);

        rc_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String news = "http://v.juhe.cn/toutiao/index?type=" + ed.getText().toString().trim() + "&key=7cb82d5e367fbf84016ddf990f25d3f1";
                GetNewsInfo(news);

            }
        });
        return view;
    }

    public void GetNewsInfo(final String url) {
        OkhttpUntil.enqueueGetrequest(url, Newsbean.class, new NetworkListining<Newsbean>() {
            @Override
            public void BackResultSuccess(Newsbean bean, int code) {
                try {
                    if (code == 200) {
                        tv_title.setText(bean.getResult().getData().get(0).getTitle());
                        tv_date.setText(bean.getResult().getData().get(0).getDate());
                        tv_rc_author_name.setText(bean.getResult().getData().get(0).getAuthor_name());
                        tv_title.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), Main2Activity.class);
                                intent.putExtra("url", bean.getResult().getData().get(0).getUrl());
                                startActivity(intent);
                            }
                        });

                        Glide.with(getActivity()).load(bean.getResult().getData().get(0).getThumbnail_pic_s()).into(img_1);

                        Glide.with(getActivity()).load(bean.getResult().getData().get(0).getThumbnail_pic_s02()).into(img_2);




                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void BackResultFail(Exception errow) {
                Toast.makeText(getActivity(), "请输入正确的查询内容", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void tostring(String responseString) {

            }
        });

        int[] imgs = new int[]{R.drawable.new_1, R.drawable.new_2,
                R.drawable.new_3, R.drawable.news_4,
                R.drawable.news_6, R.drawable.news_7};

        String[] title = new String[]{"预计KD需休养8-12个月","习近平晚会见吉尔吉斯斯坦总统","章莹颖案作案细节被披露",
                "香港主流民意支持特区修订《逃犯条例》","在印度，高考作弊有多简单","轻松一刻：妹子当心！"};
        String[] content = new String[]{"超级球星凯文-杜兰特宣布遭遇跟腱断裂，并已经成功接收手术...",
                "新华社比什凯克6月12日电(记者胡晓光　李志晖)","中新社休斯敦6月12日电 中国访问学者章莹颖被绑架致死案12日上午9时....."
        ,"原标题：综述：香港主流民意支持特区修订...","作弊这件事，似乎离中国考生有些遥远毕竟，但凡正经一点的考试场合.....",
        "正所谓“一日不见如隔三秋”，这21秋过去了，不知道各位金主爸爸们假期过得可好...."};
        myList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < title.length; i++){
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("logo",imgs[i]);
            map1.put("title",title[i]);
            map1.put("content",content[i]);
            myList.add(map1);
        }
        for (int i = 0; i < title.length; i++){
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("logo",imgs[i]);
            map1.put("title",title[i]);
            map1.put("content",content[i]);
            myList.add(map1);
        }

        simpleAdapter = new SimpleAdapter(getActivity(), myList, R.layout.news_item, new String[]{"logo", "content", "title"}, new int[]{R.id.img_logo, R.id.tv_content, R.id.tv_title});
        lv_product.setAdapter(simpleAdapter);
        lv_product.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"Hello",Toast.LENGTH_SHORT).show();
            }
        });

        swrfreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myList.clear();
                int[] imgs1 = new int[]{R.drawable.carlkss,R.drawable.car_polo,R.drawable.car_aodi,
                        R.drawable.car_byd,R.drawable.car_sy};
                String[] contents = new String[]{"网易汽车6月13日报道 6月11日，雷克萨斯刚刚在华累计销量突破100万台。随后其官方宣布推出两款限量版.....",
                        "网易汽车6月12日报道 上汽大众全新一代Polo Plus将于6月18日正式上市，新车取消了老款的入门车型安驾版.....",
                        "日前，全新一代奥迪A6 Allroad quattro在国内的路试谍照曝光，新车此前已经发布了官图，在海外市场只提供搭载3.0T V6 TDI发动机的柴油车型...",
                "比亚迪最新纯电动小型SUV车型S2将于6月17日正式上市。近日比亚迪公布了S2的部分配置信息，据了解，新车将推出智、耀、创三款车型....",
                "每年的3-4月是新车集中爆发的时期，今年也不例外，东风本田全新紧凑车--享域将在4月迎来自己的上市时刻。事实上....."};
                String[]  titles= new String[]{"39.4-43.8万 雷克萨斯推两款百万限量版车型",
                        "能选装Beats音箱 Polo Plus中配车型配置曝光",
                        "有望年底上市 全新A6 Allroad国内路试曝光",
                "将推三款车型 比亚迪S2部分配置信息曝光",
                        "新时代的搅局者？解读东风本田享域"};
                for (int i = 0; i < titles.length; i++){
                    Map<String,Object> map1 = new HashMap<String, Object>();
                    map1.put("logo",imgs1[i]);
                    map1.put("title",titles[i]);
                    map1.put("content",contents[i]);
                    myList.add(map1);
                }
                simpleAdapter.notifyDataSetChanged();
                swrfreshlayout.setRefreshing(false);

            }
        });
    }

    }






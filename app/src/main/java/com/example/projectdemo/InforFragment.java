package com.example.projectdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class InforFragment extends Fragment {
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> list;
    public InforFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_infor, container, false);
        list=new ArrayList<Map<String, Object>>();
        Map<String, Object> m1=new HashMap<String, Object>();
        m1.put("logo",R.drawable.pic_1);
        m1.put("title","大王");
        m1.put("content","此人很懒什么都没留下.....");
        list.add(m1);

        Map<String, Object> m2=new HashMap<String, Object>();
        m2.put("logo",R.drawable.pic_2);
        m2.put("title","小敏");
        m2.put("content","自律。。。。");
        list.add(m2);

        Map<String, Object> m3=new HashMap<String, Object>();
        m3.put("logo",R.drawable.pic_3);
        m3.put("content","此人很懒什么都没留下.....");
        m3.put("title","番茄姐");
        list.add(m3);

        Map<String, Object> m4=new HashMap<String, Object>();
        m4.put("logo",R.drawable.pic_4);
        m4.put("content","此人很懒什么都没留下.....");
        m4.put("title","晨晨");
        list.add(m4);

        Map<String, Object> m5=new HashMap<String, Object>();
        m5.put("logo",R.drawable.pic_5);
        m5.put("content","好好享受周围的美好风景。。。");
        m5.put("title","刹那");
        list.add(m5);

        Map<String, Object> m6=new HashMap<String, Object>();
        m6.put("logo",R.drawable.pic_6);
        m6.put("content","此人很懒什么都没留下.....");
        m6.put("title","小小小甜甜");
        list.add(m6);

        Map<String, Object> m7=new HashMap<String, Object>();
        m7.put("logo",R.drawable.pic_7);
        m7.put("content","此人很懒什么都没留下.....");
        m7.put("title","Dicped");
        list.add(m7);

        Map<String, Object> m8=new HashMap<String, Object>();
        m8.put("logo",R.drawable.pic_8);
        m8.put("content","此人很懒什么都没留下.....");
        m8.put("title","笑笑笑脸");
        list.add(m8);

        Map<String, Object> m9=new HashMap<String, Object>();
        m9.put("logo",R.drawable.pic_9);
        m9.put("content","此人很懒什么都没留下.....");
        m9.put("title","大美");
        list.add(m9);

        Map<String, Object> m10=new HashMap<String, Object>();
        m10.put("logo",R.drawable.pic_10);
        m10.put("content","此人很懒什么都没留下.....");
        m10.put("title","呦呦奶奶");
        list.add(m10);

        Map<String, Object> m11=new HashMap<String, Object>();
        m11.put("logo",R.drawable.news_6);
        m11.put("content","此人很懒什么都没留下.....");
        m11.put("title","遛遛");
        list.add(m11);

        Map<String, Object> m12=new HashMap<String, Object>();
        m12.put("logo",R.drawable.car_byd);
        m12.put("content","此人很懒什么都没留下.....");
        m12.put("title","biyadi");
        list.add(m12);

        Map<String, Object> m13=new HashMap<String, Object>();
        m13.put("logo",R.drawable.car_aodi);
        m13.put("content","此人很懒什么都没留下.....");
        m13.put("title","奥迪小伙子");
        list.add(m13);



         simpleAdapter=new SimpleAdapter(getActivity(),list,R.layout.infor,
                new String[]{"logo","content","title"},
                new int[]{R.id.chat_iv,R.id.tv_context,R.id.tv_name});
        listView=(ListView)view.findViewById(R.id.list_chat_item);
        listView.setAdapter(simpleAdapter);
        registerForContextMenu(listView);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
         return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v==listView){
            int i=((AdapterView.AdapterContextMenuInfo)menuInfo).position;
            menu.setHeaderTitle(list.get(i).get("title")+"的信息");
            menu.add(0,1,0,"详细");
            menu.add(0,2,0,"删除");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int i=((AdapterView.AdapterContextMenuInfo)item.getMenuInfo()).position;

        switch (item.getItemId()){
            case 1:
                Toast.makeText(getActivity(),"当前是"+list.get(i).get("title")+"的信息", Toast.LENGTH_LONG).show();
                break;
            case 2:
              list.remove(i);
                simpleAdapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }
}



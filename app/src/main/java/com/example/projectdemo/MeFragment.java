package com.example.projectdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    private ImageView img_login;
    private ImageView  img_friends,img_pic;
    private TextView   tv_more;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=  inflater.inflate(R.layout.fragment_me, container, false);
        img_login=(ImageView)view.findViewById(R.id.img_login);
        img_pic=(ImageView)view.findViewById(R.id.img_pic);
        img_friends=(ImageView) view.findViewById(R.id.img_friends);
       // tv_more=(TextView) view.findViewById(R.id.tv_more);

       /* tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),DwActivity.class);
                startActivity(intent);
            }
        });*/



        img_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),friendsActivity.class);
                startActivity(intent);
            }
        });


        img_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PicActivity.class);
                startActivity(intent);
            }
        });


        img_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}

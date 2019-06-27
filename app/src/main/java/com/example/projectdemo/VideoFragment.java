package com.example.projectdemo;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
  private VideoView vv_1,vv_2,vv_3;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_video, container, false);

        vv_1 = (VideoView)view.findViewById(R.id.vv_1);
        vv_2 = (VideoView)view.findViewById(R.id.vv_2);
        vv_3 = (VideoView)view.findViewById(R.id.vv_3);
        playVideo1();
        playVideo2();
        playVideo3();

             return view;
    }

    public void playVideo1() {
        String uri = "https://vd4.bdstatic.com/mda-jfrpszbmmzpvm2d5/sc/mda-jfrpszbmmzpvm2d5.mp4?auth_key=1561628786-0-0-50456c1566244a7203bc73e6318d2a34&bcevod_channel=searchbox_feed&pd=bjh&abtest=all";
        if (uri != null) {
            vv_1.setVideoURI(Uri.parse(uri
            ));
            vv_1.setMediaController(new MediaController(getActivity()));

        } else {
            vv_1.getBackground().setAlpha(0);

        }

    }

    public void playVideo2() {
        String uri = "https://vd2.bdstatic.com/mda-jfsm0dz2srx20ve0/sc/mda-jfsm0dz2srx20ve0.mp4?auth_key=1561629363-0-0-ccafdb61261a50fcf9c274856d219e61&bcevod_channel=searchbox_feed&pd=bjh&abtest=all";
        if (uri != null) {
            vv_2.setVideoURI(Uri.parse(uri
            ));
            vv_2.setMediaController(new MediaController(getActivity()));

        } else {
            vv_2.getBackground().setAlpha(0);

        }
    }
    public void playVideo3() {
        String uri = "https://vd4.bdstatic.com/mda-jevqww8tjxehg4r1/sc/mda-jevqww8tjxehg4r1.mp4?"
                + "auth_key=1561629411-0-0-cb9acb3b5ca68631e34831051e267b41&bcevod_channel=searchbox_feed&pd=unknown&abtest=all";
        if (uri != null) {
            vv_3.setVideoURI(Uri.parse(uri
            ));
            vv_3.setMediaController(new MediaController(getActivity()));

        } else {
            vv_3.getBackground().setAlpha(0);

        }

    }
}

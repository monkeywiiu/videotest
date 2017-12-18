package com.example.videotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.zmenu.PUtils;

import java.util.LinkedHashMap;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {

    public JZVideoPlayerStandard jzVideoPlayerStandard;
    public LinkedHashMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PUtils.getInstance().setVisible(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new LinkedHashMap();
        map.put("高清", "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=62670&editionType=high&source=aliyun");
        map.put("标清", "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=62670&editionType=normal&source=aliyun");

        Object[] objects = new Object[1];
        objects[0] = map;
        jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp(objects, 1, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "shipin");
        Glide.with(this).load("http://img.kaiyanapp.com/164fba033ba9698488d2a62" +
                "289c31a20.png?imageMogr2/quality/60/format/jpg").into(jzVideoPlayerStandard.thumbImageView);

    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}

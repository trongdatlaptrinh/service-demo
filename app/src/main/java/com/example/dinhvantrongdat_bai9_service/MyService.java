package com.example.dinhvantrongdat_bai9_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mymusic;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
//    Gọi hàm onCreate để tạo đối tượng service quản lý


    @Override
    public void onCreate() {
        super.onCreate();
        mymusic = MediaPlayer.create(MyService.this,R.raw.breakbeat);
        mymusic.setLooping(true);
    }

//    Gọi hàm onStartCommand để khởi chạy đối tượng mà service quản lý


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mymusic.isPlaying()){
            mymusic.pause();
        }
        else {
            mymusic.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

//    Gọi hàm onDestroy để dừng đối tượng mà service quản lý


    @Override
    public void onDestroy() {
        super.onDestroy();
        mymusic.stop();
    }
}
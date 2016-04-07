package com.example.josh.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity
    implements View.OnClickListener
{
    private String GOOGLE_API_KEY   ="AIzaSyB54raZ2K6EQS87bZerLb_io9OALQ7V64A";
    // From Youtube video URL
    private String YOUTUBE_VIDEO_ID = "ss9ygQqqL2Q";
    // From Youtube vido playlist URL
    private String YOUTUBE_PLAYLIST = "PLZe8lUNqIvyF4Hw5x77elv6ZuPcEgPIoL";
    private Button btnPlayVideo;
    private Button btnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button) findViewById(R.id.btnPlayList);

        // implements onClick method
        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);


    }

    @Override
    // v is either btnPlayVideo or btnPlaylist
    public void onClick(View v)
    {
        // Operation to be peformed
        Intent intent = null;

        // Assigns the value of intent depending on which button was pressed (playlist or video)
        switch (v.getId())
        {
            case(R.id.btnPlayVideo):
                intent = YouTubeStandalonePlayer.createVideoIntent(this,GOOGLE_API_KEY,YOUTUBE_VIDEO_ID);
                break;

            case(R.id.btnPlayList):
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YOUTUBE_PLAYLIST);
                break;

            default:
        }// End switch

        // Starts youtube player with if intent has been assigned a value from the switch statement
        if(intent != null)
        {
            startActivity(intent);
        }
    }
}

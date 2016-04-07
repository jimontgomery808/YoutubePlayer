package com.example.josh.youtubeplayer;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
    implements YouTubePlayer.OnInitializedListener
{
    private String GOOGLE_API_KEY ="AIzaSyB54raZ2K6EQS87bZerLb_io9OALQ7V64A";
    private String YOUTUBE_VIDEO_ID = "ss9ygQqqL2Q";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        //Forms a link to youtube layout
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        // Initializes youtube playter
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    /*
    Added using generate code...defines methods implemented from YouTubePlayer
     */
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored)
    {
        Toast.makeText(this, "Initialized Youtube Player Successfully", Toast.LENGTH_LONG);

        // Sets up listeners and cues up video
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored)
        {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }

    // Methods that will be called back depending on state of video
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener()
    {
        @Override
        public void onPlaying()
        {
            Toast.makeText(YoutubeActivity.this, "Good, video is playing", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused()
        {
            Toast.makeText(YoutubeActivity.this, "Video has paused", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onStopped()
        {

        }

        @Override
        public void onBuffering(boolean b)
        {

        }

        @Override
        public void onSeekTo(int i)
        {

        }
    };

    YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener()
    {
        @Override
        public void onLoading()
        {

        }

        @Override
        public void onLoaded(String s)
        {

        }

        @Override
        public void onAdStarted()
        {
            Toast.makeText(YoutubeActivity.this, "Click Ad now, make the video creator rich", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onVideoStarted()
        {
            Toast.makeText(YoutubeActivity.this, "Video has started", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onVideoEnded()
        {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason)
        {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult)
    {
        Toast.makeText(this, "Failed to Initialize Youtube Player", Toast.LENGTH_LONG);
    }
}

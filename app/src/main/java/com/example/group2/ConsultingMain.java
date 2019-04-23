package com.example.group2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

//Extending to the YouTubeBaseActivity to run the YouTubeAPI
public class ConsultingMain extends YouTubeBaseActivity {
    private static final String TAG = "Consulting Info Screen";

    private TextView titleText;
    YouTubePlayerView mYoutuberPlayerView;
    Button playVideoBtn;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulting_main);

        playVideoBtn = findViewById(R.id.playVideoBtn);
        mYoutuberPlayerView = findViewById(R.id.youtubeView);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "Successful Initialisation");
                //Loading the specific Consulting Video
                youTubePlayer.loadVideo("3wPeND2gvqc");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "Failed Initialisation");
            }
        };

        //Responding to the Play Button
        playVideoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "Initialising the YouTube Player");
                mYoutuberPlayerView.initialize(YoutubeAPIHolder.getApiKey(), mOnInitializedListener);
            }
        });

    }
}

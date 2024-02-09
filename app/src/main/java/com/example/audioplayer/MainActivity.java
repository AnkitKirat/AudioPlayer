package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button button,button2,button3;

    String [] arr={"https://tworedcrayons.com/songs/And%20We%20Danced.mp3","https://tworedcrayons.com/songs/Billie%20Jean.mp3","https://tworedcrayons.com/songs/Bottoms%20Up.mp3"};

    MediaPlayer mediaPlayer= new MediaPlayer();
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        seekBar = findViewById(R.id.seekBar);
/// for 1st song

            try {
                mediaPlayer.setDataSource(arr[0]);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();

                    seekBar.setMax(mediaPlayer.getDuration());
                    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            if (b) {
                                mediaPlayer.seekTo(i);
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });

                }
            });


            mediaPlayer.prepareAsync();






            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (button.getText() == "Pause") {
                        mediaPlayer.pause();
                        button.setText("Play");
                    } else {
                        mediaPlayer.pause();
                        mediaPlayer.reset();
                        try {
                            mediaPlayer.setDataSource(arr[0]);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        button.setText("Pause");
                        button2.setText("Play 2nd Song");
                        button3.setText("Play 3rd Song");
                        mediaPlayer.prepareAsync();
                    }
                }
            });



            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (button2.getText() == "Pause") {
                        mediaPlayer.pause();
                        button2.setText("Play");
                    } else {
                        mediaPlayer.pause();
                        mediaPlayer.reset();
                        try {
                            mediaPlayer.setDataSource(arr[1]);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        button2.setText("Pause");
                        button.setText("Play 1st Song");
                        button3.setText("Play 3rd Song");
                        mediaPlayer.prepareAsync();
                    }
                }
            });


            button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button3.getText() == "Pause") {
                    mediaPlayer.pause();
                    button3.setText("Play");
                } else {
                    mediaPlayer.pause();
                    mediaPlayer.reset();
                    try {
                        mediaPlayer.setDataSource(arr[2]);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    button3.setText("Pause");
                    button2.setText("Play 2nd Song");
                    button.setText("Play 1st Song");
                    mediaPlayer.prepareAsync();
                }
            }
        });

    }


}

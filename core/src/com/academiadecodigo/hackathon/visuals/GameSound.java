package com.academiadecodigo.hackathon.visuals;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
public class GameSound {

    private Music gameMusic;
    private Music battleSound;

    public GameSound(){
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/bestFriend8bit.wav"));
        battleSound = Gdx.audio.newMusic(Gdx.files.internal("sound/8bit Chiptune Eye of the Tiger.wav"));

    }

    public void gameMusic(){
        gameMusic.setLooping(true);
        gameMusic.play();
    }

    public void pauseGameMusic(){
        gameMusic.pause();
    }

    public void stopGameMusic(){
        gameMusic.stop();
    }

    public void lowGameMusicVolume(){
        gameMusic.setVolume(0.33f);
    }

    public void mediumGameMusicVolume(){
        gameMusic.setVolume(0.66f);
    }

    public void battleMusic(){
        battleSound.play();
        battleSound.setLooping(true);
    }

    public void pauseBattleMusic(){
        battleSound.pause();
    }

    public void lowBattleMusicVolume(){
        battleSound.setVolume(0.33f);
    }

    public void mediumBattleMusicVolume(){
        battleSound.setVolume(0.66f);
    }

}

package com.academiadecodigo.hackathon.utilities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class GameSound {

    private Music gameMusic;
    private Music battleMusic;

    public GameSound(){
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/bestFriend8bit.wav"));
        battleMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/8bit Chiptune Eye of the Tiger.wav"));

    }

    public void gameMusic(){
        gameMusic.play();
        gameMusic.setLooping(true);
    }

    public void pauseGameMusic(){
        gameMusic.pause();
    }

    public void stopGameMusic(){
        gameMusic.stop();
    }

    public void lowGameMusicVolume(){
        gameMusic.setVolume(0.1f);
    }

    public void mediumGameMusicVolume(){
        gameMusic.setVolume(0.6f);
    }

    public void battleMusic(){
        battleMusic.play();
        battleMusic.setLooping(true);
    }

    public void stopBattleMusic(){
        battleMusic.stop();
    }

    public void pauseBattleMusic(){
        battleMusic.pause();
    }

    public void lowBattleMusicVolume(){
        battleMusic.setVolume(0.2f);
    }

    public void mediumBattleMusicVolume(){
        battleMusic.setVolume(0.6f);
    }

    public void muteGameMusicVolume() {
        gameMusic.setVolume(0);
    }

    public void muteBattleMusicVolume() {
        battleMusic.setVolume(0);
    }


}

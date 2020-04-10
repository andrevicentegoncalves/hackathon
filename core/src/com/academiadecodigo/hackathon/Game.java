package com.academiadecodigo.hackathon;

import com.academiadecodigo.hackathon.battle.Battle;
import com.academiadecodigo.hackathon.chars.JabberWeak;
import com.academiadecodigo.hackathon.chars.Person;
import com.academiadecodigo.hackathon.chars.Protagonist;
import com.academiadecodigo.hackathon.view.BattleView;
import com.academiadecodigo.hackathon.view.GameView;
import com.academiadecodigo.hackathon.utilities.GameSound;
import com.academiadecodigo.hackathon.visuals.TopDownCamera;
import com.academiadecodigo.hackathon.world.Coord;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Game extends ApplicationAdapter {
	private Texture img;
	private TiledMap tiledMap;
	private OrthographicCamera camera;
	private TiledMapRenderer tiledMapRenderer;
	private SpriteBatch sb;
	private Texture player;
	private Sprite sprite;

	private TopDownCamera topDownCamera;
	private GameSound sound;

	private Screen screenWorld;
	private Screen screenBattle;
	private Screen activeScreen;

	private WorldLogic worldLogic;
	private boolean runWorldLogic;

	private BattleLogic battleLogic;
	private boolean runBattleLogic;

	private BitmapFont font;


	@Override
	public void create () {

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		camera.update();
		tiledMap = new TmxMapLoader().load("sprites/map.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

		topDownCamera = new TopDownCamera(this, camera, tiledMap);
		Gdx.input.setInputProcessor(topDownCamera);

		sb = new SpriteBatch();
		player = new Texture(Gdx.files.internal("player-right-2.png"));
		sprite = new Sprite(player);

		sprite.translate(300, 160);
		Coord playerPos = new Coord(10,5);

		font = new BitmapFont();
		font.setColor(Color.BLACK);

		worldLogic = new WorldLogic(); //Summoned on walking around?
		worldLogic.setPlayerPosition(playerPos);
		battleLogic = new BattleLogic(new Battle(new Protagonist(), JabberWeak.genWeakJabber()) , this); //Summoned on combat

		screenBattle = new BattleView(this, battleLogic, sb, font);
		screenWorld = new GameView(this, worldLogic, camera,tiledMapRenderer,sprite,sb);

		sound = new GameSound();
		sound.gameMusic();


		topDownCamera.setActiveOverworld(true);
		topDownCamera.setActiveBattle(false);
		runWorldLogic = false;
		runBattleLogic = true;
		swapLogic();

		camera.translate(258,258);
		playerPos.setX(playerPos.getX()+8);
		playerPos.setY(playerPos.getY()+8);


	}

	@Override
	public void render () {

		if(runWorldLogic) {

			setScreen(screenWorld);
			activeScreen.render(1);
			//activeScreen.render(1);
			sound.stopBattleMusic();
			sound.gameMusic();
			sound.lowGameMusicVolume();



		}

		if(runBattleLogic) { //Doing battle stuff!

			setScreen(screenBattle);
			activeScreen.render(1);
			//activeScreen.render(1);
			sound.stopGameMusic();
			sound.battleMusic();
			sound.lowBattleMusicVolume();

			//runBattleLogic = false;
			//runWorldLogic = true;

		}

	}

	@Override
	public void dispose () {
	}


	public void triggerBattle() {
		topDownCamera.setActiveOverworld(false);
		topDownCamera.setActiveBattle(true);

		swapLogic();
		//Do the switch thing here
		setScreen(screenBattle);

	}

	public void finishBattle() {
		topDownCamera.setActiveOverworld(true);
		topDownCamera.setActiveBattle(false);

		battleLogic.getScenario().getPlayer().setHpMax(35);
		battleLogic.getScenario().getPlayer().setHp(battleLogic.getScenario().getPlayer().getHpMax());
		battleLogic.getScenario().setEnemy(JabberWeak.genWeakJabber());

		swapLogic();
		//Do the switch thing here
		setScreen(screenWorld);
	}

	public void setScreen(Screen screen) {
		this.activeScreen = screen;
	}

	public void swapLogic() {
		runWorldLogic = !runWorldLogic;
		runBattleLogic = !runBattleLogic;
	}

	public WorldLogic getWorldLogic() {
		return worldLogic;
	}

	public BattleLogic getBattleLogic() {
		return battleLogic;
	}
}

package com.academiadecodigo.hackathon;

import com.academiadecodigo.hackathon.view.BattleView;
import com.academiadecodigo.hackathon.view.GameView;
import com.academiadecodigo.hackathon.visuals.GameSound;
import com.academiadecodigo.hackathon.visuals.TopDownCamera;
import com.academiadecodigo.hackathon.world.Coord;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

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
	Screen screen;

	private WorldLogic worldLogic;
	private boolean runWorldLogic;

	private BattleLogic battleLogic;
	private boolean runBattleLogic;


	@Override
	public void create () {

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		camera.update();
		tiledMap = new TmxMapLoader().load("sprites alt/map.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

		topDownCamera = new TopDownCamera(this, camera, tiledMap);
		Gdx.input.setInputProcessor(topDownCamera);

		sb = new SpriteBatch();
		player = new Texture(Gdx.files.internal("player.png"));
		sprite = new Sprite(player);

		sprite.translate(320, 160);
		Coord playerPos = new Coord(10,5);


		topDownCamera.setActiveOverworld(true);
		runWorldLogic = true;
		worldLogic = new WorldLogic();
		worldLogic.setPlayerPosition(playerPos);

		sound = new GameSound();
		sound.gameMusic();

		runWorldLogic = false;
		runBattleLogic = true;


	}

	@Override
	public void render () {

		if(runWorldLogic) {
			/*
			Gdx.gl.glClearColor(1, 0, 0, 1);
			Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			camera.update();
			tiledMapRenderer.setView(camera);
			tiledMapRenderer.render();

			sb.begin();
			sprite.draw(sb);
			sb.end();

			 */
			setScreen(new GameView(this, camera,tiledMapRenderer,sprite,sb));
			screen.render(1);
			sound.stopBattleMusic();
			sound.gameMusic();

			/*runWorldLogic = false;
			runBattleLogic = true;

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();*/
		}

		if(runBattleLogic) {
			setScreen(new BattleView(this));
			screen.render(1);
			sound.stopGameMusic();
			sound.battleMusic();

			runBattleLogic = false;
			runWorldLogic = true;

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			render();
		}

	}

	@Override
	public void dispose () {
	}


	public void triggerBattle() {
		topDownCamera.setActiveOverworld(false);
		runWorldLogic = false;
		topDownCamera.setActiveBattle(true);
		runBattleLogic = true;
		//Do the switch thing here

	}

	public void finishBattle() {
		topDownCamera.setActiveOverworld(true);
		runWorldLogic = true;
		topDownCamera.setActiveBattle(false);
		runBattleLogic = false;
		//Do the switch thing here

	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

}

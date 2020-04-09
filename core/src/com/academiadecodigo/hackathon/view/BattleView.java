package com.academiadecodigo.hackathon.view;

import com.academiadecodigo.hackathon.BattleLogic;
import com.academiadecodigo.hackathon.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class BattleView implements Screen {

    private final Game game;
    //private Texture img;
    private Rectangle player;
    private SpriteBatch sb;
    private BitmapFont font;
    private ShapeRenderer sp;

    private Texture background;

    private Texture playerTexture;
    private Texture enemyTexture;

    private BattleLogic logic;

    public BattleView(final Game game, BattleLogic logic, SpriteBatch sb, BitmapFont font) {
        this.game = game;
        this.sb = sb;
        this.font = font;
        sp = new ShapeRenderer();

        this.logic = logic;

        playerTexture = new Texture(Gdx.files.internal("tempAssets/battle-player.png"));
        enemyTexture = new Texture(Gdx.files.internal("tempAssets/old-dude.png"));
        //playerSprite = new Sprite(playerTexture);

        background = new Texture(Gdx.files.internal("tempAssets/City4.png"));
        //backSprite = new Sprite()


    }

    @Override
    public void show() {

        player = new Rectangle();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Attack box
        sp.begin(ShapeRenderer.ShapeType.Filled);
        sp.setColor(Color.WHITE);
        sp.rect(0,0,640,60);
        sp.end();

        sp.begin(ShapeRenderer.ShapeType.Line);
        sp.setColor(Color.BLACK);
        sp.rect(3,3,634,54);
        sp.end();

        sb.begin();
        sb.draw(background,0,60,640,240);
        sb.end();

        sb.begin();
        font.draw(sb, (logic.getScenario().getPlayer().getMoves().size() >= 1 ?
                "1 -  " + logic.getScenario().getPlayer().getMove(0).getName():
                "1 -  " + logic.getScenario().getPlayer().getMove(0).getName()
            ),20,50);
        font.draw(sb, (logic.getScenario().getPlayer().getMoves().size() >= 2 ?
                "2 -  " + logic.getScenario().getPlayer().getMove(1).getName():
                "2 -  " + "<no move>"
            ),340,50);
        font.draw(sb, (logic.getScenario().getPlayer().getMoves().size() >= 3 ?
                "3 -  " + logic.getScenario().getPlayer().getMove(2).getName():
                "3 -  " + "<no move>"
            ),20,24);
        font.draw(sb, (logic.getScenario().getPlayer().getMoves().size() >= 4 ?
                "4 -  " + logic.getScenario().getPlayer().getMove(3).getName():
                "4 -  " + "<no move>"
            ),340,24);
        sb.end();

        sb.begin();
        sb.draw(playerTexture, 50, 80);
        sb.draw(enemyTexture, 450, 80);
        sb.end();

        //Status bar (player)
        sp.begin(ShapeRenderer.ShapeType.Filled);
        sp.setColor(Color.WHITE);
        sp.rect(0,70,160,30);
        sp.end();

        sp.begin(ShapeRenderer.ShapeType.Line);
        sp.setColor(Color.BLACK);
        sp.rect(3,73,156,24);
        sp.end();

        sb.begin();
        font.draw(
                sb,  String.valueOf(logic.getScenario().getPlayer().getHp()),10,92
        );
        sb.end();

        //Status bar (enemy)
        sp.begin(ShapeRenderer.ShapeType.Filled);
        sp.setColor(Color.WHITE);
        sp.rect(480,70,160,30);
        sp.end();

        sp.begin(ShapeRenderer.ShapeType.Line);
        sp.setColor(Color.BLACK);
        sp.rect(483,73,156,24);
        sp.end();

        sb.begin();
        font.draw(
                sb,  String.valueOf(logic.getScenario().getEnemy().getHp()),490,92
        );
        sb.end();

        //Message box
        sp.begin(ShapeRenderer.ShapeType.Filled);
        sp.setColor(Color.WHITE);
        sp.rect(0,300,640,60);
        sp.end();

        sp.begin(ShapeRenderer.ShapeType.Line);
        sp.setColor(Color.BLACK);
        sp.rect(3,303,634,54);
        sp.end();





    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

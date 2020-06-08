package com.mygdx.testproject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter implements InputProcessor {
    private final SpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera camera;
    private Box2DDebugRenderer b2dr;
    private World world;
    private Stage stage;

    public GameScreen(TestProject game) {
        batch = game.getBatch();
    }

    @Override
    public void show() {
        super.show();
        camera = new OrthographicCamera();
        viewport = new FitViewport(8f, 4.8f, camera);
        b2dr = new Box2DDebugRenderer();
        world = new World(new Vector2(0, -9.8f), false);
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        SampleBody body = new SampleBody(world);

        stage.addActor(body);
    }



    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(Gdx.graphics.getDeltaTime());

        viewport.apply();
        stage.draw();
        stage.act();
        b2dr.render(world, camera.combined);
    }

    private void update(float delta) {
        world.step(1 / 60f, 6, 2);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }



    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

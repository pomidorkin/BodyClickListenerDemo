package com.mygdx.testproject;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class SampleBody extends Actor {
    private World world;
    private Body body;

    public SampleBody(World world) {
        this.world = world;

        this.setSize(2f, 2f);

        body = createRubbishBox();
        addClickListener();
    }

    private void addClickListener() {
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Body touched"); // Call a function
            }
        });
    }

    public Body createRubbishBox(){

        Body box;
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.fixedRotation = false;
        bodyDef.position.set(2f, 1f);

        box = world.createBody(bodyDef);
        PolygonShape ps = new PolygonShape();
        ps.setAsBox(1f, 1f);

        FixtureDef fixDef = new FixtureDef();
        fixDef.shape = ps;
        fixDef.density = 0.05f;
        fixDef.friction = 1f;
        box.createFixture(fixDef).setUserData(this); // required for collision

        ps.dispose();

        return box;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        this.setRotation(body.getAngle()*  MathUtils.radiansToDegrees);
//        this.setPosition(body.getPosition().x-this.getWidth()/2,body.getPosition().y-this.getHeight()/2);
        this.setPosition(body.getPosition().x-this.getWidth()/2,body.getPosition().y-this.getHeight()/2);

    }
}

package io.asteroidsjaylib.score;

import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.physicscommon.PositionComponent;
import io.asteroidsjaylib.rendercommon.RenderTag;
import io.asteroidsjaylib.rendercommon.TextComponent;
import io.asteroidsjaylib.scorecommon.ScoreTag;

import static com.raylib.Colors.WHITE;

public class ScoreEntity extends BaseEntity {

    public ScoreEntity(){

        this.addComponent(new ScoreTag());

        TextComponent textComponent = new TextComponent("Score: ", 24, WHITE);
        this.addRenderComponent(textComponent, 0);
        this.addComponent(new RenderTag(100, true));

        this.addComponent(new PositionComponent(new Vector(10, 10)));

    }

}

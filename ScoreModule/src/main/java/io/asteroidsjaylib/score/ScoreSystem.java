package io.asteroidsjaylib.score;

import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.common.ecs.BaseComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.ecs.IteratingSystem;
import io.asteroidsjaylib.rendercommon.RenderTag;
import io.asteroidsjaylib.rendercommon.TextComponent;
import io.asteroidsjaylib.scorecommon.IncrementScoreEvent;
import io.asteroidsjaylib.scorecommon.ScoreTag;

import java.util.List;

public class ScoreSystem extends IteratingSystem {
    @Override
    public void start(World world) {
        world.getEventBus().subscribe(IncrementScoreEvent.class, this::handleIncrementScore);
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(ScoreTag.class);
    }

    private void handleIncrementScore(World world, IncrementScoreEvent incrementScoreEvent) {

        BaseEntity scoreEntity = world.getEntitiesWith(ScoreTag.class).getFirst();

        scoreEntity.getComponent(ScoreTag.class).orElseThrow().score += incrementScoreEvent.amount;

    }

    @Override
    public void processEntity(World world, BaseEntity entity, float deltaTime) {

        if(!entity.hasComponent(RenderTag.class)) return;

        RenderTag renderTag = entity.getComponent(RenderTag.class).orElseThrow();

        if(!renderTag.hasRenderComponent(TextComponent.class)) return;

        ScoreTag scoreTag = entity.getComponent(ScoreTag.class).orElseThrow();

        TextComponent textComponent = renderTag.getRenderComponent(TextComponent.class);
        textComponent.text = "Score: " + scoreTag.score;

    }
}

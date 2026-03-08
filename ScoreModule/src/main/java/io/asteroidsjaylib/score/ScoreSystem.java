package io.asteroidsjaylib.score;

import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.common.ecs.BaseComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.ecs.IteratingSystem;
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

        scoreEntity.getComponent(ScoreTag.class).score += incrementScoreEvent.amount;

    }

    @Override
    public void processEntity(World world, BaseEntity entity, double deltaTime) {
        if(!entity.hasRenderComponent(TextComponent.class)) return;

        ScoreTag scoreTag = entity.getComponent(ScoreTag.class);

        TextComponent textComponent = entity.getRenderComponent(TextComponent.class);
        textComponent.text = "Score: " + scoreTag.score;

    }
}

import io.asteroidsjaylib.background.BackgroundProvider;
import io.asteroidsjaylib.common.ecs.EntitySpi;

module Background {
    requires Common;
    requires RenderCommon;

    provides EntitySpi with BackgroundProvider;
}
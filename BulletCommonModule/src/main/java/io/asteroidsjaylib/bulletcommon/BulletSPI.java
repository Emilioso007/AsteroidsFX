package io.asteroidsjaylib.bulletcommon;

import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.util.Vector;

public interface BulletSPI {
    BaseEntity CreateBullet(BaseEntity owner, Vector startPosition, Vector velocity);
}

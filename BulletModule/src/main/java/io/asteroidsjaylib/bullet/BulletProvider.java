package io.asteroidsjaylib.bullet;

import io.asteroidsjaylib.bulletcommon.BulletSPI;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.util.Vector;

public class BulletProvider implements BulletSPI {

    @Override
    public BaseEntity CreateBullet(BaseEntity owner, Vector startPosition, Vector velocity) {
        return new BulletEntity(owner, startPosition, velocity);
    }
}

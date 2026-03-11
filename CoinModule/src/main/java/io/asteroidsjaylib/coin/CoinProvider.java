package io.asteroidsjaylib.coin;

import io.asteroidsjaylib.coincommon.CoinSPI;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.util.Vector;

public class CoinProvider implements CoinSPI {
    @Override
    public BaseEntity createCoin(Vector startPosition, Vector startVelocity, int value) {
        return new CoinEntity(startPosition, startVelocity, value);
    }
}

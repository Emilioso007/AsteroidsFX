package io.asteroidsjaylib.scorecommon;

import io.asteroidsjaylib.common.event.BaseEvent;

public class IncrementScoreEvent extends BaseEvent {

    public int amount;

    public IncrementScoreEvent(int amount){
        this.amount = amount;
    }
}

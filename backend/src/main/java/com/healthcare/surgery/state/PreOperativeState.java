package com.healthcare.surgery.state;

import com.healthcare.surgery.context.SurgeryContext;

public class PreOperativeState implements SurgeryState {

    @Override
    public void next(SurgeryContext context) {
        context.setPreOperativeReady(true);
        context.setState(new SurgeryStateImpl());
    }

    @Override
    public String getName() {
        return "Pre-Operative";
    }
}
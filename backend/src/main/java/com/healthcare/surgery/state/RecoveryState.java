package com.healthcare.surgery.state;

import com.healthcare.surgery.context.SurgeryContext;

public class RecoveryState implements SurgeryState {

    @Override
    public void next(SurgeryContext context) {
        context.setRecoveryStable(true);
        context.setState(new DischargedState());
    }

    @Override
    public String getName() {
        return "Recovery";
    }
}
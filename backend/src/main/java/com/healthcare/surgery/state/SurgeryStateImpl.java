package com.healthcare.surgery.state;

import com.healthcare.surgery.context.SurgeryContext;

public class SurgeryStateImpl implements SurgeryState {

    @Override
    public void next(SurgeryContext context) {
        context.setSurgerySuccessful(true);
        context.setState(new RecoveryState());
    }

    @Override
    public String getName() {
        return "Surgery";
    }
}
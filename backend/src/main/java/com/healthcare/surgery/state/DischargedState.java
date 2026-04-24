package com.healthcare.surgery.state;

import com.healthcare.surgery.context.SurgeryContext;

public class DischargedState implements SurgeryState {

    @Override
    public void next(SurgeryContext context) {
        // Final state, no transition
    }

    @Override
    public String getName() {
        return "Discharged";
    }
}
package com.healthcare.surgery.state;

import com.healthcare.surgery.context.SurgeryContext;

public class EvaluatedState implements SurgeryState {

    @Override
    public void next(SurgeryContext context) {
        context.setEvaluationApproved(true);
        context.setState(new PreOperativeState());
    }

    @Override
    public String getName() {
        return "Evaluated";
    }
}
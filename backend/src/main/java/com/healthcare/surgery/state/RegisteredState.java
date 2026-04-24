package com.healthcare.surgery.state;

import com.healthcare.surgery.context.SurgeryContext;

public class RegisteredState implements SurgeryState {

    @Override
    public void next(SurgeryContext context) {
        context.setState(new EvaluatedState());
    }

    @Override
    public String getName() {
        return "Registered";
    }
}
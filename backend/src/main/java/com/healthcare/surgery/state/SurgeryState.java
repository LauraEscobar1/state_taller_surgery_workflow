package com.healthcare.surgery.state;

import com.healthcare.surgery.context.SurgeryContext;

public interface SurgeryState {
    void next(SurgeryContext context);

    String getName();
}
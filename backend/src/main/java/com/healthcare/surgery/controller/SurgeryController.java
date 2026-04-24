package com.healthcare.surgery.controller;

import com.healthcare.surgery.context.SurgeryContext;
import com.healthcare.surgery.state.RegisteredState;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surgery")
@CrossOrigin
public class SurgeryController {

    private final SurgeryContext context = new SurgeryContext(new RegisteredState());

    @GetMapping("/state")
    public String getCurrentState() {
        return context.getCurrentState();
    }

    @GetMapping("/next")
    public String moveToNextStep() {
        context.nextStep();
        return context.getCurrentState();
    }
}
package com.healthcare.surgery.context;

import com.healthcare.surgery.state.SurgeryState;

public class SurgeryContext {

    private SurgeryState currentState;

    private boolean evaluationApproved;
    private boolean preOperativeReady;
    private boolean surgerySuccessful;
    private boolean recoveryStable;

    public SurgeryContext(SurgeryState initialState) {
        this.currentState = initialState;
    }

    public void setState(SurgeryState state) {
        System.out.println("Transitioning to: " + state.getName());
        this.currentState = state;
    }

    public void nextStep() {
        currentState.next(this);
    }

    public String getCurrentState() {
        return currentState.getName();
    }

    // Getters & Setters

    public boolean isEvaluationApproved() {
        return evaluationApproved;
    }

    public void setEvaluationApproved(boolean evaluationApproved) {
        this.evaluationApproved = evaluationApproved;
    }

    public boolean isPreOperativeReady() {
        return preOperativeReady;
    }

    public void setPreOperativeReady(boolean preOperativeReady) {
        this.preOperativeReady = preOperativeReady;
    }

    public boolean isSurgerySuccessful() {
        return surgerySuccessful;
    }

    public void setSurgerySuccessful(boolean surgerySuccessful) {
        this.surgerySuccessful = surgerySuccessful;
    }

    public boolean isRecoveryStable() {
        return recoveryStable;
    }

    public void setRecoveryStable(boolean recoveryStable) {
        this.recoveryStable = recoveryStable;
    }
}
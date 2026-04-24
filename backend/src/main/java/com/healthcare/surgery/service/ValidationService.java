package com.healthcare.surgery.service;

import com.healthcare.surgery.context.SurgeryContext;

public class ValidationService {

    public static boolean canProceedToEvaluation(SurgeryContext context) {
        return true;
    }

    public static boolean canProceedToPreOperative(SurgeryContext context) {
        return context.isEvaluationApproved();
    }

    public static boolean canProceedToSurgery(SurgeryContext context) {
        return context.isPreOperativeReady();
    }

    public static boolean canProceedToRecovery(SurgeryContext context) {
        return context.isSurgerySuccessful();
    }

    public static boolean canDischarge(SurgeryContext context) {
        return context.isRecoveryStable();
    }
}
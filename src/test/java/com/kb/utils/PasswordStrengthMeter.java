package com.kb.utils;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }
        int metCounts = getMetCriteriaCounts(password);

        if (metCounts <= 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String password) {
        int metCounts = 0;
        if (password.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(password)) metCounts++;
        if (meetsContainingUppercaseCriteria(password)) metCounts++;
        return metCounts;
    }

    private boolean meetsContainingUppercaseCriteria(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        return false;
    }

    private boolean meetsContainingNumberCriteria(String password) {
        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }

        return false;
    }
}

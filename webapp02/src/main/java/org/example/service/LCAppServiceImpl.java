package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService {
    public final String LC_APP_FORMULA = "FLAME";

    @Override
    public String calculateLove(String userName, String crushName) {
        int userAndCrushCount = (userName + crushName).toCharArray().length;
        int formulaCount = LC_APP_FORMULA.toCharArray().length;
        int rem = userAndCrushCount % formulaCount;
        char resultChar = LC_APP_FORMULA.charAt(rem);

        return whatsBetweenUs(resultChar);
    }

    @Override
    public String whatsBetweenUs(char calculationResult) {
        return switch (calculationResult) {
            case 'F' -> LoveCalculatorConstants.F_CHAR_MEANING;
            case 'L' -> LoveCalculatorConstants.L_CHAR_MEANING;
            case 'A' -> LoveCalculatorConstants.A_CHAR_MEANING;
            case 'M' -> LoveCalculatorConstants.M_CHAR_MEANING;
            case 'E' -> LoveCalculatorConstants.E_CHAR_MEANING;
            case 'S' -> LoveCalculatorConstants.S_CHAR_MEANING;
            default -> "";
        };
    }
}

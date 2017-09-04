package com.zzp.funny;

import java.util.List;

public class PromoCode {

    public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
        return isWin(codeList, shoppingCart) ? 1 : 0;
    }

    public boolean isWin(List<List<String>> codeList, List<String> shoppingCart) {
        if (codeList == null || codeList.isEmpty()) {
            return true;
        }
        if (shoppingCart == null || shoppingCart.isEmpty()) {
            return false;
        }
        List<String> code = codeList.get(0);

        for (int i = 0; i < shoppingCart.size() - code.size() + 1; i++) {
            if (isMatch(code, shoppingCart, i)) {
                boolean under = isWin(codeList.subList(1, codeList.size()), shoppingCart.subList(i + code.size(), shoppingCart.size()));
                if (under) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatch(List<String> code, List<String> cart, int offset) {
        // edge case
        if (code.size() + offset > cart.size()) {
            return false;
        }
        for (int i = 0; i < code.size(); i++) {
            if ("anything".equals(code.get(i))) {
                continue;
            } else if (!code.get(i).equals(cart.get(offset + i))) {
                return false;
            }
        }
        return true;
    }
}

package com.zzp.funny;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromoCodeTest {
    @Test
    public void checkWinner() {
        List<List<String>> codeList = new ArrayList<>();
        List<String> shoppingCart = new ArrayList<>();
        // test case 1
        codeList.add(Arrays.asList(new String[]{"orange"}));
        codeList.add(Arrays.asList(new String[]{"anything", "apple"}));
        codeList.add(Arrays.asList(new String[]{"banana", "anything", "apple"}));
        codeList.add(Arrays.asList(new String[]{"banana"}));

        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        // test case 2
/*        codeList.add(Arrays.asList(new String[]{"apple","apricot"}));
        codeList.add(Arrays.asList(new String[]{"banana", "anything","guava"}));
        codeList.add(Arrays.asList(new String[]{"papaya", "anything"}));

        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("guava");
        shoppingCart.add("apple");
        shoppingCart.add("apricot");
        shoppingCart.add("papaya");
        shoppingCart.add("kiwi");*/
// test case 3
/*        codeList.add(Arrays.asList(new String[]{"apple","apricot"}));
        codeList.add(Arrays.asList(new String[]{"banana", "anything","guava"}));
        codeList.add(Arrays.asList(new String[]{"papaya", "anything"}));

        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("guava");
        shoppingCart.add("apple");
        shoppingCart.add("apricot");
        shoppingCart.add("papaya");
        shoppingCart.add("kiwi");*/
        PromoCode promoCode = new PromoCode();
        System.out.println(promoCode.checkWinner(codeList, shoppingCart));
    }

}
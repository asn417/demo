package com.asn.se;

/**
 * @Author: wangsen
 * @Date: 2020/10/31 19:32
 * @Description:
 **/
public interface Food {
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements Food {
        FRUIT, CAKE, GELATO
    }
}

package hello.material.pattern.factory.simple;

import hello.material.pattern.factory.bean.*;

/**
 * @author karl xie
 */
public class SimpleFactory {

    public static House getHouse(String type) {

        switch (type) {
            case "1":
                return new VankeFlat();
            case "2":
                return new EvergrandeFlat();
            case "3":
                return new VankeVilla();
            default:
                return new EvergrandeVilla();
        }
    }
}
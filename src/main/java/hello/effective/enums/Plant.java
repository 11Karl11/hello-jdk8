package hello.effective.enums;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/**
 * @author karl xie
 * Created on 2022-01-05 11:22
 */
class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }


    // Using an EnumMap to associate data with an enum
    static Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

    public static void main(String[] args) {
        Plant[] garden = new Plant[]{
                new Plant("A", LifeCycle.ANNUAL),
                new Plant("B", LifeCycle.BIENNIAL),
                new Plant("C", LifeCycle.PERENNIAL),
                new Plant("D", LifeCycle.BIENNIAL),
                new Plant("E", LifeCycle.PERENNIAL),
        };
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());

        // for (Plant p : garden)
        //     plantsByLifeCycle.get(p.lifeCycle).add(p);
        EnumMap<LifeCycle, Set<Plant>> collect = Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), toSet()));

        System.out.println(collect);

        // System.out.println(plantsByLifeCycle);
    }
}
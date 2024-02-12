package net.okamiz.thelongstory.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum BreedyVariant {
    DEFAULT(0),
    PINK(1),
    BLUE(2),
    GREEN(3);

    private static final BreedyVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BreedyVariant::getId)).toArray(BreedyVariant[]::new);
    private final int id;

    BreedyVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static BreedyVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}

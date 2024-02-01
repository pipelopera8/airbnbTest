package com.flypass.airbnb.general.Enum;

public enum EnumStatusHouse {

    DISABLE(0, "No Disponible"),
    ACTIVE(1, "Disponible");

    private long id;

    private String name;

    EnumStatusHouse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

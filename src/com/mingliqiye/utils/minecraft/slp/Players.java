package com.mingliqiye.utils.minecraft.slp;

import lombok.Data;

@Data
public class Players {

    private int max;
    private int online;
    private PlayerSample[] sample;
}

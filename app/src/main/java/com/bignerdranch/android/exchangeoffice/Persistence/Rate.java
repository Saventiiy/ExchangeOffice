package com.bignerdranch.android.exchangeoffice.Persistence;

import android.arch.persistence.room.ColumnInfo;

public class Rate {
    @ColumnInfo(name = "rate")
    public double rate;
}

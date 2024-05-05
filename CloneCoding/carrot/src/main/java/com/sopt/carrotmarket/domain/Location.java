package com.sopt.carrotmarket.domain;

public enum Location {
    JUNGDONG("중앙동"),
    WONINDONG("원인동"),
    GAEUNDONG("개운동"),
    MYEONGRYUN1DONG("명륜1동"),
    MYEONGRYUN2DONG("명륜2동"),
    DANGUDONG("단구동"),
    ILSANDONG("일산동"),
    HAKSEONGDONG("학성동"),
    DANGYEDONG("단계동"),
    USANDONG("우산동"),
    TAEJANG1DONG("태장1동"),
    TAEJANG2DONG("태장2동"),
    BONGSANDONG("봉산동"),
    HAENGUDONG("행구동"),
    MUSILDONG("무실동"),
    BANGOKKWANSEOLDONG("반곡관설동");

    private final String dong;

    Location(String dong) {
        this.dong = dong;
    }

    public String getDong() {
        return dong;
    }
}

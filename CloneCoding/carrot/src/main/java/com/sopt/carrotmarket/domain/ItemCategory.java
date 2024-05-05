package com.sopt.carrotmarket.domain;

public enum ItemCategory {
    DIGITAL_DEVICES("디지털기기"),
    HOME_APPLIANCES("생활가전"),
    FURNITURE_INTERIOR("가구/인테리어"),
    LIVING_KITCHEN("생활/주방"),
    KIDS("유아동"),
    KIDS_BOOKS("유아도서"),
    WOMEN_CLOTHING("여성의류"),
    WOMEN_ACCESSORIES("여성잡화"),
    MEN_FASHION_ACCESSORIES("남성패션/잡화"),
    BEAUTY("뷰티/미용"),
    SPORTS_LEISURE("스포츠/레저"),
    HOBBIES_GAMES_MUSIC("취미/게임/음반"),
    BOOKS("도서"),
    TICKETS("티켓/교환권"),
    PROCESSED_FOOD("가공식품"),
    PET_SUPPLIES("반려동물용품"),
    PLANTS("식물"),
    OTHER_USED_ITEMS("기타 중고물품"),
    BUY("삽니다"); // ItemStatus가 판매중, 판매완료일 때 비활성화

    private final String category;

    ItemCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }
}

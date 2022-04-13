package day411.project.config;

import day411.project.Player;

import static day411.project.config.Setting.getCreditLimit;

/**
 * @Author Cien
 * @Date 2022/4/11 16:09
 * @Version 1.0
 * @Note 枚举类
 */
public enum PlayerEnums {


    Rookie(0,"菜鸟"),
    Introduction(1,"入门"),
    Primary(2,"初"),
    Intermediate(3,"中"),
    Advanced(4,"高"),
    GodLike(5,"接近神明"),
    Legendary(6,"超神");

    private final int value ;
    private final String description;
    private PlayerEnums(int value, String description) {
        this.value = value;
        this.description = description;
    }
    public int getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }


    public static PlayerEnums getUserEnums(Integer value){
        PlayerEnums[] values = PlayerEnums.values();
        PlayerEnums p=Legendary;
        for (PlayerEnums pe:values) {
            if(value==pe.value){
                 p=pe;
            }
        }
        return p;
    }

}

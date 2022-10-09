package day20.java2;

import java.io.Serializable;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-09 13:27
 * @description:
 **/
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }

}

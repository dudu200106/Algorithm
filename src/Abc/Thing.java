package Abc;


import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public abstract class Thing {
    public static final int LIVE=0;
    public static final int DEAD=1;
    protected int state = DEAD;

    protected int width;  //宽
    protected int height; //高
    protected int x;      //x坐标
    protected int y;      //y坐标
    protected int award;//金币

    public Thing(int width, int height, int x, int y, int speed){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.award = award;
    }

    //获取图片
    public abstract ImageIcon getImage();

    public boolean isLive(){
        return state==LIVE;
    }

    public boolean isDead(){
        return state==DEAD;
    }


    //state状态
    public void goDead(){
        state = DEAD;
    }



}

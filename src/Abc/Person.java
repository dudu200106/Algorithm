package Abc;

public interface Person {
    public boolean IsTouchGround();  // 是否触碰地板, 便于判断y是否下坠
    public boolean IsTouchDeadly();  //是否触碰致命道具(如地刺, 蜜蜂之类的)
    public boolean isTouchGun() ; //人物是否碰到了水枪, 具体人物在实现男女的时候重写

    public void moveLeft();
    public void moveRight();
}

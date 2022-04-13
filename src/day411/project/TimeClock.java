package day411.project;


/**
 * @Author Cien
 * @Date 2022/4/11 11:58
 * @Version 1.0
 * @Note 计时类
 */
public class TimeClock {
    private long startTime = 0;
    private long endTime = 0;

    //开始计时
    public void startTime(){
        //获取当前系统时间
        startTime = System.currentTimeMillis();
    }
    //结束计时并返回耗时
    public Long endTime(){
        //获取当前的系统时间，与初始时间相减就是程序运行的毫秒数，除以1000就是秒数
        endTime = System.currentTimeMillis();
        long usedTime = (endTime-startTime)/1000;
        return usedTime;
    }

}

package day411.project;


import day411.project.config.PlayerEnums;

import java.util.Scanner;

import static day411.project.config.PlayerEnums.*;
import static day411.project.config.Setting.*;
import static day411.project.utils.FileUtils.stop;

/**
 * @Author Cien
 * @Date 2022/4/11 15:26
 * @Version 2.0
 * @Note 玩家类
 */
public class Player {

    /**
     * 玩家等级
     */
    private Integer no;

    /**
     * 玩家段位，且与游戏难度挂钩
     */
    private PlayerEnums role;

    /**
     * 积分
     */
    private Integer credit;

    /**
     * 已做题数
     */
    private Integer queSum;

    /**
     * 正确题数
     */
    private Integer rightQueSum;


    /**
     * 正确率
     */
    //private Long accuracy;



    public Player() {
    }

    public void init(){
        this.no= 0 ;
        this.credit = 0;
        this.queSum = 0;
        this.rightQueSum = 0;
        this.role = PlayerEnums.Rookie;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getQueSum() {
        return queSum;
    }

    public void setQueSum(Integer queSum) {
        this.queSum = queSum;
    }

    public Integer getRightQueSum() {
        return rightQueSum;
    }

    public void setRightQueSum(Integer rightQueSum) {
        this.rightQueSum = rightQueSum;
    }

    public PlayerEnums getRole() {
        return role;
    }

    public void setRole(PlayerEnums role) {
        this.role = role;
    }

    private void addCredit(){
        Integer increase= getInCredit(this.role.getValue());
        this.credit+=increase;
        System.out.println("输入正确,积分增加"+increase+"分,当前正确率为"+getAccuracy()+"%");
    }


    //玩家等级和段位提升
    public void rank(){

        if(this.queSum>=getQueLimit(this.role.getValue()) && this.no!=6){
            this.no+=1;
            System.out.println("题数满足要求,等级+1,当前等级为:"+this.no);
        }

        if(this.role!=Legendary&&this.credit>getCreditLimit(this.role.getValue()) && this.no>getNoLimit(this.role.getValue())){
            this.role = getUserEnums(this.role.getValue()+1);
            System.out.println("积分和等级满足晋级条件,你已是"+this.role.getDescription()+"级强者");

        }



    }

    private boolean isQuick(Long ltime){
        boolean flag=false;
        if(ltime<=getTime(this.no)){
            flag=true;
        }
        return flag;
    }

    private String getAccuracy(){
        String accuracy = null;
        try {
            if(this.queSum==0){
                accuracy="0";
            }else {
                accuracy=String.format("%.2f", (rightQueSum*1.0/queSum)*100);
            }
        } catch (Exception e) {
            System.err.println("读取到的题数存在空指针异常,请检查数据和代码");
            Scanner in= new Scanner(System.in);
            System.err.println("题数存在问题,是否初始化题数数据(y/n):");
            String i = in.nextLine();
            if("y".equals(i)){
                this.queSum=0;
                this.rightQueSum=0;
                System.out.println("初始化成功");
            }else {
                stop();
            }
        }
        return accuracy;
    }

    private void success(){
        if(getComment()){
            System.out.println(successPoem());
        }
        setQueSum(getQueSum()+1);
        setRightQueSum(getRightQueSum()+1);
        addCredit();
    }

    private void fail(){
        if(getComment()){
            System.out.println(failurePoem());
        }
        setQueSum(getQueSum()+1);
        System.out.println("输入错误,当前正确率为"+getAccuracy()+"%");

    }

    public void isSuccess(String str, String userStr, Long time){
        if(str.equals(userStr)||str.trim().equals(userStr.trim())){
            if(!isQuick(time)){
                System.out.println("超过规定时间,不予加分");
            }else {
                success();
            }
        }else{
            fail();
        }
    }

    public void print(){
        System.out.println("玩家等级为:"+this.no+",游戏难度为:"+this.role.getDescription()+"级,积分为:"+this.credit+"分,已尝试:"+this.getQueSum()+"关,通过:"+this.getRightQueSum()+"关");
    }

}

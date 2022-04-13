package day411.project;

import java.util.Scanner;
import static day411.project.config.Setting.getTime;

/**
 * @Author Cien
 * @Date 2022/4/11 17:12
 * @Version 1.0
 * @Note 游戏主类
 */
public class Play {

    public void gameMain(Player p){
        TimeClock tc = new TimeClock();
        Scanner in = new Scanner(System.in);
        RandomString randomString = new RandomString();
        String str = randomString.getStr(p.getRole().getValue());

        tc.startTime();
        System.out.println("计时开始,你有"+getTime(p.getRole().getValue())+"秒时间进行填写");
        System.out.println(str);
        String userStr = in.nextLine();
        Long time = tc.endTime();

        System.out.println("用时"+time+"秒");
        p.isSuccess(str,userStr,time);
        p.rank();
    }
    public Player getPlayer(Player p){
        FileWR fwr = new FileWR();

        //读取数据
        if(!fwr.fileExist()){
            System.out.println("指定位置没有存档文件,或者无存档数据,已为你初始化数据");
            p.init();
        }else {
            System.out.println("读取数据中...");
            p = fwr.fileRead();
        }
        return p;
    }
    public static void main(String[] args) {
        Play play = new Play();
        Player p = new Player();
        FileWR fwr = new FileWR();
        Scanner in = new Scanner(System.in);
        p = play.getPlayer(p);
        p.rank();
        while (true){
            System.out.println("输入1开始游戏,2查看当前数据,3保存数据,4退出游戏");
            String flag = in.next();
            switch (flag){
                case "1":play.gameMain(p);;break;
                case "2":p.print();break;
                case "3":fwr.fileWirte(p);break;
            }
            if("4".equals(flag)) {
                System.out.println("see you again");
                break;
            }
        }
    }


}

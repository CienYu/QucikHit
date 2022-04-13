package day411.project.utils;

import day411.project.Player;
import day411.project.config.PlayerEnums;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Cien
 * @Date 2022/4/11 22:24
 * @Version 1.0
 * @Note 文件工具类
 */
public class FileUtils {

    //实体类转map
    public static Map<String, Object> entityToMap(Object object) {
        Map<String, Object> map = new HashMap<>();
        //获取声明字段并遍历放入map中
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                //field.isAccessible()在jdk1.9后废弃，教室环境使用field.canAccess
                //boolean flag = field.isAccessible();
                //boolean flag = field.canAccess(o);
                //设置访问权限
                field.setAccessible(true);
                Object o = field.get(object);
                map.put(field.getName(), o);
                field.setAccessible(true);
            } catch (Exception e) {
                System.err.println("反射获取值出现问题");
            }
        }
        return map;
    }

    //String转map
    public static Map<String, Object> stringToMap(String str){
        Map<String, Object> map = new HashMap<>();
        StringBuffer sbf = new StringBuffer();
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if(c!='{' && c!='}' && c!=','){
                sbf.append(c);
            }
        }
        String[] strings = sbf.toString().split("\\ ");
        for (String s: strings) {
            map.put(s.substring(0, s.indexOf("=")), s.substring(s.indexOf("=")+1, s.length()) );
        }
        return map;
    }

    //map转实体类
    public static Player mapToEntry(Map<String,Object> map){
        Player p = new Player();
        try {
            p.setNo(Integer.valueOf(map.get("no").toString()));
            p.setCredit(Integer.valueOf(map.get("credit").toString()));
            p.setQueSum(Integer.valueOf(map.get("queSum").toString()));
            p.setRightQueSum(Integer.valueOf(map.get("rightQueSum").toString()));
            p.setRole(PlayerEnums.valueOf(map.get("role").toString()));
            System.out.println("读取数据成功,已为你继承上次数据");
        } catch (NumberFormatException e) {
            Scanner in= new Scanner(System.in);
            System.err.println("存档数据存在问题,是否初始化数据(y/n):");
            String i = in.nextLine();
            if("y".equals(i)){
                p.init();
                System.out.println("初始化成功");
            }else {
                stop();
            }
        }
        return p;
    }

    //中断
    public static void stop(){
            System.out.println("请更换存档或检查数据,see you again!");
            System.exit(0);
    }

}

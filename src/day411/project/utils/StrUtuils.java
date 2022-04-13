package day411.project.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @Author Cien
 * @Date 2022/4/12 17:54
 * @Version 1.0
 * @Note
 */
public class StrUtuils {

    //生成单个小写字母
    public static char getLowercaseChar(){

        Random random = new Random();
        int num = random.nextInt(26)+97;
        char a = (char)num;
        //System.out.println(a);
        return a;
    }
    //生成单个大写字母
    public static char getUppercaseChar(){
        Random random = new Random();
        int num = random.nextInt(26)+65;
        char a = (char)num;
        //System.out.println(a);
        return a;
    }
    //生成数字字符
    public static char getFiguresChar(){
        Random random = new Random();
        int num = random.nextInt(32)+33;
        char a = (char)num;
        //System.out.println(a);
        return a;
    }

    //生成汉字
    public static String getchineseStr() {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            //这里采用GBK格式生成汉字,而gbk中汉字是双字节
            //获取高位值
            hightPos = (176 + Math.abs(random.nextInt(39)));
            //获取低位值
            lowPos = (161 + Math.abs(random.nextInt(93)));
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                // 转成中文
                str = new String(b, "GBK");
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            return str;
    }
}

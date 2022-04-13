package day411.project.config;

/**
 * @Author Cien
 * @Date 2022/4/11 15:36
 * @Version 2.0
 * @Note 游戏配置类
 */
public class Setting {

    //存档目录
    private static final String catalogue = "F:\\存档.txt";

    //中文开关
    private static final boolean havachinese = false;

    //趣味开关
    private static final boolean Comment = false;

    //段位对应时间规定
    private static final Long[] TimeLimit = new Long[]{3l,5l,7l,10l,15l,20l,10l};

    //段位对应字符串长度
    private static final Integer[] StrLimit = new Integer[]{3,5,10,10,15,20,50};

    //段位对应积分要求
    private static final Integer[] CreditLimit = new Integer[]{10,40,90,130,210,310,460};

    //段位对应加分
    private static final Integer[] InCreditLimit = new Integer[]{1,3,5,7,9,10,15};

    //段位对应等级要求
    private static final Integer[] NoLimit = new Integer[]{0,1,2,3,4,5,6};

    //等级对应题数要求
    private static final Integer[] QueLimit = new Integer[]{3,5,7,9,10,13,15};


    public static Integer getQueLimit(Integer roleNo){
        return QueLimit[roleNo];
    }

    public static Integer getNoLimit(Integer roleNo){
        return NoLimit[roleNo];
    }
    public static Long getTime(Integer roleNo){
        return TimeLimit[roleNo];
    }

    public static Integer getStrLength(Integer roleNo){
        return StrLimit[roleNo];
    }

    public static Integer getCreditLimit(Integer roleNo){
        return CreditLimit[roleNo];
    }

    public static Integer getInCredit(Integer roleNo){
        return InCreditLimit[roleNo];
    }
    public static Boolean gethavachinese(){
        return havachinese;
    }
    public static Boolean getComment(){
        return Comment;
    }
    public static String getCatalogue(){
        return catalogue;
    }

    public static String successPoem(){
        String str = "";
        int a = (int) (Math.random() * 5);
        switch (a){
            case 1:
                str="白衣走马执霜雪,不枉人间少年郎.";break;
            case 2:
                str="明年此日青云去,却笑人间举子忙";break;
            case 3:
                str="夫何瑰逸之令姿，独旷世以秀群";break;
            case 4:
                str="绿蚁新醅酒，红泥小火炉。晚来天欲雪，能饮一杯无？";break;
            default:
                //若教眼底无离恨，不信人间有白头
                str="直道相思了无益，未妨惆怅是清狂";break;
        }
       return str;
    }
    public static String failurePoem(){
        String str = "";
        int a = (int) (Math.random() * 5);
        switch (a){
            case 1:
                str="人生若只如初见，何事秋风悲画扇";break;
            case 2:
                str="欲买桂花同载酒,终不似,少年游。";break;
            case 3:
                str="惆怅东栏一株雪，人生看得几清明。";break;
            case 4:
                str="休言万事转头空，未转头时皆梦。";break;
            default:
                str="试问岭南应不好，却道：此心安处是吾乡。";break;
        }
        return str;
    }

    //后续增加泛型？
    public <T> T fun(T t){
        return t ;
    }
}

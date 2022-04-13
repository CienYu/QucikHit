package day411.project;

import static day411.project.config.Setting.getStrLength;
import static day411.project.config.Setting.gethavachinese;
import static day411.project.utils.StrUtuils.*;

/**
 * @Author Cien
 * @Date 2022/4/11 11:34
 * @Version 1.0
 * @Note 字符生成类
 */
public class RandomString {

    /*
     * 纯恶搞
     */
    private static String Legendary(){
        StringBuffer sbf  = new StringBuffer();
        for (int i = 0; i < 30; i++) {
            if(gethavachinese()){
                sbf.append(getchineseStr());
            }else {
                sbf.append(getLowercaseChar());
                sbf.append(getUppercaseChar());
                sbf.append(getFiguresChar());
            }
        }
        return sbf.toString();
    }

    private static StringBuffer insertSpace(StringBuffer sbf, Integer roleNo){
        if(gethavachinese() &&  ((int) (Math.random() * 2)) == 1){
            int len = sbf.toString().replaceAll(" ", "").length();
            if (len%5==0 && roleNo != 6) {
                sbf.append((char)32);
            }
            sbf.append(getchineseStr());
        }
        return sbf;
    }

    /*
     * 获取对应难度的字符串
     */
    public String getStr(Integer roleNo){
        StringBuffer sbf  = new StringBuffer();
        int len = 0;
        for (int i = 0; i < getStrLength(roleNo); i++) {
            switch (roleNo){
                case 0:
                case 1:
                case 2:
                    sbf.append(getLowercaseChar());
                    sbf=insertSpace(sbf,roleNo);
                    break;
                case 3:
                case 4:
                    if ((int) (Math.random() * 2) == 1) {
                        sbf.append(getLowercaseChar());
                    } else {
                        sbf.append(getUppercaseChar());
                    }
                    sbf=insertSpace(sbf,roleNo);
                    break;
                case 5:
                case 6:
                    if ((int) (Math.random() * 3) == 1) {
                        sbf.append(getLowercaseChar());
                    } else if((int) (Math.random() * 3) == 2){
                        sbf.append(getUppercaseChar());
                    }else {
                        sbf.append(getFiguresChar());
                    }
                    sbf=insertSpace(sbf,roleNo);
                    break;
                default:
                    sbf.append(Legendary());break;
            }
            len = sbf.toString().replaceAll(" ", "").length();
            if (len%5==0 && roleNo != 6) {
                sbf.append((char)32);
            }
        }
        return sbf.toString();
    }


}

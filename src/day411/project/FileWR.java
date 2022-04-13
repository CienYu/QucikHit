package day411.project;

import java.io.*;
import static day411.project.config.Setting.getCatalogue;
import static day411.project.utils.FileUtils.*;

/**
 * @Author Cien
 * @Date 2022/4/11 17:48
 * @Version 1.0
 * @Note 存档读取类
 */
public class FileWR {


    private final String catalogue = getCatalogue();

    //判断存档是否存在
    public boolean fileExist() {
        File file = new File(catalogue);
        boolean flag;
        if(!file.exists()){
            flag = false;
        }else{
            flag = true;
        }
        return flag;
    }
    //存档
    public void fileWirte(Player p) {
        try {
            Writer fw = new FileWriter(catalogue);
            String str = entityToMap(p).toString().trim();
            fw.write(str);
            System.out.println("存档成功");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //读取存档
    public Player fileRead() {
        StringBuffer sbf=new StringBuffer();
        try {
            File file = new File(catalogue);
            Reader fr = new FileReader(file);
            char[] ch = new char[(int)file.length()];
            int length=fr.read(ch);

            while ((length!= -1)) {
                sbf.append(ch);
                length=fr.read();
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Player p1 = mapToEntry(stringToMap(sbf.toString()));
        System.out.println("当前用户等级为:"+p1.getNo()+",积分为:"+p1.getCredit());
        return p1;
    }


}

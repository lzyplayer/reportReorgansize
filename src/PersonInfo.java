import java.io.*;

/**
 * Created by vickylzy on 2019/5/27
 */
public class PersonInfo {
    private File file;
    private String name;
    private String sex;
    private String age;
    private String checkDate;
    private String checkDoc;
    private String checkReport;

    public PersonInfo(File file) throws IOException {
        this.file = file;
//        FileReader fileReader =;
        BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(file),"GBK"));
        String container;
        while ((container = reader.readLine())!=null){
            if (container.contains("姓名")) break;
        }
        this.name = reader.readLine();
        reader.readLine();
        this.sex = reader.readLine();
        reader.readLine();
        this.age = reader.readLine().split("岁")[0];
        while ((container = reader.readLine())!=null){
            if (container.contains("检查日期")) break;
        }
        this.checkDate = reader.readLine().split(" ")[0];
        while ((container = reader.readLine())!=null){
            if (container.contains("检查医师")) break;
        }
        this.checkDoc = reader.readLine();
        while ((container = reader.readLine())!=null){
            if (container.contains("电子皮肤镜提示")) break;
        }
        String repoInfo = container.substring(8);
        while ((container = reader.readLine())!=null){
            repoInfo = repoInfo.concat(container);
        }
        this.checkReport= repoInfo;

       reader.close();
    }
    public String getFormatString(){
        return name+","+sex+","+age+","+checkDate+","+checkDoc+","+checkReport+"\r\n";
    }
}

//        reader.readLine();
//        String personalinfo = reader.readLine();
//        int sname = personalinfo.indexOf("姓名");
//        int ssex = personalinfo.indexOf("性别",sname);
//        int sage = personalinfo.indexOf("年龄",ssex);
//        int sagePo = personalinfo.indexOf("岁",sage);
//        int stime = personalinfo.indexOf("201",sagePo);
//        int stimePo = personalinfo.indexOf(" ",stime);
//        System.out.println(personalinfo.substring(sname,ssex));
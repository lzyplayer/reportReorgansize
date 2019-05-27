/**
 * Created by vickylzy on 2019/5/27
 */


import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {


//        generateTxt("../wordReport","E:\\班级\\master\\祝老师组\\皮肤镜报告\\reportReorgansize\\txtReport\\");
        File[] txts = getFileList("./txtReport");

        File resultCsv = new File( "./reportCsv.csv");
        stastisticTxt(txts,resultCsv);



    }
    public static void stastisticTxt(File[] files,File targetCsv) throws IOException {
        if (targetCsv.exists()){
            targetCsv.delete();
        }
        targetCsv.createNewFile();
        Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(targetCsv), "GBK"));
        writer.write("姓名,性别,年龄,检查日期,检查医师,电子皮肤镜提示\r\n");
        writer.flush();
        int counter=0;
        for (File f : files){
            System.out.print("result got successful on ");
            System.out.println(++counter);
            PersonInfo currPer = new PersonInfo(f);
            writer.write(currPer.getFormatString());
            writer.flush();
        }



        writer.close();

    }

    public static void generateTxt(String thePath,String tarPath){
        File[] fileList = getFileList(thePath);
        // generate txt
        int curr=0;
        for (File file: fileList) {
            System.out.print("generate txt successful on ");
            System.out.println(++curr);
            String docPath = file.getAbsolutePath();
            String[] lines = file.getName().split("-");
            System.out.println(lines[1]);
            String txtPath = tarPath+lines[1]+".txt";
            Word2txt.extractDoc(docPath,txtPath);
        }
    }


    public static File[] getFileList(String thePath) {

        File file = new File(thePath);
        // get rid of word backup
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith("~"))
                    return false;
                else return true;
            }
        };
        return file.listFiles(filenameFilter);

    }
}

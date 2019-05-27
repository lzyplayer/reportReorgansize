import java.io.File;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

class Word2txt{
    public static void extractDoc(String inputFIle, String outputFile) {

        boolean flag = false;



        // ��WordӦ�ó���

        ActiveXComponent app = new ActiveXComponent("Word.Application");

        try {

            // ����word���ɼ�

            app.setProperty("Visible", new Variant(false));

            // ��word�ļ�

            Dispatch doc1 = app.getProperty("Documents").toDispatch();

            Dispatch doc2 = Dispatch.invoke(

                    doc1,

                    "Open",

                    Dispatch.Method,

                    new Object[] { inputFIle, new Variant(false),

                            new Variant(true) }, new int[1]).toDispatch();

            // ��Ϊtxt��ʽ���浽��ʱ�ļ�

            Dispatch.invoke(doc2, "SaveAs", Dispatch.Method, new Object[] {

                    outputFile, new Variant(7) }, new int[1]);

            // �ر�word

            Variant f = new Variant(false);

            Dispatch.call(doc2, "Close", f);

            flag = true;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            app.invoke("Quit", new Variant[] {});

        }

        if (flag == true) {

            System.out.println("success");

        } else {

            System.out.println("failed");

        }

    }




//    public static void main(String[] args) {
//        File myFileName = new File("..\\..\\wordReport\\俎茗睿-2018053000020-报告单.docx");
//        String wordList[] = myFileName.list();
//        String txtList[] = myFileName.list();
//        if(myFileName.isDirectory())
//        {
//            for(int i=0;i<wordList.length;i++ )
//            {
//                txtList[i] = wordList[i].substring(0,wordList[i].lastIndexOf("."));
//                System.out.println( txtList[i] + "\n");
//            }
//        }
//
//        //��ʼ����ת��Word
//        for(int i=0;i<wordList.length;i++)
//        {
//            Word2txt.extractDoc("d:\\doc\\"+wordList[i],"d:\\doc\\"+txtList[i]+".txt");
//        }
//    }
}
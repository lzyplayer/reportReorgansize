import java.io.File;
import java.io.IOException;


/**
 * Created by vickylzy on 2019/5/27
 */
public class Blank {
    public static void main(String[] args) throws IOException {
        File file =new File("./txtReport/2018073100015.txt");
        PersonInfo personInfo =new PersonInfo(file);

    }
}

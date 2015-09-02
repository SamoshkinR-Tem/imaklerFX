import model.entities.Flat;
import model.tools.FileUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by R-Tem on 08.06.2015.
 */
public class FileUtilTest {
    @Test
    public void writeObjToFileTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        ArrayList<Flat> flats = new ArrayList<>();
        Flat f1 = new Flat("1", "2�", formatter.format(LocalDate.now()).toString(), formatter.format(LocalDate.now()).toString(),
                "��. ������������ 46�", "45/30/6, 2/5", "��������� ���.", "093 006 2161", "�����", "���.", "45 000",
                "����������", "#FFFF00", "asdf", "fdsa");
        Flat f2 = new Flat("2", "1�", formatter.format(LocalDate.now()).toString(), formatter.format(LocalDate.now()).toString(),
                "��. ������������ 58", "33/15/7, 5/9", "������ � ����", "099 209 4121", "������", "���.", "46 000",
                "������������", "#00FF00", "qwer", "rewq");
        flats.add(f1);
        flats.add(f2);
        new FileUtil().writeObjToFile(flats, "src/main/resources/data/ser/flats.ser");
        System.out.println("Done!");
    }
    @Test
    public void readObjFromFile (){
        ArrayList<Flat> flats = new FileUtil<Flat>().readObjFromFile("src/main/resources/data/ser/flats.ser");
        for (int i = 0; i < flats.size(); i++) {
            System.out.println(flats.get(i));
        }
    }
}

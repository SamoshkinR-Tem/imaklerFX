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
        Flat f1 = new Flat("1", "2к", formatter.format(LocalDate.now()).toString(), formatter.format(LocalDate.now()).toString(),
                "ул. Вышгородская 46а", "45/30/6, 2/5", "частичный рем.", "093 006 2161", "Артем", "хоз.", "45 000",
                "Оболонский", "#FFFF00", "asdf", "fdsa");
        Flat f2 = new Flat("2", "1к", formatter.format(LocalDate.now()).toString(), formatter.format(LocalDate.now()).toString(),
                "ул. Дегтяревская 58", "33/15/7, 5/9", "заходи и живи", "099 209 4121", "Лариса", "хоз.", "46 000",
                "Святошинский", "#00FF00", "qwer", "rewq");
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

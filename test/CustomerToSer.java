import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entities.Customer;
import model.entities.Flat;
import model.tools.FileUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by R-Tem on 02.07.2015.
 */
public class CustomerToSer {
    @Test
    public void test(){
        ArrayList<Customer> customers = new ArrayList<>();
        Flat flat = new Flat();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        Customer natalya = new Customer("Наталья (066) 499 50 01", "24/06/2015", formatter.format(LocalDate.now()).toString(),
                "Наталья", "(066) 499 50 01", flat, "Бюджет ~49 000 у.е. на все, нужна трешка под ремонт на углу Драйзера/Закревского" +
                " (5-й мкр.)");
        customers.add(natalya);
        new FileUtil().writeObjToFile(customers, "C:/Users/R-Tem/IdeaProjects/imakler/resources/data/ser/customers.ser");
        System.out.println("Done!");
    }
    @Test
    public void readObjFromFile (){
        ArrayList<Flat> flats = new FileUtil<Flat>().readObjFromFile("src/main/resources/data/ser/customers.ser");
        for (int i = 0; i < flats.size(); i++) {
            System.out.println(flats.get(i));
        }
    }
}

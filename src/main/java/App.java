import mappers.OscarMapper;
import models.OscarModel;
import util.FileUtil;
import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {

        var oscarMale = new FileUtil<OscarModel>("oscar_age_male.csv");
        var oscarFemale = new FileUtil<OscarModel>("oscar_age_female.csv");

        var dadosOscarMale = oscarMale.readFile(new OscarMapper());
        var dadosOscarFemale = oscarFemale.readFile(new OscarMapper());

        dadosOscarFemale.forEach(System.out::println);
        dadosOscarMale.forEach(System.out::println);

    }
}

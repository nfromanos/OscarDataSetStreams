import mapper.OscarMapper;
import models.OscarModel;
import services.OscarServices;
import util.FileUtil;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App
{
    public static void main( String[] args ) throws IOException {

        var oscarMale = new FileUtil<OscarModel>("oscar_age_male.csv");
        var oscarFemale = new FileUtil<OscarModel>("oscar_age_female.csv");

        var dadosOscarMale = oscarMale.readFile(new OscarMapper());
        var dadosOscarFemale = oscarFemale.readFile(new OscarMapper());

        var dadosOscarMaleFemale = Stream.concat(dadosOscarFemale.stream(), dadosOscarMale.stream()).collect(Collectors.toList());

        OscarServices oscarServices = new OscarServices(dadosOscarMaleFemale);
        oscarServices.youngestActor();
        oscarServices.mostRewardedActor();
        oscarServices.mostRewardedActor18_24();



    }
}

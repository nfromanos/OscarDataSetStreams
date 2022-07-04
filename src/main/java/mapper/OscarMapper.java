package mapper;
import models.OscarModel;
import java.util.function.Function;
import static java.lang.Integer.parseInt;

public class OscarMapper implements Function<String, OscarModel> {

    @Override
    public OscarModel apply(String s) {
        var dadosLinha = s.split(";");
        var index = parseInt(dadosLinha[0].replace(" ", ""));
        var year = parseInt(dadosLinha[1].replace(" ", ""));
        var age = parseInt(dadosLinha[2].replace(" ", ""));
        var name = (dadosLinha[3]);
        var movie = (dadosLinha[4]);

        return new OscarModel(index, year, age, name, movie);
    }
}

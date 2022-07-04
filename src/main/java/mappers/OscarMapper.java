package mappers;
import models.OscarModel;
import java.util.function.Function;
import static java.lang.Integer.parseInt;

public class OscarMapper implements Function<String, OscarModel> {

    @Override
    public OscarModel apply(String s) {
            s = s.replaceAll(" ", "");
            var dadosLinha = s.split(";");
            var index = parseInt(dadosLinha[0]);
            var year = parseInt(dadosLinha[1]);
            var age = parseInt(dadosLinha[2]);
            var name = (dadosLinha[3]);
            var movie = (dadosLinha[4]);

            return new OscarModel(index, year, age, name, movie);
    }
}

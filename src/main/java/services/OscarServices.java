package services;
import models.OscarModel;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OscarServices {

    private final List<OscarModel> oscarModel;

    public OscarServices(List<OscarModel> oscarModel) {
        this.oscarModel = oscarModel;
    }

    public void youngestActor(){
        oscarModel.stream()
                .collect(Collectors.groupingBy(OscarModel::getAge))
                .entrySet().stream()
                .min(Map.Entry.comparingByKey()).get().getValue()
                .forEach(s -> System.out.printf("O ator/atriz mais novo(a) a ganhar o oscar é%s com %s anos.%n", s.getName(), s.getAge()));

    }


    public void mostRewardedActor(){
        var mostRewardedActor = oscarModel.stream()
                .collect(Collectors.groupingBy(OscarModel::getName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        mostRewardedActor.ifPresent(s -> System.out.printf("O ator/atriz mais premiado(a) é o(a)%s com um total de %s oscar(s).", s.getKey(), s.getValue()));
    }
}


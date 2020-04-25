import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static UserInfo createValidUserInfo() {
        Faker faker = new Faker(new Locale("ru"));
        return new UserInfo(
                getCity(),
                faker.name().fullName(),
                faker.phoneNumber().phoneNumber()
        );
    }

    public static String getCity() {
        String[] citi = {"Москва", "Астрахань", "Казань", "Тверь", "Новосибирск", "Воронеж", "Краснодар", "Екатеринбург"};
        Random random = new Random();
        int index = random.nextInt(citi.length);
        return (citi[index]);
    }


    public static int getMinimumDaysToDelivery () {
        return 3;
    }

    public static LocalDate getEarliestValidDate () {
        return LocalDate.now().plusDays(getMinimumDaysToDelivery());
    }

    public static long getTimeStampString (LocalDate date){
        ZoneId zoneId = ZoneId.systemDefault();
        return date.atStartOfDay(zoneId).toEpochSecond();
    }
}
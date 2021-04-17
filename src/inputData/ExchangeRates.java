package inputData;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRates{
    Map<LocalDate, Double> exchangeRatesOfDollar = new HashMap<>();
    Map<LocalDate, Double> exchangeRatesOfEuro = new HashMap<>();
    Map<LocalDate, Double> exchangeRatesOfZloty = new HashMap<>();

    public ExchangeRates() {
        exchangeRatesOfDollar.put(LocalDate.of(2021,4,5), 2.638);
        exchangeRatesOfDollar.put(LocalDate.of(2021, 4, 6), 2.6552);
        exchangeRatesOfDollar.put(LocalDate.of(2021, 4, 7), 2.6546);
        exchangeRatesOfDollar.put(LocalDate.of(2021, 4, 8), 2.6676);
        exchangeRatesOfDollar.put(LocalDate.of(2021, 4, 9), 2.6621);
        exchangeRatesOfDollar.put(LocalDate.of(2021, 4, 10), 2.6411);

        exchangeRatesOfEuro.put(LocalDate.of(2021,4,5), 3.1089);
        exchangeRatesOfEuro.put(LocalDate.of(2021,4,6), 3.1171);
        exchangeRatesOfEuro.put(LocalDate.of(2021,4,7), 3.1353);
        exchangeRatesOfEuro.put(LocalDate.of(2021,4,8), 3.1684);
        exchangeRatesOfEuro.put(LocalDate.of(2021,4,9), 3.1635);
        exchangeRatesOfEuro.put(LocalDate.of(2021,4,10), 3.1436);

        exchangeRatesOfZloty.put(LocalDate.of(2021,4,5), 6.7558);
        exchangeRatesOfZloty.put(LocalDate.of(2021,4,6), 6.7821);
        exchangeRatesOfZloty.put(LocalDate.of(2021,4,7), 6.8235);
        exchangeRatesOfZloty.put(LocalDate.of(2021,4,8), 6.9262);
        exchangeRatesOfZloty.put(LocalDate.of(2021,4,9), 6.9371);
        exchangeRatesOfZloty.put(LocalDate.of(2021,4,10), 6.9168);
    }
}
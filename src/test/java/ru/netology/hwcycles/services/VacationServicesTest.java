package ru.netology.hwcycles.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class VacationServicesTest {

    @ParameterizedTest
    @CsvSource({
            "3,10000,3000,20000",
            "2,100000,60000,150000"
    })
    public void testVacationParamsInCsvInCode(int expected, int income, int expenses, int threshold) {
        VacationServices services = new VacationServices();
        int actual = services.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvFileSource(files="src/test/resources/vacationconditions.csv")

    public void testVacationParamsInCsvFile(int expected, int income, int expenses, int threshold) {
        VacationServices services = new VacationServices();
        int actual = services.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }
}
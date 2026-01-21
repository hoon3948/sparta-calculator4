package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    public List<Double> results = new ArrayList<>();

    public <T extends Number, U extends Number> double calculate(T num1, U num2, OperatorType operator){
        double double1 = num1.doubleValue();
        double double2 = num2.doubleValue();
        double result = operator.apply(double1, double2);

        results.add(result);
        return result;
    }

    public List<Double> getResults(){
        return results;
    }

    public void removeResults(){
        results.remove(0);
    }

    public List<Double> getBigResult(double value){
        return results.stream()
                .filter(v -> v > value)
                .collect(Collectors.toList());
    }
}

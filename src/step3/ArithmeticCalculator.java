package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    public List<Double> data = new ArrayList<>();

    public <T extends Number, U extends Number> double calculate(T num1, U num2, OperatorType operatorType){
        double dnum1 = num1.doubleValue();
        double dnum2 = num2.doubleValue();
        double result = operatorType.apply(dnum1,dnum2);


        data.add(result);
        return result;
    }

    public List<Double> getData(){
        return data;
    }

    public void removeData(){
        data.remove(0);
    }

    public List<Double> searchData(double value){
        return data.stream()
                .filter(v -> v > value)
                .collect(Collectors.toList());
    }
}

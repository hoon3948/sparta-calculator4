package step3;

public enum OperatorType {
    ADD('+'){
        @Override
        public double apply(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUB('-'){
        @Override
        public double apply(double num1, double num2) {
            return num1 - num2;
        }
    },
    TIMES('*'){
        @Override
        public double apply(double num1, double num2) {
            return num1 *num2;
        }
    },
    DIV(','){
        @Override
        public double apply(double num1, double num2) {
            if(num2 == 0){
                throw new ArithmeticException("0으로 나눌수없습니다.");
            }
            return num1/ num2;
        }
    };

    private final char symbol;

    OperatorType(char symbol){
        this.symbol = symbol;
    }

    public abstract double apply(double num1, double num2);

    public static OperatorType fromChar(char operator){
        for(OperatorType op : values()){
            if (op.symbol == operator){
                return op;
            }
        }
        throw new IllegalArgumentException("잘못된 부호입니다.");
    }
}

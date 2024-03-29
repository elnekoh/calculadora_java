public class Calculadora {
    private final String MESSAGE_ERROR = "Error";
    private final char[] operators = {'+','-','*','-'};

    public Calculadora(int n1, int n2){
        System.out.println("suma"+ this.sum(n1,n2));
        System.out.println("resta"+ this.substract(n1,n2));
        System.out.println("multiplicacion"+ this.multiply(n1,n2));
        System.out.println("division"+ this.divide(n1,n2));
    }

        public Calculadora(){

    }
    //operaciones

    private float sum(float number1, float number2){
        return number1 + number2;
    }

    private float substract(float number1, float number2){
        return number1 - number2;
    }

    private float multiply(float number1, float number2){
        return number1 * number2;
    }

    private float divide(float number1, float number2){
        if(number2 != 0){
            return number1 / number2;
        }else{
            throw new ArithmeticException("se intento dividir por 0!!!");
        }
    }

    public float solve(float number1, float number2, char operator){
        switch (operator) {
            case '+':
                return sum(number1, number2);
            case '-':
                return substract(number1, number2);
            case '*':
                return multiply(number1, number2);
            case '/':
                return divide(number1, number2);
            default:
                throw new IllegalArgumentException("Llego un perador no válido: " + operator);
        }
    }
}

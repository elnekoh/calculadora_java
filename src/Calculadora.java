public class Calculadora {
    private final String MESSAGE_ERROR = "Error";
    private final String[] operators = {"+","-","*","-"};

    public Calculadora(int n1, int n2){
        System.out.println("suma"+ this.sum(n1,n2));
        System.out.println("resta"+ this.substract(n1,n2));
        System.out.println("multiplicacion"+ this.multiply(n1,n2));
        System.out.println("division"+ this.divide(n1,n2));
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

}

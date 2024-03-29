public class Calculadora {
    private final String MESSAGE_ERROR = "Error";
    private final char[] OPERATORS = {'+','-','*','-'};

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

    //resolver
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
                throw new IllegalArgumentException("Llego un operador no válido: " + operator);
        }
    }

    private boolean hasNoDecimals(float number){
        return Math.abs(number - (int) number) < 0.00001;
    }

    public String[] splitExpression(String text){
        int i = 0;
        int position = -1;

        //busca coincidencia
        while (position == -1 && i < this.OPERATORS.length){
            position = text.indexOf(this.OPERATORS[i]);
            i++;
        }

        //encuentra coincidencia?
        //no encontró
        if (position == -1 && text == ""){
            throw new IllegalArgumentException("Llego un una expresion vacia");
        } else if (position == -1 && text != "") {
            return new String[]{text,null,null};
        }

        //si encontró
        String textBeforeMatch = text.substring(0,position);
        String textAfterMatch = text.substring(position,text.length()-1);
        String operator = String.valueOf(text.charAt(position));

        //controla si el primer numero es negativo
        if (textBeforeMatch == "" && textAfterMatch == ""){
            return new String[]{null,null,operator};
        } else if (textBeforeMatch == "" && textAfterMatch != "" && operator == "-") {
            //si llego hasta aca, el primer numero era negativo.
            String[] splittedText = this.splitExpression(textAfterMatch);
            splittedText[0] = "-" + splittedText[0];
            return splittedText;
        } else if (textBeforeMatch == "" && textAfterMatch != "" && operator != "-") {
            return new String[]{null,textAfterMatch,operator};
        }

        //el primer numero NO es negativo
        if(textAfterMatch == ""){
            return new String[]{textBeforeMatch,null,operator};
        }
        return new String[]{textBeforeMatch,textAfterMatch,operator};
    }
}

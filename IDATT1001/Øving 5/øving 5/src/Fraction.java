public class Fraction{

    //this
    private int numerator = 0;
    private int denominator = 0;

    public Fraction(int x, int y) throws Exception{
        if(y == 0){
            throw new Exception("IllegalArgumentException");
        }
        else{
            numerator = x;
            denominator = y;
        }
    };

    public Fraction(int x){
        numerator = x;
        denominator = 1;
    };

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public void add(Fraction frac2){
        if(this.denominator == frac2.getDenominator()){
            numerator = this.numerator + frac2.getNumerator();
        }
        else{
            numerator = this.numerator * frac2.getDenominator() + frac2.getNumerator() * this.denominator;
            denominator = this.denominator * frac2.getDenominator();
        }
        shorten();
    }

    public void sub(Fraction frac2){
        if(this.denominator == frac2.getDenominator()){
            numerator = this.numerator - frac2.getNumerator();
        }
        else{
            numerator = this.numerator * frac2.getDenominator() - frac2.getNumerator() * this.denominator;
            denominator = this.denominator * frac2.getDenominator();
        }
        shorten();
    }

    public void mult(Fraction frac2){
        numerator = this.numerator * frac2.getNumerator();
        denominator = this.denominator * frac2.getDenominator();
        shorten();
    }

    public void div(Fraction frac2){
        numerator = this.numerator * frac2.getDenominator();
        denominator = this.denominator * frac2.getNumerator();
        shorten();
    }

    public void shorten(){
        if(this.numerator < this.denominator){
            for(int i = numerator +1; i > 0; i--){
                if(this.numerator % i == 0 && this.denominator % i == 0){
                    numerator = numerator / i;
                    denominator = denominator / i;
                }
            }
        }
        else if(this.numerator > this.denominator){
            for(int i = denominator +1; i > 0; i--){
                if(this.numerator % i == 0 && this.denominator % i == 0){
                    numerator = numerator / i;
                    denominator = denominator / i;
                }
            }
        }
        else{
            numerator = 1;
            denominator = 1;
        }
    }

    public void toConsole(){
        System.out.println(getNumerator());
        System.out.println(getDenominator());
    }

}
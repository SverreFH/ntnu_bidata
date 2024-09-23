public class Calculator {
    public double recursiveCalculate(int n, double x){
        if (n == 1) return x;
        return x + recursiveCalculate((n-1), x);
    }

    public double recursiveCalculateOddEven(int n, double x){
        if (n == 1) return x;
        if ((n & 1) == 0) return recursiveCalculateOddEven(n/2, (x + x));
        return  x + recursiveCalculateOddEven((n-1)/2, (x + x));
    }
}

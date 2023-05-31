public class zadanie20 {
    public static int round(double a)
    {
        int A = (int) a; // отбрасываем часть после запятой
        double raznost = a - A;

        if (raznost >= 0.5){
            A = A + 1;
        }
        return A;
    }
    public static double abs(double a)
    {
        if(a < 0){
            return -a;
        }else{
            return a;
        }
    }
    public static long pow(int a, double stepen)
    {
        long result = 1;
        if (stepen > 0){
            for (int i = 0; i < stepen; i++){
                result *= a;
            }
        } else {
            for (int i = 0; i > stepen; i--)
            {
                result *= a;
            }
        }
        return result;
    }


    public static void main(String[] args)
    {
        System.out.println(round(10000.49909089890));
        System.out.println(abs(-100000));
        System.out.println(pow(2, 21));


    }
}

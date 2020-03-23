import java.math.BigInteger;
import java.util.Random;

public class RsaParametersGenerator {
    private static Random random = new Random();

    public static BigInteger generateRandom(){
        BigInteger primeNumber = generate1024BigInteger();
        while (primeNumber.isProbablePrime(1) != true){
            primeNumber = generate1024BigInteger();
        }

        return primeNumber;
    }

    public static BigInteger generateRandomE(){
        BigInteger primeNumber = generate1024BigInteger();
        while (primeNumber.isProbablePrime(1) != true){
            primeNumber = generate512BigInteger();
        }

        return primeNumber;
    }

    private static BigInteger generate1024BigInteger(){
        return new BigInteger(1024, random);
    }

    private static BigInteger generate512BigInteger(){
        return new BigInteger(512, random);
    }
}

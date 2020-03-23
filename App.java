import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        BigInteger p;
        BigInteger q;
        BigInteger e;
        p = RsaParametersGenerator.generateRandom();
        q = RsaParametersGenerator.generateRandom();
        e = RsaParametersGenerator.generateRandomE();

        System.out.println(String.format("Сгенерированный набор простых чисел p=%s q=%s и e=%s", p, q, e));

        RsaAlghorithm rsa = new RsaAlghorithm(p, q, e);

        System.out.println(String.format("Шифруем число %s", 111111L));
        BigInteger encryptedValue = rsa.encryptValue(new BigInteger("111111"));
        System.out.println(String.format("Число в зашифрованном виде: %s", encryptedValue));
        BigInteger decryptedValue = rsa.decryptValue(encryptedValue);
        System.out.println(String.format("Дешифруем число: %s", decryptedValue));

        System.out.println(String.format("Шифруем строку: %s", "Simple Message Test"));
        BigInteger[] encryptedMessage = rsa.encryptMessage("Simple Message Test");
        System.out.println(String.format("Строка в зашифрованном виде: %s", encryptedMessage));
        String decryptedMessage = rsa.decryptMessage(encryptedMessage);
        System.out.println(String.format("Дешифруем строку: %s", decryptedMessage));

        System.out.println();
    }
}

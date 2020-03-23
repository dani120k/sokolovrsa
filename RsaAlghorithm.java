import java.math.BigInteger;

public class RsaAlghorithm{
    private BigInteger privateKey;
    private BigInteger e;
    private BigInteger module;
    private BigInteger p;
    private BigInteger q;
    private final BigInteger eulerFunctionResult;

    RsaAlghorithm(BigInteger p, BigInteger q, BigInteger e) {
        module = p.multiply(q);
        eulerFunctionResult = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
        this.e = e;
        this.p = p;
        this.q = q;
        privateKey = e.modInverse(eulerFunctionResult);
    }

    public BigInteger encryptValue(BigInteger message){
        return powerByMod(message, e, module);
    }

    private BigInteger powerByMod(BigInteger message, BigInteger e, BigInteger module) {
        return message.modPow(e, module);
    }

    public BigInteger decryptValue(BigInteger decryptedMessage){
        return powerByMod(decryptedMessage, privateKey, module);
    }

    public BigInteger[] encryptMessage(String message){
        int[] chars = stringToCharsArray(message);
        BigInteger[] cypher = new BigInteger[chars.length];
        for (int i = 0; i < chars.length; i++) {
            cypher[i] = encryptValue(BigInteger.valueOf(chars[i]));
        }
        return cypher;
    }

    public String decryptMessage(BigInteger[] cypher) {
        int[] chars = new int[cypher.length];
        for (int i = 0; i < cypher.length; i++) {
            chars[i] = decryptValue(cypher[i]).intValue();
        }
        return charsArrayToString(chars);
    }

    private static int[] stringToCharsArray(String str) {
        int[] characters = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            characters[i] = str.charAt(i);
        }
        return characters;
    }

    private static String charsArrayToString(int[] characters) {
        String str = "";
        for (int i = 0; i < characters.length; i++) {
            str = str + ((char) characters[i]);
        }
        return str;
    }
}

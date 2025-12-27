import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CryptoChain cryptoChain1 = new CryptoChain("Hello");
        CryptoChain cryptoChain2 = new CryptoChain("");
        CryptoChain cryptoChain3 = new CryptoChain("");
        CryptoChain cryptoChain4 = new CryptoChain("");
        CryptoChain cryptoChain5 = new CryptoChain("");

        CryptoChain[] cryptoChains = {cryptoChain1, cryptoChain2, cryptoChain3, cryptoChain4, cryptoChain5};

        for (int i = 0; i < cryptoChains.length-1; i++) {
            cryptoChains[i].setNext(cryptoChains[i + 1]);
        }

        CryptoChain current = cryptoChain1;
        int i = 0;
        String result1 = current.getValue() + i;
        char[] resultChar1 = new char[result1.length()];
        for (int j = 0; j < result1.length(); j++) {
            resultChar1[j] = result1.charAt(j);
        }
        current.getNext().setString(current.encrypt(resultChar1));
        current = current.getNext();
        System.out.println(current.getValue());
        i++;


        while (current.getNext() != null) {
//            расшифровка
            int[] res = new int[current.getValue().length()];
            for (int j = 0; j < res.length; j++) {
                res[j] = (int) current.getValue().charAt(j);
            }
            System.out.println(Arrays.toString(res));
            char[] resChar = current.decrypt(res);
//            добавили номер
            String resString = new String(resChar) + i;
//            зашифровка
            char[] resStringChar = new char[resString.length()];
            for (int j = 0; j < resString.length(); j++) {
                resStringChar[j] = resString.charAt(j);
            }


            current.getNext().setString(current.encrypt(resStringChar));
            current = current.getNext();
            System.out.println(current.getValue());
            i++;
        }
        int[] resLast = new int[current.getValue().length()];
        for (int j = 0; j < resLast.length; j++) {
            resLast[j] = (int) current.getValue().charAt(j);
        }
        char[] resLastChar = current.decrypt(resLast);
        String resLastString = new String(resLastChar) + i;

        System.out.println(resLastString);
    }

}

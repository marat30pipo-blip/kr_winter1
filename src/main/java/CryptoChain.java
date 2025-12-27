public class CryptoChain implements ChainElement, Crypto {
    private CryptoChain next;
    private CryptoChain prev;
    private String value;

    public CryptoChain(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setString(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += (char) arr[i];
        }

        this.value = result;
    }

    @Override
    public CryptoChain getNext() {
        return next;
    }

    @Override
    public int[] encrypt(char[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] ^ 0x123;
        }
        return newArr;
    }

    @Override
    public char[] decrypt(int[] arr) {
        char[] newArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = (char) (arr[i] ^ 0x123);
        }
        return newArr;
    }

    public void setNext(CryptoChain next) {
        this.next = next;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
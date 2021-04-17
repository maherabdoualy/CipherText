public class ShuffleCipher extends Cipher implements MessageEncoder, MessageDecoder {
    int n;

    public ShuffleCipher(int number) {
        n = number;
    }

    @Override
    String cipherType() {
        return "ShuffleCipher";
    }

    @Override
    public String encode(String PlainText) {
        String encodedText = PlainText;
        while (n > 0) {
            encodedText = oneShuffle(encodedText);
            n--;
        }
        return encodedText;
    }

    private String oneShuffle(String PlainText) {
        String encodedText = "";
        String first = ""; //to store each half
        String second = "";
        int m = 0, n = 0; //to loop through each string

        if (PlainText.length()%2==0) { //case string has even number of chars
            first = PlainText.substring(0, PlainText.length()/2);
            second = PlainText.substring(PlainText.length()/2);
        }
        else { //case string has odd number of chars
            first = PlainText.substring(0, PlainText.length()/2+1);
            second = PlainText.substring(PlainText.length()/2+1);
        }

        for (int i = 0; i < PlainText.length(); i++) { //loop to concatenate both half strings
          //this algo will add chars from first when i is even and chars from second when i is odd
            if (i % 2 == 0) {
                encodedText += first.charAt(m);
                m++;
            }
            else {
                encodedText += second.charAt(n);
                n++;
            }
        }
        // return output
        return encodedText;
    }

    @Override
    public String decode(String cipherText) {
        String decodedText = cipherText;
        while (n > 0) {
            decodedText = oneUnshuffle(decodedText);
            n--;
        }
        return decodedText;
    }

    private String oneUnshuffle(String cipherText) {
        String decodedText = "";
        //algorithm will go through cipherText and concatenate all the even positions then all the odd ones
        for (int i = 0; i < cipherText.length(); i += 2) {
            decodedText += cipherText.charAt(i);
        }
        for (int i = 1; i < cipherText.length(); i += 2) {
            decodedText += cipherText.charAt(i);
        }
        return decodedText;
    }
}
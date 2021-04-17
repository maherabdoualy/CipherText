public class SubstitutionCipher extends Cipher implements MessageEncoder, MessageDecoder{
    public int shift; //global var

    //constructor
   public SubstitutionCipher(int Shift){
       shift = Shift;
   }

   //override cipherType()
    @Override
    String cipherType() {
        return "SubstitutionCipher";
    }

    @Override
    public String encode(String PlainText) {
        // Convert to char array
        char[] encodedText = PlainText.toCharArray();
        // Loop over characters
        for (int i = 0; i < encodedText.length; i++) {
            // Shift letter
            char letter = encodedText[i];
            letter = (char) (letter + shift);
            encodedText[i] = letter;
        }
        //final string
        return new String(encodedText);

    }

    @Override
    public String decode(String cipherText) {
        char[] decodedText = cipherText.toCharArray();
        // Loop over characters
        for (int i = 0; i < decodedText.length; i++) {
            // Shift letter back to its original place
            char letter = decodedText[i];
            letter = (char)(letter - shift);
            decodedText[i] =letter;
        }
        //final string
        return new String(decodedText);
    }
}



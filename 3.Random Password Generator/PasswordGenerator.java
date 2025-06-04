import java.util.Random;
public class PasswordGenerator {
    String LOWERCASE_CHARACTERS="abcdefghijklmnopqrstuvwxyz";
    String UPPERCASE_CHARACTERS="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String NUMBERS="0123456789";
    String SPECIAL_SYMBOLS="!@#$%^&*()_+-=[]{}|;:,.<>?";
    
    private final Random random;
    public PasswordGenerator(){random=new Random();}
    
    public String generatePassword(int length,boolean includeUppercase,boolean includeLowercase,boolean includeNumbers,boolean includeSpecialSymbols){
        StringBuilder passwordBuilder=new StringBuilder();
        String ValidCharacters="";
        if(includeUppercase) ValidCharacters+=UPPERCASE_CHARACTERS;
        if(includeLowercase) ValidCharacters+=LOWERCASE_CHARACTERS;
        if(includeNumbers) ValidCharacters+=NUMBERS;
        if(includeSpecialSymbols) ValidCharacters+=SPECIAL_SYMBOLS;
        for(int i=0;i<length;i++){
            int randomIndex=random.nextInt(ValidCharacters.length());
            char randomChar=ValidCharacters.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }
        return passwordBuilder.toString();
    }
}

final class NewString {

    private static String string;
    
    public NewString(String str){
        string = str;
    }

    public String abreviate(){
        String abv = "";
        String[] words = string.split(" ");
        for(int i = 0; i < words.length; i++){
            char letter = words[i].charAt(0);
            abv += letter;
        }
        return abv;
    }

    public String removeChar(String letterToRemove){
        String newString = string.replace(letterToRemove, "");
        return newString;
    }

}

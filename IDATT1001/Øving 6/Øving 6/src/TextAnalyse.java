public class TextAnalyse {
    String text;

    public TextAnalyse(String txt){
        text = txt;
    };

    private static int[] letterList = new int[30];
    
    public int uniqueLetters(){
        int uniqueLetters = 0;
        for( int i = 'a'; i < 'z' + 1; i++){
            for(int j = 0; j < text.length(); j++){
                if(text.charAt(j) == i && letterList[i - 'a'] == 0){
                    uniqueLetters ++;
                    letterList[i - 'a'] ++;
                }
            }
        }
        return uniqueLetters;
    }

    public int totalLetters(){
        int total = 0;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) >= 'a' && text.charAt(i) <= 'z'){
                total ++;
            }
        }
        return total;
    }

    public double prosentLetters(){
        int letter = totalLetters();
        int total = text.length();
        double prosent = 100 - ((double)letter / (double)total)*100;
        return prosent;
    }

    public int numberOfLetter(char letter){
        int totalOfLetter = 0;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == letter){
                totalOfLetter++;
            }
        }
        return totalOfLetter;
    }

    public String mostCommonLetter(){
        int current = 0;
        int letterIndex = 0;
        String mostCommenChar = "";
        for(int i = 'a'; i < 'z' + 1; i++){
            int totalLetter = numberOfLetter((char)i);
            letterList[i - 'a'] = totalLetter;
        }

        for(int i = 0; i < 30; i++){
            
            if(current < letterList[i]){
                mostCommenChar = "";
                current = letterList[i];
                letterIndex = i + 'a';
                char let = (char) letterIndex;
                mostCommenChar += let;
            }
            else if(current == letterList[i]){
                current = letterList[i];
                letterIndex = i + 'a';
                char let = (char) letterIndex;
                mostCommenChar += let;
            }
        }
        
        return mostCommenChar;
    }

}

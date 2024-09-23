public class TextFormating {

    private String txt;
    
    public TextFormating(String text){
        txt = text;
    }

    public int totalWords(){
        int totalWords = 0;
        String[] words = txt.split(" ");
        totalWords = words.length;
        return totalWords;
    }

    public double averageWordLength(){
        int total = totalWords();
        int totalWordsLength = 0;
        String[] words = txt.split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = words[i].replace("!", "");
            words[i] = words[i].replace(".", "");
            words[i] = words[i].replace(",", "");
            words[i] = words[i].replace("?", "");
            words[i] = words[i].replace(" ", "");
            totalWordsLength += words[i].length();
        }
        double average = (double)totalWordsLength / (double)total;
        return average;
    }

    public double averageWordsPerPeriode(){
        String[] sentences = txt.split("[.!?:]");
        //TextFormating txtF = new TextFormating(txt);
        int totalWords = totalWords();
        int periodes = sentences.length;
        double perPeriode = (double)totalWords/(double)periodes;
        return perPeriode;   
    }

    public String replaceWord(String wordToReplace, String replaceWith){
        String[] textSplit = txt.split(" ");
        for(int i = 0; i < textSplit.length; i++){
            if(textSplit[i].equals(wordToReplace)){
                textSplit[i] = replaceWith;
            }
        }
        txt = String.join(" ", textSplit);
        return txt;
    }

    public String getText(){return txt;}

    public String getTextCapitalized(){return txt.toUpperCase();}

}

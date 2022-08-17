import java.util.*;

public class MinimumCharactersForWords {
    public static char[] minimumCharactersForWords(String[] words) {
        HashMap<String,Integer> perWord = new HashMap<>();
        HashMap<String,Integer> allWords = new HashMap<>();

        for(int word=0; word<words.length; word++){
            perWord = new HashMap<>();

            for(int i=0; i<words[word].length(); i++ ){
                // if(!perWord.containsKey(word.charAt(i)))
                perWord.put(String.valueOf(words[word].charAt(i)),
                        perWord.getOrDefault(String.valueOf(words[word].charAt(i)),0)+1);
                // else
                // perWord.put(word.charaAt(i),1);
            }

            for(Map.Entry<String,Integer> entry: perWord.entrySet()){
                if(allWords.containsKey(entry.getKey()))
                    allWords.put(entry.getKey(),
                            Math.max(allWords.get(entry.getKey()),  entry.getValue()));
                else
                    allWords.put( entry.getKey(), entry.getValue());
            }

        }

        List<String> solution = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: allWords.entrySet()){
            int numberOfTimes = entry.getValue();
            while(numberOfTimes > 0){
                solution.add(entry.getKey());
                numberOfTimes--;
            }
        }

        PriorityQueue<Integer> a = new PriorityQueue<>();
        a.add(1);

        char[] solutionArray = new char[solution.size()];
        for(int i=0; i<solution.size(); i++){
            solutionArray[i] = solution.get(i).charAt(0);
        }
        return solutionArray;
    }
}

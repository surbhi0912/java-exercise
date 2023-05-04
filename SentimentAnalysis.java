import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class SentimentAnalysis {

    public static final String POSITIVE = "positive";
    public static final String NEGATIVE = "negative";

    public static void main(String[] args) throws Exception {

        // Hello World
        System.out.println("*** Hello World ***");

        // Read a file
        String file ="sentiments.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();

        //Loop using "while" until there is nothing to read.

        Map<String, String> wordToSentinents = new HashMap<>();

        while(currentLine != null){
            System.out.println(" Reading from file "+currentLine);
            //Split line using "="
            String[] sentiments = currentLine.split("=");

            System.out.println(" First element of sentiments array "+sentiments[0]);
            System.out.println(" Second element of sentiments array "+sentiments[1]);
            System.out.println("================================");

            fillMap(wordToSentinents, sentiments[0], sentiments[1]);

            currentLine = reader.readLine();

        }
        reader.close();

        analyseSentiment(args, wordToSentinents);

    }

    private static void analyseSentiment(String[] args, Map<String, String> wordToSentinents) {
        if(args.length != 0) {
            String lineToTest = args[0];

            System.out.println("!! Sentence to Test: " + lineToTest);

            //Find how many negative word and how many positive word are there in this sentence
            //Break the sentence on spaces
            String[] words = lineToTest.split(" ");
            //Iterate and count positive and negative word
            int positive = 0;
            int negative = 0;
            for(String word : words){
                if(wordToSentinents.containsKey(word)){
                    String sentiment = wordToSentinents.get(word);
                    if(sentiment.equals(POSITIVE)){
                        positive = positive + 1;
                    }

                    if(sentiment.equals(NEGATIVE)){
                        negative = negative + 1;
                    }
                }
            }
            if(positive > negative){
                System.out.println("It's a positive sentence");
            } else if (positive < negative) {
                System.out.println("It's a negative sentence");
            } else {
                System.out.println("It's a neutral sentence");
            }
        }
    }

    private static void fillMap(Map<String, String> wordToSentinents, String sentiment, String words) {
        String[] wordArr = words.split(",");
        for(String word : wordArr){
            wordToSentinents.put(word, sentiment);
        }

        System.out.println(" Map "+wordToSentinents);
    }
}

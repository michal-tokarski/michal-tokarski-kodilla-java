package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain_71_task {

    public static void main(String[]args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("\n1. Change all to uppercase :");
        String inputText1 = "Only two things are infinite, the universe and human stupidity, and I'm not sure about the former";
        String outputText1 = poemBeautifier.beautify (inputText1, inputText ->  inputText.toUpperCase());
        System.out.println("- Input text...........: " + inputText1);
        System.out.println("- Output text..........: " + outputText1);

        System.out.println("\n2. Add string '<ABC>' at the beginning and at the end :");
        String inputText2 = "You can't judge a book by its cover";
        String outputText2 = poemBeautifier.beautify (inputText2, inputText ->  "<ABC>" + " " + inputText + " " + "<ABC>");
        System.out.println("- Input text...........: " + inputText2);
        System.out.println("- Output text..........: " + outputText2);

        System.out.println("\n3. Replace all spaces with '_' :");
        String inputText3 = "A ship in harbor is safe, but that is not what ships are built for";
        String outputText3 = poemBeautifier.beautify (inputText3, inputText -> inputText.replace(" ", "_"));
        System.out.println("- Input text...........: " + inputText3);
        System.out.println("- Output text..........: " + outputText3);

        System.out.println("\n4. Show only 20 first characters :");
        String inputText4 = "A picture is worth a thousand words";
        String outputText4 = poemBeautifier.beautify (inputText4, inputText ->  inputText.substring(0,20) );
        System.out.println("- Input text...........: " + inputText4);
        System.out.println("- Output text..........: " + outputText4);

    }

}

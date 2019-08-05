package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String inputText, PoemDecorator poemDecorator){
        return poemDecorator.decorate(inputText);
    }
}

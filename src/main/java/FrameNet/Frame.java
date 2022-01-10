package FrameNet;

import java.util.ArrayList;

public class Frame {

    private String name;
    private ArrayList<String> lexicalUnits;
    private ArrayList<String> frameElements;

    /**
     * Constructor of {@link Frame} class which takes inputStream as input and reads the frame
     *
     * @param name  Name of the frame
     */
    public Frame(String name){
        this.name = name;
        lexicalUnits = new ArrayList<>();
        frameElements = new ArrayList<>();
    }

    public void addLexicalUnit(String lexicalUnit){
        lexicalUnits.add(lexicalUnit);
    }

    public void addFrameElement(String frameElement){
        frameElements.add(frameElement);
    }

    public boolean lexicalUnitExists(String lexicalUnit){
        return lexicalUnits.contains(lexicalUnit);
    }

    public String getLexicalUnit(int index){
        return lexicalUnits.get(index);
    }

    public String getFrameElement(int index){
        return frameElements.get(index);
    }

    public int lexicalUnitSize(){
        return lexicalUnits.size();
    }

    public int frameElementSize(){
        return frameElements.size();
    }

    public String getName(){
        return name;
    }

}

package FrameNet;

import java.util.ArrayList;

public class Frame {

    private final String name;
    private final ArrayList<String> lexicalUnits;
    private final ArrayList<String> frameElements;

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

    /**
     * Adds a new lexical unit to the current frame
     * @param lexicalUnit Lexical unit to be added
     */
    public void addLexicalUnit(String lexicalUnit){
        lexicalUnits.add(lexicalUnit);
    }

    /**
     * Adds a new frame element to the current frame
     * @param frameElement Frame element to be added
     */
    public void addFrameElement(String frameElement){
        frameElements.add(frameElement);
    }

    /**
     * Checks if the given lexical unit exists in the current frame
     * @param lexicalUnit Lexical unit to be searched.
     * @return True if the lexical unit exists, false otherwise.
     */
    public boolean lexicalUnitExists(String lexicalUnit){
        return lexicalUnits.contains(lexicalUnit);
    }

    /**
     * Accessor for a given index in the lexicalUnit array.
     * @param index Index of the lexical unit
     * @return The lexical unit at position index in the lexicalUnit array
     */
    public String getLexicalUnit(int index){
        return lexicalUnits.get(index);
    }

    /**
     * Accessor for a given index in the frameElements array.
     * @param index Index of the frame element
     * @return The frame element at position index in the frameElements array
     */
    public String getFrameElement(int index){
        return frameElements.get(index);
    }

    /**
     * Returns number of lexical units in the current frame
     * @return Number of lexical units in the current frame
     */
    public int lexicalUnitSize(){
        return lexicalUnits.size();
    }

    /**
     * Returns number of frame elements in the current frame
     * @return Number of frame elements in the current frame
     */
    public int frameElementSize(){
        return frameElements.size();
    }

    /**
     * Accessor for the name of the frame
     * @return Name of the frame
     */
    public String getName(){
        return name;
    }

}

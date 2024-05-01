package FrameNet;

import Xml.XmlDocument;
import Xml.XmlElement;

import java.io.InputStream;
import java.util.ArrayList;

public class FrameNet {

    private final ArrayList<Frame> frames;

    /**
     * A constructor of {@link FrameNet} class which reads all frame files inside the files2.txt file. For each
     * filename inside that file, the constructor creates a FrameNet.Frame and puts in inside the frames {@link ArrayList}.
     */
    public FrameNet(){
        frames = new ArrayList<>();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("framenet.xml");
        XmlDocument doc = new XmlDocument(inputStream);
        doc.parse();
        XmlElement frameNet = doc.getFirstChild();
        XmlElement frameNode = frameNet.getFirstChild();
        while (frameNode != null){
            Frame currentFrame = new Frame(frameNode.getAttributeValue("NAME"));
            XmlElement lexicalUnits = frameNode.getFirstChild();
            XmlElement lexicalUnit = lexicalUnits.getFirstChild();
            while (lexicalUnit != null){
                currentFrame.addLexicalUnit(lexicalUnit.getPcData());
                lexicalUnit = lexicalUnit.getNextSibling();
            }
            XmlElement frameElements = lexicalUnits.getNextSibling();
            XmlElement frameElement = frameElements.getFirstChild();
            while (frameElement != null){
                currentFrame.addFrameElement(frameElement.getPcData());
                frameElement = frameElement.getNextSibling();
            }
            frames.add(currentFrame);
            frameNode = frameNode.getNextSibling();
        }
    }

    /**
     * Checks if the given lexical unit exists in any frame in the frame set.
     * @param synSetId Id of the lexical unit
     * @return True if any frame contains the given lexical unit, false otherwise.
     */
    public boolean lexicalUnitExists(String synSetId){
        for (Frame frame : frames){
            if (frame.lexicalUnitExists(synSetId)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an array of frames that contain the given lexical unit in their lexical units
     * @param synSetId Id of the lexical unit.
     * @return An array of frames that contains the given lexical unit.
     */
    public ArrayList<Frame> getFrames(String synSetId){
        ArrayList<Frame> result = new ArrayList<>();
        for (Frame frame : frames){
            if (frame.lexicalUnitExists(synSetId)){
                result.add(frame);
            }
        }
        return result;
    }

    /**
     * Returns number of frames in the frame set.
     * @return Number of frames in the frame set.
     */
    public int size(){
        return frames.size();
    }

    /**
     * Returns the element at the specified position in the frame list.
     * @param index index of the element to return
     * @return The element at the specified position in the frame list.
     */
    public Frame getFrame(int index){
        return frames.get(index);
    }

}

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

    public boolean lexicalUnitExists(String synSetId){
        for (Frame frame : frames){
            if (frame.lexicalUnitExists(synSetId)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Frame> getFrames(String synSetId){
        ArrayList<Frame> result = new ArrayList<>();
        for (Frame frame : frames){
            if (frame.lexicalUnitExists(synSetId)){
                result.add(frame);
            }
        }
        return result;
    }

    public int size(){
        return frames.size();
    }

    public Frame getFrame(int index){
        return frames.get(index);
    }

}

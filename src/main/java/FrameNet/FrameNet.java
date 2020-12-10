package FrameNet;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FrameNet {

    private ArrayList<Frame> frames;

    /**
     * A constructor of {@link FrameNet} class which reads all frame files inside the files2.txt file. For each
     * filename inside that file, the constructor creates a FrameNet.Frame and puts in inside the frames {@link ArrayList}.
     */
    public FrameNet(){
        frames = new ArrayList<Frame>();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("framenet.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream, "UTF-8");
            NodeList nodeList = doc.getElementsByTagName("FRAME");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node frameNode = nodeList.item(i);
                String name = frameNode.getAttributes().getNamedItem("NAME").getNodeValue();
                Frame frame = new Frame(name);
                Node childNode = frameNode.getFirstChild();
                while (childNode != null){
                    if (childNode.getNodeName().equals("LEXICAL_UNITS")){
                        Node lexicalNode = childNode.getFirstChild();
                        while (lexicalNode != null){
                            if (lexicalNode.getNodeName().equals("LEXICAL_UNIT")){
                                frame.addLexicalUnit(lexicalNode.getFirstChild().getNodeValue());
                            }
                            lexicalNode = lexicalNode.getNextSibling();
                        }
                    } else {
                        if (childNode.getNodeName().equals("FRAME_ELEMENTS")){
                            Node elementNode = childNode.getFirstChild();
                            while (elementNode != null){
                                if (elementNode.getNodeName().equals("FRAME_ELEMENT")){
                                    frame.addFrameElement(elementNode.getFirstChild().getNodeValue());
                                }
                                elementNode = elementNode.getNextSibling();
                            }
                        }
                    }
                    childNode = childNode.getNextSibling();
                }
                frames.add(frame);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
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

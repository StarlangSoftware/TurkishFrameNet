package FrameNet;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Frame {

    private String name;
    private ArrayList<LexicalUnit> lexicalUnits;

    /**
     * Constructor of {@link Frame} class which takes inputStream as input and reads the frame
     *
     * @param name  Name of the frame
     * @param inputStream  inputStream to read frame
     */
    public Frame(String name, InputStream inputStream){
        this.name = name;
        lexicalUnits = new ArrayList<LexicalUnit>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream, "UTF-8");
            NodeList nodeList = doc.getElementsByTagName("LEXICALUNIT");
            for (int i = 0; i < nodeList.getLength(); i++) {
                lexicalUnits.add(new LexicalUnit(nodeList.item(i)));
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public boolean lexicalUnitExists(String synSetId){
        for (LexicalUnit lexicalUnit : lexicalUnits){
            if (lexicalUnit.getSynSetId().equals(synSetId)){
                return true;
            }
        }
        return false;
    }

    public LexicalUnit getLexicalUnitWithId(String synSetId){
        for (LexicalUnit lexicalUnit : lexicalUnits){
            if (lexicalUnit.getSynSetId().equals(synSetId)){
                return lexicalUnit;
            }
        }
        return null;
    }

    public LexicalUnit getLexicalUnit(int index){
        return lexicalUnits.get(index);
    }

    public int size(){
        return lexicalUnits.size();
    }

    public String getName(){
        return name;
    }
}

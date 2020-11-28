package FrameNet;

import org.w3c.dom.Node;

import java.io.PrintWriter;
import java.util.ArrayList;

public class LexicalUnit {

    private String synSetId;
    private ArrayList<String> frameElements;

    public LexicalUnit(Node node){
        Node elementNode;
        frameElements = new ArrayList<>();
        synSetId = node.getAttributes().getNamedItem("ID").getNodeValue();
        elementNode = node.getFirstChild();
        while (elementNode != null){
            if (elementNode.getNodeName().equals("ELEMENT")){
                frameElements.add(elementNode.getFirstChild().getNodeValue().trim());
            }
            elementNode = elementNode.getNextSibling();
        }
    }

    public String getSynSetId(){
        return synSetId;
    }

    public int size(){
        return frameElements.size();
    }

    public ArrayList<String> getFrameElements(){
        return frameElements;
    }

    public void save(PrintWriter output){
        output.println("<LEXICALUNIT ID=\"" + synSetId + "\">");
        for (String frameElement : frameElements){
            output.println("<ELEMENT>" + frameElement + "</ELEMENT>");
        }
        output.println("</LEXICALUNIT>");
    }
}

package FrameNet;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class FrameNetTest {
    FrameNet frameNet = new FrameNet();

    @Test
    public void testFrameSize() {
        assertEquals(139, frameNet.size());
    }

    @Test
    public void testLexicalUnitSize() {
        int count = 0;
        for (int i = 0; i < frameNet.size(); i++){
            count += frameNet.getFrame(i).size();
        }
        assertEquals(2561, count);
    }

    @Test
    public void testFrameElementSize() {
        int count = 0;
        for (int i = 0; i < frameNet.size(); i++){
            for (int j = 0; j < frameNet.getFrame(i).size(); j++) {
                count += frameNet.getFrame(i).getLexicalUnit(j).size();
            }
        }
        assertEquals(10476, count);
    }

    @Test
    public void testDistinctFrameElements() {
        HashSet<String> elements = new HashSet<>();
        for (int i = 0; i < frameNet.size(); i++){
            for (int j = 0; j < frameNet.getFrame(i).size(); j++) {
                for (String element : frameNet.getFrame(i).getLexicalUnit(j).getFrameElements()){
                    elements.add(element);
                }
            }
        }
        assertEquals(203, elements.size());
    }

}
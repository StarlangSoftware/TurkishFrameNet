package FrameNet;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class FrameNetTest {
    FrameNet frameNet = new FrameNet();
    
    @Test
    public void testFrameSize() {
        assertEquals(809, frameNet.size());
    }

    @Test
    public void testLexicalUnitSize() {
        int count = 0;
        for (int i = 0; i < frameNet.size(); i++){
            count += frameNet.getFrame(i).lexicalUnitSize();
        }
        assertEquals(8493, count);
    }

    @Test
    public void testFrameElementSize() {
        int count = 0;
        for (int i = 0; i < frameNet.size(); i++){
            count += frameNet.getFrame(i).frameElementSize();
        }
        assertEquals(8656, count);
    }

    @Test
    public void testDistinctFrameElements() {
        HashSet<String> elements = new HashSet<>();
        for (int i = 0; i < frameNet.size(); i++){
            for (int j = 0; j < frameNet.getFrame(i).frameElementSize(); j++){
                elements.add(frameNet.getFrame(i).getFrameElement(j));
            }
        }
        assertEquals(1012, elements.size());
    }

}
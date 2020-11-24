package FrameNet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameElementTest {

    @Test
    public void testFrameElement() {
        FrameElement frameElement = new FrameElement("Agent$TUR10-0100230");
        assertEquals("Agent", frameElement.getFrameElementType());
        assertEquals("TUR10-0100230", frameElement.getId());
        assertEquals("Agent$TUR10-0100230", frameElement.toString());
    }

}

package FrameNet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameElementTest {

    @Test
    public void testFrameElement() {
        FrameElement frameElement = new FrameElement("Agent$Apply_Heat$TUR10-0100230");
        assertEquals("Agent", frameElement.getFrameElementType());
        assertEquals("Apply_Heat", frameElement.getFrame());
        assertEquals("TUR10-0100230", frameElement.getId());
        assertEquals("Agent$Apply_Heat$TUR10-0100230", frameElement.toString());
    }

}

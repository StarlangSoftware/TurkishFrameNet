package FrameNet;

import java.util.Objects;

public class DisplayedFrame {
    private final Frame frame;
    private final String lexicalUnit;

    /**
     * Constructur for the DisplayedFrame class. DisplayedFrame is a pair object just to store a Frame with one of its
     * Lexical units to be displayed.
     * @param frame Frame to be displayed
     * @param lexicalUnit Lexical unit of the frame to be displayed
     */
    public DisplayedFrame(Frame frame, String lexicalUnit) {
        this.frame = frame;
        this.lexicalUnit = lexicalUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayedFrame that = (DisplayedFrame) o;
        return frame.getName().equals(that.frame.getName()) &&
                lexicalUnit.equals(that.lexicalUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frame, lexicalUnit);
    }

    /**
     * Accessor for the frame attribute
     * @return Frame
     */
    public Frame getFrame() {
        return frame;
    }

    /**
     * Accessor for the lexical unit attribute
     * @return Lexical unit
     */
    public String getLexicalUnit() {
        return lexicalUnit;
    }

    @Override
    public String toString() {
        return frame.getName();
    }
}

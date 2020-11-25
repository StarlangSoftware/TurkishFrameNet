package FrameNet;

public class FrameElement {

    private String frameElementType;
    private String frame;
    private String id;

    /**
     * A constructor of {@link FrameElement} class which takes frameElement string which is in the form of frameElementType$id
     * and parses this string into frameElementType and id. If the frameElement string does not contain '$' then the
     * constructor return a NONE type frameElement.
     *
     * @param frameElement  Argument string containing the argumentType and id
     */
    public FrameElement(String frameElement){
        if (frameElement.contains("$")){
            frameElementType = frameElement.substring(0, frameElement.indexOf("$"));
            frame = frameElement.substring(frameElement.indexOf("$") + 1, frameElement.lastIndexOf("$"));
            id = frameElement.substring(frameElement.lastIndexOf("$") + 1);
        } else {
            frameElementType = "NONE";
        }
    }

    /**
     * Another constructor of {@link FrameElement} class which takes frameElementType and id as inputs and initializes corresponding attributes
     *
     * @param frameElementType  Type of the frameElement
     * @param frame  Frame of the frameElement
     * @param id  Id of the frameElement
     */
    public FrameElement(String frameElementType, String frame, String id){
        this.frameElementType = frameElementType;
        this.frame = frame;
        this.id = id;
    }

    /**
     * Accessor for frameElementType.
     *
     * @return frameElementType.
     */
    public String getFrameElementType(){
        return frameElementType;
    }

    /**
     * Accessor for frame.
     *
     * @return frame.
     */
    public String getFrame(){
        return frame;
    }

    /**
     * Accessor for id.
     *
     * @return id.
     */
    public String getId(){
        return id;
    }

    /**
     * toString converts an {@link FrameElement} to a string. If the frameElementType is "NONE" returns only "NONE", otherwise
     * it returns argument string which is in the form of frameElementType$id
     *
     * @return string form of frameElement
     */
    public String toString(){
        if (frameElementType.equals("NONE")){
            return frameElementType;
        } else {
            return frameElementType + "$" + frame + "$" + id;
        }
    }

}

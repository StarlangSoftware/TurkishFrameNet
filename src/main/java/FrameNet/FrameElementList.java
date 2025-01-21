package FrameNet;

import java.util.ArrayList;

public class FrameElementList {

    private final ArrayList<FrameElement> frameElements;

    /**
     * Constructor of frame element list from a string. The frame elements for a word is a concatenated list of
     * frame element separated via '#' character.
     * @param frameElementList String consisting of frame elements separated with '#' character.
     */
    public FrameElementList(String frameElementList) {
        frameElements = new ArrayList<>();
        String[] items = frameElementList.split("#");
        for (String item : items) {
            frameElements.add(new FrameElement(item));
        }
    }

    /**
     * Overloaded toString method to convert a frame element list to a string. Concatenates the string forms of all
     * frame element with '#' character.
     * @return String form of the frame element list.
     */
    public String toString(){
        if (frameElements.isEmpty()){
            return "NONE";
        } else {
            String result = frameElements.get(0).toString();
            for (int i = 1; i < frameElements.size(); i++){
                result += "#" + frameElements.get(i).toString();
            }
            return result;
        }
    }

    /**
     * Replaces id's of predicates, which have previousId as synset id, with currentId.
     * @param previousId Previous id of the synset.
     * @param currentId Replacement id.
     */
    public void updateConnectedId(String previousId, String currentId){
        for (FrameElement frameElement : frameElements) {
            if (frameElement.getId().equals(previousId)){
                frameElement.setId(currentId);
            }
        }
    }

    /**
     * Adds a predicate argument to the frame element list of this word.
     * @param predicateId Synset id of this predicate.
     */
    public void addPredicate(String predicateId){
        if (!frameElements.isEmpty() && frameElements.get(0).getFrameElementType().equals("NONE")){
            frameElements.remove(0);
        }
        frameElements.add(new FrameElement("PREDICATE", "NONE", predicateId));
    }

    /**
     * Removes the predicate with the given predicate id.
     */
    public void removePredicate(){
        for (FrameElement frameElement : frameElements) {
            if (frameElement.getFrameElementType().equals("PREDICATE")){
                frameElements.remove(frameElement);
                break;
            }
        }
    }

    /**
     * Checks if one of the frame elements is a predicate.
     * @return True, if one of the frame elements is predicate; false otherwise.
     */
    public boolean containsPredicate(){
        for (FrameElement frameElement : frameElements) {
            if (frameElement.getFrameElementType().equals("PREDICATE")){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if one of the frame element is a predicate with the given id.
     * @param predicateId Synset id to check.
     * @return True, if one of the frame element is predicate; false otherwise.
     */
    public boolean containsPredicateWithId(String predicateId){
        for (FrameElement frameElement : frameElements) {
            if (frameElement.getFrameElementType().equals("PREDICATE") && frameElement.getId().equals(predicateId)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the frame elements as an array list of strings.
     * @return Frame elements as an array list of strings.
     */
    public ArrayList<String> getFrameElements() {
        ArrayList<String> result = new ArrayList<>();
        for (FrameElement frameElement : frameElements) {
            result.add(frameElement.toString());
        }
        return result;
    }

    /**
     * Checks if the given argument with the given type and id exists or not.
     * @param frameElementType Type of the frame element to search for.
     * @param frame frame Name of the frame to search for
     * @param id Id of the frame element to search for.
     * @return True if the frame element exists, false otherwise.
     */
    public boolean containsFrameElement(String frameElementType, String frame, String id){
        for (FrameElement frameElement : frameElements) {
            if (frameElement.getFrameElementType().equals(frameElementType) &&
                    frameElement.getFrame().equals(frame) &&
                    frameElement.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}

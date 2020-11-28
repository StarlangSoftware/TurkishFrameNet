package FrameNet;

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
        InputStream inputStream = classLoader.getResourceAsStream("files2.txt");
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()){
            String fileName = scanner.next();
            frames.add(new Frame(fileName.substring(0, fileName.indexOf(".xml")), classLoader.getResourceAsStream(fileName)));
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

    public void save(String folder){
        for (Frame frame : frames){
            frame.save(folder);
        }
    }

}

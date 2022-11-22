import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Node {


    private File folder;
    private ArrayList<Node> children;

    private long size;

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Node(File folder){
        this.folder = folder;
        children = new ArrayList<>();
    }

    public File getFolder(){
        return this.folder;
    }
    public void addChild(Node node){
        children.add(node);
    }

    public ArrayList<Node> getChildren(){
        return children;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + " - " + size + "\n");
        for (Node child : children)
        {
            builder.append("  " + child.toString());
        }
        return builder.toString();
    }
}

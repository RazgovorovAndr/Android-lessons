import java.nio.file.Path;

abstract public class AbstractFileSystemNode implements FileSystemNode{

    FileSystemNode parent_node = null;
    String name;

    public String name(){
        return name;
    }

    public final FileSystemNode parent(){
        return parent_node;
    }

    public final void setParent(FileSystemNode _parent){
        parent_node = _parent;
    }

    public final String path(){
        String result = "/" + name;
        FileSystemNode current = parent_node;
        while(current != null){
            result = "/" + current.name() + result;
            current = current.parent();
        }
        return result;
    }
}

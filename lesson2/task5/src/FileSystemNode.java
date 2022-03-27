public interface FileSystemNode{
    public String name();
    public FileSystemNode parent();
    public void setParent(FileSystemNode _parent);
    public String path();
};

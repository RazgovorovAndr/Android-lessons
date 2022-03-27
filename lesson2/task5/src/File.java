public class File extends AbstractFileSystemNode{
    File( String _name ){
        name = _name;
    }

    public String extension(){
        int index = name.lastIndexOf('.');
        return name.substring(index);
    }
}

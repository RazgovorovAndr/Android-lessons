public class Folder extends  AbstractFileSystemNode{

    FileSystemNode nodes[];

    Folder(String _name, FileSystemNode ... _nodes){
        nodes = _nodes;
        for(FileSystemNode node: nodes){
            node.setParent(this);
        }
        name = _name;
    }

    FileSystemNode[] childred(){
        return nodes;
    }

    public void printNFile(int number){
        if( number < 0 ){
            System.out.println("pass positive or zero number instead of: " + number);
            return;
        }

        int count = 0;
        for(FileSystemNode node : nodes){
            if(!(node instanceof File))
                continue;

            if(count == number){
                System.out.println("n_file path = " + node.path());
                return;
            }
            count++;
        }
        System.out.println("no file number: " + number +  " in folder " + name);
    }
}

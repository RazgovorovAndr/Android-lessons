public class Main {

    public static void main(String[] args){
        System.out.println("Hello! It's my own file system!");
        File picture_jpeg = new File("picture.jpeg");
        File query_sql = new File("query.sql");
        File query2_sql = new File("query2.sql");
        File doc_txt = new File("doc.txt");

        Folder with_sql = new Folder( "sql_inside", query_sql );
        Folder empty_folder = new Folder( "empty_folder");
        Folder empty_folder2 = new Folder( "empty_folder2");
        Folder full_folder = new Folder( "full_folder", doc_txt, picture_jpeg, query2_sql, empty_folder );
        Folder with_full_folder = new Folder( "with_full_folder", full_folder );
        Folder root = new Folder( "root", empty_folder2, with_full_folder, with_sql );

        System.out.println("root path = " + root.path() );
        System.out.println("with_sql path = " + query_sql.path() );
        System.out.println("picture_jpeg path = " + picture_jpeg.path() );
        full_folder.printNFile(5);
        full_folder.printNFile(1);
    }
}

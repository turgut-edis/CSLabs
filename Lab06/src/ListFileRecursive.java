import java.io.File;

/**
 * This class lists the number of files in directory with recursively
 * @author Turgut Alp Edis
 * date: 8/12/20
 */
public class ListFileRecursive {

    public static void main( String[] args ){

        //CONSTANTS

        //Variables
        String path;
        File folder;
        File[] files;
        int fileNumber;

        //Program Code
        path = "C:\\Users\\TurgutAlp\\Downloads\\lab05";
        folder = new File( path );
        files = folder.listFiles();
        fileNumber = countFiles( files , 0 );

        System.out.print(" Total file number in " + folder.getName() + ": ");
        System.out.println(fileNumber);

    }

    /**
     * This method counts total file amount in file array with the distinction of folder and file
     * @param files the file array obtained from main directory
     * @param index the index number of file array
     * @return the file count in file array
     */
    private static int countFiles(File[] files, int index) {
        int fileCnt = 0;
        //Base case: if the index equals or bigger than length of file array, the file count returns which is zero
        if ( index >= files.length )
            return fileCnt;
        //Main case: if the index is below, checks if the current file is really a file.
        //If it is directory, recursive call occurs
        else {
            if ( files[index].isFile() ) {
                fileCnt++;
            }
            else if ( files[index].isDirectory() )
                fileCnt = fileCnt + countFiles(files[index].listFiles(), 0 );

            return fileCnt + countFiles( files, index + 1 );
        }
    }
}

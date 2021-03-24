
import model_builder.ModelBuilder;
import org.apache.commons.io.FilenameUtils;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class FileLoader {
    private static ModelBuilder builder = new ModelBuilder();


    // Generate a .glb or .gltf model of a graph reading the information from a text file
    public static void loadModel(){
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                Scanner input = new Scanner(System.in);
                File file = chooser.getSelectedFile();
                input = new Scanner(file);

                while (input.hasNextLine()) {
                    String element = input.nextLine();
                    String[] elements = element.split("#");
                    if(elements[0].equals("S")){
                        float cX = Float.parseFloat(elements[1]);
                        float cY = Float.parseFloat(elements[2]);
                        float cZ = Float.parseFloat(elements[3]);
                        double r = Double.parseDouble(elements[4]);
                        String text  = elements[5];
                        builder.loadSNode(cX,cY,cZ,r,null,text);
                    }
                    else if(elements[0].equals("P")){
                        float cX = Float.parseFloat(elements[1]);
                        float cY = Float.parseFloat(elements[2]);
                        float cZ = Float.parseFloat(elements[3]);
                        float height = Float.parseFloat(elements[4]);
                        float width = Float.parseFloat(elements[5]);
                        float depth = Float.parseFloat(elements[6]);
                        String text  = elements[7];
                        builder.loadPNode(cX,cY,cZ,height,width,depth,null,text);
                    }
                    else{
                        float p1X = Float.parseFloat(elements[1]);
                        float p1Y = Float.parseFloat(elements[2]);
                        float p1Z = Float.parseFloat(elements[3]);
                        float p2X = Float.parseFloat(elements[4]);
                        float p2Y = Float.parseFloat(elements[5]);
                        float p2Z = Float.parseFloat(elements[6]);
                        String text  = elements[7];
                        builder.loadEdge(p1X,p1Y,p1Z,p2X,p2Y,p2Z,null,text);
                    }
                }
                input.close();
                String fileName = FilenameUtils.removeExtension(file.getName());
                GoogleDriveService.fileCreator(builder,fileName);
                builder.deleteAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

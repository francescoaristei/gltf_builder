package model_builder;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileGenerator {
    private final static String OUT_PATH = "src/main/java/model/";

    public static File getFile(String _name) throws IOException {
        Path relativePath = Paths.get(OUT_PATH +_name+ ".glb");
        Path absolutePath = relativePath.toAbsolutePath();
            File _outFile = absolutePath.toFile();
        _outFile.getParentFile().mkdirs();
        return _outFile;
    }
}


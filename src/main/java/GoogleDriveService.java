import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import model_builder.FileGenerator;
import model_builder.ModelBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class GoogleDriveService {
    private static final String APPLICATION_NAME = "Google Drive API Java Tesi";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final java.util.List<String> SCOPES = (List<String>) Collections.singletonList(DriveScopes.DRIVE_FILE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    public static void fileCreator(ModelBuilder builder, String fileName) throws Exception {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        java.io.File _outFile = FileGenerator.getFile(fileName);
        builder.buildModel(_outFile);
        File fileMetadata = new File();
        fileMetadata.setName(fileName + ".glb");
        java.io.File filePath = new java.io.File("src/main/java/model/" + fileName + ".glb");
        FileContent mediaContent = new FileContent(null, filePath);
        File file = service.files().create(fileMetadata, mediaContent)
                .setFields("id, parents")
                .execute();
        System.out.println("File ID: " + file.getId());
        GoogleDriveService.deletetempFile(fileName);
        GoogleDriveService.deleteToken();
    }

   private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {

        // Load client secrets.
        InputStream in = FileMaker.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, (Collection<String>) SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        System.out.println(flow);

        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        System.out.println(receiver.getHost());
       AuthorizationCodeInstalledApp acia = new AuthorizationCodeInstalledApp(flow,receiver);
       System.out.println(acia.getFlow().getCredentialDataStore().getId());
       return acia.authorize("user");
   }


   // Delete the token
    public static void deleteToken(){
        try
        {
            Files.deleteIfExists(Paths.get("./tokens/StoredCredential"));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty.");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }

        System.out.println("Deletion successful.");
    }


    // Delete the files once has been loaded
    public static void deletetempFile(String name){
        try
        {
            Files.deleteIfExists(Paths.get("src/main/java/model/"+ name + ".glb"));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty.");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }

        System.out.println("Deletion successful.");
    }
}

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnectionTest {
    public static void main(String[] args) {
        String uri = "mongodb+srv://kunalsable990:1234@cluster0.pbdsl.mongodb.net/journalDB?retryWrites=true&w=majority&appName=Cluster0";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("journalDB");
            System.out.println("Connected to the database successfully");
        } catch (MongoException e) {
            System.err.println("An error occurred while attempting to connect to MongoDB: " + e.getMessage());
        }
    }
}
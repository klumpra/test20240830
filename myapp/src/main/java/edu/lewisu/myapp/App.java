package edu.lewisu.myapp;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Connect to MongoDB
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://raymondklump:8VDwmsjS85Ylhoq1@cluster0.0tomtgx.mongodb.net/?retryWrites=true&w=majority")) {
            MongoDatabase database = mongoClient.getDatabase("CBS");

            // Perform operations with the database here
            System.out.println("Connected to the database successfully");
            MongoCollection<Document> collection = database.getCollection("DDPRO");
/*            Document doc = new Document("name", "John Doe")
                                .append("age", 30)
                                .append("city", "New York");
            collection.insertOne(doc);
*/
            FindIterable<Document> documents = collection.find(new Document("AssignedTo", "Brender, Joe"));
            for (Document document : documents) {
                System.out.println(document.toJson());            	
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

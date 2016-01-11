package com.somallg.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient("localhost:37017");
        MongoDatabase db = mongoClient.getDatabase("enron");

        FindIterable<Document> messages = db.getCollection("messages").find(
                new Document("mailbox", "bass-e")
        ).limit(1);

        messages.forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document);
            }
        });

    }
}

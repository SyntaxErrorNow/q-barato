package com.management.modelo.database;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String CONNECTION_STRING = "mongodb+srv://syntaxerrorcorp:sintaxis2023@sintaxerror.sbuvjlw.mongodb.net/q-barato";
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoDBConnection instance = null;
    private MongoDBConnection(){

        CodecRegistry codecRegistry =CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        ConnectionString connString = new ConnectionString(CONNECTION_STRING);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("q-barato").withCodecRegistry(codecRegistry);
        System.out.println("MongoDB conexion exitosa.");
    }

    public static MongoDBConnection getInstance() {
        if(instance == null) {
            instance = new MongoDBConnection();
        }

        return instance;
    }


    public static MongoDatabase getDatabase(){
        return database;
    }

}

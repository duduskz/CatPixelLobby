package cn.lemonnetwork.catpixellobby.LeaderBoard.database;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.UUID;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDB {
  private MongoClient mongoClient = new MongoClient(((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getString("database.host"), ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getInt("database.port"));
  
  private MongoDatabase database = this.mongoClient.getDatabase(((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getString("database.database"));
  
  private MongoCollection<Document> playerCollection = this.database.getCollection("leaderboards");
  
  public void savePlayerData(UUID playerUUID, String player, String mode, String time, String view, String players, String alignment) {
    Document playerData = (new Document("uuid", playerUUID.toString())).append("name", player).append("mode", mode).append("time", time).append("view", view).append("players", players).append("alignment", alignment);
    if (this.playerCollection.find((Bson)new Document("uuid", playerUUID.toString())).first() != null)
      return; 
    this.playerCollection.insertOne(playerData);
  }
  
  public void updatePlayerData(UUID playerUUID, String type, String data) {
    if (this.playerCollection.find((Bson)new Document("uuid", playerUUID.toString())).first() == null)
      return; 
    Document document1 = new Document("uuid", playerUUID.toString());
    Document document2 = new Document("$set", new Document(type, data));
    this.playerCollection.updateOne((Bson)document1, (Bson)document2);
  }
  
  public String getPlayerData(UUID playerUUID, String type) {
    Document playerData = (Document)this.playerCollection.find(Filters.eq("uuid", playerUUID.toString())).first();
    if (playerData != null)
      return playerData.getString(type); 
    return null;
  }
}

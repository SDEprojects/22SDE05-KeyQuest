package com.game;

import org.json.JSONObject;
import static com.game.JSONParser.*;

public class Item {
    private final String name;// = getItemName() ;
    private final String room;// = getItemRoom();
    private final String furniture;//= getItemFurniture();
    private final String usage;//= getItemUsage();

   /* JSONObject jsonObjectItem = JSONParser.ReadJSON("items.json");
    JSONObject items = jsonObjectItem.getJSONObject("item");*/

    public Item(String name){
        this.name = name;
    /*String roomKey = "room";
    String furnitureKey = "furniture";
    String usageKey = "usage";
    JSONObject information = items.getJSONObject(name);
    room = information.getString(roomKey);
    furniture = information.getString(furnitureKey);
    usage = information.getString(usageKey);*/
        room =getItemRoom();
        furniture=getItemFurniture();
        usage= getItemUsage();
        //System.out.println(room);
    }

    public String getName() {
        return name;
    }

   /* public void setName(String name) {
        this.name = name;
    }*/

    public String getRoom() {
        return room;
    }

    /*public void setRoom(String room) {
        this.room = room;
    }
*/
    public String getFurniture() {
        return furniture;
    }

   /* public void setFurniture(String furniture) {
        this.furniture = furniture;
    }
*/
    public String getUsage() {
        return usage;
    }

    /*public void setUsage(String usage) {
        this.usage = usage;
    }*/

    public JSONObject getJsonObjectItem() {
        return jsonObjectItem;
    }

    /*public void setJsonObjectItem(JSONObject jsonObjectItem) {
        this.jsonObjectItem = jsonObjectItem;
    }*/
    @Override
    public String toString(){
        return "Item{" + "name" + name + "'\'" +
                "room = " + room +"'\'" +
                "furniture = " + furniture +"'\'"+
                "usage = " + usage;
    }

   /* public static void main(String[] args) {
        Item item = new Item("cucumber");
        System.out.println(item.getRoom());
        System.out.println(item.getUsage());
    }*/
}
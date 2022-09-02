package com.game;

import org.json.JSONObject;

public class Introduction {
    private String story;
    private String player;
    private String objective;
    private String win;

    JSONObject jsonObjectIntroduction = JSONParser.ReadJSON("intro.json");

    public Introduction() {
        String storyKey = "story";
        String playerKey = "player";
        String objectiveKey = "objective";
        String winKey = "win";
        story = jsonObjectIntroduction.getString(storyKey);
        player = jsonObjectIntroduction.getString(playerKey);
        objective = jsonObjectIntroduction.getString(objectiveKey);
        win = jsonObjectIntroduction.getString(winKey);
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    @Override
    public String toString() {
        return "Introduction{" +
                "story='" + story + '\'' +
                ", player='" + player + '\'' +
                ", objective='" + objective + '\'' +
                ", win='" + win + '\'' +
                '}';
    }
}

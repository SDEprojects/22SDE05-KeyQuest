package com.game;

import static com.game.JSONParser.*;

public class Introduction {
    private final String story = getIntroductionStory();
    private final String player = getIntroductionPlayer();
    private final String objective = getIntroductionObjective();
    private final String prompt = getIntroductionPrompt();
    private final String win = getIntroductionWin();
    private final String lose = getIntroductionLose();

    public String getStory() {
        return story;
    }

    public String getPlayer() {
        return player;
    }

    public String getObjective() {
        return objective;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getWin() {
        return win;
    }

    public String getLose() {
        return lose;
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

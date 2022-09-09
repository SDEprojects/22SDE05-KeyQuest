package com.game;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntroductionTest {

    @Test
    public void getStory() {
        String story = "\nIn a quiet rural town, far-far away there was a little house. \n\nBeside the little house laid an enormous garden, abundant with vegetables and fruits. \nThe oasis of a garden was fenced around for its own good. \nTo feast on the forbidden food, little rabbit a path you must choose. \nFind the key within the little house to open the gated garden and consume the food. ";
        Introduction intro = new Introduction();
        assertEquals(story, intro.getStory());
    }


}
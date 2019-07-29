package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleStatistics implements Statistics{


    @Override
    public List<String> usersNames() {
        return new ArrayList<>
                (Arrays.asList("John Rambo" , "James Hetfield" , "Abraham Lincoln", "Robert E. Lee"));
    }

    @Override
    public int postsCount() {
        return 1000;
    }

    @Override
    public int commentsCount() {
        return 2000;
    }


}

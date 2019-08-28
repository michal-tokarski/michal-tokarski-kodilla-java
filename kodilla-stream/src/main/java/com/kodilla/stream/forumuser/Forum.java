package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add (new ForumUser (123123, "John F. Kennedy   ", 'M', LocalDate.parse("2005-06-01"),10));
        userList.add (new ForumUser (478999, "Angus Young       ", 'M', LocalDate.parse("1980-12-11"),0));
        userList.add (new ForumUser (314871, "Margaret Thatcher ", 'F', LocalDate.parse("1944-02-25"),77));
        userList.add (new ForumUser (293859, "Stuart Price      ", 'M', LocalDate.parse("1989-07-15"),41));
        userList.add (new ForumUser (395359, "Jane Fonda        ", 'F', LocalDate.parse("1981-12-13"),0));
        userList.add (new ForumUser (798411, "William Wallace   ", 'M', LocalDate.parse("1977-05-02"),5));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }

}

package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain_73_task {

    public static void main(String[]args) {

        Forum forum = new Forum();

        System.out.println("\nOriginal List :");
        System.out.println("---------------");
        forum.getUserList().stream()
                .forEach(System.out::println);


        System.out.println("\nFiltered and Mapped List :");
        System.out.println("----------------------------");
        Map <Integer, ForumUser> mapOfForumUsers = forum.getUserList().stream()
                .filter (forumUser -> forumUser.getSex() == 'M')
                .filter (forumUser -> forumUser.getCurrentAge() >= 20)
                .filter (forumUser -> forumUser.getNumberOfPosts() >= 1)
                .collect (Collectors.toMap(ForumUser:: getUserId, ForumUser -> ForumUser));

        mapOfForumUsers.entrySet().stream()
                .map(entry -> "Key - " + entry.getKey() + " ; " + "Value - " + entry.getValue())
                .forEach(System.out::println);

    }

}

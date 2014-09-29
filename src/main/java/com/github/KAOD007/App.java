package com.github.KAOD007;

import java.util.List;
import java.util.Scanner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class App {

    public static void main(String[] args) {
        System.out.println("Please enter a twitter account name and press ENTER (without the @)");
        Scanner input = new Scanner(System.in);
        String userInputString = input.nextLine();

        System.out.println("You entered " + userInputString);

        Twitter twitter = TwitterFactory.getSingleton();

        try {
            User user = twitter.showUser(userInputString);
            System.out.println(user.getFollowersCount());
            List<Status> statuses = twitter.getUserTimeline(user.getId());
            for(Status status : statuses){
            	System.out.println(status);	
            	}
            

        } catch (TwitterException tExp) {
            System.out.println("Twitter error :" + tExp.getMessage());
        }

    }//end of public static void main
}//end of public class App

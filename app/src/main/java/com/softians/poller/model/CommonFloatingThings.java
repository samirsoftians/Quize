package com.softians.poller.model;

/**
 * Created by HP on 10-09-2017.
 */

public class CommonFloatingThings {
    public static final String links= "http://softianstech.com/quizplay/quizplay_app/";
    //public static final String links= "http://samirsoftians.000webhostapp.com/poller2/";//http://samirsoftians.000webhostapp.com/poller2/
    public static String registration=links+"user_register.php";
    public static String login=links+"user_login.php";
    public static String forgot=links+"forgot.php";
    public static String answers=links+"answers.php";
    public static String questions=links+"questions.php?topic_id=";//samir.php    questions.php
    public static String score=links+"total_test.php?email=";
    public static String marks=links+"total_marks.php?email=";
    public static final String USER_IMAGE = links+"getImage.php?email=";
    public static final String USER_PHOTO = links+"upload.php";
    public static final String token = links+"tokensetter.php";
    public static final String jsonQuestionAnswer = links+"jsonQuestionAnswer.php";
    public static final String list_of_questions_feed=links+"list_of_questions_feed.php?id=";
    public static final String json_provider_for_recycler=links+"json_provider_for_recycler.php?id=";
    public static final String winners_feed=links+"winners_feed.php?id=";
    public static final String winners=links+"winners.php";
}

package com.codepath.apps.restclienttemplate.models;
/*

     {

         {
             "text": "...", "retweeted" false,
             "in_reply_to_screen_name" : null,
             "id": "240558470661799936",
             "in_reply_to_user_id_str" : null,
             "source": "web", "favorited": false,
             "in_reply_to_status_id": null,
             "retweet"_count": 1, "in_reply_to_user_id": null,
             "created_at": "Tue Aug 28 21:16:23 +0000 2012",
             "favorite_count": 0, "id_str": "240558470661799936",
  "user": {
                "id": 26813101, "following": true,
                "favourite_count": 14, "verified": true,
                "description": "...", "name": "Some Name",
                "created_at": "Wed Mar 03 19:37:35 +0000 2010",
                "followers_count": 154043, "url": "http://...",
                "friends_count": 1435, "screen_name": "somename",
                "profile_image":_url": "http://....jpg"

         }

         },

         {

         ]

 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

// Parse the JSON + Store the data, encapsulate state logic or display logic
public class Tweet {
    // list out of the attributes
    private String body;
    private long uid; // unique id for the tweet
    private User user; // store embedded user object
    private String createdAt;

    public User getUser() {
        return user;
    }
    public String getBody() {
        return body;
    }
    public long getUid() {
        return uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // Deserialize the JSON and build Tweet objects
    // Tweet.fromJSON("{...}"} => <Tweet>
    public  static Tweet fromJSON(JSONObject jsonObject) {
        Tweet tweet = new Tweet();
        // Extract the values from json, store them
            try {
                tweet.body = jsonObject.getString("text");
                tweet.uid = jsonObject.getLong("id");
                tweet.createdAt = jsonObject.getString("created_at");
                tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Return the tweet object
            return tweet;
      }
    // Tweet.fromJSONArray({ {...}, {...} } => List<Tweet>
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray) {
        ArrayList<Tweet> tweets = new ArrayList<>();
        // Itirate the json array and create tweets
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetJson);
                if (tweet != null) {
                    tweets.add(tweet);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
        }
            // Return the finished list
        return tweets;
        }


    }
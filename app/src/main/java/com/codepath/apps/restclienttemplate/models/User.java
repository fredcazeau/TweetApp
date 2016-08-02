package com.codepath.apps.restclienttemplate.models;


import org.json.JSONException;
import org.json.JSONObject;

/*

    "user": {
                "id": 26813101, "following": true,
                "favouritee_count": 14, "verified": true,
                "description": "...", "name": "Some Name",
                "created_at": "Tue Aug 28 21:16:23 +0000 2012",
                "followers_count": 154043, "url": "http://...",
                "friends_count": 1435, "screen_name": "somename",
                "profile_image":_url": "http://....jpg"

 */

public class User {
    // list attributes
    private String name;
    private long uid;
    private String screenName;
    private String profileImageUrl;

    public String getName() {
        return name;
    }

    public long getUid() {
        return uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
    // deserialize the user json ==> User
    public static User fromJSON(JSONObject json) {
        User u = new User();
        // Extract and fill the values
        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.screenName = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Return a user
        return u;
    }
}

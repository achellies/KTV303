package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class UserFunctions {
	
	private JSONParser jsonParser;
	
	private static String URL = "http://ktv303.ddict.nl/api/";
	
	private static String login_tag = "login";
	private static String register_tag = "register";
	private static String highscoreboard_tag = "highscoreboard";
	
	// constructor
	public UserFunctions(){
		jsonParser = new JSONParser();
	}
	
	/**
	 * function make Login Request
	 * @param username
	 * @param password
	 * */
	public JSONObject loginUser(String username, String password){
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", login_tag));
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));
		JSONObject json = jsonParser.getJSONFromUrl( URL, params );
		// return json
		return json;
	}
	
	/**
	 * function make Login Request
	 * @param username
	 * @param password
	 * */
	public JSONObject registerUser(String username, String password){
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", register_tag));
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));
		
		// getting JSON Object
		JSONObject json = jsonParser.getJSONFromUrl( URL, params);
		// return json
		return json;
	}
	
	/**
	 * Function get Login status
	 * */
	public boolean isUserLoggedIn(Context context){
		DatabaseHandler db = new DatabaseHandler(context);
		int count = db.getRowCount();
		if(count > 0){
			// user logged in
			return true;
		}
		return false;
	}
	
	/**
	 * Function to logout user
	 * Reset Database
	 * */
	public boolean logoutUser(Context context){
		DatabaseHandler db = new DatabaseHandler(context);
		db.resetTables();
		return true;
	}
	
	/**
	 * Function get User Highscore
	 * @param context
	 * @return int highscore of user
	 */
	public int getUserHighScore(Context context)
	{
		DatabaseHandler db = new DatabaseHandler(context);
		return Integer.parseInt( db.getUserDetails().get("highscore") );
	}
	
	
	public JSONObject getHighscoreBoard() {
		//  Building parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add( new BasicNameValuePair("tag", highscoreboard_tag) );
		
		//  getting JSON Object
		JSONObject json = jsonParser.getJSONFromUrl( URL, params );
		//return json
		return json;
	}
	
}

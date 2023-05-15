/*
Game.java

Class in charge of filtering through the user input in order to find matching results in the Games.csv file.

Programmed by: Alex D., Aleks G., Maksim G., Ilya R., and Kaan U.
Last modified: Apr. 27th, 2023
*/

import java.util.*;
import java.io.*;

public class Game {
  private String title;
  private float rating;
  private ArrayList<String> genres;
  private String ID;
  private String image;

  /**
  *Constructor sets fields for Game
  *@param gameTitle is title of the game
  *@param gameGenres are genres of the game
  *@param gameID is the ID of the game
  *@param gameImage is the image of the game
  */
  public Game (String gameTitle, ArrayList<String> gameGenres, float gameRating, String gameID, String gameImage){
    
    this.title = gameTitle;
    this.genres = gameGenres;
    this.rating = gameRating;
    this.ID = gameID;
    this.image = gameImage;
    
  }
  
    /**
     * Method dealing with title 
     * 
     * @return title
     */
  
  public String getTitle() {
	 return title;
  }
  
    /**
     * Method that sets the title of the game
     * @param title renewed
     */
  
  public void setTitle(String title) {
	 this.title = title;
  }
  
    /**
     * Method dealing with rating 
     * 
     * @return rating
     */
  
  public float getRating() {
	 return rating;
  }
  
    /**
     * Method that sets the title of the game
     * @param rating renewed
     */
  
  public void setRating(float rating) {
	 this.rating = rating;
  }
  
    /**
     * Method dealing with genres 
     * 
     * @return genres
     */
  
  public ArrayList<String> getGenres() {
	 return genres;
  }

    /**
     * Method that sets the genres of the game
     * @param genres renewed
     */
  
  public void setGenres(ArrayList<String> genres) {
	 this.genres = genres;
  }
  
    /**
     * Method dealing with game ID 
     * 
     * @return ID of game
     */
  
  public String getID() {
	 return ID;
  }
  
    /**
     * Method that sets the ID of the game
     * @param ID renewed
     */
  
  public void setID(String iD) {
	 ID = iD;
  }
  
    /**
     * Method dealing with game ID 
     * 
     * @return ID of game
     */
  
  public String getImage() {
	 return image;
  }
  
    /**
     * Method that sets the image of the game
     * @param image renewed
     */
  
  public void setImage(String image) {
	 this.image = image;
  }

  /**
  This method reads through the CSV file in order to find a game that matches the Users input.
  */
  public Game (String inputID) throws IOException {
    File gameFile = new File("Games.csv"); //initializes csv file
    Scanner gameReader = new Scanner(gameFile); //initializes scanner
    String gameInfoMerged = "";
    boolean validID = false;
    gameReader.nextLine();
    while (gameReader.hasNext() && validID == false){ //while loop that reads game info
    gameInfoMerged = gameReader.nextLine();
      String[] findID = gameInfoMerged.split(",");
      String checkID = findID[3];
      if (inputID.equals(checkID)){
       validID = true;
      }  
    }
      //constructor params renewed
      String[] gameInfoSplit = gameInfoMerged.split(",");
      
      this.title = gameInfoSplit[0];

      String gameGenresMerged = gameInfoSplit[1];
      
      String[] gameGenresSplit = gameGenresMerged.split(";");

      this.genres = new ArrayList<String>(Arrays.asList(gameGenresSplit));
      
      this.rating = Float.parseFloat(gameInfoSplit[2]);

      this.ID = gameInfoSplit[3];

      this.image = gameInfoSplit[4];
       
    }


  /**
  This method prints out all the relevant and necessary information found in the csv file.
  */
  public void printGameInfo (Game searchedGame) {
    System.out.println(searchedGame.getTitle());
    System.out.println(searchedGame.getGenres());
    System.out.println(searchedGame.getRating());
    System.out.println(searchedGame.getID());
    System.out.println(searchedGame.getImage());
  }
  
}
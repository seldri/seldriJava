package com.blueJ.chapter09.OnlineShop;

public class Comment{

    private String author;
    private String text;
    private int votes;
    private int rating;
    
    /**
     * Create a comment with all necessary details. The initial vote balance is 0.
     * @param author the name of the Author
     * @param text the text of the Comment
     * @param rating the rating given by the Author
     */
    public Comment(String author, String text, int rating){
        this.author = author;
        this.text = text;
        this.rating = rating;
        votes = 0;
    }

    public String getAuthor(){
        return author;
    }

    public String getText(){
        return text;
    }

    public int getRating(){
        return rating;
    }

    public int getVoteCount(){
        return votes;
    }

    /**
     * This is used when reader clicks the 'Yes' button 
     * after the "Was this comment helpful?" question.
     */
    public void upvote(){
        votes++;
    }
    
    /**
     * This is used when reader clicks the 'No' button 
     * after the "Was this comment helpful?" question.
     */

    public void downvote(){
        votes--;
    }

    /**Return the full text and details of the comment, including
     * the comment text, author and rating.
     */
    public String getFullDetails(){
        String details = "Rating: " + "*****".substring(0, rating) + "   "
        + "By: " + author + "\n"
        + "    " + text + "\n";
        //Note: For testing purposes only, in the final version this will not be shown
        details += "(Voted as helpful: " + votes + ") \n";
        return details;
    }
}

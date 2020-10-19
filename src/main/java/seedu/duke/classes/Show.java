package seedu.duke.classes;


import seedu.duke.utility.Ui;

import java.time.LocalDateTime;

public class Show {
    protected String name;
    protected int numSeasons;
    protected int[] numEpisodesForSeasons;
    protected int[][] durationEpisodeForSeasons; //The duration of each episode for each season
    protected int rating;
    protected String review;
    protected LocalDateTime showTime;   //The time of the show, maybe include date
    protected int currentSeason;    //to keep track of watch progress
    protected int currentEpisode;

    public Show(String name, int numSeasons, int[] numEpisodesForSeasons) {
        this.name = name;
        this.numSeasons = numSeasons;
        this.numEpisodesForSeasons = numEpisodesForSeasons;
        this.rating = -1;
        this.review = "null";
        this.currentEpisode = 1;
        this.currentSeason = 1;
    }

    /**
     * overload Show if duration of Episodes is provided.
     * @param name name of show
     * @param numSeasons number of seasons
     * @param numEpisodesForSeasons number of episodes per season
     * @param durationEpisodeForSeasons length of episodes
     */
    public Show(String name, int numSeasons, int[] numEpisodesForSeasons, int[][] durationEpisodeForSeasons) {
        this.name = name;
        this.numSeasons = numSeasons;
        this.numEpisodesForSeasons = numEpisodesForSeasons;
        this.durationEpisodeForSeasons = durationEpisodeForSeasons;
        this.rating = -1;
        this.review = "null";
        this.currentEpisode = 1;
        this.currentSeason = 1;
    }

    public String getName() {
        return name;
    }

    public int getNumSeasons() {
        return numSeasons;
    }

    public int[] getNumEpisodesForSeasons() {
        return numEpisodesForSeasons;
    }

    public int getRating() {
        return rating;
    }

    public int getEpisodesForSeason(int season) {
        try {
            return numEpisodesForSeasons[season - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printBadInputException();
            return -1;
        }
    }

    public int getRawEpisodesForSeason(int season) {
        try {
            return numEpisodesForSeasons[season];
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printBadInputException();
            return -1;
        }
    }

    public int getCurrentSeason() {
        return currentSeason;
    }

    public int getCurrentEpisode() {
        return currentEpisode;

    }

    public String getReview() {
        return review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }

    public void setNumEpisodesForSeasons(int[] numEpisodesForSeasons) {
        this.numEpisodesForSeasons = numEpisodesForSeasons;
    }

    public void setEpisodeWatched(int watchedEpisode) {
        this.currentEpisode = watchedEpisode;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setCurrentSeason(int season) {
        this.currentSeason = season;
        this.currentEpisode = 1;
    }

    /**
     * Overload/overwrite? the previous setCurrentSeason method signature.
     * Should check with user if they want to input an episode else default it to 1
     * as in the previous declaration of setCurrentSeason
     *
     * @param season  season num
     * @param episode episode num
     */
    public void setCurrentSeason(int season, int episode) {
        this.currentEpisode = episode;
        this.currentSeason = season;
    }


    public void setEpisodeDuration(int season, int episode, int duration) {
        durationEpisodeForSeasons[season][episode] = duration;
    }


    @Override
    public String toString() {
        //TODO: Bernado&jiqing verify if the new toString works well
        StringBuilder des = new StringBuilder(name + " | ");
        des.append("WatchHistory : S");
        des.append(currentSeason);
        des.append("E");
        des.append(currentEpisode);
        if (rating != -1) {
            //TODO : make sure a review is always passed in with a rating
            des.append("| Rating: ");
            des.append(rating);
        }
        des.append(" | : ");
        des.append("Seasons ").append(numSeasons).append(" | Episodes: ");
        for (int episode : numEpisodesForSeasons) {
            des.append(episode);
            des.append(" ");
        }
        return des.toString();
    }

}

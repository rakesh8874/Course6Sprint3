import java.util.Comparator;

public class MovieData implements Comparable<MovieData> {
    private String title;
    private int budgetInMillions;
    private String releaseDate;
    private int revenuesInMillion;
    private float ratingAvg;

    public MovieData(String title, int budgetInMillions, String releaseDate, int revenuesInMillion, float ratingAvg) {
        this.title = title;
        this.budgetInMillions = budgetInMillions;
        this.releaseDate = releaseDate;
        this.revenuesInMillion = revenuesInMillion;
        this.ratingAvg = ratingAvg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBudgetInMillions() {
        return budgetInMillions;
    }

    public void setBudgetInMillions(int budgetInMillions) {
        this.budgetInMillions = budgetInMillions;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRevenuesInMillion() {
        return revenuesInMillion;
    }

    public void setRevenuesInMillion(int revenuesInMillion) {
        this.revenuesInMillion = revenuesInMillion;
    }

    public float getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(float ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    @Override
    public String toString() {
        return "MovieData{" +
                "title='" + title + '\'' +
                ", budgetInMillions=" + budgetInMillions +
                ", releaseDate='" + releaseDate + '\'' +
                ", revenuesInMillion=" + revenuesInMillion +
                ", ratingAvg=" + ratingAvg +
                '}';
    }

    @Override
    public int compareTo(MovieData o1) {
        return  getBudgetInMillions()-o1.budgetInMillions;
    }
}

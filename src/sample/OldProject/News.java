package sample.OldProject;

import java.util.Date;

public class News {
    private String title;
    private Date date;
    private String txt;

    public News(String title, Date date, String txt) {
        super();
        this.title = title;
        this.date = date;
        this.txt = txt;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getTxt() {
        return txt;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((date == null) ? 0 : date.hashCode());
        result = PRIME * result + ((title == null) ? 0 : title.hashCode());
        result = PRIME * result + ((txt == null) ? 0 : txt.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof News)) {
            return false;
        }

        final News other = (News) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (txt == null) {
            if (other.txt != null)
                return false;
        } else if (!txt.equals(other.txt))
            return false;
        return true;
    }


}
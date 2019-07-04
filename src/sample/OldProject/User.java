package sample.OldProject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private static final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    private int ID;
    private String fio;
    private Date regDate;

    public User(int id, String fio, Date date) {
        super();
        ID = id;
        this.fio = fio;
        this.regDate = date;
    }

    public String getFio() {
        return fio;
    }

    public int getID() {
        return ID;
    }

    public Date getRegDate() {
        return regDate;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ID;
        result = PRIME * result + ((fio == null) ? 0 : fio.hashCode());
        result = PRIME * result + ((regDate == null) ? 0 : regDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof User))
            return false;

        final User other = (User) obj;
        if (ID != other.ID)
            return false;
        if (fio == null) {
            if (other.fio != null)
                return false;
        } else if (!fio.equals(other.fio))
            return false;
        if (regDate == null) {
            if (other.regDate != null)
                return false;
        } else if (!regDate.equals(other.regDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " |ID=" + ID
                + "|fio=" + fio + "|regDate="
                + df.format(regDate);
    }

}

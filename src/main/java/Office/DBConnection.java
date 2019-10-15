package Office;

import java.util.Objects;

public class DBConnection {
    private String ID;
    private String DBStatus;

    @Override
    public String toString() {
        return "DBConnection{" +
                "ID='" + ID + '\'' +
                ", DBStatus='" + DBStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBConnection that = (DBConnection) o;
        return Objects.equals(ID, that.ID) &&
                Objects.equals(DBStatus, that.DBStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, DBStatus);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDBStatus() {
        return DBStatus;
    }

    public void setDBStatus(String DBStatus) {
        this.DBStatus = DBStatus;
    }
}

package dbconnection;

public class HibernateDemo {

    public static void main(String[] args) {
        HibernateConnection hibernateConnection = new HibernateConnection();
        hibernateConnection.connect();
        hibernateConnection.listStudents();
    }
}

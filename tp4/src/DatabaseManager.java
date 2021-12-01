import java.sql.*;
import java.util.LinkedList;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;
    private LinkedList<Product> products;

    DatabaseManager(String url, String user, String password) {
        this.password = password;
        this.user = user;
        this.url = url;
        this.products = new LinkedList<>();
    }

    public LinkedList<Product> getProducts() {
        return products;
    }

    public void fetchProducts() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM articles");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int quantity = resultSet.getInt(3);

                Product s = new Product(id,name,quantity);
                this.products.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void printProducts() {
        for (Product product : this.products) {
            System.out.println(product.getId() + product.getName() + product.getQuantity());
        }
    }

    public void update(int id, String name, int quantity){
        Connection connection = null;
        Statement statement = null;
        int resultSet = 0;
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE articles SET nom ='"+name+"', quantite= "+quantity+" where id =" + id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void add(int id, String name, int quantity){
        Connection connection = null;
        Statement statement = null;
        int resultSet = 0;
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO articles (id, nom, quantite) VALUES ("+id+",'"+ name+"',"+quantity+");");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

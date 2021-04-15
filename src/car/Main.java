package car;
import car.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    private static String[] brands = {"TOYOTA", "BMW", "HYUNDAI"};
    private List<Car> carList;

    public static Connection getJDBCConnection() {
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/car";
        final String DB_USER = "root";
        final String DB_PASS = "mangcut1";
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        Main main = new Main();
        main.init();
        Connection
    }
    private Connection cn;

    public void openconnect() throws Exception {
        if (cn == null || cn.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/car";
            cn = DriverManager.getConnection(url, "root", "mangcut1");
        }
    }

    public void closeconnect() throws Exception {
        if (cn != null && !cn.isClosed()) {
            cn.close();
        }
    }


    public List<Car> getAll() throws SQLException {
        List<Car> carList = new ArrayList<>();
        Connection connection = getJDBCConnection();
        String sql = "select * from car";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            Car car = new Car();
            car.setId(Long.parseLong(result.getString("id")));
            car.setName(result.getString("name"));
            car.setBrand(result.getString("brand"));
            car.setNumberPlate(result.getString("numberPlate"));
            car.setYearOfManufacture(Integer.parseInt(result.getString("yearOfManufacture")));
            if (result.getString("actionDuration") != null) {
                car.setActionDuration(Long.parseLong(result.getString("actionDuration")));
            }
            car.setHaveInsurance(Long.parseLong(result.getString("haveInsurance")) == 0 ? false:true);
            if (result.getString("havePositioningDevice") != null) {
                car.setHavePositioningDevice(Long.parseLong(result.getString("havePositioningDevice")) == 0 ? false : true);
            }

            carList.add(car);
        }

        return carList;
    }
    public void insert() {
        String sql = "INSERT INTO car VALUES(?, ?, ?)";

        try {
            openconnect();
            PreparedStatement stmt = cn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.println("nhập id");
            int id = sc.nextInt();
            System.out.println("nhập biển số:");
            int numberPlate = sc.nextInt();
            System.out.println("nhập năm");
            int yearOfManufacture = sc.nextInt();
            stmt.setInt(1, id);
            stmt.setInt(2, numberPlate);
            stmt.setInt(3, yearOfManufacture);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2)
                        + "  " + rs.getInt(3));
            }
            stmt.close();
            cn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void init() throws SQLException {
        Connection connection = getJDBCConnection();
        Statement statement = connection.createStatement();
        Random random = new Random();
        carList = getAll();
        if (carList == null || carList.isEmpty()){
            for (int i=0; i<10; i++) {
                Car car = new Car();
                car.setName("Car #("+i+")");
                car.setBrand(brands[random.nextInt(3)]);
                car.setNumberPlate(String.format("%05d", random.nextInt(100000)));
                car.setYearOfManufacture(random.nextInt(33) + 1980);
                car.setHaveInsurance(random.nextInt(2) == 0 ? false : true);
                String sql = "insert into car(name, brand, yearOfManufacture, numberPlate, haveInsurance) value " +
                        "('"+car.getName()+"',"+
                        "'"+car.getBrand()+"',"+
                        car.getYearOfManufacture()+","+
                        car.getNumberPlate()+","+
                        car.getHaveInsurance()+
                        ")";
                statement.executeUpdate(sql);
            }
            carList = getAll();
        }

    }
}
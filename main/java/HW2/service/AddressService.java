package HW2.service;

import HW2.database.Database;
import HW2.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService {
    private static final String SELECT_ALL_ADDRESS_QUERY = "SELECT * FROM address ";
    private static final String SAVE_ADDRESS_QUERY = "INSERT INTO address(city,street,house) VALUES (?,?,?)";
    private static final String UPDATE_ADDRESS_QUERY = "UPDATE address SET city = ?,street = ?,house = ? WHERE id = ?";
    private static final String DELETE_ADDRESS_QUERY = "DELETE FROM address WHERE id = ? ";

    public List<Address> read() {
        List<Address> addresses = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ADDRESS_QUERY);
            while (resultSet.next()) {
                Address addresses1 = new Address();
                addresses1.setId(resultSet.getLong("id"));
                addresses1.setCity(resultSet.getString("city"));
                addresses1.setStreet(resultSet.getString("street"));
                addresses1.setHouse(resultSet.getLong("house"));
                addresses.add(addresses1);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    public void create(Address address) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SAVE_ADDRESS_QUERY)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setDouble(3, address.getHouse());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Address address) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDRESS_QUERY)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setLong(3, address.getHouse());
            preparedStatement.setLong(4, address.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Address address) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADDRESS_QUERY)) {
            preparedStatement.setLong(1,  address.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

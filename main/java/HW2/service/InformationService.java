package HW2.service;

import HW2.database.Database;
import HW2.entity.Information;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InformationService {
    private static final String SELECT_ALL_INFORMATION_QUERY = "SELECT * FROM information";
    private static final String SAVE_INFORMATION_QUERY = "INSERT INTO information(name,surname,age,phone) VALUES (?,?,?,?)";
    private static final String UPDATE_INFORMATION_QUERY = "UPDATE information SET name = ?,surname = ?,age = ?, phone = ? WHERE id = ?";
    private static final String DELETE_INFORMATION_QUERY = "DELETE FROM information WHERE id = ? ";

    public List<Information> read() {
        List<Information> information = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_INFORMATION_QUERY);
            while (resultSet.next()) {
                Information information1 = new Information();
                information1.setId(resultSet.getLong("id"));
                information1.setName(resultSet.getString("name"));
                information1.setSurname(resultSet.getString("surname"));
                information1.setAge(resultSet.getInt("age"));
                information1.setPhone(resultSet.getLong("phone"));
                information.add(information1);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return information;
    }

    public void create(Information information) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SAVE_INFORMATION_QUERY)) {
            preparedStatement.setString(1, information.getName());
            preparedStatement.setString(2, information.getSurname());
            preparedStatement.setInt(3, information.getAge());
            preparedStatement.setLong(4, information.getPhone());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Information information) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_INFORMATION_QUERY)) {
            preparedStatement.setString(1, information.getName());
            preparedStatement.setString(2, information.getSurname());
            preparedStatement.setInt(3, information.getAge());
            preparedStatement.setLong(4, information.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Information information) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_INFORMATION_QUERY)) {
            preparedStatement.setLong(1, information.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

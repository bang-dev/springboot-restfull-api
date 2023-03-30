package com.dev.daos;

import com.dev.builders.PersonalBuilder;
import com.dev.dtos.PersonalDTO;
import com.dev.utils.ConnectorDatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int createPersonal(PersonalDTO personalDTO) {
        int result = 0;
        try {
           ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "INSERT INTO Personal(id, firtName, lastName,major) VALUES(?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                                  preparedStatement.setString(1, personalDTO.getId());
                                  preparedStatement.setString(2, personalDTO.getFirstName());
                                  preparedStatement.setString(3, personalDTO.getLastName());
                                  preparedStatement.setString(4, personalDTO.getMajor());
                         result = preparedStatement.executeUpdate();
                                  preparedStatement.close();
           ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatePersonal(PersonalDTO personalDTO) {
        int result = 0;
        try {
            ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "UPDATE Personal SET id=?, firtName=?, lastName=?,major=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                                  preparedStatement.setString(1, personalDTO.getId());
                                  preparedStatement.setString(2, personalDTO.getFirstName());
                                  preparedStatement.setString(3, personalDTO.getLastName());
                                  preparedStatement.setString(4, personalDTO.getMajor());
                         result = preparedStatement.executeUpdate();
                                  preparedStatement.close();
            ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public PersonalDTO getPersonalById(String id) {
        PersonalDTO personalDTO = new PersonalBuilder().builder();
        try {
            ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "SELECT *FROM Personal WHERE(id=?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                personalDTO.setId(resultSet.getString(1));
                personalDTO.setFirstName(resultSet.getString(2));
                personalDTO.setLastName(resultSet.getString(3));
                personalDTO.setMajor(resultSet.getString(4));
            }
                        preparedStatement.close();
            ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalDTO;
    }

    public List<PersonalDTO> getAllPersonal(int start, int total) {
        List<PersonalDTO> personalDTOS = new ArrayList<>();
        try {
            ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "SELECT *FROM Personal limit" + (start - 1) + "," + total;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PersonalDTO personalDTO =
                        new PersonalBuilder()
                                .personalBuilderID(resultSet.getString(1))
                                .personalBuilderFirstName(resultSet.getString(2))
                                .personalBuilderLastName(resultSet.getString(3))
                                .personalBuilderMajor(resultSet.getString(4))
                                .builder();
                personalDTOS.add(personalDTO);
            }
                                    preparedStatement.close();
            ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalDTOS;
    }

    public int deletePersonal(String id) {
        int result = 0;
        try {
            ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "DELETE FROM Personal WHERE (id=?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                                  preparedStatement.setString(1, id);
                         result = preparedStatement.executeUpdate();
                                  preparedStatement.close();
            ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}

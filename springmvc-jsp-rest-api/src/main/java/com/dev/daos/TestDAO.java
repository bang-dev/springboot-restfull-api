package com.dev.daos;

import com.dev.dtos.TestDTO;
import com.dev.utils.ConnectorDatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int createTest(TestDTO testDTO) {
        int result = 0;
        try {
           ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "INSERT INTO TestDTO(id, content, createAt) VALUES(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                                  preparedStatement.setString(1, testDTO.getContent());
                                  preparedStatement.setString(2, testDTO.getCreateAt().toString());
                         result = preparedStatement.executeUpdate();
                                  preparedStatement.close();
           ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateTest(TestDTO testDTO) {
        int result = 0;
        try {
            ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "UPDATE TestDTO SET id=?, content=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                         preparedStatement.setString(1, testDTO.getContent());
                         preparedStatement.setString(2, testDTO.getCreateAt().toString());
                result = preparedStatement.executeUpdate();
                         preparedStatement.close();
            ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public TestDTO getTestById(String id) {
        TestDTO testDTO = new TestDTO();
        try {
            ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "SELECT *FROM TestDTO WHERE(id=?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                testDTO.setId(resultSet.getString(1));
                testDTO.setContent(resultSet.getString(2));
                testDTO.setCreateAt(resultSet.getDate(3));
            }
                        preparedStatement.close();
            ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testDTO;
    }

    public List<TestDTO> getAllTest(int start, int total) {
        List<TestDTO> testDTOS = new ArrayList<>();
        try {
            ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "SELECT *FROM TestDTO limit" + (start - 1) + "," + total;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TestDTO testDTO = new TestDTO();
                testDTO.setId(resultSet.getString(1));
                testDTO.setContent(resultSet.getString(2));
                testDTO.setCreateAt(resultSet.getDate(3));
                testDTOS.add(testDTO);
            }
                                    preparedStatement.close();
            ConnectorDatabaseUtils.disConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testDTOS;
    }

    public int deleteTest(String id) {
        int result = 0;
        try {
            ConnectorDatabaseUtils.openConnectionDatabase();
                String query = "DELETE FROM TestDTO WHERE (id=?)";
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

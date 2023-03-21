package com.dev.servlets.combine.normal;

import com.dev.daos.TestDAO;
import com.dev.dtos.TestDTO;
import com.dev.utils.ConnectorDatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TestServletRest extends HttpServlet {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
    private TestDAO testDAO;

    public TestServletRest() {
        super();
    }

    public void init(){
        testDAO = (TestDAO) ConnectorDatabaseUtils.openConnectionDatabase();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/":
                   adminTest(request, response);
                    break;
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTest(request, response);
                    break;
                case "/delete":
                    deleteTest(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTest(request, response);
                    break;
                default:
                    listTest(request, response);
                    break;
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void adminTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getHeader("Welcome");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void listTest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<TestDTO> test = testDAO.getAllTest(1,10);
        request.setAttribute("test", test);
        request.getRequestDispatcher("test-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("test-form.jsp").forward(request, response);
    }

    private void insertTest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        String content = request.getParameter("content");
        Date createAt = dateFormat.parse(request.getParameter("createAt"));
        TestDTO testDTO = new TestDTO();
        testDTO.setId(UUID.randomUUID().toString());
        testDTO.setContent(content);
        testDTO.setCreateAt(createAt);
        testDAO.createTest(testDTO);
        response.sendRedirect("list");
    }


    private void deleteTest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("id");
        testDAO.deleteTest(id);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        TestDTO test = testDAO.getTestById(id);
        request.setAttribute("test", test);
        testDAO.updateTest(test);
        request.getRequestDispatcher("test-form.jsp").forward(request, response);
    }

    private void updateTest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        String id = request.getParameter("id");
        String content = request.getParameter("content");
        Date createAt =dateFormat.parse( request.getParameter("createAt"));
        TestDTO test = new TestDTO();
        test.setId(id);
        test.setContent(content);
        test.setCreateAt(createAt);
        testDAO.updateTest(test);
        response.sendRedirect("list");
    }


    public void destroy() {
        try {
            ConnectorDatabaseUtils.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     @author: Bang Vo Anh
     @since: 03/21/2023 11:47 PM
     @description:
     @update:

     ==================== GETTER - SETTER ==================
     **/
    public TestDAO getTestDAO() {
        return testDAO;
    }

    public void setTestDAO(TestDAO testDAO) {
        this.testDAO = testDAO;
    }
}

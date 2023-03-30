package com.dev.servlets.combine.normal;

import com.dev.builders.PersonalBuilder;
import com.dev.daos.PersonalDAO;
import com.dev.dtos.PersonalDTO;
import com.dev.utils.ConnectorDatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PersonalServletRest extends HttpServlet {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
    private PersonalDAO personalDAO;

    public PersonalServletRest() {
        super();
    }

    public void init(){
       // personalDAO = (PersonalDAO) ConnectorDatabaseUtils.openConnectionDatabase();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        request.getHeader("Admin");
        writer.println("<h1>WELCOME PRACTICE SERVLET</h1>");
        writer.println(new Date().toString());
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/welcome":
                   adminPersonal(request, response);
                    break;
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertPersonal(request, response);
                    break;
                case "/delete":
                    deletePersonal(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updatePersonal(request, response);
                    break;
                case "/list":
                    listPersonal(request, response);
                    break;
                default:
                  //  listPersonal(request, response);
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

    private void adminPersonal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getHeader("Welcome");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void listPersonal(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<PersonalDTO> personal = personalDAO.getAllPersonal(1,10);
        request.setAttribute("personal", personal);
        request.getRequestDispatcher("personal-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("personal-form.jsp").forward(request, response);
    }

    private void insertPersonal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String major = request.getParameter("major");
        PersonalDTO personalDTO = new PersonalBuilder().builder();
        personalDTO.setId(UUID.randomUUID().toString());
        personalDTO.setFirstName(firstName);
        personalDTO.setLastName(lastName);
        personalDTO.setMajor(major);
        personalDAO.createPersonal(personalDTO);
        response.sendRedirect("personal-list.jsp");
    }


    private void deletePersonal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("id");
        personalDAO.deletePersonal(id);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        PersonalDTO personal = personalDAO.getPersonalById(id);
        request.setAttribute("personal", personal);
        personalDAO.updatePersonal(personal);
        request.getRequestDispatcher("personal-form.jsp").forward(request, response);
    }

    private void updatePersonal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String major = request.getParameter("major");
        PersonalDTO personal = new PersonalBuilder().builder();
        personal.setId(id);
        personal.setFirstName(firstName);
        personal.setLastName(lastName);
        personal.setMajor(major);
        personalDAO.updatePersonal(personal);
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
    public PersonalDAO getPersonalDAO() {
        return personalDAO;
    }

    public void setPersonalDAO(PersonalDAO personalDAO) {
        this.personalDAO = personalDAO;
    }
}

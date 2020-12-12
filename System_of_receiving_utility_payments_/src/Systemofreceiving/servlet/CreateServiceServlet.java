package Systemofreceiving.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Systemofreceiving.beans.Service;
import Systemofreceiving.utils.DBUtils;
import Systemofreceiving.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createService" })
public class CreateServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateServiceServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createServiceView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String service_id = (String) request.getParameter("service_id");
        String service_name = (String) request.getParameter("service_name");
        String client = (String) request.getParameter("client");
        String paymentStr = (String) request.getParameter("payment");
        float payment = 0;
        try {
            payment = Float.parseFloat(paymentStr);
        } catch (Exception e) {
        }
        Service service = new Service(service_id, service_name, client, payment);
 
        String errorString = null;
 
        String regex = "\\w+";
 
        if (service_id == null || !service_id.matches(regex)) {
            errorString = "id invalid!";
        }
 
        if (errorString == null) {
            try {
                DBUtils.insertService(conn, service);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        request.setAttribute("errorString", errorString);
        request.setAttribute("service", service);
 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createServiceView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/serviceList");
        }
    }
 
}
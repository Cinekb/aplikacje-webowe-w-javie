/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marci
 */
@WebServlet(name = "Servlet2", urlPatterns = {"/Servlet2"})
public class Servlet2 extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//             out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Servlet2</title>");
//            out.println("</head>");
//            out.println("<body>");
//            ServletContext sc=this.getServletContext();
//            ArrayList<String> list = new ArrayList<>();
//            list= (ArrayList)sc.getAttribute("s3");
//            for(int i=0;i<list.size();i++){
//                out.println("<p>"+(i+1)+". "+list.get(i) + "</p>");
//            }
//            out.println("</body>");
//            out.println("</html>");
//    }
        HttpSession session= request.getSession();
        session.setAttribute("Servlet2",request.getServletPath());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }



}

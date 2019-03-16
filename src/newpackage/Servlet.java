package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author marci
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
   // ArrayList<String> list = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        ServletContext sc=this.getServletContext();
//        String  s=request.getParameter("imie");
//        String  s2=request.getParameter("nazwisko");
//        String1 s3=s+" "+s2;
//
//        synchronized(getServletContext()){
//            list.add(s3);
//            sc.setAttribute("s3", list);
//        }
//        RequestDispatcher rd=request.getRequestDispatcher("/Servlet2");
//        rd.forward(request, response);
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");


    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //    processRequest(request, response);

        //     try (PrintWriter out = response.getWriter()) {
        //       out.print("loginGet= ");
//           out.println(request.getParameter("login"));
//           out.println("<br>");
//           out.print("passwordGet= ");
//           out.println(request.getParameter("password"));
//           out.println("<br>");
//           out.print("ImieGet= ");
//           out.println(request.getParameter("imie"));
//           out.println("<br>");
//           out.print("nazwiskoGet= ");
//           out.println(request.getParameter("nazwisko"));
//           out.println("<br>");
//           out.print("WiekGet= ");
//           out.println(request.getParameter("wiek"));
//           out.println("<br>");
//           out.print("zainteresowaniaGet= ");
//           out.println(request.getParameter("zainteresowania"));
//
//                 }

        String name = request.getParameter("imie");
        Cookie cookie = null;
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            Cookie[] cookies = request.getCookies();//pobranie tablicy z ciasteczkami
        if(cookies!=null) {//sprawdzam czy tablica  nie jest pusta
            for (int i = 0; i < cookies.length; i++) {//przeglądanie tablicy z ciasteczkami
                cookie = cookies[i];
                if (cookie.getName().equals("user1")) {
                    break;
                }
            }
        }else{
            Cookie ck = new Cookie("user1", name);//tworze obiekt
            ck.setMaxAge(-1);
            response.addCookie(ck);
            out.println("Ciasteczko zostalo utworzone, odswiez strone");

        }

            if (cookie.getName().equals("user1")) {
                out.println("Witaj " + cookie.getValue());
            }else{
              Cookie ck = new Cookie("user1", name);
              ck.setMaxAge(-1);
              response.addCookie(ck);
              out.println("Witaj gosciu");

            }

            HttpSession session=request.getSession();
            session.setAttribute("0","localhost:8080/");
            session.setAttribute("1","localhost:8080/"+request.getServletPath());
            int i=0;
            Enumeration enumeration=session.getAttributeNames();
            while (enumeration.hasMoreElements()) {

                String n = (String) enumeration.nextElement();
                out.println("<a href='" + session.getAttribute(n) + "'>strona "+i+"</a>");
                i++;
            }
            out.close();



        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   //     processRequest(request, response);
//               try (PrintWriter out = response.getWriter()) {
//
//           out.print("loginPost= ");
//           out.println(request.getParameter("login"));
//           out.println("<br>");
//           out.print("passwordPost= ");
//           out.println(request.getParameter("password"));
//           out.println("<br>");
//           out.print("ImiePost= ");
//           out.println(request.getParameter("imie"));
//           out.println("<br>");
//           out.print("nazwiskoPost= ");
//           out.println(request.getParameter("nazwisko"));
//           out.println("<br>");
//           out.print("WiekPost= ");
//           out.println(request.getParameter("wiek"));
//           out.println("<br>");
//           out.print("zainteresowaniaPost= ");
//           out.println(request.getParameter("zainteresowania"));
//                }
    }
}


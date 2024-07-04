/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package detailsbook;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Ashish Kumar Singh
 */
public class issuebook extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
            String name1=request.getParameter("name1");
            String Enroll=request.getParameter("enroll");
            String issue=request.getParameter("date1");
            String retur=request.getParameter("date2");
            String book=request.getParameter("bookname");
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
     Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/adminpage","root", "") ;
     PreparedStatement ps=conn.prepareStatement("insert into bookissuedetalslibrary values(?,?,?,?,?)");
     ps.setString(1,name1);
     ps.setString(2,Enroll);
     ps.setString(3,issue);
     ps.setString(4,retur);
     ps.setString(5,book);
     int count=ps.executeUpdate();
     if(count>0){
         response.setContentType("text/html");
         out.println("<h3>book issue successfully</h3>");
          RequestDispatcher rd=request.getRequestDispatcher("librarypage.html");
         rd.include(request, response);
     }
     else{
          response.setContentType("text/html");
         out.println("<h3>book not issue successfully</h3>");
          RequestDispatcher rd=request.getRequestDispatcher("librarypage.html");
         rd.include(request, response);
        
     }
            }
     catch(Exception e){
                e.printStackTrace();
                
                 response.setContentType("text/html");
         out.println("<h3 style='color:red;'> Exception Occured"+e.getMessage()+"</h3>");
          RequestDispatcher rd=request.getRequestDispatcher("librarypage.html");
         rd.include(request, response);
                
            }   
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

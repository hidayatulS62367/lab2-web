/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 *
 * @author USER
 */
public class ViewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          
            out.println("<a href='index.html'>Add New User</a>");
            out.println("<h1>User List</h1>");
            
            List<User> list=UserDao.getAllUsers();
            
            out.print("<table border='1' width='100%'");
            out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Role</th>"+"<th>Edit</th><th>Delete</th></tr>");            
            for(User e:list){
                
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getUsername()+"</td><td>"+e.getPassword()+"</td><td>"+e.getRole()+"</td><td><a href='EditServlet?id="+e.getId()+"'>delete</a></td></tr>");
            }
            out.println("</table>");
            out.close();
        }
    }

   
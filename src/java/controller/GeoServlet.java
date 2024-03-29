/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class GeoServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GeoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GeoServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String outline = "<p></p>";
        String imagePath = null;
        String type = null;
        try {
            String choice = request.getParameter("geo");
            switch(choice) {
                case "c": {            
                    imagePath = "https://vcdn-suckhoe.vnecdn.net/2016/10/05/6e851119-b702-46f9-84a6-72528b-4543-9390-1475655691.jpg";
                    type = "Circle";
                    break;
                }
                case "t": {
                    imagePath = "https://onthi123.vn/public/uploads/lop-6giua-ki-ii-ket-noi/9_2.png";
                    type = "Triangle";
                    break;
                }
                case "s": {
                    imagePath = "https://www.rowsignsandgraphics.com/wp-content/uploads/2021/10/Square_Yellow_Black_Border_solid.jpg";
                    type = "Square";
                    break;
                }
                case "r": {
                    imagePath = "https://glosbe.com/fb_img/profilePageAvatar/fW257602_Rectangle_.png.cvrt.jpg";
                    type = "Rectangle";
                    break;
                }
            }
            outline = "<h1>"+type+"</h1>" + "<img src='"+ imagePath + "' style=\"width: 300px\">";
        } catch (Exception e) {
            imagePath = null;
        }
       
        
        out.println("<html><body>");
        out.println(" <form name=\"geo1\" action=\"GeoServlet\" method=\"post\">\n" +
"                <table>\n" +
"                    <tr>\n" +
"                        <a>Please choose your favourite geometry: </a>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td></td><td><select name=\"geo\">\n" +
"                                <option value=\"c\">Circle</option>\n" +
"                                <option value=\"t\">Triangle</option>\n" +
"                                <option value=\"s\">Square</option>\n" +
"                                <option value=\"r\">Rectangle</option>\n" +
"                            </select></td>\n" +
"                    </tr>\n" +
"                   <tr>\n" +
"                        <td></td><td><input type=\"submit\" value=\"Choose\"/></td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </form>");
        out.println(outline);
        out.println("<br>");
        out.println("</body></html>");
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

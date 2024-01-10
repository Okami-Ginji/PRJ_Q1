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
public class CalServlet extends HttpServlet {
    private  String op = null;
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
            out.println("<title>Servlet CalServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalServlet at " + request.getContextPath () + "</h1>");
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
       
        String firstS = null;
        String secondS = null;
        String resultS = null;
        try {
            double result = 0;
            firstS = request.getParameter("first");
            secondS = request.getParameter("second");
            op = request.getParameter("operator");
            int first = Integer.parseInt(firstS);
            int second = Integer.parseInt(secondS);
            switch(op) {
                case "+":{
                    result = first + second;
                    break;
                }
                case "-":{
                    result = first - second;
                    break;
                }
                case "*":{
                    result = first * second;
                    break;
                }
                case "/":{
                    if(second == 0){
                        result = -9999;
                    }
                    else {
                        result = (double) first / second;
                    }
                    break;
                }
            }
            resultS = Double.toString(result);
        } catch(Exception e) {
            resultS = null;
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form name=\"cal\" action=\"CalServlet\" method=\"post\">\n" +
"                <table>\n" +
"                    <tr>\n" +
"                        <td>First: </td><td><input type=\"number\" name=\"first\" value=\""+firstS+"\"/></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>Second: </td><td><input type=\"number\" name=\"second\" value=\""+secondS+"\"/></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>Operator: </td><td><select name=\"operator\">\n" +
"                                <option value=\"+\">+</option>\n" +
"                                <option value=\"-\">-</option>\n" +
"                                <option value=\"*\">*</option>\n" +
"                                <option value=\"/\">/</option>\n" +
"                            </select></td>\n" +
"                    </tr>\n" +
"                   <tr>\n" +
"                        <td></td><td><input type=\"submit\" value=\"Computer\"/></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>Result: </td><td><input type=\"number\" name=\"result\" value=\"" + resultS + "\" /></td>\n" +
"                    </tr>             \n" +
"                </table>\n" +
"            </form>");
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

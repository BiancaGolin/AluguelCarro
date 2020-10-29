/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.AluguelDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vickp
 */
@WebServlet(name = "ExcluirAluguel", urlPatterns = {"/ExcluirAluguel"})

public class ExcluirAluguel extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            AluguelDAO.deleteAluguel(id);
            response.getWriter().print(true);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExcluirAluguel.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print(false);
        }
    }
}

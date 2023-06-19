/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lonpo;

import beans.Database;
import moi.Infos;
import beans.Log;
import beans.Users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diak.ibrahim
 */
@WebServlet(name = "MonServlet", urlPatterns = {"/accueil"})
public class MonServlet extends HttpServlet {

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
        Database myBase = new Database("jdbc:mysql://localhost:3310/test2","root","");
            myBase.load();
            //preparation des donnee pour la liste d'affichage
           
            
            
            String page = "";
                   page =  request.getParameter("page");
        if(page.equals("index")){//gestion pour la page index
            
            
            //recuperation de parametre de donnee
            
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String pseudo = request.getParameter("pseudo");
            String repassword = request.getParameter("repassword");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            
            //donnee de verification dérreur
            boolean pseudoError = myBase.checkPseudo(pseudo);//Ici si le pseudo existe notre variable pseudoError va contenir vrai
            boolean passwordError = !(password.equals(repassword));//Ici si les deux password ne sont pas egaux notre passwordError va contenir vrai
            //if pour verifier que le pseudo est unique et que le password est correct
            
            if(!pseudoError && !passwordError ){
                //verification du password
     
                Users user =new Users();
                user.setNom(nom);
                user.setPrenom(prenom);
                user.setPseudo(pseudo);
                user.setPassword(password);
                user.setEmail(email);
            
                myBase.addUser(user);
                List<Infos> liste = new ArrayList<>();
                myBase.userList(liste);
                request.setAttribute("pseudo", user.getPseudo());
                request.setAttribute("passwordError", passwordError);
                request.setAttribute("liste",liste);
                this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
                //recuperation de la liste
                
                myBase.closeDatabase();
                request.setAttribute("passwordError", passwordError);
                request.setAttribute("pseudoError", pseudoError);
            }
            else{
                request.setAttribute("passwordError", passwordError);
                request.setAttribute("pseudoError", pseudoError);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
    }
    else{ //gestion pour la page login
        //recuperation de donnee
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        Log logData = new Log(pseudo,password);
        boolean logResult = myBase.checkLog(logData);
        if(logResult){
        List<Infos> liste = new ArrayList<>();
        myBase.userList(liste);
        request.setAttribute("pseudo", pseudo);
        request.setAttribute("liste",liste);
        myBase.closeDatabase();
        this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
        }
        else{
            request.setAttribute("logResult", logResult);
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
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




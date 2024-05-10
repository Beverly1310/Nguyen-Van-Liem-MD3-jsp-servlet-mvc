package controller;

import model.Category;
import service.ICategory;
import service.impl.CategoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    protected static final ICategory categoryImpl = new CategoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "LIST":
                request.setAttribute("categoryList",categoryImpl.findAll());
                request.getRequestDispatcher("/view/category/list.jsp").forward(request,response);
                break;
            case "ADD":
                response.sendRedirect("/view/category/add.jsp");
                break;
            case "EDIT" :
                Integer editId = Integer.valueOf(request.getParameter("id"));
                request.setAttribute("category",categoryImpl.findById(editId));
                request.getRequestDispatcher("/view/category/edit.jsp").forward(request,response);
                break;
            case "DELETE":
                Integer deleteId = Integer.valueOf(request.getParameter("id"));
                categoryImpl.deleteById(deleteId);
                response.sendRedirect("/CategoryServlet?action=LIST");
                break;
            default:
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "ADD":
                String name = request.getParameter("name");
                Boolean status = Boolean.valueOf(request.getParameter("status"));
                Category category = new Category();
                category.setName(name);
                category.setStatus(status);
                categoryImpl.save(category);
                response.sendRedirect("/CategoryServlet?action=LIST");
                break;
            case "EDIT" :
                Integer editID = Integer.valueOf(request.getParameter("id"));
                String editName = request.getParameter("name");
                Boolean editStatus = Boolean.valueOf(request.getParameter("status"));
                Category categoryEdit = new Category(editID,editName,editStatus);
                categoryImpl.save(categoryEdit);
                response.sendRedirect("/CategoryServlet?action=LIST");
                break;
            default:
                break;

        }    }
}
package controller;

import dao.IBookDao;
import dao.iml.BookDaoIml;
import dto.BookRequest;
import service.IBook;
import service.impl.BookImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static controller.CategoryServlet.categoryImpl;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private static final IBook bookImpl = new BookImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "LIST":
                request.setAttribute("bookList",bookImpl.findAll());
                request.getRequestDispatcher("/view/book/list.jsp").forward(request,response);
                break;
            case "ADD":
               request.setAttribute("categoryList", categoryImpl.findAll());
               request.getRequestDispatcher("/view/book/add.jsp").forward(request,response);
                break;
            case "EDIT":
                request.setAttribute("categoryList", categoryImpl.findAll());
                Integer editId = Integer.valueOf(request.getParameter("id"));
                request.setAttribute("book",bookImpl.findById(editId));
                request.getRequestDispatcher("/view/book/edit.jsp").forward(request,response);
                break;
            case "DELETE":
                Integer deleteId = Integer.valueOf(request.getParameter("id"));
                bookImpl.deleteById(deleteId);
                response.sendRedirect("/BookServlet?action=LIST");
                break;
            default:
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "ADD":
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                Integer categoryId = Integer.valueOf(request.getParameter("category"));
                Double price = Double.valueOf(request.getParameter("price"));
                Integer stock = Integer.valueOf(request.getParameter("stock"));
                Integer totalPages = Integer.valueOf(request.getParameter("totalPages"));
                Integer yearCreated = Integer.valueOf(request.getParameter("yearCreated"));
                Boolean status = Boolean.valueOf(request.getParameter("status"));
                BookRequest bookRequest = new BookRequest(null,name,price,stock,totalPages,yearCreated,author,status,categoryId);
                bookImpl.save(bookRequest);
                response.sendRedirect("/BookServlet?action=LIST");
                break;
            case "EDIT":
                String nameEdit = request.getParameter("name");
                String authorEdit = request.getParameter("author");
                Integer categoryIdEdit = Integer.valueOf(request.getParameter("category"));
                Double priceEdit = Double.valueOf(request.getParameter("price"));
                Integer stockEdit = Integer.valueOf(request.getParameter("stock"));
                Integer totalPagesEdit = Integer.valueOf(request.getParameter("totalPages"));
                Integer yearCreatedEdit = Integer.valueOf(request.getParameter("yearCreated"));
                Boolean statusEdit = Boolean.valueOf(request.getParameter("status"));
                Integer idEdit = Integer.valueOf(request.getParameter("id"));
                BookRequest bookRequestEdit = new BookRequest(idEdit,nameEdit,priceEdit,stockEdit,totalPagesEdit,yearCreatedEdit,authorEdit,statusEdit,categoryIdEdit);
                bookImpl.save(bookRequestEdit);
                response.sendRedirect("/BookServlet?action=LIST");
                break;
            default:
                break;

        }
    }
}
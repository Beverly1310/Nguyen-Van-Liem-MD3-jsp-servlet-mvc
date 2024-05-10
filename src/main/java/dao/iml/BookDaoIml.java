package dao.iml;

import dto.BookRequest;
import dao.IBookDao;
import model.Book;
import util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoIml implements IBookDao {
    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement call = conn.prepareCall("select * from book");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Book book = Book.builder()
                        .id(rs.getInt("id"))
                        .category(new CategoryImplDao().findById(rs.getInt("categoryId")))
                        .name(rs.getString("name"))
                        .price(rs.getDouble("price"))
                        .stock(rs.getInt("stock"))
                        .totalPages(rs.getInt("totalPages"))
                        .yearCreated(rs.getInt("yearCreated"))
                        .author(rs.getString("author"))
                        .status(rs.getBoolean("status"))
                        .build();
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnect(conn);
        }
    }

    @Override
    public void save(BookRequest bookRequest) {
        Connection conn = ConnectDB.getConnection();
        CallableStatement call = null;
        try {
            if (bookRequest.getId()==null){
                call = conn.prepareCall("insert into book(name,price,stock,totalPages,yearCreated,author,status,categoryId) values (?,?,?,?,?,?,?,?)");
            } else {
                call = conn.prepareCall("update  book set name=?,price=?,stock=?,totalPages=?,yearCreated=?,author=?,status=?,categoryId=? where id=?");
                call.setInt(9,bookRequest.getId());
            }
            call.setString(1,bookRequest.getName());
            call.setDouble(2,bookRequest.getPrice());
            call.setInt(3,bookRequest.getStock());
            call.setInt(4,bookRequest.getTotalPages());
            call.setInt(5,bookRequest.getYearCrated());
            call.setString(6,bookRequest.getAuthor());
            call.setBoolean(7,bookRequest.getStatus());
            call.setInt(8,bookRequest.getCategoryID());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement call = conn.prepareCall("delete from book where id = ?");
            call.setInt(1,id);
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnect(conn);
        }
    }

    @Override
    public Book findById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        Book book = null;
        try {
            CallableStatement call = conn.prepareCall("select * from book where id = ?");
            call.setInt(1,id);
           ResultSet rs =  call.executeQuery();
           if (rs.next()){

                book = Book.builder()
                       .id(rs.getInt("id"))
                       .category(new CategoryImplDao().findById(rs.getInt("categoryId")))
                       .price(rs.getDouble("price"))
                       .name(rs.getString("name"))
                       .stock(rs.getInt("stock"))
                       .totalPages(rs.getInt("totalPages"))
                       .yearCreated(rs.getInt("yearCreated"))
                       .author(rs.getString("author"))
                       .status(rs.getBoolean("status"))
                       .build();
           }
           return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnect(conn);
        }
    }
}

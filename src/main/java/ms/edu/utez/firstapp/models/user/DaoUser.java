package ms.edu.utez.firstapp.models.user;

import ms.edu.utez.firstapp.models.crud.DaoRepository;
import ms.edu.utez.firstapp.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser implements DaoRepository<User> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public List<User> findAll() {
        List<User> users =new ArrayList<>();
        try{
            conn= new MySQLConnection().connect();
            String query ="SELECT * FROM users;";
            pstm = conn.prepareStatement(query);
            rs= pstm.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setLastname(rs.getString("lastname"));
                user.setBirthaday(rs.getString("birthanday"));
                user.setStatus(rs.getString("status"));
                user.setUsername(rs.getString("username"));
                users.add(user);

            }

            //un query es una consulta y Statement

        }catch(SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());

        }finally {
            close();
        }
        //finally siempre se ejecuta no depende de nada
        return users;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public boolean save(User object) {
        return false;
    }

    @Override
    public boolean update(User object) {
        return false;
    }

    @Override
    public boolean delate(Long id) {
        return false;
    }
    public void close(){
    try {
        if(conn != null)conn.close();
        if(pstm !=null) pstm.close();
        if(rs != null) rs.close();
    }catch(SQLException e){

        }
    }
    //Acceso a base de datos es el intermediario en la aplicación y la base de datos


}

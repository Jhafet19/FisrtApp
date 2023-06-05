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
        try{
            conn= new MySQLConnection().connect();
            String query ="SELECT * FROM users where id = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            rs= pstm.executeQuery();
            User user=new User();
            if (rs.next()){
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setLastname(rs.getString("lastname"));
                user.setBirthaday(rs.getString("birthanday"));
                user.setStatus(rs.getString("status"));
                user.setUsername(rs.getString("username"));
            }
            return user;
            //un query es una consulta y Statement
        }catch(SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findOne"+e.getMessage());

        }finally {
            close();
        }
        return null;
    }

    @Override
    public boolean save(User object) {
        try{
            conn=new MySQLConnection().connect();
            String query = "INSERT INTO Users(name,surname,lastname,username,birthday,status) " +
                    "VALUES (?,?,?,?,?,?)";
            pstm=conn.prepareStatement(query);
            pstm.setString(1,object.getName());
            pstm.setString(2,object.getSurname());
            pstm.setString(3,object.getLastname());
            pstm.setString(4,object.getUsername());
            pstm.setString(5,object.getBirthaday());
            pstm.setString(6,object.getStatus());
            return  pstm.executeUpdate()>0;
        }catch(SQLException e){
        Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Errps save"+ e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(User object) {
        try{
            conn=new MySQLConnection().connect();
            String query = "UPDATE  users SET name = ?,surname=?, lastname=?, username=?,birthday=?, " +
                    "status=? where id=?";
            pstm=conn.prepareStatement(query);
            pstm.setString(1,object.getName());
            pstm.setString(2,object.getSurname());
            pstm.setString(3,object.getLastname());
            pstm.setString(4,object.getUsername());
            pstm.setString(5,object.getBirthaday());
            pstm.setString(6,object.getStatus());
            pstm.setLong(7,object.getId());
            return  pstm.executeUpdate()>0;
        }catch(SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Errps save"+ e.getMessage());
        }finally {
            close();
        }
        return false;
    }

//El DAO solo sirve ara manejar los datos en la base de datos es la ultima capa no se deben hacer validaciones

    @Override
    public boolean delate(Long id) {
        try{
            conn=new MySQLConnection().connect();
            String query="DELETE users WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            return pstm.executeUpdate() ==1;
        }catch ( SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error delate"+e.getMessage());
        }finally {
            close();
        }
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

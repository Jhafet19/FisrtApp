package ms.edu.utez.firstapp.models.user;

import ms.edu.utez.firstapp.models.crud.DaoRepository;

import java.util.List;

public class DaoUser implements DaoRepository<user> {
    @Override
    public List<user> findAll() {
        return null;
    }

    @Override
    public user findOne(Long id) {
        return null;
    }

    @Override
    public boolean save(user object) {
        return false;
    }

    @Override
    public boolean update(user object) {
        return false;
    }

    @Override
    public boolean delate(Long id) {
        return false;
    }
    //Acceso a base de datos es el intermediario en la aplicación y la base de datos


}

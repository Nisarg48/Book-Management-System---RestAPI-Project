package BookRestAPI.Dao;

import BookRestAPI.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

//    @Autowired
//    public UserDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public List<User> findAll() {
        String s = "From User";
        TypedQuery<User> sql = entityManager.createQuery(s, User.class);
        List<User> user = sql.getResultList();
        return user;
    }

    @Override
    public User findById(int id) {
        User user = entityManager.find(User.class, id);
        try {
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {

        System.out.println("\n\n\n\n");
        System.out.println(user);
        System.out.println();
        entityManager.merge(user);
        System.out.println("\n\n\n\n");

//        System.out.println(user.getUid() + " " + user.getAddress() + " " + user.getContactno() + " " + user.getFname() + user.getLname() + " " + user.getUsername() + " " + user.getPassword());
//        entityManager.persist(user);
//		System.out.print(user.getUid() + " " + user.getAddress() + " " + user.getContactno() + " " + user.getFname()+user.getLname());
    }

    @Override
    public void deleteById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}

package BookRestAPI.Service;

import BookRestAPI.Dao.UserPrincipal;
import BookRestAPI.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private EntityManager entityManager;

    @Autowired
    public MyUserDetailsService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Assuming you have an entity called User and an EntityManager instance called entityManager

        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);

        User user = null;
        try {
            user = (User) query.getSingleResult();
            // Handle user found
        } catch (NoResultException e) {
            // Handle user not found
        }

        return new UserPrincipal(user);
    }

}

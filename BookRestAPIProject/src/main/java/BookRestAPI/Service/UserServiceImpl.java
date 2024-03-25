package BookRestAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BookRestAPI.Dao.UserDao;
import BookRestAPI.Entities.User;

@Service
public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(@Qualifier("userDaoImpl") UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional
	public void addUser(User user) {
		System.out.println(user.getUid() + " " + user.getAddress() + " " + user.getContactno() + " " + user.getFname()+user.getLname());
		userDao.addUser(user);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		userDao.deleteById(id);
	}
}

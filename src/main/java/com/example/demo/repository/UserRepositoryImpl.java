package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

/*    @Override
    public User findUserByUsername(String username) {
        try {
            CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

            CriteriaQuery<User> query = criteria.createQuery(User.class);

            Root<User> user = query.from(User.class);

            Path<String> usernamePath = user.get("username");

            query.select(user).where(criteria.equal(usernamePath, username));

            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException nre) {
            log.error("No existe usuario con ese nombre de usuario");
        }
        return null;
    }*/

    @Override
    public Boolean login(String username, String password) {
        try {
            CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

            CriteriaQuery<User> query = criteria.createQuery(User.class);

            Root<User> user = query.from(User.class);

            Path<String> usernamePath = user.get("username");
            Path<String> passwordPath = user.get("password");

            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteria.equal(usernamePath, username));
            predicates.add(criteria.equal(passwordPath, password));

            query.select(user).where(criteria.and(predicates.toArray(new Predicate[0])));
            return entityManager.createQuery(query).getSingleResult() != null;
        } catch (NoResultException nre) {
            log.error("No existe el usuario con esas credenciales");
        }
        return Boolean.FALSE;
    }

    public static Specification<User> usernameExist(String username) {
        return (user, cq, cb) -> cb.equal(user.get("username"), username);
    }

}

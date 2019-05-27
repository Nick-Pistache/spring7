package com.wildcodeschool.example.spring7.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.wildcodeschool.example.spring7.entities.User;
import com.wildcodeschool.example.spring7.repositories.UserDAO;

@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private UserDAO userDao;

    @Override
    public void run(String... args) throws Exception {

        // Check combien d'objets se trouvent dans la BDD
        LOG.info("******************");
        LOG.info("Objects in DB : " + userDao.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        User user1 = new User("Brenda", "Wildeuse", 19);
        User user2 = new User("George", "Wildeuse", 23);
        LOG.info("******************");
        LOG.info(user1 + " has been created !");
        userDao.save(user1);
        userDao.save(user2);
        LOG.info(user1 + " has been saved !");


        //Lire le l'utilisateur
        User tempUser = userDao.findById(1L).get();
        LOG.info("******************");
        LOG.info("user's firstName is " + tempUser.getFirstName());
        LOG.info("user's lastName is " + tempUser.getLastName());
        LOG.info("user's age is " + tempUser.getAge());

        // mis à jour le dl'utilisatuer
        LOG.info("******************");
        LOG.info("user's firstName will be Nick " ) ;
        tempUser.setFirstName("Nick");
        userDao.save(tempUser);

        //Suprime l'utilisateur
        userDao.deleteById(1L);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nephtysorg.model.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.nephtysorg.model.pojo.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author cfollet
 */
public class LocationDAOImpl implements LocationDAO {
    private SessionFactory sessionFactory;
    
        public LocationDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional    
    @Override
    public void addLocation(Location location) {
        Session session = this.sessionFactory.getCurrentSession();
            session.persist(location);
    }

    @Transactional
    @Override
    public void updateLocation(Location location) {
       Session session = this.sessionFactory.getCurrentSession();
        
            session.update(location);
    }

    @Transactional
    @Override
    public List<Location> listLocations() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Location> locationList = session.createQuery("from Location").list();
        
        return locationList;
    }

    @Transactional
    @Override
    public Location getLocationById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Location location = (Location) session.load(Location.class, new Integer(id));
        return location;
    }

    @Transactional
    @Override
    public Location getLocationByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Location where label = :label").setParameter("label", name);
        
        return (Location) query.uniqueResult();
    }

    @Transactional
    @Override
    public void removeLocation(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Location location = (Location) session.load(Location.class, new Integer(id));
        if (null != location) {
                session.delete(location);
        }
    }

    @Transactional
    @Override
    public boolean exist(Location location) {
        return this.getLocationByName(location.getLabel()) != null;
    }

}

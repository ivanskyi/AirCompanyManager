package com.ivanskiy.demo.service;

import com.ivanskiy.demo.domain.AirCompany;
import com.ivanskiy.demo.dto.AirCompanyDto;
import com.ivanskiy.demo.repository.AirCompanyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private final TimeManagerImpl timeManagerImpl;
    private final AirCompanyRepository airCompanyRepository;

    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository, TimeManagerImpl timeManagerImpl) {
        this.timeManagerImpl = timeManagerImpl;
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public void createCompany(AirCompanyDto airCompanyDto) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String foundedAt = timeManagerImpl.getCurrentTimeinString();
        AirCompany airCompany = new AirCompany(airCompanyDto.getName().toUpperCase(), airCompanyDto.getCompanyType(),
                foundedAt);
        session.save(airCompany);
        transaction.commit();
        session.close();
    }

    @Override
    public AirCompany getCompanyById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AirCompany airCompany = session.get(AirCompany.class, id);
        transaction.commit();
        session.close();
        return airCompany;
    }

    @Override
    public void updateAirCompany(AirCompanyDto airCompanyDto) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AirCompany airCompany = new AirCompany();
        airCompany.setID(airCompanyDto.getID());
        airCompany.setName(airCompanyDto.getName().toUpperCase());
        airCompany.setCompanyType(airCompanyDto.getCompanyType());
        airCompany.setFoundedAt(airCompanyDto.getFoundedAt());
        session.update(airCompany);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteById(Integer id ) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        airCompanyRepository.deleteById(id);
        transaction.commit();
        session.close();
    }

    @Override
    public AirCompany getAirCompanyByName(String companyName) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AirCompany airCompany = airCompanyRepository.getAirCompanyByName(companyName);
        transaction.commit();
        session.close();
        return airCompany;
    }

    @Override
    public List<AirCompany> getAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<AirCompany> airCompanies = session.createQuery("from AirCompany").list();
        transaction.commit();
        session.close();
        return airCompanies;
    }
}

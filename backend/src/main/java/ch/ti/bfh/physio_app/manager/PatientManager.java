package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.Therapeut;

import java.util.List;
import java.util.Locale;
import java.util.Set;
/**
 * All Operations including Database queries for the Praxis class are created in here. We use an EntityManger for all
 * Database modifications and queries.
 * @Transactional: Used to make sure that the Methods are atomic.
 * @ApplicationScoped: Makes sure that the instance of ExerciseManager will be created excactly once during runtime.
 */
@ApplicationScoped
public class PatientManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public void save(Patient patient) {
        entityManager.persist(patient);
    }

    /*@Transactional
    public Patient getPatientById(long id){
        return entityManager.find(Patient.class,id);
    }*/

    @Transactional
    public Therapeut getTherapeut(Patient patient){
        return patient.getTherapeut();
    }

    @Transactional
    public Patient getPatientById(long id){
        TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p where p.id = :id", Patient.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional
    public Patient getPatientBySurname(String surname){
        TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p WHERE p.surname = :surname", Patient.class);
        query.setParameter("surname", surname);
        return query.getSingleResult();
    }

    @Transactional
    public List<Programm> getProgramms(Patient patient){
        TypedQuery<Programm> query = entityManager.createQuery("SELECT p FROM Programm p WHERE p.patient.id = :id", Programm.class);
        query.setParameter("id", patient.getId());
        return query.getResultList();
    }


    @Transactional
    public List<Patient> getAllPatients(){
        TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p", Patient.class);
        return query.getResultList();
    }


}


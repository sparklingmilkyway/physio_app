package ch.ti.bfh.physio_app.concept;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 05.04.2017.
 */
public class TherapeutTest {
    @Test
    public void getPatientList() throws Exception {
        Therapeut therapeut = new Therapeut("John","Doe","12345");

        assertNotNull(therapeut.getPatientList());
    }

    @Test
    public void setPatientList() throws Exception {
        Therapeut therapeut = new Therapeut("John","Doe","12345");

        Patient patient = new Patient();
        Patient patient1 = new Patient();

        Set<Patient> patientSet = new HashSet<Patient>();
        patientSet.add(patient);
        patientSet.add(patient1);

        therapeut.setPatientList(patientSet);

        assertEquals(therapeut.getPatientList(),patientSet);
    }

    @Test
    public void getSurname(){
        Therapeut therapeut = new Therapeut("John","Doe","12345");

        assertEquals(therapeut.getSurname(),"John");
    }

    @Test
    public void getLastname(){
        Therapeut therapeut = new Therapeut("John","Doe","12345");

        assertEquals(therapeut.getFirstname(),"Doe");
    }

    @Test
    public void setSurname(){
        Therapeut therapeut = new Therapeut("John","Doe","12345");
        therapeut.setSurname("Peter");
        assertEquals(therapeut.getSurname(),"Peter");
    }

    @Test
    public void setLastname(){
        Therapeut therapeut = new Therapeut("John","Doe","12345");
        therapeut.setFirstname("Pan");
        assertEquals(therapeut.getFirstname(),"Pan");
    }

    @Test
    public void damnPasswordTests(){
        Therapeut therapeut = new Therapeut("John","Doe","12345");
        assertEquals(therapeut.getPasswordHash(),"12345");
        therapeut.setPasswordHash("54321");
        assertEquals(therapeut.getPasswordHash(),"54321");
        assertNotEquals(therapeut.getPasswordHash(),"12345");
    }
}
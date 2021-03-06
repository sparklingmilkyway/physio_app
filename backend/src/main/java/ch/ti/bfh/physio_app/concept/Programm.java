package ch.ti.bfh.physio_app.concept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.*;

/**
 * This class describes the attributes and functionality of a Programm object. A Programm does not contain directly
 * A List with Exercises but a ProgrammExponent List. The Objects contains one Exercise Object each. Attention! Deleting
 * the default constructor will corrupt the Junit tests.
 */
@Entity
public class Programm extends pEntityWithID{

    @OneToMany
    private List<ProgrammComponent> programmComponent = new ArrayList<>();

    @Column
    private String programm_name;

    @ManyToOne
    private Patient patient;

    /** TO KEEP HIBERNATE HAPPY */
    public Programm(){ }

    public Programm(String name){
        this.programm_name = name;
    }

    public Programm(String name, List<ProgrammComponent> programmExponents){
        this.programm_name = name;
        this.programmComponent = programmExponents;
    }

    public List<ProgrammComponent> getProgrammComponent() {
        return programmComponent;
    }

    public void setProgrammComponent(List<ProgrammComponent> programmComponent) {
        this.programmComponent = programmComponent;
    }

    public String getProgramm_name() {
        return programm_name;
    }

    public void setProgramm_name(String programm_name) {
        this.programm_name = programm_name;
    }

    public String getName() {
        return programm_name;
    }

    public void setName(String name) {
        this.programm_name = name;
    }
}
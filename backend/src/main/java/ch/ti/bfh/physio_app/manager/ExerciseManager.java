package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ch.ti.bfh.physio_app.concept.Exercise;
import java.util.List;

@ApplicationScoped
public class ExerciseManager {

    @Inject
    private EntityManager entityManager;

    public void AddNote(String note, Exercise exercise){
        Exercise ex = getExerciseById(exercise.getId());
        List<String> notes = ex.getNotes();
        notes.add(note);
        ex.setNotes(notes);
        save(ex);
    }

    public boolean RemoveNote(String note, Exercise exercise){
        Exercise ex = getExerciseById(exercise.getId());
        List<String> notes = ex.getNotes();
        for(String n: notes){
            if(n.equals(note)){
                notes.remove(note);
                ex.setNotes(notes);
                save(ex);
                return true;
            }
        }
        return false;
    }

    public Exercise getExe(String note, Exercise exercise){
        //Was söu die Methode genau chönne?
        return exercise;
    }

    public void newExercise(String name,String type) {
        Exercise ex = new Exercise();
        ex.setName(name);
        ex.setType(type);
        save(ex);
    }

    public void save(Exercise ex) {
        entityManager.persist(ex);
    }

    private Exercise getExerciseById(long id){
        Exercise ex = entityManager.find(Exercise.class,id);
        return ex;
    }

}
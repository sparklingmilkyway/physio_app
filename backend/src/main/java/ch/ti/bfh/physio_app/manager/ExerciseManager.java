package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.ExerciseNote;

import java.util.List;

@ApplicationScoped
public class ExerciseManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public void save(Exercise ex) {
        entityManager.persist(ex);
    }

    @Transactional
    public Exercise getExerciseById(long id){
            return entityManager.find(Exercise.class, id);
    }

    @Transactional
    public Exercise addNote(String note, Exercise exercise){
        exercise.getNotes().add(new ExerciseNote(note, exercise));
        save(exercise);
        return getExerciseById(exercise.getId());
    }

    @Transactional
    public Exercise addNote(ExerciseNote note, Exercise exercise){
        exercise.getNotes().add(note);
        save(exercise);
        return getExerciseById(exercise.getId());
    }

    @Transactional
    public boolean removeNote(ExerciseNote note, Exercise exercise){
        if (exercise.getNotes().contains(note)) {
            exercise.getNotes().remove(note);
            save(exercise);
            return true;
        }
        return false;
    }

    public ExerciseNote getNote(Exercise exercise, ExerciseNote exerciseNote){
        List<ExerciseNote> exerciseList = exercise.getNotes();
        if(exerciseList.contains(exerciseNote)){
            return exerciseNote;
        }
        else{
            ExerciseNote exn = new ExerciseNote();
            return exn;
        }
    }

    @Transactional
    public Exercise newExercise(String name,String type) {
        Exercise ex = new Exercise();
        ex.setName(name);
        ex.setType(type);
        long ex_id = ex.getId();
        save(ex);
        return ex;
    }

    @Transactional
    public boolean removeExercise(Exercise exercise){
         if (entityManager.contains(exercise)) {
            entityManager.remove(exercise);
            return true;
        }
        else return false;
    }

}

package rodriguez.manuel.pinit_app.Database;

<<<<<<< HEAD

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
=======
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
>>>>>>> work
import androidx.room.Query;

import java.util.List;

<<<<<<< HEAD
import rodriguez.manuel.pinit_app.Models.Notes;
=======
import rodriguez.manuel.pinit_app.Model.Notes;
>>>>>>> work

@Dao
public interface MainDAO {

<<<<<<< HEAD
    @Insert(onConflict = REPLACE)
=======
    @Insert(onConflict = OnConflictStrategy.REPLACE)
>>>>>>> work
    void insert(Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :id")
<<<<<<< HEAD
    void update(int id, String title, String notes);
=======
    void update(int id,String title, String notes);
>>>>>>> work

    @Delete
    void delete(Notes notes);

}

package rodriguez.manuel.pinit_app.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//import rodriguez.manuel.pinit_app.Model.Notes;

//<<<<<<< HEAD
//import rodriguez.manuel.pinit_app.Models.Notes;
//
///**
// * Represent the Room database for the PINITAPP application.
// * This is a singleton class that provides access to the database
// */
//@Database(entities = Notes.class, version = 1, exportSchema = false)
//public abstract class RoomDB extends RoomDatabase {
//    private static RoomDB database;
//    private static String DATABASE_NAME = "PINITAPP";
//
//    /**
//     * Provides a singleton instance of the RoomDB database.
//     * Ensures that only one instance of the database is created
//     * throughout the application.
//     *
//     * @param context The context of the application.
//     * @return the singleton instance of the RoomDB database
//     */
//    public synchronized static RoomDB getInstance(Context context) {
//        if (database == null) {
//            database = Room.databaseBuilder(context.getApplicationContext(),
//                            RoomDB.class, DATABASE_NAME)
//                    .allowMainThreadQueries() // Allow queries on the main thread
//                    .fallbackToDestructiveMigration() // Handle schema migration
//            // by destroying and recreating the database
////=======
import rodriguez.manuel.pinit_app.Model.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB database;
    private static String DATABASE_NAME = "PINITAPP";

    public synchronized static RoomDB getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    public abstract MainDAO mainDAO();

}

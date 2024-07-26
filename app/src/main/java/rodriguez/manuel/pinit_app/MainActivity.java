package rodriguez.manuel.pinit_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import rodriguez.manuel.pinit_app.Adapter.NoteListAdapter;
import rodriguez.manuel.pinit_app.Database.RoomDB;
import rodriguez.manuel.pinit_app.Interface.NotesClickListener;
import rodriguez.manuel.pinit_app.Model.Notes;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;
    NoteListAdapter noteListAdapter;
    RoomDB database;
    List<Notes> notes = new ArrayList<>();
    FloatingActionButton fabtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recycleView = findViewById(R.id.noteRv);
        fabtn = findViewById(R.id.addBtn);
        database = RoomDB.getInstance(this);
        notes = database.mainDAO().getAll();

        updateRecycle(notes);
    }

    public void updateRecycle(List<Notes> notes){
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        noteListAdapter = new NoteListAdapter(MainActivity.this, notes,notesClickListener);
        recycleView.setAdapter((noteListAdapter));
    }

    private final NotesClickListener notesClickListener = new NotesClickListener(){

        @Override
        public void onClick(Notes notes) {
            Intent noteTakingActivity = new Intent(MainActivity.this, NoteTakingActivity.class);
            startActivity(noteTakingActivity);
        }

        @Override
        public void onLongPress(Notes notes, CardView cardview) {

        }

    };

}
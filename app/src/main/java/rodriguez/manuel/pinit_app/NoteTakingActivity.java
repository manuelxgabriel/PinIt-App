package rodriguez.manuel.pinit_app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NoteTakingActivity extends AppCompatActivity {

    EditText titleEdit, noteEdit;
    ImageView saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_note_taking);

        saveBtn = findViewById(R.id.saveBtn);
        titleEdit = findViewById(R.id.titleEdit);
        noteEdit = findViewById(R.id.noteEdit);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEdit.getText().toString();
            }
        });



    }
}
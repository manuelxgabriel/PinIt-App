package rodriguez.manuel.pinit_app;

import androidx.cardview.widget.CardView;

import rodriguez.manuel.pinit_app.Model.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);

}

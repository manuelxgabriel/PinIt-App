package rodriguez.manuel.pinit_app.Interface;

import android.provider.ContactsContract;

import androidx.cardview.widget.CardView;

import rodriguez.manuel.pinit_app.Model.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongPress(Notes notes, CardView cardview);


}

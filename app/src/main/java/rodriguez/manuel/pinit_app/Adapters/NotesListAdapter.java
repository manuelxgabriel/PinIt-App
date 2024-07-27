package rodriguez.manuel.pinit_app.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rodriguez.manuel.pinit_app.Model.Notes;
import rodriguez.manuel.pinit_app.NotesClickListener;
import rodriguez.manuel.pinit_app.R;


/**
 * Adapter class displaying a list of notes in a RecyclerView.
 */
public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    Context context;
    List<Notes> list;
    NotesClickListener listener;

    /**
     * Constructor for NoteListAdpater
     *
     * @param context The context in which the adapter is being used.
     * @param list The list of notes to display.
     * @param listener the listener for handling click events on the notes.
     */
    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener){
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    /**
     * Called when Recycler View needs a new ViewHolder of the given type to represent an item
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new NotesViewHolder that holds a View for a note item.
     */
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));
    }


    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        // Bind note data to the UI element
        holder.textView_title.setText(list.get(position).getTitle());
        holder.textView_title.setSelected(true);

        holder.textView_notes.setText(list.get(position).getNotes());

        holder.textView_date.setText(list.get(position).getDate());
        holder.textView_date.setSelected(true);

        // Set pin icon if the note is pinned
        if(list.get(position).getPinned()){
            holder.imageView_pin.setImageResource(R.drawable.ic_pin);
        } else {
            holder.imageView_pin.setImageResource(0);
        }

        // Set a random background color for the note container
        int color_code  = getRandomColor();
        holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code, null));

        // Set click listener for the note container.
        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });

        // Set long click listener for the note container
        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongClick(list.get(holder.getAdapterPosition()), holder.notes_container);
                return true;
            }
        });
    }


    /**
     * Return a random color resource ID from the list of predefined colors.
     * @return the resource ID of a random color.
     */
    private int getRandomColor(){
        List<Integer> colorCode = new ArrayList<>();

        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);

        Random random = new Random();
        int random_color = random.nextInt(colorCode.size());
        return random_color;

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     * @return the total number of items in this adapter
     */
    @Override
    public int getItemCount() {
        return list.size();
    }
}

/**
 * ViewHolder class for note item
 */
class NotesViewHolder extends RecyclerView.ViewHolder {

    CardView notes_container;
    TextView textView_title, textView_notes, textView_date;
    ImageView imageView_pin;

    /**
     * Constructor for NoteViewHolder.
     * @param itemView The view of the note item.
     */
    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        // Initialize UI elements for note item
        notes_container = itemView.findViewById(R.id.notes_container);
        textView_title = itemView.findViewById(R.id.textView_title);
        textView_notes = itemView.findViewById(R.id.textView_notes);
        textView_date = itemView.findViewById(R.id.textView_date);

    }
}

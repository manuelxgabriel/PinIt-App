package rodriguez.manuel.pinit_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rodriguez.manuel.pinit_app.Interface.NotesClickListener;
import rodriguez.manuel.pinit_app.Model.Notes;
import rodriguez.manuel.pinit_app.R;

public class NoteListAdapter extends RecyclerView.Adapter<NotesViewHolder>  {

    Context context;
    List<Notes> notesList;
    NotesClickListener listener;

    public NoteListAdapter(Context context, List<Notes> notesList, NotesClickListener listener){
        this.context = context;
        this.notesList = notesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.note_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.titleText.setText(notesList.get(position).getTitle());
        holder.notesText.setText(notesList.get(position).getNotes());
        holder.dateText.setText(notesList.get(position).getDate());
        holder.dateText.setSelected(true);

        if(notesList.get(position).getPinned()){
            holder.imageView.setImageResource(R.drawable.ic_pin);
        } else {
            holder.imageView.setImageResource(0);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(notesList.get(holder.getAdapterPosition()));
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongPress(notesList.get(holder.getAdapterPosition()),holder.cardView);
                return true;
            }
        });

    }


    @Override
    public int getItemCount() {
        return notesList.size();
    }
}


class NotesViewHolder extends RecyclerView.ViewHolder{
    CardView cardView;
    TextView notesText, titleText, dateText;
    ImageView imageView;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.note_container);
        notesText = itemView.findViewById(R.id.notesText);
        titleText = itemView.findViewById(R.id.titleText);
        dateText = itemView.findViewById(R.id.dateText);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
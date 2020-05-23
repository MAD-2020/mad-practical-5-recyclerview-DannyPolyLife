package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    CheckBox checkBox;
    ConstraintLayout deleteArea;

    public recyclerViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.taskTextView);
        checkBox = itemView.findViewById(R.id.taskCheckBox);
        deleteArea = itemView.findViewById(R.id.deletingHitBox);
    }
}

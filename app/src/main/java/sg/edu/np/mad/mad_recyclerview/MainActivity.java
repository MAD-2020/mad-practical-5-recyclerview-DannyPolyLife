package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText addingToDoItems;
    Button addingOfItemsBtn;
    ArrayList<String> toDoTaskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerViewCustom = findViewById(R.id.recyclerView);
        final recyclerViewAdaptor cAdaptor = new recyclerViewAdaptor(toDoTaskList);
        LinearLayoutManager cLayoutManager = new LinearLayoutManager(this);
        recyclerViewCustom.setLayoutManager(cLayoutManager);
        recyclerViewCustom.setAdapter(cAdaptor);
        recyclerViewCustom.setItemAnimator(new DefaultItemAnimator());

        InitData();

        Button add = (Button) findViewById(R.id.addTaskBtn);
        final EditText addingText = (EditText) findViewById(R.id.addTaskEditText);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = addingText.getText().toString();
                toDoTaskList.add(data);
                cAdaptor.notifyDataSetChanged();
            }
        });
    }

    public void InitData(){
        String milk = "Buy Milk";
        String postage = "Send Postage";
        String androidDevBook = "Buy Android Development Book";
        toDoTaskList.add(milk);
        toDoTaskList.add(postage);
        toDoTaskList.add(androidDevBook);
    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }


}

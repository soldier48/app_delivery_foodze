package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SearchView;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class SearchViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private EditText etsearch;
    private String[] FoodList;
    public static ArrayList<Model> NamesArrayList;
    public static ArrayList<Model> array_sort;
    int textlength = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_recycler);

        FoodList = new String[]{"Carrot Halwa and Pudhina Fry", "Onion Cheese with Curry", "Italian Chova with Onion Manjuri", "Orange Juice (2 Packs)", "Panneer Fry","Carrot Halwa and Pudhina Fry", "Onion Cheese with Curry", "Italian Chova with Onion Manjuri", "Orange Juice (2 Packs)", "Panneer Fry"};

        recyclerView = (RecyclerView) findViewById(R.id.search_recycler);

        NamesArrayList = populateList();
        Log.d("hjhjh", NamesArrayList.size() + "");
        adapter = new Adapter(this,NamesArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        etsearch = (EditText) findViewById(R.id.search);
        array_sort = new ArrayList<>();
        array_sort = populateList();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Toast.makeText(SearchViewActivity.this, array_sort.get(position).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        etsearch.addTextChangedListener(new TextWatcher() {


            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textlength = etsearch.getText().length();
                array_sort.clear();
                for (int i = 0; i < NamesArrayList.size(); i++) {
                    if (textlength <= NamesArrayList.get(i).getName().length()) {
                        Log.d("ertyyy", NamesArrayList.get(i).getName().toLowerCase().trim());
                        if (NamesArrayList.get(i).getName().toLowerCase().trim().contains(
                                etsearch.getText().toString().toLowerCase().trim())) {
                            array_sort.add(NamesArrayList.get(i));
                        }
                    }
                }
                adapter = new Adapter(SearchViewActivity.this, array_sort);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

            }
        });

    }

    private ArrayList<Model> populateList(){

        ArrayList<Model> list = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            Model imageModel = new Model();
            imageModel.setName(FoodList[i]);
            list.add(imageModel);
        }

        return list;
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
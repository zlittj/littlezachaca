package com.zachlittle.android.aca.notetoself;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mNoteAdapter = new NoteAdapter();
        ListView listNote = (ListView) findViewById(R.id.listView);
        listNote.setAdapter(mNoteAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogNewNote dialog = new DialogNewNote();
                dialog.show(getFragmentManager(), "");

            }
        });

        listNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int whichItem, long id) {
                Note tempNote = mNoteAdapter.getItem(whichItem);
                DialogShowNote dialog = new DialogShowNote();
                dialog.sendNoteSelected(tempNote);
                dialog.show(getFragmentManager(), "");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    public void createNewNote(Note n){
        mNoteAdapter.addNote(n);
    }




    public class NoteAdapter extends BaseAdapter {
        List<Note> noteList = new ArrayList<Note>();

        @Override
        public int getCount(){
            return noteList.size();
        }

        @Override
        public Note getItem(int whichItem) {
            return noteList.get(whichItem);
        }

        @Override
        public long getItemId(int whichItem) {
            return whichItem;
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup) {
            //Implement this method next
            //Has view been inflated already
            if (view == null){
                //if not do so here
                //first create a layoutinflater
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //now insttiante view
                view = inflater.inflate(R.layout.listitem, viewGroup, false);
            }//end of if statement

            //grab a referenc to all of our textview and image view widgets
            TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);
            ImageView ivImportant = (ImageView) view.findViewById(R.id.imageViewImportant);
            ImageView ivTodo = (ImageView) view.findViewById(R.id.imageViewTodo);
            ImageView ivIdea = (ImageView) view.findViewById(R.id.imageViewIdea);

            //Hide any ImageView widgets that are not relevant
            Note tempNote = noteList.get(whichItem);
            if (!tempNote.isImportant()){
                ivImportant.setVisibility(View.GONE);
            }
            if (!tempNote.isTodo()){
                ivTodo.setVisibility(View.GONE);
            }
            if (!tempNote.isIdea()){
                ivIdea.setVisibility(View.GONE);
            }
            txtTitle.setText(tempNote.getTitle());
            txtDescription.setText(tempNote.getDescription());

            return view;
        }//end of getview

        public void addNote(Note n){
            noteList.add(n);
            notifyDataSetChanged();
        }
    }//end of noteadapter
}

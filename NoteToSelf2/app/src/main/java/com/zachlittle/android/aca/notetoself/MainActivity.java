package com.zachlittle.android.aca.notetoself;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Animation mAnimFlash;
    Animation mFadeIn;

    int mIdBeep = -1;
    SoundPool mSp;

    private NoteAdapter mNoteAdapter;
    private boolean mSound;
    private int mAnimOption;
    private SharedPreferences mPrefs;
    private String mPicFilename;
    private Uri mUriPic;
    private Bitmap mRaw;
    ImageView mIvPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            mSp = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            mSp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        try {
            AssetManager assetManager = this.getAssets();
            AssetFileDescriptor descriptor;

            descriptor = assetManager.openFd("beep.ogg");
            mIdBeep = mSp.load(descriptor, 0);
        }catch (IOException e){
            Log.e("error", "failed to load sound files");
        }



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

        listNote.setLongClickable(true);
        listNote.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int whichItem, long id){
                mNoteAdapter.deleteNote(whichItem);
                return true;
            }
        });

        listNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int whichItem, long id) {
                if(mSound){
                    mSp.play(mIdBeep, 1,1,0,0,1);
                }
                Note tempNote = mNoteAdapter.getItem(whichItem);
                DialogShowNote dialog = new DialogShowNote();
                dialog.sendNoteSelected(tempNote);
                dialog.sendWhichItem(whichItem);
                dialog.show(getFragmentManager(), "");
            }
        });
    }//end of oncreate

    @Override
    protected void onResume() {
        super.onResume();
        mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
        mSound = mPrefs.getBoolean("sound", true);
        mAnimOption = mPrefs.getInt("anim option", SettingsActivity.FAST);

        mAnimFlash = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flash);
        mFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        // Set the rate of flash based on settings
        if(mAnimOption == SettingsActivity.FAST){

            mAnimFlash.setDuration(100);
            Log.i("anim = ",""+ mAnimOption);
        }else if(mAnimOption == SettingsActivity.SLOW){

            Log.i("anim = ",""+ mAnimOption);
            mAnimFlash.setDuration(1000);
        }

        mNoteAdapter.notifyDataSetChanged();

    }//end of onResume

    @Override
    protected void onPause() {
        super.onPause();
        mNoteAdapter.saveNotes();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mIvPicture.getDrawable() != null) {
            BitmapDrawable bd = (BitmapDrawable) mIvPicture.getDrawable();
            bd.getBitmap().recycle();
            mIvPicture.setImageBitmap(null);
        }
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
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    public void createNewNote(Note n){
        mNoteAdapter.addNote(n);
    }
    public void replaceNewNote(int i, Note note){
        mNoteAdapter.replaceNote(i, note);
    }




    public class NoteAdapter extends BaseAdapter {
        private JSONSerializer mSerializer;
        List<Note> noteList = new ArrayList<Note>();

        public NoteAdapter(){
            mSerializer = new JSONSerializer("NoteToSelf.json", MainActivity.this.getApplicationContext());
            try {
                noteList = mSerializer.load();
            } catch (Exception e) {
                noteList = new ArrayList<Note>();
                Log.e("Error loading notes: ", "", e);
            }

        }

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
            mIvPicture = (ImageView) view.findViewById(R.id.imageViewShowPic);
            View listitemBackground = (View) view.findViewById(R.id.list_background);
            View otherBackground = (View) view.findViewById(R.id.list_other_background);

            //Hide any ImageView widgets that are not relevant
            Note tempNote = noteList.get(whichItem);
            if (whichItem % 2 ==0 || whichItem == 0){
                listitemBackground.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
                otherBackground.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            }else {
                listitemBackground.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
                otherBackground.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
            }
            // To animate or not to animate
            if (tempNote.isImportant() && mAnimOption != SettingsActivity.NONE ) {
                view.setAnimation(mAnimFlash);

            }else{
                view.setAnimation(mFadeIn);
            }


            if (!tempNote.isImportant()){
                ivImportant.setVisibility(View.GONE);
            }
            if (!tempNote.isTodo()){
                ivTodo.setVisibility(View.GONE);
            }
            if (!tempNote.isIdea()){
                ivIdea.setVisibility(View.GONE);
            }
            if (tempNote.getPicFilename() != null){
                mPicFilename = tempNote.getPicFilename();
                BitmapDecoder decoder = new BitmapDecoder();
                decoder.doInBackground();
                decoder.onPostExecute(mRaw);
            }else {mIvPicture.setVisibility(View.GONE);}
            txtTitle.setText(tempNote.getTitle());
            txtDescription.setText(tempNote.getDescription());

            return view;
        }//end of getview

        public void addNote(Note n){
            noteList.add(n);
            notifyDataSetChanged();
        }
        public void replaceNote(int i, Note n){
            noteList.remove(i);
            noteList.add(i, n);
            notifyDataSetChanged();
        }
        public void saveNotes(){
            try{
                mSerializer.save(noteList);

            }catch(Exception e){
                Log.e("Error Saving Notes","", e);
            }
        }
        public void deleteNote(int n){
            noteList.remove(n);
            notifyDataSetChanged();
        }

    }//end of noteadapter

    class BitmapDecoder extends AsyncTask<Integer, Void, Bitmap>{


        @Override
        protected Bitmap doInBackground(Integer... params) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            mRaw = BitmapFactory.decodeFile(mPicFilename, options);
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mIvPicture.setImageBitmap(bitmap);
        }
    }
}

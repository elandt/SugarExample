package com.example;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.orm.SugarRecord;

import java.util.List;

import static com.orm.dsl.Collection.list;


public class NoteListActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notelist);
        initDb();

        List<Note> notes = getNotes();
        setListAdapter(new ArrayAdapter<Note>(this,android.R.layout.simple_list_item_1, notes));

    }

    private List<Note> getNotes() {
        return Note.listAll(this, Note.class);
       // return list();
    }

    private void initDb() {

        Tag t1 = new Tag(this, "tag1");
        Tag t2 = new Tag(this, "tag2");
        t1.save();
        t2.save();

        Note n1 = new Note(this, "note1", "description1", t1);
        Note n2 = new Note(this, "note2", "description2", t1);
        Note n3 = new Note(this, "note3", "description3", t2);
        Note n4 = new Note(this, "note4", "description4", t2);

        n1.save();
        n2.save();
        n3.save();
        n4.save();

    }
}
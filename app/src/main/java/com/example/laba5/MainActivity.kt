package com.example.laba5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.View;
import android.widget.Button

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newnote: Button = findViewById(R.id.newnote)
        newnote.setOnClickListener{
            val intent = Intent(this, AddNote::class.java)
            startActivity(intent)
        }
        /*val newnote: Button = findViewById(R.id.newnote)
        newnote.setOnClickListener{ goToAddNote() }

        val config = RealmConfiguration.create(schema = setOf(Item::class))
        val realm: Realm = Realm.open(config)

       // val items: RealmResults<Item> = realm.query<Item>().find()

    }
    private fun goToAddNote() {
        val intent = Intent(this, AddNote::class.java)
        startActivity(intent)*/
    }
}
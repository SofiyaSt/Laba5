package com.example.laba5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laba5.ui.theme.Laba5Theme
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class AddNote : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note)

        val noteTitle: EditText = findViewById(R.id.editTitle)
        val noteText: EditText = findViewById(R.id.editNote)
        val saveBtn: Button = findViewById(R.id.button)
        val config = RealmConfiguration.create(schema = setOf(Item::class))
        val realm: Realm = Realm.open(config)

        saveBtn.setOnClickListener() {
            val title: String = noteTitle.text.toString()
            val description: String = noteText.text.toString()
            realm.writeBlocking {
                copyToRealm(Item().apply {
                    titleR = title
                    noteR = description
                })
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
class Item() : RealmObject {
    @PrimaryKey
    var titleR: String = ""
    var noteR: String = ""
}
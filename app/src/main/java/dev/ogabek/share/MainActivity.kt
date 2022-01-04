package dev.ogabek.share

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val uri = Uri.parse("android.resource://dev.ogabek.share/drawable/img")
            shareImageWith(uri)
        }

    }

    fun shareMultiImage(uris: ArrayList<Uri?>?) {
        val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris)
        intent.type = "image/*"
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent, "Share"))
    }

    fun shareTextAndImage(text: String?, uri: Uri?) {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, text)
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.type = "image/*"
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent, "Share"))
    }

    fun shareImageWith(uriToImage: Uri?) {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_STREAM, uriToImage)
        intent.type = "image/*"
        startActivity(Intent.createChooser(intent, "Share"))
    }

    fun shareTextWith(text: String?) {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, text)
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Share"))
    }

    fun shareLinkWith(url: String?) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, url)
        startActivity(Intent.createChooser(intent, "Share"))
    }



}
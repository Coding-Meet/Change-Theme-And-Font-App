package com.example.changethemefontapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private val themeTitleList = arrayOf("Light","Dark","Auto (System Default)")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val changeThemeBtn = findViewById<Button>(R.id.changeThemeBtn)
        val themeTxt = findViewById<TextView>(R.id.themeTxt)


        val sharedPreferenceManger = SharedPreferenceManger(this)
        var checkedTheme = sharedPreferenceManger.theme
        themeTxt.text = "Theme: ${themeTitleList[sharedPreferenceManger.theme]}"
        val themeDialog = MaterialAlertDialogBuilder(this)
            .setTitle("Theme")
            .setPositiveButton("Ok"){_,_ ->
                sharedPreferenceManger.theme = checkedTheme
                AppCompatDelegate.setDefaultNightMode(sharedPreferenceManger.themeFlag[checkedTheme])
                themeTxt.text = "Theme: ${themeTitleList[sharedPreferenceManger.theme]}"
            }
            .setSingleChoiceItems(themeTitleList,checkedTheme){_, which ->
                checkedTheme = which
            }
            .setCancelable(false)

        changeThemeBtn.setOnClickListener {
            themeDialog.show()
        }
    }
}
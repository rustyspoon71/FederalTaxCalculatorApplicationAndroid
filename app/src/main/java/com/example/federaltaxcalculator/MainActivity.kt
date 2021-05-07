package com.example.federaltaxcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/** Author Russell Roberts
 *  This simple application will take the user's input and
 *  determine how much in taxes they will need to pay.
 *  The code is written in kotlin and xml.
 *  For further inquiries visit my github: https://github.com/rustyspoon71
 *  Or you may reach me via email: russellroberts51@yahoo.com
 *  This is based on tax brackets from 2020 via the IRS website.
 */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** This is where all the code will be ran*/

        /** Initialize the button value to start the program */

        val btnClicked = findViewById<Button>(R.id.button)

        /** start the calculations if the button is clicked*/

        btnClicked.setOnClickListener{

            /** retrieve the income from the user*/

            val income = findViewById<TextView>(R.id.editTextTextPersonName).text.toString().toInt()

            /** cast it to a double as we cannot get decimals within a int*/

            var doubleValue = income.toDouble()

            /** Begin the process of determining which tax bracket they will be in*/

            if (income in 0..19750)
            {
                doubleValue = 0.0
            }
            else if(income in 19751..80250)
                {
                    doubleValue = (doubleValue * .12) + 1975.0
                }
            else if(income in 80251..171050)
                {
                   doubleValue = (doubleValue  * .22) + 9235.0
                }
            else if(income in 171051..326600)
                {
                    doubleValue = (doubleValue *.24)  + 29211.0
                }
            else if(income in 326601..414700)
                {
                    doubleValue = (doubleValue * .32) + 66543.0
                }
            else if(income in 414701..622050)
                {
                    doubleValue = (doubleValue * .35) + 94735.0
                }
            else
                {
                    doubleValue = (doubleValue * .37) + 167307.50
                }

            /** return the Value but cast it back to a string to be displayed and update the text */

            var finalResult = doubleValue.toString()
            val text: TextView = findViewById(R.id.outputChannel) as TextView
            text.text = finalResult
        }
    }
}
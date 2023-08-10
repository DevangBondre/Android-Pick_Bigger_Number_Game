package mai.hu.beast.first.letsdoit

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Random

class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonLight = findViewById<Button>(R.id.btnLight)


        buttonLight.setOnClickListener {


            checkAnswer(LeftButtonSelected = true)
            assignNumberstoButtons()

        }

        buttonDark.setOnClickListener {

            checkAnswer(LeftButtonSelected = false)
            assignNumberstoButtons()
        }

    }

    private fun checkAnswer(LeftButtonSelected:Boolean){
        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonLight = findViewById<Button>(R.id.btnLight)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintlayout)
        val isAnswerCorrect:Boolean=if (LeftButtonSelected) buttonLight.text.toString() > buttonDark.text.toString() else buttonDark.text.toString()  > buttonLight.text.toString()


        if (isAnswerCorrect) {
            constraintLayout.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()

        } else {
            constraintLayout.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
        }
    }




    private fun assignNumberstoButtons() {
        val r = Random()
        val leftNum: Int = r.nextInt(10)

        var rightNum=leftNum
        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonLight = findViewById<Button>(R.id.btnLight)

        while (rightNum==leftNum){
            rightNum=r.nextInt(10)
        }

        buttonDark.text=leftNum.toString()
        buttonLight.text=rightNum.toString()


    }

}




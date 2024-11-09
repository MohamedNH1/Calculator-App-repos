package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var previousOp: String
    private lateinit var previousOp1: String
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvHello)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val textResult = findViewById<TextView>(R.id.textView)
        val number1 = findViewById<Button>(R.id.button1)
        val number2 = findViewById<Button>(R.id.button2)
        val number3 = findViewById<Button>(R.id.button3)
        val number4 = findViewById<Button>(R.id.button4)
        val number5 = findViewById<Button>(R.id.button5)
        val number6 = findViewById<Button>(R.id.Button6)
        val number7 = findViewById<Button>(R.id.Button7)
        val number8 = findViewById<Button>(R.id.Button8)
        val number9 = findViewById<Button>(R.id.Button9)
        val number0 = findViewById<Button>(R.id.Button0)
        val buttonPlus = findViewById<Button>(R.id.ButtonPlus)
        val buttonMinus = findViewById<Button>(R.id.ButtonMinus)
        val buttonDivide = findViewById<Button>(R.id.ButtonDivide)
        val buttonMultiply = findViewById<Button>(R.id.ButtonMultiply)
        val buttonDecimal = findViewById<Button>(R.id.ButtonDec)
        val clearButton = findViewById<Button>(R.id.ButtonClear1)
        val deleteButton = findViewById<Button>(R.id.buttonDelete)
        val showResult = findViewById<Button>(R.id.buttonEqual)
        val textDemo = findViewById<TextView>(R.id.textView2)

        previousOp = ""


        viewModel.resultDemo.observe(this, Observer {
            if (it != null) {
                textDemo.text = it.toString()
            } else {
                textDemo.text = ""
            }
        })

        number1.setOnClickListener {

            if (previousOp.length < 45) {
                previousOp += "1"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number2.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "2"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number3.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "3"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number4.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "4"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number5.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "5"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number6.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "6"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number7.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "7"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number8.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "8"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number9.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "9"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        number0.setOnClickListener {
            if (previousOp.length < 45) {
                previousOp += "0"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        buttonPlus.setOnClickListener {
            if (!(previousOp.endsWith('+') || previousOp.endsWith('-') || previousOp.endsWith('÷') || previousOp.endsWith(
                    '×'
                ) ||
                        previousOp.endsWith('.') || previousOp.isEmpty()) && previousOp.length < 45
            ) {
                previousOp += "+"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        buttonMinus.setOnClickListener {
            if (!(previousOp.endsWith('+') || previousOp.endsWith('-') || previousOp.endsWith('÷') || previousOp.endsWith(
                    '×'
                ) ||
                        previousOp.endsWith('.') || previousOp.isEmpty()) && previousOp.length < 45
            ) {
                previousOp += "-"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        buttonDivide.setOnClickListener {
            if (!(previousOp.endsWith('+') || previousOp.endsWith('-') || previousOp.endsWith('÷') || previousOp.endsWith(
                    '×'
                ) ||
                        previousOp.endsWith('.') || previousOp.isEmpty()) && previousOp.length < 45
            ) {
                previousOp += "÷"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        buttonMultiply.setOnClickListener {

            if (!(previousOp.endsWith('+') || previousOp.endsWith('-') || previousOp.endsWith('÷') || previousOp.endsWith(
                    '×'
                ) ||
                        previousOp.endsWith('.') || previousOp.isEmpty()) && previousOp.length < 45
            ) {
                previousOp += "×"
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        buttonDecimal.setOnClickListener {
            var count = 0
            for (i in previousOp) {
                when (i) {
                    '.' -> count++
                    '+' -> count = 0
                    '-' -> count = 0
                    '×' -> count = 0
                    '÷' -> count = 0
                }
            }

            if (!(previousOp.endsWith('+') || previousOp.endsWith('-') || previousOp.endsWith('÷') || previousOp.endsWith(
                    '×'
                ) ||
                        previousOp.endsWith('.') || previousOp.isEmpty()) && previousOp.length < 45 && count == 0
            ) {
                previousOp += "."
                textResult.text = previousOp
                viewModel.setResult(calculate(previousOp))
            }
        }

        deleteButton.setOnClickListener {
            previousOp = previousOp.dropLast(1)
            textResult.text = previousOp
            viewModel.setResult(calculate(previousOp))
        }

        clearButton.setOnClickListener {
            textResult.text = ""
            previousOp = ""
            viewModel.setResult(calculate(previousOp))
        }

        showResult.setOnClickListener {
            if (previousOp1.isNotBlank() && !previousOp1.endsWith('+') && !previousOp1.endsWith('-') && !previousOp1.endsWith(
                    '÷'
                ) && !previousOp1.endsWith('×') && !previousOp1.endsWith('.')
            ) {
                textResult.text = calculate(previousOp)
                previousOp = previousOp1
                textDemo.text = ""
            }
        }


        if(previousOp.contains('I'))
            previousOp = ""
    }

    private fun calculate(previousOp2: String): String {
        previousOp1 = previousOp2
        var operation = ""
        var secOperation = ""
        var finalNumberOperation: Double
        var finalResult = 0.0
        var newCounter = 0
        var insideCounter = 0
        var valueBefore = ""
        var valueAfter = ""
        var productOrDivisionValue = 0.0
        var stringBuilder: StringBuilder
        var i = 0
        var j = 0
        var number = 0
        var number2: Int
        var number3: Int
        var numberCounter = 0
        var counter = 0
        var number4: Int
        val stringFinalResult: StringBuilder

        if (previousOp1.isNotBlank() && !previousOp1.endsWith('+') && !previousOp1.endsWith('-') && !previousOp1.endsWith(
                '÷'
            ) && !previousOp1.endsWith('×') && !previousOp1.endsWith('.')
        ) {

            stringBuilder = StringBuilder(previousOp1)
            while (number < previousOp1.length) {

                if (previousOp1.startsWith('I') || previousOp1.startsWith('N') || previousOp1.endsWith(
                        'E'
                    ) || previousOp1.endsWith('y')
                ) {

                    Toast.makeText(
                        this@MainActivity,
                        "Invalid format used",
                        Toast.LENGTH_SHORT
                    ).show()
                    previousOp = ""
                    return "0"
                }

                if (previousOp1[number] == '×' || previousOp1[number] == '÷') {
                    number3 = number + 1
                    number4 = number3
                    while (number3 < previousOp1.length) {

                        if (previousOp1[number3] == '+' || previousOp1[number3] == '-' || previousOp1[number3] == '÷' || previousOp1[number3] == '×') {

                            break
                        }

                        valueAfter += previousOp1[number3]

                        counter++
                        number3++
                    }
                    while (i < counter) {
                        stringBuilder.deleteAt(number4).toString()
                        i++
                    }

                    stringBuilder.deleteAt(number4 - 1).toString()
                    number2 = number - 1
                    while (number2 >= 0) {

                        if (previousOp1[number2] == '+' || previousOp1[number2] == '-' || previousOp1[number2] == '÷' || previousOp1[number2] == '×') {

                            break
                        }
                        valueBefore += previousOp1[number2]
                        stringBuilder = stringBuilder.deleteAt(number2)

                        number2--
                    }
                    valueBefore = valueBefore.reversed()


                    if (previousOp1[number] == '×') {
                        productOrDivisionValue = valueAfter.toDouble() * valueBefore.toDouble()
                    } else if (previousOp1[number] == '÷') {
                        productOrDivisionValue = valueBefore.toDouble() / valueAfter.toDouble()
                    }

                    number2++
                    previousOp1 =
                        stringBuilder.insert(number2, productOrDivisionValue.toString())
                            .toString()


                }



                valueAfter = ""
                valueBefore = ""


                number++

            }



            i = 0
            while (i < previousOp1.length) {
                newCounter++

                if (i == 0 && previousOp1.startsWith('-')) {
                    i++
                    continue
                }
                if (previousOp1[i] == '+' || previousOp1[i] == '-' || previousOp1[i] == '÷' || previousOp1[i] == '×') {
                    while (j < previousOp1.length) {
                        insideCounter++
                        if (insideCounter >= newCounter) {
                            break
                        }

                        operation += previousOp1[j]
                        j++
                    }

                    finalNumberOperation = operation.toDouble()

                    for (k in insideCounter..<previousOp1.length) {

                        if (previousOp1[k].toString()
                                .toIntOrNull() != null || previousOp1[k] == '.'
                        ) {

                            secOperation += previousOp1[k]
                        }
                        if (previousOp1[k] == '+' || previousOp1[k] == '-' || previousOp1[k] == '÷' || previousOp1[k] == '×') {
                            when (previousOp1[i]) {
                                '+' -> {
                                    finalResult =
                                        finalNumberOperation + secOperation.toDouble()

                                }

                                '-' -> {
                                    finalResult =
                                        finalNumberOperation - secOperation.toDouble()

                                }

                                '÷' -> {
                                    finalResult =
                                        finalNumberOperation / secOperation.toDouble()

                                }

                                '×' -> {
                                    finalResult =
                                        finalNumberOperation * secOperation.toDouble()

                                }
                            }
                            previousOp1 =
                                finalResult.toString() + previousOp1.removeRange(0, k)
                            secOperation = ""
                            operation = ""
                            insideCounter = 0
                            newCounter = 0
                            j = 0
                            i = -1
                            break
                        }

                        if (k == previousOp1.length - 1) {


                            when (previousOp1[i]) {
                                '+' -> {
                                    finalResult =
                                        finalNumberOperation + secOperation.toDouble()
                                    previousOp1 = finalResult.toString()
                                }

                                '-' -> {
                                    finalResult =
                                        finalNumberOperation - secOperation.toDouble()
                                    previousOp1 = finalResult.toString()
                                }

                                '÷' -> {
                                    finalResult =
                                        finalNumberOperation / secOperation.toDouble()
                                    previousOp1 = finalResult.toString()
                                }

                                '×' -> {
                                    finalResult =
                                        finalNumberOperation * secOperation.toDouble()
                                    previousOp1 = finalResult.toString()
                                }
                            }

                        }

                    }
                }


                i++
            }
            finalResult = previousOp1.toDouble()



            if (finalResult.toString().endsWith(".0")) {
                previousOp1 = finalResult.toInt().toBigDecimal().toPlainString()
            } else if (finalResult <= 9999999999)
                previousOp1 = finalResult.toBigDecimal().toPlainString()


            for (element in previousOp1) {

                if (element == '.')
                    break
                else if (element == '-')
                    continue
                numberCounter++
            }




            if (previousOp1.startsWith('I')) {
                previousOp1 = ""
                Toast.makeText(this@MainActivity, "Invalid form used", Toast.LENGTH_SHORT).show()
                return ""
            }
            stringFinalResult = StringBuilder(previousOp1)
            if (!stringFinalResult.endsWith('y') || !stringFinalResult.startsWith('I')) {
                when (numberCounter) {
                    4 -> {
                        if (stringFinalResult.startsWith('-'))
                            stringFinalResult.insert(2, ',')
                        else
                            stringFinalResult.insert(1, ',')
                    }

                    5 -> {
                        if (stringFinalResult.startsWith('-'))
                            stringFinalResult.insert(3, ',')
                        else
                            stringFinalResult.insert(2, ',')
                    }

                    6 -> {
                        if (stringFinalResult.startsWith('-'))
                            stringFinalResult.insert(4, ',')
                        else
                            stringFinalResult.insert(3, ',')
                    }

                    7 -> {
                        if (stringFinalResult.startsWith('-')) {
                            stringFinalResult.insert(2, ',')
                            stringFinalResult.insert(6, ',')

                        } else {
                            stringFinalResult.insert(1, ',')
                            stringFinalResult.insert(5, ',')
                        }
                    }

                    8 -> {
                        if (stringFinalResult.startsWith('-')) {
                            stringFinalResult.insert(6, ',')
                            stringFinalResult.insert(3, ',')

                        } else {
                            stringFinalResult.insert(5, ',')
                            stringFinalResult.insert(2, ',')
                        }
                    }

                    9 -> {
                        if (stringFinalResult.startsWith('-')) {
                            stringFinalResult.insert(7, ',')
                            stringFinalResult.insert(4, ',')

                        } else {
                            stringFinalResult.insert(6, ',')
                            stringFinalResult.insert(3, ',')
                        }
                    }

                    10 -> {
                        if (stringFinalResult.startsWith('-')) {
                            stringFinalResult.insert(8, ',')
                            stringFinalResult.insert(5, ',')
                            stringFinalResult.insert(2, ',')

                        } else {
                            stringFinalResult.insert(7, ',')
                            stringFinalResult.insert(4, ',')
                            stringFinalResult.insert(1, ',')
                        }
                    }


                }
            }

            return stringFinalResult.toString()

        }
        return ""
    }



}


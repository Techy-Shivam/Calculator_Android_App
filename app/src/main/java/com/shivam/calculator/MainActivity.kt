package com.shivam.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.shivam.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder as ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAllclear.setOnClickListener {
            binding.inputtxt.text=""
            binding.outputtxt.text=""
        }

        binding.btn0.setOnClickListener {
            binding.inputtxt.append("0")
        }

        binding.btn1.setOnClickListener {
            binding.inputtxt.append("1")
        }

        binding.btn2.setOnClickListener {
            binding.inputtxt.append("2")
        }

        binding.btn3.setOnClickListener {
            binding.inputtxt.append("3")
        }

        binding.btn4.setOnClickListener {
            binding.inputtxt.append("4")
        }

        binding.btn5.setOnClickListener {
            binding.inputtxt.append("5")
        }

        binding.btn6.setOnClickListener {
            binding.inputtxt.append("6")
        }

        binding.btn7.setOnClickListener {
            binding.inputtxt.append("7")
        }

        binding.btn8.setOnClickListener {
            binding.inputtxt.append("8")
        }

        binding.btn9.setOnClickListener {
            binding.inputtxt.append("9")
        }

        binding.btnadd.setOnClickListener {
            binding.inputtxt.append(" + ")
        }

        binding.btnsubtract.setOnClickListener {
            binding.inputtxt.append(" - ")
        }

        binding.btndivide.setOnClickListener {
            binding.inputtxt.append(" / ")
        }

        binding.btnmultiply.setOnClickListener {
            binding.inputtxt.append(" * ")
        }

        binding.btnstartbracket.setOnClickListener {
            binding.inputtxt.append(" ( ")
        }

        binding.btnclosebracket.setOnClickListener {
            binding.inputtxt.append(" ) ")
        }

        binding.btndecimal.setOnClickListener {
            binding.inputtxt.append(".")
        }
        binding.btnequalsto.setOnClickListener {

            try {
                val expression = ExpressionBuilder(binding.inputtxt.text.toString()).build()

                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble()) {
                    binding.outputtxt.text = longResult.toString()
                } else {
                    binding.outputtxt.text = result.toString()
                }
            } catch (e: ArithmeticException) {
                // Handle division by zero exception
                binding.outputtxt.text = "Undefined"
            }

            binding.btndelete.setOnClickListener {
                val inputText = binding.inputtxt.text.toString()
                if (inputText.isNotEmpty()) {
                    val newInputText = inputText.substring(0, inputText.length - 1)
                    binding.inputtxt.text = newInputText.toString()
                }
            }
        }
    }
}
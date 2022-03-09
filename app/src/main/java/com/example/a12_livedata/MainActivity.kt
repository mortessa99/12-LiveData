package com.example.a12_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.a12_livedata.databinding.ActivityMainBinding
enum class myEnum{Even,Odd}

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        viewModel.count.observe(this) {
            binding.txtNumber.text = it.toString()
        }

        viewModel.isEven.observe(this){
            if (it == true) { print("زوج") } else {print("فرد") }
        }




        binding.btnClick.setOnClickListener {
           viewModel.setCount(binding.edtNumber.text.toString().toInt())
            if (viewModel.count.value.toString().toInt() %2 ==0) {viewModel.isEven.value = true } else { viewModel.isEven.value = false }
        }
    }
}
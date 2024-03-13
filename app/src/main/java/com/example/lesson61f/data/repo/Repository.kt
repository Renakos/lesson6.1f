package com.example.lesson61f.data.repo

import com.example.lesson61f.R
import com.example.lesson61f.data.model.ExampleModel

class Repository {
    val list = mutableListOf<ExampleModel>()
    private val model: ExampleModel =
        ExampleModel("This is A text", R.drawable.ic_launcher_background)

    init {
        add()
    }

    private fun add() {

        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
    }
}
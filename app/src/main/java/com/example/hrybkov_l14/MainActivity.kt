package com.example.hrybkov_l14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hrybkov_l14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerAdapter(getFamilyTree(createPerson()))
    }

    private fun setupRecyclerAdapter(tree: List<Pair<Person, Int>>) {
        binding.rV.adapter = RecyclerAdapter(tree)
        binding.rV.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        binding.rV.addItemDecoration(
            DividerItemDecoration(
                applicationContext,
                RecyclerView.VERTICAL
            )
        )
    }

    private fun createPerson(): Person {
        val fGrandfatherOfMother = Person("Benjamin", 98)
        val mGrandfatherOfMother = Person("Charlotte", 97)
        val fGrandmotherOfMother = Person("Lucas", 93)
        val mGrandmotherOfMother = Person("Sophia", 95)
        val fGrandfatherOfFather = Person("Oliver", 94)
        val mGrandfatherOfFather = Person("Isabella", 91)
        val fGrandmotherOfFather = Person("Elijah", 92)
        val mGrandmotherOfFather = Person("Emma", 91)
        val grandfatherOfFather = Person("James", 71, mGrandfatherOfFather, fGrandfatherOfFather)
        val grandmotherOfFather = Person("Elisabet", 67, mGrandmotherOfFather, fGrandmotherOfFather)
        val grandfatherOfMother = Person("Noah", 65, mGrandfatherOfMother, fGrandfatherOfMother)
        val grandmotherOfMother = Person("Ann", 66, mGrandmotherOfMother, fGrandmotherOfMother)
        val mother = Person("Helen", 46, grandmotherOfMother, grandfatherOfMother)
        val father = Person("Liam", 47, grandmotherOfFather, grandfatherOfFather)
        val me = Person("Andrew", 22, mother, father)

        return me
    }

    private fun getFamilyTree(person: Person, kinshipLevel: Int = 0): List<Pair<Person, Int>> {
        val listOfRelatives: MutableList<Pair<Person, Int>> = mutableListOf()
        listOfRelatives.add(Pair(person, kinshipLevel))

        person.mother?.also { listOfRelatives.addAll(getFamilyTree(it, kinshipLevel + 1)) }
        person.father?.also { listOfRelatives.addAll(getFamilyTree(it, kinshipLevel + 1)) }

        return listOfRelatives
    }
}
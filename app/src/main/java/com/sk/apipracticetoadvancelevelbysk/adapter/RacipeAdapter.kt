package com.sk.apipracticetoadvancelevelbysk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sk.apipracticetoadvancelevelbysk.R
import com.sk.apipracticetoadvancelevelbysk.db.Recipe

class RacipeAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RacipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeName: TextView = itemView.findViewById(R.id.recipeName)
        val recipeImage: ImageView = itemView.findViewById(R.id.recipeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.recipeName.text = recipe.name
        Glide.with(holder.itemView.context)
            .load(recipe.image)
            .into(holder.recipeImage)
    }

    override fun getItemCount() = recipes.size
}

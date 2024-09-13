package com.sk.apipracticetoadvancelevelbysk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sk.apipracticetoadvancelevelbysk.R
import com.sk.apipracticetoadvancelevelbysk.db.UserX

class UserAdapter(private val users: List<UserX>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: ImageView = itemView.findViewById(R.id.userImage)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val userEmail: TextView = itemView.findViewById(R.id.userEmail)
        val userPhone: TextView = itemView.findViewById(R.id.userPhone)
        val userpassword: TextView = itemView.findViewById(R.id.userpassword)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.userName.text = "${user.firstName} ${user.lastName}"

        holder.userName.setOnClickListener { holder.userEmail.text = user.email
        holder.userPhone.text = user.phone
        holder.userpassword.text = user.password
        }

        // Load user image using Glide
        Glide.with(holder.itemView.context)
            .load(user.image)
            .into(holder.userImage)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
